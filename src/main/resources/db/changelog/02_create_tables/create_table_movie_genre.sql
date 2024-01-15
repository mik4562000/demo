--liquibase formatted sql
--changeset liz:create_table_movie_genre:postgresql encoding:UTF8

create table demo.movie_genre
(
    movie_id integer not null
        references demo.movie,
    genre_id integer not null
        references demo.genre,
    primary key (movie_id, genre_id)
);

-- grants
GRANT SELECT, INSERT, DELETE ON TABLE demo.movie_genre TO demo;

-- comments
COMMENT
    ON TABLE demo.movie_genre
    IS 'Genre of movie';
COMMENT
    ON COLUMN demo.movie_genre.movie_id
    IS 'Movie identification';
COMMENT
    ON COLUMN demo.movie_genre.genre_id
    IS 'Genre identification';

-- rollback  DROP TABLE demo.movie_genre;