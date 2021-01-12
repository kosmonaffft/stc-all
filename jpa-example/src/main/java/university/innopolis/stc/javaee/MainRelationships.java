package university.innopolis.stc.javaee;

import lombok.Cleanup;
import lombok.val;
import university.innopolis.stc.javaee.entity.Article;
import university.innopolis.stc.javaee.entity.Role;
import university.innopolis.stc.javaee.entity.Section;
import university.innopolis.stc.javaee.entity.Topic;
import university.innopolis.stc.javaee.entity.User;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class MainRelationships {

    public static void main(String[] args) {
        val entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        @Cleanup val entityManager = entityManagerFactory.createEntityManager();

        val role = entityManager.find(Role.class, 1L);
        System.out.printf("Role: %s%n", role);

        Article.ArticleId articleId = new Article.ArticleId(1L, 1L, 1L);
        val article = entityManager.find(Article.class, articleId);
        System.out.printf("Article: %s%n", article);

        val section = entityManager.find(Section.class, 1L);
        val topic = entityManager.find(Topic.class, new Topic.TopicId(section, 1L));
        System.out.printf("Topic is: %s%n", topic);

        final TypedQuery<User> selectCoAuthorQuery = entityManager.createNamedQuery("select_co_author", User.class);
        selectCoAuthorQuery.setParameter("userId", 1L);
        final List<User> coAuthors = selectCoAuthorQuery.getResultList();
        System.out.printf("CoAuthors is: %s%n", coAuthors);
    }
}
