package university.innopolis.stc.springbestpractices.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "USER_ID_GENERATOR")
    @SequenceGenerator(name = "USER_ID_GENERATOR", allocationSize = 1, sequenceName = "users_user_id_seq")
    @Column(name = "user_id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "reg_date")
    private LocalDate date;

    @Column(name = "role")
    private String role;

    @Column(name = "picture")
    private byte[] picture;
}
