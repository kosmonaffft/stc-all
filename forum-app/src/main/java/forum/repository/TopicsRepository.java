package forum.repository;

import forum.entity.Topic;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicsRepository extends PagingAndSortingRepository<Topic, Topic.Id>, QuerydslPredicateExecutor<Topic> {
}
