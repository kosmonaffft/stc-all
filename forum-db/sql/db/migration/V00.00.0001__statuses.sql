-- Status table.

CREATE TABLE statuses
(
    status_id BIGINT,
    name      TEXT NOT NULL,
    CONSTRAINT pk_status PRIMARY KEY (status_id)
);

INSERT INTO statuses (status_id, name)
VALUES (1, 'registered'),
       (2, 'active'),
       (3, 'banned');
