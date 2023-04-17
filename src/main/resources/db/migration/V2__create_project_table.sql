CREATE TABLE project
(
    id            BIGSERIAL PRIMARY KEY NOT NULL,
    title         VARCHAR               NOT NULL,
    creation_date DATE                  NOT NULL,
    author_id     BIGINT                NOT NULL,
    FOREIGN KEY (author_id) REFERENCES "user"
);
