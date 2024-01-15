--liquibase formatted sql
--changeset liz:fill_table_parents_guide:postgresql encoding:UTF8

INSERT INTO demo.parents_guide (pg_id, pg_name, pg_age) VALUES (1, '16+', 16);
INSERT INTO demo.parents_guide (pg_id, pg_name, pg_age) VALUES (2, '18+', 18);
INSERT INTO demo.parents_guide (pg_id, pg_name, pg_age) VALUES (3, '14+', 14);
INSERT INTO demo.parents_guide (pg_id, pg_name, pg_age) VALUES (4, '12+', 12);

SELECT setval('demo.parents_guide_pg_id_seq', 4, true);

-- rollback  truncate TABLE demo.parents_guide;
-- rollback  SELECT setval('demo.parents_guide_pg_id_seq', 1, true);