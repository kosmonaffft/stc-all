package university.innopolis.stc.javaee.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@ToString
@IdClass(User2Article.User2ArticleId.class)
@Table(name = "user2article")
public class User2Article {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class User2ArticleId implements Serializable {

        private Article article;

        private User user;
    }

    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "section_id"),
            @JoinColumn(name = "topic_id"),
            @JoinColumn(name = "article_id")
    })
    private Article article;

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
