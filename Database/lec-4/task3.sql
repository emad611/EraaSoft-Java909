
CREATE TABLE EMPLOYEE (
    emp_id     NUMBER,
    emp_name   VARCHAR2(50),
    hire_date  DATE
);

INSERT INTO EMPLOYEE (emp_id, emp_name, hire_date)
VALUES (1, 'EMAD', DATE '2024-01-15');

SELECT hire_date,
       TO_CHAR(hire_date,'DD MON YYYY') AS "formatted_date"
FROM EMPLOYEE;

SELECT hire_date,TO_CHAR(hire_date,'Month YYYY') AS "formatted_date"
FROM  EMPLOYEE;

SELECT TO_CHAR(12345.67,'99,999.99') AS "formatted_date"
FROM  dual;

SELECT TO_CHAR(12345.67, 'L9,999.99') AS SALARY
FROM dual;
