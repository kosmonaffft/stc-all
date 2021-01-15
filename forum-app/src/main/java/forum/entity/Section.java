package forum.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sections")
public class Section {

    @Id
    @Column(name = "section_id", nullable = false)
    @GeneratedValue(generator = "SECTION_ID_GENERATOR", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "SECTION_ID_GENERATOR", allocationSize = 1, sequenceName = "sections_section_id_seq")
    private Long id;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    @Column(name = "name", nullable = false, unique = true)
    private String name;
}
