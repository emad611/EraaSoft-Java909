SELECT d.department_name, e.employee_name
FROM employees e
RIGHT JOIN departments d
ON e.department_id = d.department_id;

SELECT c.customer_name, o.order_id
FROM orders o
RIGHT JOIN customers c
ON o.customer_id = c.customer_id;

SELECT c.course_name, s.student_name
FROM enrollments e
RIGHT JOIN courses c
ON e.course_id = c.course_id
LEFT JOIN students s
ON e.student_id = s.student_id;

SELECT p.project_name, e.employee_name
FROM employees e
RIGHT JOIN projects p
ON e.project_id = p.project_id;

SELECT pm.payment_method, t.transaction_id
FROM transactions t
RIGHT JOIN payment_methods pm
ON t.payment_method_id = pm.payment_method_id;

SELECT pm.payment_method, t.transaction_id
FROM transactions t
RIGHT JOIN payment_methods pm
ON t.payment_method_id = pm.payment_method_id;

SELECT a.author_name, b.book_title
FROM books b
RIGHT JOIN authors a
ON b.author_id = a.author_id;

SELECT c.category_name, p.product_name
FROM products p
RIGHT JOIN categories c
ON p.category_id = c.category_id;

SELECT d.room_number, s.student_name
FROM students s
RIGHT JOIN dorm_rooms d
ON s.room_id = d.room_id;
