package university.innopolis.stc.javaee;

import lombok.Cleanup;
import lombok.val;
import university.innopolis.stc.javaee.entity.Article;
import university.innopolis.stc.javaee.entity.Role;

import javax.persistence.Persistence;

public class MainRelationships {

    public static void main(String[] args) {
        val entityManagerFactory = Persistence.createEntityManagerFactory("PU");
        @Cleanup val entityManager = entityManagerFactory.createEntityManager();

        val role = entityManager.find(Role.class, 1L);
        System.out.printf("Role: %s%n", role);

        Article.ArticleId articleId = new Article.ArticleId(1L, 1L, 1L);
        val article = entityManager.find(Article.class, articleId);
        System.out.printf("Article: %s%n", article);
    }
}
