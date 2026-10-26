-- Задача 3.2 · JOIN без WHERE
-- Упрощённая банковская схема: только таблицы и колонки, нужные для задачи.
--
-- Связанные с департаментами типы продуктов: ACCOUNT, LOAN.
-- Без связи: INSURANCE (продукт есть, но счетов по нему не открывали)
-- и CARD (продуктов этого типа нет вообще).

DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS product_type;

CREATE TABLE product_type (
    product_type_cd VARCHAR(20) PRIMARY KEY,
    name            VARCHAR(100) NOT NULL
);

CREATE TABLE product (
    product_cd      VARCHAR(20) PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    product_type_cd VARCHAR(20) REFERENCES product_type (product_type_cd)
);

CREATE TABLE department (
    dept_id INTEGER PRIMARY KEY,
    name    VARCHAR(100) NOT NULL
);

CREATE TABLE employee (
    emp_id  INTEGER PRIMARY KEY,
    name    VARCHAR(100) NOT NULL,
    dept_id INTEGER REFERENCES department (dept_id)
);

CREATE TABLE account (
    account_id  INTEGER PRIMARY KEY,
    product_cd  VARCHAR(20) REFERENCES product (product_cd),
    open_emp_id INTEGER REFERENCES employee (emp_id)
);

INSERT INTO product_type (product_type_cd, name) VALUES
    ('ACCOUNT',   'Счета'),
    ('LOAN',      'Кредиты'),
    ('INSURANCE', 'Страхование'),
    ('CARD',      'Карты');

INSERT INTO product (product_cd, name, product_type_cd) VALUES
    ('CHK', 'Расчётный счёт',      'ACCOUNT'),
    ('SAV', 'Сберегательный счёт', 'ACCOUNT'),
    ('MRT', 'Ипотека',             'LOAN'),
    ('LIF', 'Страхование жизни',   'INSURANCE');

INSERT INTO department (dept_id, name) VALUES
    (1, 'Операционный'),
    (2, 'Кредитный');

INSERT INTO employee (emp_id, name, dept_id) VALUES
    (10, 'Иванов',  1),
    (11, 'Петрова', 2);

INSERT INTO account (account_id, product_cd, open_emp_id) VALUES
    (100, 'CHK', 10),
    (101, 'SAV', 10),
    (102, 'MRT', 11);
