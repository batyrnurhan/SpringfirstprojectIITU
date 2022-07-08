DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       user_id serial primary key,
                       user_name varchar(50),
                       user_last varchar(50),
                       username varchar(50),
                       password varchar(1000),
);

DROP TABLE IF EXISTS books;

CREATE TABLE books (
                        book_id integer primary key,
                        book_name varchar(50),
                        book_genre varchar(50),
                        book_author varchar(50),
);