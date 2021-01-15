package forum.rest;

import com.google.common.base.Strings;
import com.querydsl.core.types.dsl.BooleanExpression;
import forum.entity.QTopic;
import forum.entity.Topic;
import forum.repository.TopicsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicsRestController {

    private final TopicsRepository topicsRepository;

    public TopicsRestController(TopicsRepository topicsRepository) {
        this.topicsRepository = topicsRepository;
    }

    @GetMapping("/api/sections/{sectionId}/topics")
    public Iterable<Topic> getAll(@PathVariable("sectionId") Long sectionId,
                                  @RequestParam(name = "name", required = false) String name) {

        BooleanExpression predicate = QTopic.topic.topicId.section.id.eq(sectionId);

        if (!Strings.isNullOrEmpty(name)) {
            predicate = predicate.or(QTopic.topic.name.eq(name));
        }

        Iterable<Topic> all = topicsRepository.findAll(predicate);
        return all;
    }
}
