--liquibase formatted sql
-- changeset henry:1
insert into tbl_user (name, age, category) values ("Henry Li", 34, 'VIP');

