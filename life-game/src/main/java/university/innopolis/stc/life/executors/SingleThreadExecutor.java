package university.innopolis.stc.life.executors;


import university.innopolis.stc.life.data.LifeSnapshot;

import java.util.Arrays;


public class SingleThreadExecutor implements LifeExecutor {

    @Override
    public LifeSnapshot execute(LifeSnapshot startState, long iterationsCount) {
        final byte[] data = startState.getData();
        final int xsize = startState.getXsize();
        final int ysize = startState.getYsize();
        byte[] oldState = Arrays.copyOf(data, data.length);
        byte[] newState = new byte[data.length];
        for (long iteration = 0; iteration < iterationsCount; ++iteration) {
            for (int y = 0; y < ysize; ++y) {
                LifeExecutor.processLine(xsize, ysize, oldState, newState, y);
            }

            byte[] tmp = oldState;
            oldState = newState;
            newState = tmp;
        }

        return new LifeSnapshot(xsize, ysize, oldState);
    }
}
