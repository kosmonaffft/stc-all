-- Users table.

CREATE TABLE users
(
    user_id  BIGSERIAL,
    login    TEXT         NOT NULL,
    password TEXT         NOT NULL,
    reg_date DATE         NOT NULL,
    role     VARCHAR(128) NOT NULL,
    picture  BYTEA,
    CONSTRAINT pk_users PRIMARY KEY (user_id),
    CONSTRAINT uq_users_login UNIQUE (login)
);
