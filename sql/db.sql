CREATE TABLE DIVON."users"
(
  "id"    INT PRIMARY KEY,
  "email" VARCHAR2(100) NOT NULL,
  "role"  VARCHAR2(50) CHECK("role" IN ('user', 'admin')) NOT NULL
);

CREATE TABLE DIVON."quizes"
(
  "id"          INT PRIMARY KEY,
  "title"       VARCHAR2(200) NOT NULL,
  "content"     BLOB,
  "date_create" DATE,
  "date_expire" DATE       NOT NULL,
  "status"      INT        NOT NULL,
  "user_id"     INT        NOT NULL
);

CREATE TABLE DIVON."answers"
(
  "id"      INT PRIMARY KEY,
  "title"   VARCHAR2(200) NOT NULL,
  "type"    VARCHAR2(20) CHECK("type" IN ('one', 'many')),
  "quiz_id" INT
);

CREATE TABLE DIVON."history"
(
  "id"        INT PRIMARY KEY,
  "answer_id" INT NOT NULL,
  "user_id"   INT NOT NULL,
  "date"      DATE
);


ALTER TABLE "quizes" ADD CONSTRAINT "Quizes_fk0" FOREIGN KEY ("user_id") REFERENCES DIVON."users" ("id");
ALTER TABLE "answers" ADD CONSTRAINT "Answers_fk0" FOREIGN KEY ("quiz_id") REFERENCES DIVON."quizes" ("id");
ALTER TABLE "history" ADD CONSTRAINT "history_fk0" FOREIGN KEY ("answer_id") REFERENCES DIVON."answers" ("id");
ALTER TABLE "history" ADD CONSTRAINT "history_fk1" FOREIGN KEY ("user_id") REFERENCES DIVON."users" ("id");

COMMIT;
