package forum.controller;

import forum.entity.Article;
import lombok.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Controller
public class ArticlesController {

    private final EntityManager entityManager;

    public ArticlesController(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @GetMapping(value = "/articles")
    public String articlesByRequestParams(
            @RequestParam("sectionId") Long sectionId,
            @RequestParam("topicId") Long topicId,
            @RequestHeader("User-Agent") String agent,
            Model model) {
        List<Article> resultList = entityManager.createNamedQuery("get_articles", Article.class)
                .setParameter("sectionId", sectionId)
                .setParameter("topicId", topicId)
                .getResultList();
        model.addAttribute("articles", resultList);
        return "articles";
    }

    @GetMapping(value = "/articles/{sectionId}/{topicId}")
    public String articles(
            @PathVariable("sectionId") Long sectionId,
            @PathVariable("topicId") Long topicId,
            Model model) {
        List<Article> resultList = entityManager.createNamedQuery("get_articles", Article.class)
                .setParameter("sectionId", sectionId)
                .setParameter("topicId", topicId)
                .getResultList();
        model.addAttribute("articles", resultList);
        return "articles";
    }
}
