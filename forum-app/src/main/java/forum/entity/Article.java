package forum.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "articles")
@NamedQueries({
        @NamedQuery(name = "get_articles", query = "SELECT a FROM Article a WHERE a.id.topic.topicId.section.id = :sectionId" +
                " AND a.id.topic.topicId.topicId = :topicId")
})
public class Article {

    @Getter
    @Setter
    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Id implements Serializable {

        @ManyToOne(optional = false)
        @JoinColumns({
                @JoinColumn(name = "section_id"),
                @JoinColumn(name = "topic_id")
        })
        private Topic topic;

        @Column(name = "article_id")
        private Long articleId;
    }

    @EmbeddedId
    private Id id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToMany
    @JoinTable(
            name = "user2article",
            joinColumns = {
                    @JoinColumn(name = "article_id"),
                    @JoinColumn(name = "topic_id"),
                    @JoinColumn(name = "section_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id")
            }
    )
    private List<User> users;
}
