--liquibase formatted sql
--changeset liz:fill_table_movie_genre:postgresql encoding:UTF8

INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (6, 1);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (6, 2);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (1, 3);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (2, 3);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (2, 4);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (7, 5);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (7, 4);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (7, 3);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (7, 6);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (8, 3);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (8, 4);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (11, 7);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (11, 3);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (11, 8);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (13, 5);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (13, 3);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (13, 9);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (13, 10);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (3, 3);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (3, 4);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (12, 5);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (12, 9);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (12, 3);
INSERT INTO demo.movie_genre (movie_id, genre_id) VALUES (12, 10);

-- rollback  truncate TABLE demo.movie_genre;