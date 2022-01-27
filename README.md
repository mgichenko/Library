# Library
Library Management System
The library management system is a system that keeps record of books that the library offers. 
The books are divided into categories according to the genre they belong to. The members have
cards with unique number so that they can be identified. The books that are no longer available
can be removed and new books can also be added.
This way the system allows a simple organized library, that is available to people in an easy way.
The programming language used is JAVA, and a database in My SQL Server using XAMPP.

Requests:
GET requests
“/book” – retrieves a list of all books in library;
“/book/{category}” – retrieves the books from the specified category;
“/book/{id} – retrieves the books from the specified id;
“/category” – retrieves all categories
“/category/ordered” – retrieves all categories in an ascending order

POST requests
“/book” – inputs a book

DELETE requests
“/book/{id}” – deletes a book by id

DEPENDENCIES
•	spring-boot-starter-data-jpa
•	spring-boot-starter-web
•	spring-boot-starter-test
•	mysql-connector-java


DDL
CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `title` text NOT NULL,
  `author` text NOT NULL,
  `publisher` text NOT NULL,
  `category_id` int(11) DEFAULT NULL
);



CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL
);

ALTER TABLE `book`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Category` (`category_id`);

ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

ALTER TABLE `book`
  ADD CONSTRAINT `FK_Category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);
COMMIT;
