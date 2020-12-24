-- Roles table.

CREATE TABLE roles
(
    role_id BIGINT,
    name    TEXT NOT NULL,
    CONSTRAINT pk_roles PRIMARY KEY (role_id)
);

INSERT INTO roles (role_id, name)
VALUES (1, 'anon'),
       (2, 'user'),
       (3, 'admin'),
       (4, 'moderator');
