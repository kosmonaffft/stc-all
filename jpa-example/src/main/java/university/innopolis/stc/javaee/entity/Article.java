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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@ToString
@Table(name = "articles")
@IdClass(Article.ArticleId.class)
public class Article {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class ArticleId implements Serializable {

        private Long sectionId;

        private Long topicId;

        private Long articleId;
    }

    @Id
    @Column(name = "section_id", nullable = false)
    private Long sectionId;

    @Id
    @Column(name = "topic_id")
    private Long topicId;

    @Id
    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "text")
    private String text;

    @ManyToMany
    @JoinTable(name = "user2article", joinColumns = {
            @JoinColumn(name = "section_id"),
            @JoinColumn(name = "topic_id"),
            @JoinColumn(name = "article_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "user_id")
    })
    private List<User> users;
}
