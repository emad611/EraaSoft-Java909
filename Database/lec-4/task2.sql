
SELECT REPLACE('ahmed','a','@') FROM dual;

SELECT REPLACE('my car is old ','old','new')FROM dual;

CREATE TABLE PRODUCT
(
product_name VARCHAR(50)
);
INSERT INTO PRODUCT (product_name)
VALUES ('BMW');

INSERT INTO PRODUCT (product_name )
VALUES ('SUPRA');

INSERT INTO PRODUCT (product_name )
VALUES ('TOYTA');

SELECT product_name ,LPAD('MY NAME IS '||product_name,15,'*') AS fullname
FROM PRODUCT;


SELECT product_name ,RPAD('MY NAME IS '||product_name,15,'*') AS fullname
FROM PRODUCT;
