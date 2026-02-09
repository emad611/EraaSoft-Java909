DROP TABLE Employee;

CREATE TABLE Employee
(
    id NUMBER PRIMARY KEY,
    name VARCHAR2(55) UNIQUE,
    age NUMBER
);

CREATE TABLE Phone
(
    id NUMBER PRIMARY KEY,
    phoneNumber NUMBER,
    employee_id NUMBER UNIQUE NOT NULL,

    CONSTRAINT phone_employee_fk
        FOREIGN KEY (employee_id)
        REFERENCES Employee(id)
);