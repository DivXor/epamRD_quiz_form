CREATE TABLE DIVON.users
(
  id    INT PRIMARY KEY,
  email VARCHAR2(100) NOT NULL
);

CREATE TABLE DIVON.quizzes
(
  id              INT PRIMARY KEY,
  title           VARCHAR2(200)                                          NOT NULL,
  content         VARCHAR2(1000),
  creation_time   TIMESTAMP DEFAULT CURRENT_TIMESTAMP                    NOT NULL,
  expiration_time TIMESTAMP,
  anonymous       NUMBER(1, 0) DEFAULT 0                                 NOT NULL,
  status          NUMBER(1, 0) DEFAULT 0                                 NOT NULL,
  user_id         INT                                                    NOT NULL
);

CREATE TABLE DIVON.answers
(
  id           INT PRIMARY KEY,
  title        VARCHAR2(200)                                        NOT NULL,
  type         VARCHAR2(20) CHECK (type IN ('one', 'many', 'text')) NOT NULL,
  answer_order INT                                                  NOT NULL,
  quiz_id      INT                                                 NOT NULL
);

CREATE TABLE DIVON.history
(
  id          INT PRIMARY KEY,
  answer_id   INT                                  NOT NULL,
  user_id     INT                                  NOT NULL,
  answer_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL
);

ALTER TABLE quizzes ADD CONSTRAINT Quizzes_fk0 FOREIGN KEY (user_id) REFERENCES DIVON.users (id);
ALTER TABLE answers ADD CONSTRAINT Answers_fk0 FOREIGN KEY (quiz_id) REFERENCES DIVON.quizzes (id) ON DELETE CASCADE;
ALTER TABLE history ADD CONSTRAINT history_fk0 FOREIGN KEY (answer_id) REFERENCES DIVON.answers (id);
ALTER TABLE history ADD CONSTRAINT history_fk1 FOREIGN KEY (user_id) REFERENCES DIVON.users (id);

COMMIT;
