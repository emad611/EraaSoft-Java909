SELECT e.employee_name, m.employee_name AS manager_name
FROM employees e
JOIN employees m
ON e.manager_id = m.employee_id;

SELECT c.name AS customer_name , s.name AS salesperson_name
FROM CUSTOMERS c
JOIN employees s
ON c.salesperson_id=s.employee_id;

SELECT o.order_id, od.product_id
FROM orders o
JOIN order_details od
ON o.order_id = od.order_id;

SELECT s.name AS student_name, i.name AS instructor_name
FROM students s
JOIN instructors i
ON s.instructor_id = i.instructor_id;

SELECT e.salary, d.budget
FROM employees e
JOIN departments d
ON e.department_id = d.department_id;

SELECT p.name AS project_name, t.name AS task_name
FROM projects p
JOIN tasks t
ON p.project_id = t.project_id;

SELECT c.date AS course_date, e.date AS exam_date
FROM courses c
JOIN exams e
ON c.course_id = e.course_id;

SELECT p.name AS product_name, c.name AS category_name
FROM products p
JOIN categories c
ON p.category_id = c.category_id;

SELECT b.title, p.name AS publisher_name
FROM books b
JOIN publishers p
ON b.publisher_id = p.publisher_id;

SELECT e.employee_name, d.location
FROM employees e
JOIN departments d
ON e.department_id = d.department_id;
