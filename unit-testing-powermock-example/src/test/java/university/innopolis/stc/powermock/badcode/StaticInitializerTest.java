package university.innopolis.stc.powermock.badcode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticInitializer.class)
public class StaticInitializerTest {

    @Test
    public void name() {
        PowerMockito.mockStatic(StaticInitializer.class);
        PowerMockito.when(StaticInitializer.getFilename()).thenReturn("/home");

        assertEquals("/home", StaticInitializer.getFilename());
    }
}
