CREATE TABLE STUDENTS 
(
name VARCHAR(50),
mark NUMBER

);
INSERT INTO STUDENTS(name,mark)
VALUES('emad',91);

INSERT INTO STUDENTS(name,mark)
VALUES('mohamed',87);

INSERT INTO STUDENTS(name,mark)
VALUES('eslam',81);

INSERT INTO STUDENTS(name,mark)
VALUES('magdey',75);

INSERT INTO STUDENTS(name,mark)
VALUES('ahmed',63);

SELECT name,
       mark,
       CASE
           WHEN mark >= 90 THEN 'A'
           WHEN mark >= 80 THEN 'B'
           WHEN mark >= 70 THEN 'C'
           ELSE 'F'
       END AS grade
FROM STUDENTS;
