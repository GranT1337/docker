DROP TABLE IF EXISTS film;
create table film
(
   id serial PRIMARY KEY,
   title varchar(255),
   producer varchar(255),
   points double precision
);