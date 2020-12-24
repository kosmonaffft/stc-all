-- Articles table.

CREATE TABLE articles
(
    section_id BIGINT NOT NULL,
    topic_id   BIGINT NOT NULL,
    article_id BIGSERIAL,
    text       TEXT   NOT NULL,
    date       DATE   NOT NULL,
    CONSTRAINT pk_articles PRIMARY KEY (section_id, topic_id, article_id),
    CONSTRAINT fk_articles_topic FOREIGN KEY (section_id, topic_id) REFERENCES topics (section_id, topic_id)
);
