CREATE TABLE Player (
    id   NUMBER PRIMARY KEY,--pk=unique+not null
    name VARCHAR2(55) UNIQUE,
    age  NUMBER
);

CREATE TABLE Manager (
    id     NUMBER NOT NULL,
    name   VARCHAR2(55),
    salary NUMBER,
    CONSTRAINT manager_id_name_uk UNIQUE (id, name) -- composite unique pair 
);

CREATE TABLE Manager_909 (
    id   NUMBER PRIMARY KEY,
    name VARCHAR2(55),
    age  NUMBER
);
