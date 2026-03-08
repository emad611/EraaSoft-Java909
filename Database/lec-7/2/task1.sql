SELECT e.employee_name,d.department_name
FROM employee e LEFT JOIN DEPARTMENTS d 
ON e.department_id=d.department_id;

SELECT p.product_name, c.category_name
FROM products p
LEFT JOIN categories c
ON p.category_id = c.category_id;

SELECT s.student_name, c.course_name
FROM students s
LEFT JOIN enrollments e
ON s.student_id = e.student_id
LEFT JOIN courses c
ON e.course_id = c.course_id;

--m->m

SELECT o.order_id, c.customer_name
FROM orders o
LEFT JOIN customers c
ON o.customer_id = c.customer_id;

SELECT d.department_name, e.employee_name AS manager_name
FROM departments d
LEFT JOIN employees e
ON d.manager_id = e.employee_id;

SELECT b.book_title, a.author_name
FROM books b
LEFT JOIN authors a
ON b.author_id = a.author_id;


SELECT i.invoice_id, p.payment_status
FROM invoices i
LEFT JOIN payments p
ON i.invoice_id = p.invoice_id;

SELECT e.employee_name, p.project_name
FROM employees e
LEFT JOIN projects_assigned pa
ON e.employee_id = pa.employee_id
LEFT JOIN projects p
ON pa.project_id = p.project_id;