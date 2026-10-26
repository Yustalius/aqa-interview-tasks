-- Задача 3.1 · users и orders
-- Таблицы и данные ровно те, что в условии.

DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id    INTEGER PRIMARY KEY,
    name  VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE orders (
    id      INTEGER PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES users (id),
    amount  INTEGER NOT NULL,
    status  VARCHAR(20) NOT NULL
);

INSERT INTO users (id, name, email) VALUES
    (1, 'Борис',    'boris@test.com'),
    (2, 'Анна',     'anna@test.com'),
    (3, 'Богдан',   'bogdan@test.com'),
    (4, 'Виктор',   'victor@test.com'),
    (5, 'Белла',    'bella@test.com'),
    (6, 'Борислав', 'borislav@test.com');

INSERT INTO orders (id, user_id, amount, status) VALUES
    (1, 1, 1500, 'PAID'),
    (2, 2,  500, 'CREATED'),
    (3, 3, 3200, 'PAID');
