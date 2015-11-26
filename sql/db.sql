CREATE TABLE users
(
  id         INT PRIMARY KEY,
  email      VARCHAR2(100) NOT NULL,
  password   VARCHAR2(100) NOT NULL,
  first_name VARCHAR2(100) NOT NULL,
  last_name  VARCHAR2(100) NOT NULL,
  role_id    INT           NOT NULL
);

CREATE TABLE user_roles
(
  id        INT PRIMARY KEY,
  role_name VARCHAR2(100) NOT NULL
);

CREATE TABLE user_messages
(
  id        INT PRIMARY KEY,
  title     VARCHAR2(200) NOT NULL,
  content   VARCHAR2(5000),
  sent_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  user_id   INT           NOT NULL,
  quiz_id   INT           NOT NULL
);

CREATE TABLE quizzes
(
  id              INT PRIMARY KEY,
  title           VARCHAR2(200)                       NOT NULL,
  CONTENT         VARCHAR2(1000),
  creation_time   TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  expiration_time TIMESTAMP,
  anonymous       NUMBER(1, 0) DEFAULT 0              NOT NULL,
  status          NUMBER(1, 0) DEFAULT 0              NOT NULL,
  user_id         INT                                 NOT NULL
);

CREATE TABLE answers
(
  id           INT PRIMARY KEY,
  title        VARCHAR2(200)                                NOT NULL,
  type         VARCHAR2(20) CHECK (type IN ('one', 'many')) NOT NULL,
  answer_order INT                                          NOT NULL,
  quiz_id      INT                                          NOT NULL
);

CREATE TABLE history
(
  id          INT PRIMARY KEY,
  answer_id   INT                                  NOT NULL,
  user_id     INT                                  NOT NULL,
  answer_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP  NOT NULL
);

ALTER TABLE quizzes ADD CONSTRAINT Quizzes_fk0 FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE answers ADD CONSTRAINT Answers_fk0 FOREIGN KEY (quiz_id) REFERENCES quizzes (id) ON DELETE CASCADE;
ALTER TABLE history ADD CONSTRAINT history_fk0 FOREIGN KEY (answer_id) REFERENCES answers (id);
ALTER TABLE history ADD CONSTRAINT history_fk1 FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE users ADD CONSTRAINT users_fk0 FOREIGN KEY (role_id) REFERENCES user_roles (id);
ALTER TABLE user_messages ADD CONSTRAINT messages_fk0 FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE user_messages ADD CONSTRAINT messages_fk1 FOREIGN KEY (quiz_id) REFERENCES quizzes (id);

INSERT INTO user_roles (id, role_name) VALUES (0, 'ANONYMOUS');
INSERT INTO user_roles (id, role_name) VALUES (1, 'USER');
INSERT INTO user_roles (id, role_name) VALUES (2, 'ADMIN');

COMMIT;
