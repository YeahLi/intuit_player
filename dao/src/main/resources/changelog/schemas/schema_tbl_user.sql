--liquibase formatted sql
-- changeset henry:1
CREATE TABLE tbl_user (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	name varchar(100) NOT NULL,
	age INT NULL,
	category varchar(50) NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT tbl_user_pk PRIMARY KEY (id)
);
-- rollback drop table tbl_user;