package forum.jdbc;

import forum.dto.UserDto;
import forum.entity.User;
import lombok.val;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;

@Repository
public class UsersRepository {

    @PersistenceContext
    private EntityManager em;

    public static final RowMapper<UserDto> MAPPER = (rs, rowNum) -> {
        UserDto dto = new UserDto();
        dto.setId(rs.getLong("user_id"));
        dto.setLogin(rs.getString("login"));
        dto.setPassword(rs.getString("password"));
        return dto;
    };

    private final NamedParameterJdbcTemplate template;

    public UsersRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public UserDto findById(Long id) {
        List<UserDto> list = template.query(
                "select * from users where user_id = :id",
                new HashMap<String, Object>() {{
                    put("id", id);
                }},
                MAPPER
        );
        return list.get(0);
    }

    public List<User> test() {
        val provider = new JinqJPAStreamProvider(em.getMetamodel());
        List<User> users = provider.streamAll(em, User.class)
                .where(u -> u.getStatus().getField().equals(1L))
                .where(u -> u.getRole().getId().equals(1L))
                .where(u -> u.getLogin().equals("login1"))
                .toList();
        return users;
    }
}
