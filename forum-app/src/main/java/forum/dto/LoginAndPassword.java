package forum.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginAndPassword {

    private String email;

    private String password;
}
