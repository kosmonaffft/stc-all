package university.innopolis.stc.life.data;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class LifeUtilsTest {

    @Test
    void readFromStreamTest() {
        try (InputStream testFle = getClass().getClassLoader().getResourceAsStream("test3x3.txt")) {
            final LifeSnapshot lifeSnapshot = LifeUtils.readFromStream(testFle);
            assertEquals(3, lifeSnapshot.getXsize());
            assertEquals(3, lifeSnapshot.getYsize());
            assertArrayEquals(new byte[]{0, 1, 0, 0, 1, 0, 0, 1, 0}, lifeSnapshot.getData());
        } catch (IOException e) {
            fail();
        }
    }
}
