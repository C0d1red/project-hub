CREATE TABLE "user"
(
    id       BIGSERIAL PRIMARY KEY NOT NULL,
    username VARCHAR   UNIQUE      NOT NULL,
    password VARCHAR
);
