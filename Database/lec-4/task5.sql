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
       DECODE(mark ,
       mark>=90,'A',
       mark>=80,'B',
       mark>=70,'C',
       'F'
       )
       AS grade
FROM STUDENTS;

DROP TABLE ORDERS;
CREATE TABLE ORDERS
(
ord VARCHAR(50)
);


INSERT INTO ORDERS(ord)
VALUES ('P');

INSERT INTO ORDERS(ord)
VALUES ('S');

INSERT INTO ORDERS(ord)
VALUES ('D');

SELECT DECODE(ord,
'P','Pending',
'S','Shipped',
'D','Delivered'
) AS "Order" FROM ORDERS;
