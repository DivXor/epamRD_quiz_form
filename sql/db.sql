CREATE TABLE DIVON.users
(
  id    INT PRIMARY KEY,
  email VARCHAR2(100) NOT NULL
);

CREATE TABLE DIVON.quizzes
(
  id             INT PRIMARY KEY,
  title          VARCHAR2(200)                NOT NULL,
  content        VARCHAR2(1000),
  creationTime   TIMESTAMP                    NOT NULL,
  expirationTime TIMESTAMP                    NOT NULL,
  status         INT CHECK (status IN (0, 1)) NOT NULL,
  user_id        INT                          NOT NULL
);

CREATE TABLE DIVON.answers
(
  id          INT PRIMARY KEY,
  title       VARCHAR2(200) NOT NULL,
  type        VARCHAR2(20) CHECK (type IN ('one', 'many', 'text')),
  answerOrder INT           NOT NULL,
  quiz_id     INT           NOT NULL
);

CREATE TABLE DIVON.history
(
  id         INT PRIMARY KEY,
  answer_id  INT       NOT NULL,
  user_id    INT       NOT NULL,
  answerTime TIMESTAMP NOT NULL
);


ALTER TABLE quizzes ADD CONSTRAINT Quizzes_fk0 FOREIGN KEY (user_id) REFERENCES DIVON.users (id);
ALTER TABLE answers ADD CONSTRAINT Answers_fk0 FOREIGN KEY (quiz_id) REFERENCES DIVON.quizzes (id);
ALTER TABLE history ADD CONSTRAINT history_fk0 FOREIGN KEY (answer_id) REFERENCES DIVON.answers (id);
ALTER TABLE history ADD CONSTRAINT history_fk1 FOREIGN KEY (user_id) REFERENCES DIVON.users (id);

COMMIT;
