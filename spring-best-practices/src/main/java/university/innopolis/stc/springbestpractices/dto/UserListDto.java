package university.innopolis.stc.springbestpractices.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserListDto {

    private Long id;

    private String login;

    private LocalDate date;

    private String role;
}
