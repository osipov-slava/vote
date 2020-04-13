DELETE FROM votes;
DELETE FROM menus;
DELETE FROM dishes;
DELETE FROM restaurants;
DELETE FROM user_roles;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
    ('User', 'user@yandex.ru', 'password'), --100000
    ('Admin', 'admin@gmail.com', 'admin'), --100001
    ('User2', 'user2@yandex.ru', 'password'), --100002
    ('User3', 'user3@yandex.ru', 'password'); --100003

INSERT INTO user_roles (role, user_id) VALUES

    ('ROLE_USER', 100000),
    ('ROLE_ADMIN', 100001),
    ('ROLE_USER', 100001),
    ('ROLE_USER', 100002),
    ('ROLE_USER', 100003);

INSERT INTO restaurants (name)
VALUES ('Royal Palace'),--100004
       ('Castle Wall'),--100005
       ('Uncle Вася');--100006

INSERT INTO dishes (name, price)
VALUES ('Салат Столичный',350),--100007
       ('Борщ Сибирский с фасолью',590),--100008
       ('Куринные биточки',690),--100009
       ('Рис Микс',200),--100010

       ('Салат Карелия',220),--100011
       ('Суп Лапша по домашнему',450),--100012
       ('Зразы мясные с томатным соусом',470),--100013
       ('Греча',90),--1000014

       ('Салат Оливье',70),--1000015
       ('Суп Гороховый с копченностями',90),--100016
       ('Поджарка из свинины',160),--100017
       ('Макароны',50);--100018

INSERT INTO menus (restaurant_id, dish_id)
VALUES (100004, 100007), --100019
       (100004, 100008), --100020
       (100004, 100009),--100021
       (100004, 100010);--100022

--Old dates
INSERT INTO votes (date, user_id, restaurant_id)
VALUES ('2020-04-07', 100000, 100005),--100023
       ('2020-04-07', 100001, 100005),--100024
       ('2020-04-07', 100002, 100005);--100025

--Current date
INSERT INTO votes (user_id, restaurant_id)
VALUES (100000, 100004),--100026
       (100001, 100005);--100027
