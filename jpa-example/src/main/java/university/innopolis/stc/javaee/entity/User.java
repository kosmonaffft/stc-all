package university.innopolis.stc.javaee.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString(exclude = "role")
@NoArgsConstructor
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "select_all_users", query = "SELECT u FROM User u"),
        @NamedQuery(name = "select_by_login", query = "SELECT u FROM User u WHERE u.login = :login"),
        @NamedQuery(name = "select_co_author", query = "SELECT DISTINCT u2a1.user FROM User2Article u2a1 WHERE u2a1.article IN (SELECT DISTINCT u2a2.article FROM User2Article u2a2 WHERE u2a2.user.id = :userId)")
})
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "status_id")
    private Status status;
}
