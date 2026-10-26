-- Решения блока 3. Сначала выполни setup.sql (3.1) или bank-schema.sql (3.2).

-- ===========================================================================
-- 3.1 · users и orders (setup.sql)
-- ===========================================================================

-- 1. Пользователи на «Б»: Борис, Богдан, Белла, Борислав
SELECT *
FROM users
WHERE name LIKE 'Б%';

-- 2. Заказы дороже 1000 по убыванию, не больше пяти: заказы 3 и 1
SELECT *
FROM orders
WHERE amount > 1000
ORDER BY amount DESC
LIMIT 5;

-- 3. Заказы с именами пользователей: три строки, пользователи без заказов не попадут
SELECT o.id, o.amount, o.status, u.name
FROM orders o
INNER JOIN users u ON o.user_id = u.id;

-- Доп. вопрос: оконная функция, номер заказа у каждого пользователя
SELECT user_id, amount,
       ROW_NUMBER() OVER (PARTITION BY user_id ORDER BY amount DESC) AS rn
FROM orders;


-- ===========================================================================
-- 3.2 · JOIN без WHERE (bank-schema.sql)
-- Ожидается: INSURANCE и CARD
-- ===========================================================================

-- Вариант 1: цепочка LEFT JOIN + HAVING
SELECT pt.product_type_cd, pt.name
FROM product_type pt
LEFT JOIN product p    ON p.product_type_cd = pt.product_type_cd
LEFT JOIN account a    ON a.product_cd = p.product_cd
LEFT JOIN employee e   ON e.emp_id = a.open_emp_id
LEFT JOIN department d ON d.dept_id = e.dept_id
GROUP BY pt.product_type_cd, pt.name
HAVING COUNT(d.dept_id) = 0;

-- Вариант 2: вычитание множеств
SELECT product_type_cd FROM product_type
EXCEPT
SELECT p.product_type_cd
FROM product p
JOIN account a    ON a.product_cd = p.product_cd
JOIN employee e   ON e.emp_id = a.open_emp_id
JOIN department d ON d.dept_id = e.dept_id;
