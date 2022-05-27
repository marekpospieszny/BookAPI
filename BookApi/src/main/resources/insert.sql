CREATE SCHEMA IF NOT EXISTS `workshop-hibernate` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `workshop-hibernate`;
CREATE TABLE books (
  id        int not null auto_increment,
  author    varchar(255) null,
  isbn      varchar(255) null,
  publisher varchar(255) null,
  title     varchar(255) null,
  type      varchar(255) null,
  PRIMARY KEY (id)
);
# Add books:
INSERT INTO books (author, isbn, publisher, title, type) VALUES ('Andrzej Sapkowski','9788375780635','Supernova','Wiedzmin','fantasy');
INSERT INTO books (author, isbn, publisher, title, type) VALUES ('Remigiusz Mróz','9781234567897','Helion','Kasacja','crime');
INSERT INTO books (author, isbn, publisher, title, type) VALUES ('Jacek Placek','9782123456803','Itaka','Przepisy na dobry dzień','cooking');