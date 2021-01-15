package forum.rest;

import forum.dto.UserDto;
import forum.entity.Article;
import forum.entity.Section;
import forum.entity.Topic;
import forum.entity.User;
import forum.jdbc.UsersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.sql.Date;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ArticlesRestController {

    @PersistenceContext
    private EntityManager entityManager;

    private final ModelMapper mapper = new ModelMapper();

    private final UsersRepository usersRepository;

    public ArticlesRestController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.mapper.createTypeMap(User.class, UserDto.class)
                .addMapping(u -> u.getStatus().getField(), UserDto::setStatusId);
    }

    @GetMapping("/api/test")
    public List<User> test() {
        return usersRepository.test();
    }

    @GetMapping(value = "/api/users/{id}")
    public UserDto byId(@PathVariable("id") Long id) {
        UserDto resultList = usersRepository.findById(id);
        return resultList;
    }

    @GetMapping(value = "/api/articles/{sectionId}/{topicId}")
    public Collection<String> articles(
            @PathVariable("sectionId") Long sectionId,
            @PathVariable("topicId") Long topicId) {
        List<String> resultList = entityManager.createNamedQuery("get_articles", Article.class)
                .setParameter("sectionId", sectionId)
                .setParameter("topicId", topicId)
                .getResultList()
                .stream()
                .map(a -> a.getText())
                .collect(Collectors.toList());
        return resultList;
    }

    @Transactional
    @GetMapping(value = "/api/articles/{sectionId}/{topicId}/generate")
    public Article generateArticle(
            @PathVariable("sectionId") Long sectionId,
            @PathVariable("topicId") Long topicId) {

        Article a = new Article();
        Section section = entityManager.find(Section.class, sectionId);
        Topic topic = entityManager.find(Topic.class, new Topic.Id(section, topicId));
        Article.Id id = new Article.Id();

        id.setTopic(topic);
        id.setArticleId(
                ((BigInteger) entityManager.createNativeQuery(
                        "SELECT NEXTVAL('articles_article_id_seq')").getSingleResult()).longValue()
        );

        a.setId(id);
        a.setText("1");
        a.setDate(new Date(Instant.now().toEpochMilli()));

        entityManager.persist(a);
        return a;
    }
}
