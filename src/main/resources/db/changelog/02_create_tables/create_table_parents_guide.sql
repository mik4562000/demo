--liquibase formatted sql
--changeset liz:create_table_parents_guide:postgresql encoding:UTF8

create table demo.parents_guide
(
    pg_id   serial primary key,
    pg_name varchar(50) not null,
    pg_age  integer     not null
);

-- grants
GRANT SELECT, INSERT, DELETE ON TABLE demo.parents_guide TO demo;

-- comments
COMMENT
    ON TABLE demo.parents_guide
    IS 'Parents guide restriction';
COMMENT
    ON COLUMN demo.parents_guide.pg_id
    IS 'Unique identification';
COMMENT
    ON COLUMN demo.parents_guide.pg_name
    IS 'Restriction name';
COMMENT
    ON COLUMN demo.parents_guide.pg_age
    IS 'Restriction age';

-- rollback  DROP TABLE demo.parents_guide;