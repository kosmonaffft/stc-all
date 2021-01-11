package university.innopolis.stc.javaee.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "statuses")
public class Status {

    @Id
    @Column(name = "status_id")
    private Long id;

    @Column(name = "name")
    private String name;
}
