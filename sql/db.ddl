CREATE TABLE QUIZ_ENGINE.ANSWERS
(
  ID           INTEGER       NOT NULL,
  TITLE        VARCHAR2(200) NOT NULL,
  TYPE         VARCHAR2(20)  NOT NULL,
  ANSWER_ORDER INTEGER       NOT NULL,
  QUIZ_ID      INTEGER       NOT NULL
);
ALTER TABLE QUIZ_ENGINE.ANSWERS ADD CHECK ( TYPE IN ('many', 'one'));
ALTER TABLE QUIZ_ENGINE.ANSWERS ADD CONSTRAINT ANSWERS_PK PRIMARY KEY (ID);


CREATE TABLE QUIZ_ENGINE.HISTORY
(
  ID          INTEGER                             NOT NULL,
  ANSWER_ID   INTEGER                             NOT NULL,
  USER_ID     INTEGER                             NOT NULL,
  ANSWER_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  QUIZ_ID     INTEGER                             NOT NULL
);
ALTER TABLE QUIZ_ENGINE.HISTORY ADD CONSTRAINT HISTORY_PK PRIMARY KEY (ID);


CREATE TABLE QUIZ_ENGINE.QUIZZES
(
  ID              INTEGER                             NOT NULL,
  TITLE           VARCHAR2(200)                       NOT NULL,
  CONTENT         VARCHAR2(1000),
  CREATION_TIME   TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  EXPIRATION_TIME TIMESTAMP,
  ANONYMOUS       NUMBER DEFAULT 0                    NOT NULL,
  STATUS          NUMBER DEFAULT 0                    NOT NULL,
  AUTHOR_ID       INTEGER                             NOT NULL
);
ALTER TABLE QUIZ_ENGINE.QUIZZES ADD CHECK ( ANONYMOUS IN (0, 1));
ALTER TABLE QUIZ_ENGINE.QUIZZES ADD CHECK ( STATUS IN (0, 1));
ALTER TABLE QUIZ_ENGINE.QUIZZES ADD CONSTRAINT QUIZZES_PK PRIMARY KEY (ID);


CREATE TABLE QUIZ_ENGINE.USERS
(
  ID         INTEGER       NOT NULL,
  EMAIL      VARCHAR2(100) NOT NULL,
  PASSWORD   VARCHAR2(100) NOT NULL,
  FIRST_NAME VARCHAR2(100) NOT NULL,
  LAST_NAME  VARCHAR2(100) NOT NULL,
  ROLE_ID    INTEGER       NOT NULL
);
ALTER TABLE QUIZ_ENGINE.USERS ADD CONSTRAINT USERS_PK PRIMARY KEY (ID);


CREATE TABLE QUIZ_ENGINE.USER_MESSAGES
(
  ID        INTEGER       NOT NULL,
  TITLE     VARCHAR2(200) NOT NULL,
  CONTENT   VARCHAR2(4000),
  AUTHOR_ID INTEGER       NOT NULL
);
ALTER TABLE QUIZ_ENGINE.USER_MESSAGES ADD CONSTRAINT USER_MESSAGES_PK PRIMARY KEY (ID);


CREATE TABLE QUIZ_ENGINE.USER_ROLES
(
  ID        INTEGER       NOT NULL,
  ROLE_NAME VARCHAR2(100) NOT NULL
);
ALTER TABLE QUIZ_ENGINE.USER_ROLES ADD CONSTRAINT USER_ROLES_PK PRIMARY KEY (ID);


ALTER TABLE QUIZ_ENGINE.ANSWERS ADD CONSTRAINT ANSWERS_FK0 FOREIGN KEY (QUIZ_ID) REFERENCES QUIZ_ENGINE.QUIZZES (ID) ON
DELETE CASCADE;

ALTER TABLE QUIZ_ENGINE.HISTORY ADD CONSTRAINT HISTORY_FK0 FOREIGN KEY (ANSWER_ID) REFERENCES QUIZ_ENGINE.ANSWERS (ID);

ALTER TABLE QUIZ_ENGINE.HISTORY ADD CONSTRAINT HISTORY_FK1 FOREIGN KEY (USER_ID) REFERENCES QUIZ_ENGINE.USERS (ID);

ALTER TABLE QUIZ_ENGINE.HISTORY ADD CONSTRAINT HISTORY_QUIZZES_FK FOREIGN KEY (QUIZ_ID) REFERENCES QUIZ_ENGINE.QUIZZES (ID);

ALTER TABLE QUIZ_ENGINE.USER_MESSAGES ADD CONSTRAINT MESSAGES_FK0 FOREIGN KEY (AUTHOR_ID) REFERENCES QUIZ_ENGINE.USERS (ID);

ALTER TABLE QUIZ_ENGINE.QUIZZES ADD CONSTRAINT QUIZZES_FK0 FOREIGN KEY (AUTHOR_ID) REFERENCES QUIZ_ENGINE.USERS (ID);

ALTER TABLE QUIZ_ENGINE.USERS ADD CONSTRAINT USERS_FK0 FOREIGN KEY (ROLE_ID) REFERENCES QUIZ_ENGINE.USER_ROLES (ID);

INSERT INTO user_roles (id, role_name) VALUES (0, 'ANONYMOUS');
INSERT INTO user_roles (id, role_name) VALUES (1, 'USER');
INSERT INTO user_roles (id, role_name) VALUES (2, 'ADMIN');

COMMIT;