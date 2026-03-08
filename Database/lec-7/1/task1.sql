SELECT employee_name, department_name
FROM employees
NATURAL JOIN department;

SELECT order_id,customer_name,
FROM employees
NATURAL JOIN department;

SELECT student_name, course_name
FROM student
NATURAL JOIN courses;

SELECT project_name, employee_name
FROM project
NATURAL JOIN employees;

SELECT invoice_id, product_name
FROM invoice
NATURAL JOIN product;

SELECT book_name, author_name
FROM books
NATURAL JOIN authors;


SELECT schedule_id, instructor_name
FROM class_schedule
NATURAL JOIN instructors;

SELECT supplier_name, product_name
FROM suppliers
NATURAL JOIN products;

SELECT order_id, shipping_details
FROM orders
NATURAL JOIN shipping;

SELECT employee_name, job_title
FROM employees
NATURAL JOIN jobs;