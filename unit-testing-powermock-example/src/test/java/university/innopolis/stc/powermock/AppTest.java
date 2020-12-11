package university.innopolis.stc.powermock;

import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws SQLException {
        final ResultSet resultSet = Mockito.mock(ResultSet.class);
        final PreparedStatement preparedStatement = Mockito.mock(PreparedStatement.class);
        final Connection connection = Mockito.mock(Connection.class);

        Mockito.when(connection.prepareStatement(Mockito.eq("SELECT * FROM TABLE")))
                .thenReturn(preparedStatement)
                .thenReturn(preparedStatement)
                .thenReturn(preparedStatement)
                .thenReturn(preparedStatement);

        connection.prepareStatement("SELECT * FROM TABLE");
        connection.prepareStatement("SELECT * FROM TABLE");
        final PreparedStatement mockedStatement = connection.prepareStatement("SELECT * FROM TABLE");

        Mockito.verify(connection, Mockito.times(3)).prepareStatement("SELECT * FROM TABLE");

        Mockito.when(preparedStatement.execute())
                .thenReturn(true);
        assertTrue(preparedStatement.execute());
        Mockito.verify(preparedStatement, Mockito.times(1)).execute();

        Mockito.when(preparedStatement.getResultSet())
                .thenReturn(resultSet);

        Mockito.when(resultSet.next())
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(true)
                .thenReturn(false);
        Mockito.when(resultSet.getString(Mockito.any()))
                .thenReturn("Hello, world!!!");

        while (resultSet.next()) {
            assertEquals("Hello, world!!!", resultSet.getString("string"));
        }

        Mockito.verify(resultSet, Mockito.times(6)).next();

        assertTrue(true);

        Mockito.when(connection.prepareStatement(Mockito.eq("SELECT * FROM TABLE")))
                .thenReturn(preparedStatement);
        Mockito.when(connection.prepareStatement(Mockito.argThat(arg -> arg != "SELECT * FROM TABLE")))
                .thenReturn(null);
    }
}
