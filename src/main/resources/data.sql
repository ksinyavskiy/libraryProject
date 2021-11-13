INSERT INTO role (ROLE_ID, NAME, DESCRIPTION) VALUES (1, 'ADMIN', 'This user role allows to do any action in the app');
INSERT INTO role (ROLE_ID, NAME, DESCRIPTION) VALUES (2, 'STUDENT', 'Limited user role');

INSERT INTO permission (PERMISSION_ID, NAME) VALUES (1, 'admin:read');
INSERT INTO permission (PERMISSION_ID, NAME) VALUES (2, 'admin:write');
INSERT INTO permission (PERMISSION_ID, NAME) VALUES (3, 'student:read');
INSERT INTO permission (PERMISSION_ID, NAME) VALUES (4, 'student:write');

INSERT INTO role_permission (ROLE_ID, PERMISSION_ID) VALUES (1, 1);
INSERT INTO role_permission (ROLE_ID, PERMISSION_ID) VALUES (1, 2);
INSERT INTO role_permission (ROLE_ID, PERMISSION_ID) VALUES (2, 3);
INSERT INTO role_permission (ROLE_ID, PERMISSION_ID) VALUES (2, 4);


INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES(1, 1, 'Bob', 'Smith', 'alloy123', 'password', 'koka@gmail.com');
INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES(2, 1, 'Mark', 'Jhonson', 'tetris21', 'passWo77', 'gmail@gmail.com');

INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES (3, 2, 'Maria', 'Nebora', 'studentRole87', '123PassS', 'ma_7@gmail.com');
INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES (4, 2, 'Anna', 'Yablovski', 'tentacle', 'password123', 'email@gmail.com');
INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES(5, 2, 'Garry', 'Smith', 'check456', 'truePass87', 'ma_PassGOD@gmail.com');
INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES (6, 2, 'Vanessa', 'Iordano', 'grasp_body89', 'check56321', 'myQueryE@gmail.com');
INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES(7, 2, 'Robert', 'Jons', 'spider897_tRue', 'theBestPassword87', 'maOverTor@gmail.com');
INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES (8, 2, 'Bridget', 'Salovski', 'Salovski78', 'passWordWord45', 'trueBody@gmail.com');
INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES(9, 2, 'Draik', 'Robertson', 'pirat1020', 'password987', 'pirat@gmail.com');
INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES (10, 2, 'Georgiy', 'Rudkovskiy', 'rusUk85', 'passGo_Re852', 'chernCom@gmail.com');

/* authors */
INSERT INTO author(AUTHOR_ID, LAST_NAME, FIRST_NAME, NICK_NAME, BIRTH_DATE)
VALUES (1, 'Толстой', 'Лев', null, '1828-09-28');
INSERT INTO author(AUTHOR_ID, LAST_NAME, FIRST_NAME, NICK_NAME, BIRTH_DATE)
VALUES (2, 'Булгаков', 'Михаил', null, '1891-06-15');
INSERT INTO author(AUTHOR_ID, LAST_NAME, FIRST_NAME, NICK_NAME, BIRTH_DATE)
VALUES (3, 'Чехов', 'Антон', 'Антоша Чехонте', '1860-01-29');
INSERT INTO author(AUTHOR_ID, LAST_NAME, FIRST_NAME, NICK_NAME, BIRTH_DATE)
VALUES (4, 'Достоевский', 'Федор', 'Друг Козьмы Пруткова', '1821-11-11');
INSERT INTO author(AUTHOR_ID, LAST_NAME, FIRST_NAME, NICK_NAME, BIRTH_DATE)
VALUES (5, 'Есенин', 'Сергей', null, '1895-10-03');

/* genres */
INSERT INTO genre(GENRE_ID, NAME, DESCRIPTION)
VALUES(1, 'Роман-эпопея',
 'Обширное эпическое повествование в стихах или прозе о выдающихся национально-исторических событиях');

 /* books */
 INSERT INTO book(BOOK_ID, NAME, PUBLISH_YEAR, AUTHOR_ID, GENRE_ID)
 VALUES(1, 'Война и мир', 1865, 1, 1);