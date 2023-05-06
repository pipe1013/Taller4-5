CREATE DATABASE MyApp;
USE MyApp;

CREATE TABLE users_tbl (
  `user_id` int,
  `user_firstname` varchar(40) NOT NULL,
  `user_lastname` varchar(40) NOT NULL,
  `user_email` varchar(60) NOT NULL,
  `user_password` varbinary(255) NOT NULL,
  PRIMARY KEY (`user_id`)
);
INSERT INTO MyApp.users_tbl(user_firstname,user_lastname,user_email,user_password) VALUES (UPPER("nombres"),UPPER('apellidos'), 'buzon@correo.com',
AES_ENCRYPT('password', '$2a$12$uG/gUt5JMFFFU0Su4gLAvuizXe/dgLfZZ8j7BGWekd4whP7I82DoK'));
SELECT *,
 CAST(AES_DECRYPT(user_password,
'$2a$12$uG/gUt5JMFFFU0Su4gLAvuizXe/dgLfZZ8j7BGWekd4whP7I82DoK') AS CHAR(50))
end_data FROM users_tbl WHERE user_id = 1;
select * from users_tbl;

