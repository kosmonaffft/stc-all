-- Users table.

CREATE TABLE vip_users
(
    user_id  BIGINT,
    vip_card TEXT NOT NULL,
    CONSTRAINT pk_vip_users PRIMARY KEY (user_id),
    CONSTRAINT fk_vip_user_id_user FOREIGN KEY (user_id) REFERENCES users (user_id)
);
