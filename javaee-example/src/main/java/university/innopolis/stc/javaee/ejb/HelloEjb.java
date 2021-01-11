package university.innopolis.stc.javaee.ejb;

import university.innopolis.stc.javaee.dto.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class HelloEjb {

    @Resource(lookup = "java:/ForumDS")
    private DataSource dataSource;

    public List<String> getAllUsersLogins() {
        ArrayList<String> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT login FROM users");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(resultSet.getString(1));
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

        return result;
    }

    public List<User> getAllUsers() {
        ArrayList<User> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT user_id, login FROM users");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String login = resultSet.getString(2);
                result.add(new User(id, login));
            }
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

        return result;
    }
}
