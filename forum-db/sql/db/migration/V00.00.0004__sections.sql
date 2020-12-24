-- Sections table.

CREATE TABLE sections
(
    section_id BIGSERIAL,
    name       TEXT   NOT NULL,
    version    BIGINT NOT NULL DEFAULT 1,
    CONSTRAINT pk_sections PRIMARY KEY (section_id)
);
