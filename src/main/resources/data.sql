INSERT INTO role (ROLE_ID, NAME, DESCRIPTION)
VALUES (1, 'ADMIN', 'This role type allows to perform any action in the application');
INSERT INTO role (ROLE_ID, NAME, DESCRIPTION)
VALUES (2, 'STUDENT', 'This tole type is limited');

INSERT INTO permission (PERMISSION_ID, NAME)
VALUES (1, 'admin:read');
INSERT INTO permission (PERMISSION_ID, NAME)
VALUES (2, 'admin:write');
INSERT INTO permission (PERMISSION_ID, NAME)
VALUES (3, 'student:read');
INSERT INTO permission (PERMISSION_ID, NAME)
VALUES (4, 'student:write');

INSERT INTO role_permission (ROLE_ID, PERMISSION_ID)
VALUES (1, 1);
INSERT INTO role_permission (ROLE_ID, PERMISSION_ID)
VALUES (1, 2);
INSERT INTO role_permission (ROLE_ID, PERMISSION_ID)
VALUES (2, 3);
INSERT INTO role_permission (ROLE_ID, PERMISSION_ID)
VALUES (2, 4);

INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES (1, 1, 'Bob', 'Smith', 'alloy123', 'password', 'koka@gmail.com');
INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES (2, 1, 'Mark', 'Jhonson', 'tetris21', 'passWo77', 'gmail@gmail.com');

INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES (3, 2, 'Maria', 'Nebora', 'studentRole87', '123PassS', 'ma_7@gmail.com');
INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES (4, 2, 'Anna', 'Yablovski', 'tentacle', 'password123', 'email@gmail.com');
INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES (5, 2, 'Garry', 'Smith', 'check456', 'truePass87', 'ma_PassGOD@gmail.com');
INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES (6, 2, 'Vanessa', 'Iordano', 'grasp_body89', 'check56321', 'myQueryE@gmail.com');
INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES (7, 2, 'Robert', 'Jons', 'spider897_tRue', 'theBestPassword87', 'maOverTor@gmail.com');
INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES (8, 2, 'Bridget', 'Salovski', 'Salovski78', 'passWordWord45', 'trueBody@gmail.com');
INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES (9, 2, 'Draik', 'Robertson', 'pirat1020', 'password987', 'pirat@gmail.com');
INSERT INTO user (USER_ID, ROLE_ID, FIRST_NAME, LAST_NAME, LOGIN, PASSWORD, EMAIL)
VALUES (10, 2, 'Georgiy', 'Rudkovskiy', 'rusUk85', 'passGo_Re852', 'chernCom@gmail.com');