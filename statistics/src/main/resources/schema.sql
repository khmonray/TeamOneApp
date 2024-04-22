CREATE TABLE IF NOT EXISTS stats
(
    id               BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    course_id        BIGINT                                 NOT NULL,
    count            INTEGER
);