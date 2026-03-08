SELECT c.customer_name, o.order_id
FROM customers c
FULL OUTER JOIN orders o
ON c.customer_id = o.customer_id;

SELECT e.employee_name, p.project_name
FROM employees e
FULL OUTER JOIN projects p
ON e.project_id = p.project_id;

SELECT p.product_name, s.supplier_name
FROM products p
FULL OUTER JOIN suppliers s
ON p.supplier_id = s.supplier_id;

SELECT s.student_name, c.course_name
FROM students s
FULL OUTER JOIN enrollments e
ON s.student_id = e.student_id
FULL OUTER JOIN courses c
ON e.course_id = c.course_id;

SELECT a.author_name, b.book_title
FROM authors a
FULL OUTER JOIN books b
ON a.author_id = b.author_id;

SELECT e.employee_name, d.department_name
FROM employees e
FULL OUTER JOIN departments d
ON e.department_id = d.department_id;

SELECT t.transaction_id, pm.payment_method
FROM transactions t
FULL OUTER JOIN payment_methods pm
ON t.payment_method_id = pm.payment_method_id;

SELECT r1.customer_name, r2.customer_name
FROM customers_region1 r1
FULL OUTER JOIN customers_region2 r2
ON r1.customer_id = r2.customer_id;
