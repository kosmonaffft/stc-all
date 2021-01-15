package forum.repository;

import forum.entity.Article;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends PagingAndSortingRepository<Article, Article.Id> {
}
