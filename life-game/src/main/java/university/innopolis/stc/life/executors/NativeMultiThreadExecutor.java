package university.innopolis.stc.life.executors;


import university.innopolis.stc.life.data.LifeSnapshot;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

public class NativeMultiThreadExecutor implements LifeExecutor {

    private final int threadsCount;

    public NativeMultiThreadExecutor(int threadsCount) {
        this.threadsCount = threadsCount;
    }

    @Override
    public LifeSnapshot execute(LifeSnapshot startState, long iterationsCount) {
        ExecutorInternal executorInternal = new ExecutorInternal(startState, iterationsCount);
        executorInternal.run();
        return new LifeSnapshot(executorInternal.xsize, executorInternal.ysize, executorInternal.oldState);
    }

    private class ExecutorInternal {

        private CyclicBarrier calculationsBarrier;

        private CyclicBarrier swapBarrier;

        private byte[] oldState;

        private byte[] newState;

        private int xsize;

        private int ysize;

        private long iterationsCount;

        private int actualThreadsCount;

        ExecutorInternal(LifeSnapshot startState, long iterationsCount) {
            final byte[] data = startState.getData();
            this.iterationsCount = iterationsCount;
            xsize = startState.getXsize();
            ysize = startState.getYsize();
            oldState = Arrays.copyOf(data, data.length);
            newState = new byte[data.length];
            actualThreadsCount = Math.min(threadsCount, ysize);
            calculationsBarrier = new CyclicBarrier(actualThreadsCount);
            swapBarrier = new CyclicBarrier(actualThreadsCount);
        }

        void run() {
            final List<Thread> threads = range(0, actualThreadsCount)
                    .mapToObj(i -> new ThreadImpl(i, iterationsCount))
                    .collect(Collectors.toList());
            threads.forEach(Thread::start);
            threads.forEach(thread -> {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        private class ThreadImpl extends Thread {

            private int threadIndex;

            private long iterationsCount;

            ThreadImpl(int threadIndex, long iterationsCount) {
                this.threadIndex = threadIndex;
                this.iterationsCount = iterationsCount;
            }

            @Override
            public void run() {
                try {
                    for (long iteration = 0; iteration < iterationsCount; ++iteration) {
                        for (int y = threadIndex; y < ysize; y += threadsCount) {
                            LifeExecutor.processLine(xsize, ysize, oldState, newState, y);
                        }
                        calculationsBarrier.await();

                        if (threadIndex == 0) {
                            byte[] tmp = oldState;
                            oldState = newState;
                            newState = tmp;
                        }

                        swapBarrier.await();
                    }
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
