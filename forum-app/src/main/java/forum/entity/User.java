package forum.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "findUserByLogin", query = "SELECT u FROM User u WHERE u.login = :login")
})
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(generator = "USER_ID_GENERATOR", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "USER_ID_GENERATOR", allocationSize = 1, sequenceName = "users_user_id_seq")
    private Long id;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "reg_date", nullable = false)
    private Date registrationDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

//    @ManyToMany
//    @JoinTable(
//            name = "user2article",
//            inverseJoinColumns = {
//                    @JoinColumn(name = "article_id"),
//                    @JoinColumn(name = "topic_id"),
//                    @JoinColumn(name = "section_id")
//            },
//            joinColumns = {
//                    @JoinColumn(name = "user_id")
//            }
//    )
//    private List<Article> articles;
}
