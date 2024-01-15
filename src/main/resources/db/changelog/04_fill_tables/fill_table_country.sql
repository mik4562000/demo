--liquibase formatted sql
--changeset liz:fill_table_country:postgresql encoding:UTF8

INSERT INTO demo.country (country_id, country_name) VALUES (1, 'USA');

SELECT setval('demo.country_country_id_seq', 1, true);

-- rollback  truncate TABLE demo.country;
-- rollback  SELECT setval('demo.country_country_id_seq', 1, true);