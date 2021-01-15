package forum.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "role_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
