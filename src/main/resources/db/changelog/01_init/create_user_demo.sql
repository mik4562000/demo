--liquibase formatted sql
--changeset liz:create_user_demo dbms:postgresql encoding:UTF8

CREATE
    USER demo WITH
    LOGIN
    NOSUPERUSER
    NOCREATEDB
    NOCREATEROLE
    NOINHERIT
    NOREPLICATION
    PASSWORD 'demo';

GRANT CONNECT
    ON DATABASE demo TO demo;

COMMENT
    ON ROLE demo
    IS 'User for service demo';

GRANT USAGE ON SCHEMA
    demo TO demo;

--rollback REVOKE USAGE ON SCHEMA demo FROM demo;
--rollback REVOKE CONNECT ON DATABASE demo FROM demo;
--rollback DROP ROLE demo;