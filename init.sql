CREATE DATABASE IF NOT EXISTS pspims;

CREATE USER IF NOT EXISTS 'springuser'@'localhost' IDENTIFIED BY 'password';

GRANT ALL PRIVILEGES ON pspims.* TO 'springuser'@'localhost';

FLUSH PRIVILEGES;
