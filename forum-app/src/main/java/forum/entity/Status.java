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
@Table(name = "statuses")
public class Status {

    @Id
    @Column(name = "status_id", nullable = false)
    private Long field;

    @Column(name = "name", nullable = false)
    private String name;
}
