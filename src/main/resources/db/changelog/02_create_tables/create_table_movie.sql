--liquibase formatted sql
--changeset liz:create_table_movie:postgresql encoding:UTF8

create table demo.movie
(
    movie_id     serial primary key,
    movie_name   varchar(100) not null,
    release_year integer,
    pg_id        integer
        constraint fk_pg
            references demo.parents_guide,
    country_id   integer
        constraint fk_country
            references demo.country
);

-- grants
GRANT SELECT, INSERT, DELETE ON TABLE demo.movie TO demo;

-- comments
COMMENT
    ON TABLE demo.movie
    IS 'Movie';
COMMENT
    ON COLUMN demo.movie.movie_id
    IS 'Unique identification';
COMMENT
    ON COLUMN demo.movie.movie_name
    IS 'Movie name';
COMMENT
    ON COLUMN demo.movie.release_year
    IS 'Release year';
COMMENT
    ON COLUMN demo.movie.country_id
    IS 'Country identification';
COMMENT
    ON COLUMN demo.movie.pg_id
    IS 'Age restriction identification';

-- rollback  DROP TABLE demo.movie;