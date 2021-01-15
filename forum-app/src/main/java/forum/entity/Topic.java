package forum.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "topics")
public class Topic {

    @Getter
    @Setter
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Id implements Serializable {

        @ManyToOne(optional = false)
        @JoinColumn(name = "section_id")
        private Section section;

        @Column(name = "topic_id")
        private Long topicId;
    }

    @EmbeddedId
    private Id topicId;

    @Column(name = "name", nullable = false)
    private String name;
}
