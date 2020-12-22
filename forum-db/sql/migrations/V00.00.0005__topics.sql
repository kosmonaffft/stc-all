-- Topics table.

CREATE TABLE topics
(
    section_id BIGINT NOT NULL,
    topic_id   BIGSERIAL,
    name       TEXT   NOT NULL,
    CONSTRAINT pk_topics PRIMARY KEY (section_id, topic_id),
    CONSTRAINT fk_topics_section FOREIGN KEY (section_id) REFERENCES sections (section_id)
);
