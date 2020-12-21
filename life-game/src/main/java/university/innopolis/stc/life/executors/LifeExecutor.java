package university.innopolis.stc.life.executors;

import university.innopolis.stc.life.data.LifeSnapshot;

public interface LifeExecutor {

    LifeSnapshot execute(LifeSnapshot startState, long iterationsCount);

    static int toPlainIndex(int x, int y, int xSize) {
        return x + y * xSize;
    }

    static void processLine(int xsize, int ysize, byte[] oldState, byte[] newState, int y) {
        for (int x = 0; x < xsize; ++x) {
            //noinspection PointlessArithmeticExpression
            int neighborsCount = 0 + // For beautiful align.
                    oldState[toPlainIndex((x - 1 + xsize) % xsize, (y - 1 + ysize) % ysize, xsize)] + // Top left.
                    oldState[toPlainIndex(x, (y - 1 + ysize) % ysize, xsize)] + // Top.
                    oldState[toPlainIndex((x + 1) % xsize, (y - 1 + ysize) % ysize, xsize)] + // Top Right.
                    oldState[toPlainIndex((x - 1 + xsize) % xsize, y, xsize)] + // Left.
                    oldState[toPlainIndex((x + 1) % xsize, y, xsize)] + // Right;
                    oldState[toPlainIndex((x - 1 + xsize) % xsize, (y + 1) % ysize, xsize)] + // Bottom left.
                    oldState[toPlainIndex(x, (y + 1) % ysize, xsize)] + // Bottom.
                    oldState[toPlainIndex((x + 1) % xsize, (y + 1) % ysize, xsize)];
            if (oldState[toPlainIndex(x, y, xsize)] == 1) { // Alive old cell.
                if (neighborsCount == 2 || neighborsCount == 3) {
                    newState[toPlainIndex(x, y, xsize)] = 1;
                } else {
                    newState[toPlainIndex(x, y, xsize)] = 0;
                }
            } else { // Dead old cell.
                if (neighborsCount == 3) {
                    newState[toPlainIndex(x, y, xsize)] = 1;
                } else {
                    newState[toPlainIndex(x, y, xsize)] = 0;
                }
            }
        }
    }
}
