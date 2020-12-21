package university.innopolis.stc.life.executors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import university.innopolis.stc.life.data.LifeSnapshot;
import university.innopolis.stc.life.data.LifeUtils;

import java.io.IOException;
import java.io.InputStream;

class SingleThreadExecutorTest {

    private LifeSnapshot lifeSnapshot;

    @BeforeEach
    void setUp() throws IOException {
        try (InputStream testFle = getClass().getClassLoader().getResourceAsStream("test5x5.txt")) {
            lifeSnapshot = LifeUtils.readFromStream(testFle);
        }
    }

    @Test
    void execute() {
        SingleThreadExecutor executor = new SingleThreadExecutor();
        LifeSnapshot result = executor.execute(lifeSnapshot, 1);
        Assertions.assertArrayEquals(new byte[]{
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 1, 1, 1, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 0
        }, result.getData());
        final LifeSnapshot secondResult = executor.execute(result, 1);
        Assertions.assertArrayEquals(lifeSnapshot.getData(), secondResult.getData());
    }
}