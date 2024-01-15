--liquibase formatted sql
--changeset liz:create_table_genre:postgresql encoding:UTF8

create table demo.country
(
    country_id   serial primary key,
    country_name varchar(50) not null
);

-- grants
GRANT SELECT, INSERT, DELETE ON TABLE demo.country TO demo;

-- comments
COMMENT
    ON TABLE demo.country
    IS 'Country';
COMMENT
    ON COLUMN demo.country.country_id
    IS 'Unique identification';
COMMENT
    ON COLUMN demo.country.country_name
    IS 'Country name';

-- rollback  DROP TABLE demo.country;