SELECT name_employee FROM EMPLOYEE WHERE 
salary> (SELECT avg(salary) FROM EMPLOYEE); 

SELECT customer_id
FROM ORDERS 
GROUP BY customer_id
HAVING COUNT(*)(
SELECT MAX(cnt) FROM  (
SELECT count(*)cnt 
FROM ORDERS 
GROUP BY customer_id
)
);

SELECT product_id
FROM products
WHERE price > ANY (
    SELECT price_product
    FROM products
    WHERE product_name = 'Accessories'
);

SELECT employee_name
FROM employee
WHERE department_id = (
    SELECT department_id
    FROM employee
    WHERE employee_name = 'John Smith'
);

SELECT order_id
FROM orders
WHERE customer_id IN (
    SELECT customer_id
    FROM customers
    WHERE city = 'New York'
);

SELECT d.department_id,d.department_name
FROM department d
WHERE NOT EXISTS (
SELECT 1
FROM employee e
WHERE e.department_id=d.department_id
);

SELECT s.student_id, s.student_name
FROM students s
WHERE NOT EXISTS (
    SELECT 1
    FROM enrollments e
    WHERE e.student_id = s.student_id
);

SELECT MAX(salary)
FROM employees
WHERE salary < (
    SELECT MAX(salary)
    FROM employees
);

SELECT p.product_name FROM products p
WHERE p.price>(
SELECT avg(price)FROM products);


SELECT c.customer_id, c.customer_name
FROM customers c
WHERE NOT EXISTS (
    SELECT 1
    FROM products p
    WHERE p.category = 'A'
      AND NOT EXISTS (
          SELECT 1
          FROM orders o
          WHERE o.customer_id = c.customer_id
            AND o.product_id = p.product_id
      )
);


