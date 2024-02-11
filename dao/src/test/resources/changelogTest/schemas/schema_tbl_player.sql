--liquibase formatted sql
-- changeset henry:1
CREATE TABLE tbl_player (
	id VARCHAR(50),
	birth_year INT UNSIGNED NULL,
	birth_month TINYINT UNSIGNED NULL,
	birth_day TINYINT UNSIGNED NULL,
	birth_country VARCHAR(100) NULL,
	birth_state VARCHAR(100) NULL,
	birth_city VARCHAR(100) NULL,

	death_year INT UNSIGNED NULL,
    death_month TINYINT UNSIGNED NULL,
    death_day TINYINT UNSIGNED NULL,
    death_country VARCHAR(100) NULL,
    death_state VARCHAR(100) NULL,
    death_city VARCHAR(100) NULL,

    name_first VARCHAR(100) NULL,
    name_last VARCHAR(100) NULL,
    name_given VARCHAR(200) NULL,
    weight INT UNSIGNED NULL,
    height INT UNSIGNED NULL,

    bats CHAR(2) NULL,
    throws CHAR(2) NULL,
    debut DATE NULL,
    final_game DATE NULL,
    retro_id VARCHAR(50) NULL,
    bbref_id VARCHAR(50) NULL,

	CONSTRAINT tbl_user_pk PRIMARY KEY (id)
);
-- rollback drop table tbl_player;