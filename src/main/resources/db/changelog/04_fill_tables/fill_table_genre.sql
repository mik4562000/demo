--liquibase formatted sql
--changeset liz:fill_table_genre:postgresql encoding:UTF8

INSERT INTO demo.genre (genre_id, genre_name, genre_key) VALUES (1, 'Horror', 'hrr');
INSERT INTO demo.genre (genre_id, genre_name, genre_key) VALUES (2, 'Mystery', 'mst');
INSERT INTO demo.genre (genre_id, genre_name, genre_key) VALUES (3, 'Drama', 'drm');
INSERT INTO demo.genre (genre_id, genre_name, genre_key) VALUES (4, 'Crime', 'crm');
INSERT INTO demo.genre (genre_id, genre_name, genre_key) VALUES (5, 'Action', 'act');
INSERT INTO demo.genre (genre_id, genre_name, genre_key) VALUES (6, 'Thriller', 'thr');
INSERT INTO demo.genre (genre_id, genre_name, genre_key) VALUES (7, 'Biography', 'bio');
INSERT INTO demo.genre (genre_id, genre_name, genre_key) VALUES (8, 'History', 'hst');
INSERT INTO demo.genre (genre_id, genre_name, genre_key) VALUES (9, 'Adventure', 'adv');
INSERT INTO demo.genre (genre_id, genre_name, genre_key) VALUES (10, 'Fantasy', 'fnt');

SELECT setval('demo.genre_genre_id_seq', 10, true);

-- rollback  truncate TABLE demo.genre;
-- rollback  SELECT setval('demo.genre_genre_id_seq', 1, true);