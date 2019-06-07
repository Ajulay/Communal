CREATE SCHEMA `cmnl_schema` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

CREATE TABLE `cmnl_schema`.`tb_counter` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cnt_el1` FLOAT NOT NULL,
  `cnt_el2` FLOAT NOT NULL,
  `cnt_cw` FLOAT NOT NULL,
  `cnt_hw` FLOAT NOT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `cmnl_schema`.`tbl_tariffs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `electr1` FLOAT NOT NULL,
  `electr2` FLOAT NOT NULL,
  `cld_wtr` FLOAT NOT NULL,
  `ht_wtr` FLOAT NOT NULL,
  `wtr_out` FLOAT NOT NULL,
  `date_bgn` DATE NOT NULL,
  `date_end` DATE NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `cmnl_schema`.`add_tariffs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `add_tariff` FLOAT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `cmnl_schema`.`tbl_param` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_cntr` INT NOT NULL,
  `param_bf` FLOAT NOT NULL,
  `date` DATE NOT NULL,
  `param_now` FLOAT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `cmnl_schema`.`results` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `overal` FLOAT NOT NULL,
  `electr1` FLOAT NOT NULL,
  `electr2` FLOAT NOT NULL,
  `cld_wtr` FLOAT NOT NULL,
  `ht_wtr` FLOAT NOT NULL,
  `warm` FLOAT NULL DEFAULT 0,
  `cap_repaire` FLOAT NULL DEFAULT 0,
  PRIMARY KEY (`id`));
  
  ALTER TABLE `cmnl_schema`.`tbl_param` 
CHANGE COLUMN `param_now` `param_now` FLOAT NOT NULL AFTER `param_bf`,
ADD INDEX `fk_cntrs_idx` (`id_cntr` ASC);

ALTER TABLE `cmnl_schema`.`tbl_param` 
ADD CONSTRAINT `fk_cntrs`
  FOREIGN KEY (`id_cntr`)
  REFERENCES `cmnl_schema`.`tb_counter` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `cmnl_schema`.`tbl_tariffs` 
ADD INDEX `fk_cntrstf_idx` (`id_cntr` ASC);

ALTER TABLE `cmnl_schema`.`tbl_tariffs` 
ADD CONSTRAINT `fk_cntrs_tf`
  FOREIGN KEY (`id_cntr`)
  REFERENCES `cmnl_schema`.`tb_counter` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  ALTER TABLE `cmnl_schema`.`add_tariffs` 
ADD COLUMN `name_adtariff` VARCHAR(45) NOT NULL AFTER `add_tariff`


