--liquibase formatted sql
--changeset liz:fill_table_movie:postgresql encoding:UTF8

INSERT INTO demo.movie (movie_id, movie_name, release_year, pg_id, country_id) VALUES (1, 'The Shawshank Redemption', 1994, 1, 1);
INSERT INTO demo.movie (movie_id, movie_name, release_year, pg_id, country_id) VALUES (2, 'The Godfather', 1972, 1, 1);
INSERT INTO demo.movie (movie_id, movie_name, release_year, pg_id, country_id) VALUES (8, '12 Angry Men', 1957, 1, 1);
INSERT INTO demo.movie (movie_id, movie_name, release_year, pg_id, country_id) VALUES (11, 'Schindler''s List', 1993, 1, 1);
INSERT INTO demo.movie (movie_id, movie_name, release_year, pg_id, country_id) VALUES (3, 'Pulp Fiction', 1994, 2, 1);
INSERT INTO demo.movie (movie_id, movie_name, release_year, pg_id, country_id) VALUES (6, 'Scream', 1999, 2, 1);
INSERT INTO demo.movie (movie_id, movie_name, release_year, pg_id, country_id) VALUES (7, 'The Dark Knight', 2008, 3, 1);
INSERT INTO demo.movie (movie_id, movie_name, release_year, pg_id, country_id) VALUES (12, 'The Lord of the Rings: The Fellowship of the Ring', 2001, 4, 1);
INSERT INTO demo.movie (movie_id, movie_name, release_year, pg_id, country_id) VALUES (13, 'The Lord of the Rings: The Return of the King', 2003, 4, 1);

SELECT setval('demo.movie_movie_id_seq', 13, true);

-- rollback  truncate TABLE demo.movie;
-- rollback  SELECT setval('demo.movie_movie_id_seq', 1, true);