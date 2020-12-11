package university.innopolis.stc.powermock;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import university.innopolis.stc.powermock.badcode.StaticInitializer;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticInitializer.class)
public class BadCodeUserTest {

    @BeforeClass
    public static void init() {
        Connection mock = mock(Connection.class);
        when(mock.toString())
                .thenReturn("Hello from mock!!!");

        mockStatic(StaticInitializer.class);
        PowerMockito.when(StaticInitializer.getConnection())
                .thenReturn(mock);
    }


    @Test
    public void process() {
        BadCodeUser badCodeUser = new BadCodeUser();
        String process = badCodeUser.process("asdf");
        System.out.println(process);
        assertEquals("Hello from mock!!!:asdf", process);
    }
}