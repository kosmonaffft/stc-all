package forum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String login;

    private String password;

    private Date registrationDate;

    private Long statusId;

    private Long roleId;
}
