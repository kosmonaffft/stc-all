package university.innopolis.stc.javaee.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "sections")
public class Section {

    @Id
    @Column(name = "section_id")
    private Long id;

    @Version
    @Column(name = "version")
    private Long version;

    @Column(name = "name")
    private String name;
}
