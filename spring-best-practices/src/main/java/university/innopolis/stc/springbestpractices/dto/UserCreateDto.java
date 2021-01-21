package university.innopolis.stc.springbestpractices.dto;

import lombok.Data;

@Data
public class UserCreateDto {

    private String login;

    private String password;

    private String role;
}
