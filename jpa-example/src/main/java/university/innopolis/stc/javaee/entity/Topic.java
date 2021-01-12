package university.innopolis.stc.javaee.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@IdClass(Topic.TopicId.class)
@Table(name = "topics")
public class Topic {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class TopicId implements Serializable {

        private Section section;

        private Long topicId;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @Id
    @Column(name = "topic_id")
    private Long topicId;

    @Column(name = "name")
    private String name;
}
