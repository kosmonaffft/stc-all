package university.innopolis.stc.threading;

import com.google.common.base.Stopwatch;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * Hello world!
 */
public class App {

    private static void process(int[] array, int start, int increment) {
        for (int i = start; i < array.length; i += increment) {
            array[i] = array[i] * array[i] * array[i] / 73;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] ints = IntStream.range(0, 10_000_001).toArray();
        int threadsCount = 2;
        Thread[] threads = new Thread[threadsCount];
        Future[] futures = new Future[threadsCount];
        ExecutorService executorService = Executors.newFixedThreadPool(threadsCount);

        Stopwatch s = Stopwatch.createStarted();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = ints[i] * ints[i] * ints[i] / 73;
        }
        s.stop();
        System.out.println(s.toString());

        final double[] x = new double[] {0.0};
        for (int[] i = new int[]{0}; i[0] < threadsCount; ++i[0]) {
            Thread thread = new Thread(() -> {
                process(ints, i[0], threadsCount);
                x[0] = 10.0;
            });
            threads[i[0]] = thread;
        }

        s = Stopwatch.createStarted();
        Arrays.stream(threads).forEach(Thread::start);
        Arrays.stream(threads).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException ignored) {
            }
        });
        s.stop();
        System.out.println(s.toString());

        s = Stopwatch.createStarted();
        for (int i = 0; i < threadsCount; ++i) {
            int start = i;
            Future<?> future = executorService.submit(() -> process(ints, start, threadsCount));
            futures[i] = future;
        }
        for (int i = 0; i < futures.length; i++) {
            futures[i].get();
        }
        s.stop();
        System.out.println(s.toString());
        
        executorService.shutdown();
    }
}
