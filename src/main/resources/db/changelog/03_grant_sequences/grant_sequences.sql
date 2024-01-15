--liquibase formatted sql
--changeset liz:grant_sequences:postgresql encoding:UTF8

GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA demo TO demo;

-- rollback  REVOKE USAGE, SELECT ON ALL SEQUENCES IN SCHEMA demo FROM demo;