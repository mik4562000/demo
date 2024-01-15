--liquibase formatted sql

--changeset liz:create_scheme_demo dbms:postgresql encoding:UTF8

CREATE SCHEMA demo AUTHORIZATION demo_liquibase;

--rollback DROP SCHEMA demo CASCADE;