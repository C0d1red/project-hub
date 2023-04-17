CREATE TABLE task
(
    id            BIGSERIAL PRIMARY KEY  NOT NULL,
    creation_date DATE                   NOT NULL,
    title         VARCHAR                        ,
    description   VARCHAR                        ,
    number        INTEGER                NOT NULL,
    priority      VARCHAR                        ,
    status        VARCHAR                NOT NULL,
    due_date      DATE                   NOT NULL,
    project_id    BIGINT                 NOT NULL,
    author_id     BIGINT                 NOT NULL,
    performer_id  BIGINT                 NOT NULL,
    FOREIGN KEY (project_id)   REFERENCES project,
    FOREIGN KEY (author_id)    REFERENCES "user",
    FOREIGN KEY (performer_id) REFERENCES "user"
);
