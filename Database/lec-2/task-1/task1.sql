CREATE TABLE Doctor
(
  id NUMBER(2),
  name VARCHAR2(20),
  salary NUMBER(10,2),
  address VARCHAR2(50)
);
INSERT INTO Doctor (id, name, salary, address) VALUES (1, 'Emad', 1000, 'Cairo');
INSERT INTO Doctor (id, name, salary, address) VALUES (2, 'Ahmed', 7000, 'Giza');
INSERT INTO Doctor (id, name, salary, address) VALUES (3, 'Sara', 4500, 'Alexandria');
INSERT INTO Doctor (id, name, salary, address) VALUES (4, 'Mona', 4800, 'Tanta');
INSERT INTO Doctor (id, name, salary, address) VALUES (5, 'Omar', 2000, 'Mansoura');
INSERT INTO Doctor (id, name, salary, address) VALUES (6, 'Youssef', 6000, 'Cairo');
INSERT INTO Doctor (id, name, salary, address) VALUES (7, 'Laila', 5500, 'Zagazig');
INSERT INTO Doctor (id, name, salary, address) VALUES (8, 'Hassan', 3000, 'Aswan');
INSERT INTO Doctor (id, name, salary, address) VALUES (9, 'Nour', 4000, 'Fayoum');
INSERT INTO Doctor (id, name, salary, address) VALUES (10, 'Khaled', 6500, 'Minya');

UPDATE Doctor 
SET salary = 20000
WHERE id = 3;

DELETE FROM Doctor
WHERE id = 9;


SELECT name || ' has salary ' || salary AS Name_Salary
FROM Doctor;

SELECT id, name, salary, salary * 2 AS double_salary, address
FROM Doctor;

SELECT *
FROM Doctor
WHERE salary IN (1000, 2000, 3000);

RENAME Doctor TO PRD_DOCTOR;

