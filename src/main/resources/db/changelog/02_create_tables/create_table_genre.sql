--liquibase formatted sql
--changeset liz:create_table_genre:postgresql encoding:UTF8

create table demo.genre
(
    genre_id   serial  primary key,
    genre_name varchar(30) not null,
    genre_key  varchar(5) not null unique
);

-- grants
GRANT SELECT, INSERT, DELETE ON TABLE demo.genre TO demo;

-- comments
COMMENT
    ON TABLE demo.genre
    IS 'Genre';
COMMENT
    ON COLUMN demo.genre.genre_id
    IS 'Unique identification';
COMMENT
    ON COLUMN demo.genre.genre_name
    IS 'Genre name';
COMMENT
    ON COLUMN demo.genre.genre_key
    IS 'Genre key used for translation';

-- rollback  DROP TABLE demo.genre;