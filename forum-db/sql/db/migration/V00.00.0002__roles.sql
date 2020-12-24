-- Roles table.

CREATE TABLE roles
(
    role_id BIGINT,
    name    TEXT NOT NULL,
    CONSTRAINT pk_roles PRIMARY KEY (role_id)
);

INSERT INTO roles (role_id, name)
VALUES (4, 'anon'),
       (3, 'user'),
       (1, 'admin'),
       (2, 'moderator');
