CREATE TABLE customers 
(
full_name VARCHAR(50)

);
INSERT INTO customers(full_name)
VALUES ('  emad  ');

SELECT TRIM(BOTH ' ' FROM full_name)AS name FROM customers;

SELECT LTRIM(full_name) AS name
FROM customers;

SELECT RTRIM(full_name)AS name
FROM customers;

SELECT TRIM(BOTH '*'FROM '*1PASWORD#*')AS COOL FROM dual;

SELECT TRIM(BOTH '#'FROM '##*1PASWORD#*##')AS COOL FROM dual;

SELECT replace('promotion','o','0')AS cool FROM dual;

SELECT REPLACE('This is a basic course','basic','advanced')AS COOL FROM dual;

CREATE TABLE departments 
(
dept_name VARCHAR(20)

);

INSERT INTO departments(dept_name)
VALUES ('BMW');

INSERT INTO departments(dept_name)
VALUES ('SUPRA');

INSERT INTO departments(dept_name)
VALUES ('TOYTA');

SELECT dept_name,
       LPAD('MY NAME IS ' || dept_name, 15, '*') AS name
FROM departments;

DROP TABLE EMPLOYEE;
CREATE TABLE EMPLOYEE (
    emp_id     NUMBER,
    emp_name   VARCHAR2(50),
    hire_date  DATE
);

INSERT INTO EMPLOYEE (emp_id, emp_name, hire_date)
VALUES (1, 'EMAD', DATE '2024-01-15');

SELECT hire_date,TO_CHAR(hire_date,'DD-MON-YYYY')AS "formated date" FROM EMPLOYEE;

SELECT hire_date,TO_CHAR(hire_date,'Day, Month YYYY')AS "formated date" FROM EMPLOYEE;

SELECT TO_CHAR(12345.67, '99,999.99') AS formatted_number
FROM dual;

SELECT TO_CHAR(12345.67, 'L9,999.99') AS formatted_salary
FROM dual;

SELECT hire_date,TO_CHAR(hire_date,'YYYY/MM/DD  HH24:MI:SS.')AS "FORMATED DATE" FROM EMPLOYEE;

DROP TABLE STUDENT
CREATE TABLE STUDENT
(
name VARCHAR(50),
score NUMBER,
hire_date DATE
);

INSERT INTO STUDENT VALUES ('EMAD', 95, DATE '2024-06-01');
INSERT INTO STUDENT VALUES ('AHMED', 88, DATE '2024-06-01');
INSERT INTO STUDENT VALUES ('OMAR', 76, DATE '2024-06-02');
INSERT INTO STUDENT VALUES ('SARA', 69, DATE '2024-06-02');
INSERT INTO STUDENT VALUES ('LAILA', 82, DATE '2024-06-03');

SELECT name,score,
   CASE 
   	WHEN score>=90 THEN 'A'
   	WHEN score>=80 THEN 'B'
   	WHEN score>=70 THEN 'C'
   	ELSE 'F'
   END 
   AS grade FROM STUDENT;


SELECT name,score,
   CASE 
   	WHEN score>=90 THEN 'A'
   	WHEN score>=80 THEN 'B'
   	WHEN score>=70 THEN 'C'
   WHEN score>=60 THEN 'Pass'
   ELSE 'Fail'
   END 
   AS grade FROM STUDENT;


SELECT name,score,
   CASE 
   	WHEN score>=90 THEN 'Excellent'
   	WHEN score>=80 THEN 'Good'
   	WHEN score>=70 THEN 'Average'
   ELSE 'Needs Improvement'
   END 
   AS grade FROM STUDENT;


SELECT CASE TO_CHAR(SYSDATE, 'DAY')
         WHEN 'SUNDAY   '   THEN 'Today is Sunday'
         WHEN 'MONDAY   '   THEN 'Today is Monday'
         WHEN 'TUESDAY  '   THEN 'Today is Tuesday'
         WHEN 'WEDNESDAY'   THEN 'Today is Wednesday'
         WHEN 'THURSDAY '   THEN 'Today is Thursday'
         WHEN 'FRIDAY   '   THEN 'Today is Friday'
         WHEN 'SATURDAY '   THEN 'Today is Saturday'
       END AS today_message
FROM dual;


SELECT name,score,DECODE(score,score>=90,'A',score>=80,'B',score>=70,'C',score>=60,'D','F')AS grade FROM STUDENT;

CREATE TABLE status_log
(
status_code VARCHAR(50)

);
INSERT INTO status_log(status_code)
VALUES ('N');

INSERT INTO status_log(status_code)
VALUES ('I');

INSERT INTO status_log(status_code)
VALUES ('C');

SELECT status_code,
  DECODE(status_code,'N','New',
  'I','In Progress',
  'C','Completed'
  )
  AS CODE FROM status_log;

DROP TABLE PRODUCT;
CREATE TABLE PRODUCT
(
quantity VARCHAR(50)
);
INSERT INTO PRODUCT(quantity)
VALUES(0);

SELECT quantity,
  DECODE(quantity,0,'Out of Stock','Available')
  AS quantity_product FROM PRODUCT;

CREATE TABLE PRODUCTS (
    product_name VARCHAR2(50),
    price        NUMBER(8,2),
    category     VARCHAR2(30)
);
INSERT INTO PRODUCTS VALUES ('Laptop', 25000.50, 'HR');
INSERT INTO PRODUCTS VALUES ('Mobile', 15000.00, 'HR');
INSERT INTO PRODUCTS VALUES ('Chair', 1200.75, 'Sales');
INSERT INTO PRODUCTS VALUES ('Desk', 3500.00, 'IT');
INSERT INTO PRODUCTS VALUES ('T-Shirt', 450.25, 'Clothing');

SELECT product_name,price,category,
  DECODE(category,'HR',price+500,
  'Sales',price+1500,
  'IT',price+1000
  ,price+300
  ) AS salary FROM PRODUCTS;



