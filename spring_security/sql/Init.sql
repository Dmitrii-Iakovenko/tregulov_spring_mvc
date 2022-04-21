DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    username varchar(15),
    password varchar(100),
    enabled  smallint,
    PRIMARY KEY (username)
);

CREATE TABLE authorities
(
    username  varchar(15),
    authority varchar(25),
    FOREIGN KEY (username) references users (username)
);

insert into users (username, password, enabled)
VALUES ('Заур', '{noop}Заур', 1),
       ('Елена', '{noop}Елена', 1),
       ('Иван', '{noop}Иван', 1);

insert into authorities (username, authority)
VALUES ('Заур', 'ROLE_EMPLOYEE'),
       ('Елена', 'ROLE_HR'),
       ('Иван', 'ROLE_HR'),
       ('Иван', 'ROLE_MANAGER');


-- update users
-- set password = '{bcrypt}$2a$12$oITtotz6Y0YYhG2QPRAVgeUNofNprgi1cJSQ8UlZ9sBSvcvdNCgG.'
-- where username = 'Иван';