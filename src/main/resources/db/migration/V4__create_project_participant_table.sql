CREATE TABLE project_participant
(
    id            BIGSERIAL PRIMARY KEY  NOT NULL,
    role          VARCHAR                NOT NULL,
    project_id    BIGINT                 NOT NULL,
    user_id       BIGINT                 NOT NULL,
    FOREIGN KEY (project_id)   REFERENCES project,
    FOREIGN KEY (user_id)      REFERENCES "user"
);
