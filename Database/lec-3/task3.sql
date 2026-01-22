DROP TABLE employees;

CREATE TABLE employees (
    emp_id NUMBER PRIMARY KEY,
    first_name VARCHAR2(50),
    last_name VARCHAR2(50),
    jop_id VARCHAR2(50),
    salary NUMBER(10,2),
    manager_id NUMBER,
    hire_date DATE 
);

INSERT INTO employees VALUES (100, 'Steven', 'King',     'AD_PRES', 24000, NULL, TO_DATE('17-06-2003','DD-MM-YYYY'));
INSERT INTO employees VALUES (101, 'Neena',  'Kochhar',  'AD_VP',    17000, 100,  TO_DATE('21-09-2005','DD-MM-YYYY'));
INSERT INTO employees VALUES (102, 'Lex',    'De Haan',  'AD_VP',    17000, 100,  TO_DATE('13-01-2001','DD-MM-YYYY'));
INSERT INTO employees VALUES (103, 'Alexander','Hunold', 'IT_PROG',  9000,  102,  TO_DATE('03-01-2006','DD-MM-YYYY'));
INSERT INTO employees VALUES (104, 'Bruce',  'Ernst',    'IT_PROG',  6000,  103,  TO_DATE('21-05-2007','DD-MM-YYYY'));
INSERT INTO employees VALUES (105, 'David',  'Austin',   'IT_PROG',  4800,  103,  TO_DATE('25-06-2005','DD-MM-YYYY'));
INSERT INTO employees VALUES (106, 'Valli',  'Pataballa','IT_PROG',  4800,  103,  TO_DATE('05-02-2006','DD-MM-YYYY'));
INSERT INTO employees VALUES (107, 'Diana',  'Lorentz',  'IT_PROG',  4200,  103,  TO_DATE('07-02-2007','DD-MM-YYYY'));
INSERT INTO employees VALUES (108, 'Nancy',  'Greenberg','FI_MGR',   12000, 101,  TO_DATE('02-08-2005','DD-MM-YYYY'));
INSERT INTO employees VALUES (109, 'Daniel', 'Faviet',   'FI_ACCOUNT',9000, 108, TO_DATE('16-08-2007','DD-MM-YYYY'));
INSERT INTO employees VALUES (110, 'John',   'Chen',     'FI_ACCOUNT',8200, 108, TO_DATE('28-09-2005','DD-MM-YYYY'));
INSERT INTO employees VALUES (111, 'Ismael', 'Sciarra',  'FI_ACCOUNT',7700, 108, TO_DATE('30-09-2005','DD-MM-YYYY'));
INSERT INTO employees VALUES (112, 'Jose',   'Manuel',   'FI_ACCOUNT',7800, 108, TO_DATE('07-03-2006','DD-MM-YYYY'));
INSERT INTO employees VALUES (113, 'Luis',   'Popp',     'FI_ACCOUNT',6900, 108, TO_DATE('07-12-2007','DD-MM-YYYY'));
INSERT INTO employees VALUES (114, 'Den',    'Raphaely', 'PU_MAN',    11000, 100, TO_DATE('07-12-2002','DD-MM-YYYY'));
INSERT INTO employees VALUES (115, 'Alexander','Khoo',    'PU_CLERK', 3100, 114, TO_DATE('18-05-2003','DD-MM-YYYY'));
INSERT INTO employees VALUES (116, 'Shelli', 'Baida',    'PU_CLERK', 2900, 114, TO_DATE('24-12-2005','DD-MM-YYYY'));
INSERT INTO employees VALUES (117, 'Sigal',  'Tobias',   'PU_CLERK', 2800, 114, TO_DATE('24-12-2005','DD-MM-YYYY'));
INSERT INTO employees VALUES (118, 'Guy',    'Himuro',   'PU_CLERK', 2600, 114, TO_DATE('15-11-2006','DD-MM-YYYY'));

SELECT 1 FROM dual

SELECT *
FROM employees
WHERE emp_id BETWEEN 100 AND 105


SELECT *
FROM employees
WHERE emp_id IN(151,152,153,154,155)

SELECT *
FROM employees 
WHERE first_name LIKE 'p%'
OR first_name LIKE 'P%'


SELECT *
FROM employees 
WHERE first_name LIKE '%A'
OR first_name LIKE '%a'


SELECT *
FROM employees 
WHERE first_name LIKE '%A%'
OR first_name LIKE '%a%'


SELECT *
FROM employees 
WHERE first_name LIKE '__A%'
OR first_name LIKE '__a%'


SELECT *
FROM employees 
WHERE first_name LIKE '__E%'
OR first_name LIKE '__e%'


SELECT *
FROM employees 
WHERE manager_id IS NULL


SELECT *
FROM employees 
WHERE emp_id IS NOT NULL


INSERT INTO employees VALUES (119, 'Stee', 'posla','AD_PRES', 24000, NULL, TO_DATE('22-06-2003','DD-MM-YYYY'));


SELECT *
FROM employees
WHERE jop_id IN('AD_VP')
OR jop_id IN('IT_PROG')


SELECT *
FROM employees
ORDER BY last_name ASC

SELECT *
FROM employees
ORDER BY hire_date DESC

SELECT *
FROM employees
ORDER BY jop_id ASC,salary DESC

SELECT emp_id,
       UPPER(first_name) AS first_name_upper,
      LOWER( last_name) AS last_name_lower
      
FROM employees;

SELECT emp_id,
       INITCAP(first_name) AS first_name_cap,
       INITCAP(last_name) AS last_name_cap
FROM employees;

SELECT *
FROM  employees
WHERE UPPER(last_name)='SMITH';

SELECT *
FROM  employees
WHERE LOWER(last_name)='smith';


