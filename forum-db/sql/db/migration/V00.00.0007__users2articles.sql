-- User-Article intermediate table.

CREATE TABLE user2article
(
    user_id    BIGINT NOT NULL,
    section_id BIGINT NOT NULL,
    topic_id   BIGINT NOT NULL,
    article_id BIGINT NOT NULL,
    CONSTRAINT pk_user2article PRIMARY KEY (user_id, section_id, topic_id, article_id),
    CONSTRAINT fk_articles FOREIGN KEY (section_id, topic_id, article_id) REFERENCES articles (section_id, topic_id, article_id),
    CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);
