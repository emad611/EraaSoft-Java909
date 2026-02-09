
DROP TABLE Language;
CREATE TABLE Language
(
    id NUMBER PRIMARY KEY,
    name VARCHAR2(55) UNIQUE
);
DROP TABLE Teacher;
CREATE TABLE Teacher
(
    id NUMBER PRIMARY KEY,
    name VARCHAR2(55) UNIQUE,
    salary NUMBER,
    language_id NUMBER,

    CONSTRAINT teacher_language_fk
        FOREIGN KEY (language_id)
        REFERENCES Language(id)
);