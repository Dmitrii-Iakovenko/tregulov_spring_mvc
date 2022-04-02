DROP TABLE IF EXISTS employees;

CREATE TABLE employees
(
    id         bigserial PRIMARY KEY,
    name       varchar(15),
    surname    varchar(25),
    department varchar(20),
    salary     int
);



INSERT INTO employees (name, surname, department, salary)
VALUES ('Zaur', 'Tregulov', 'IT', 500),
       ('Oleg', 'Ivanov', 'Sales', 700),
       ('Nina', 'Sidorova', 'HR', 850);



-- CREATE TABLE example
-- (
--     a integer,
--     b integer,
--     c integer,
--     PRIMARY KEY (a, c)
-- );
