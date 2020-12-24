-- Users table.

CREATE TABLE users
(
    user_id   BIGSERIAL,
    login     TEXT   NOT NULL,
    password  TEXT   NOT NULL,
    reg_date  DATE   NOT NULL,
    role_id   BIGINT NOT NULL,
    status_id BIGINT NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (user_id),
    CONSTRAINT uq_users_login UNIQUE (login),
    CONSTRAINT fk_users_roles FOREIGN KEY (role_id) REFERENCES roles (role_id),
    CONSTRAINT fk_users_statuses FOREIGN KEY (status_id) REFERENCES statuses (status_id)
);
