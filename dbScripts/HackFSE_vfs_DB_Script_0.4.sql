-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema outreach_vfs
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `outreach_vfs` ;

-- -----------------------------------------------------
-- Schema outreach_vfs
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `outreach_vfs`;
USE `outreach_vfs` ;

-- -----------------------------------------------------
-- Table `outreach_vfs`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outreach_vfs`.`location` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(255) NOT NULL,
  `state` VARCHAR(255) NOT NULL,
  `country` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `outreach_vfs`.`business_unit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outreach_vfs`.`business_unit` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `buss_unit_name` VARCHAR(255) NOT NULL,
  `location_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `Business_Unit_fk0`
    FOREIGN KEY (`location_id`)
    REFERENCES `outreach_vfs`.`location` (`id`));

CREATE INDEX `Business_Unit_fk0` ON `outreach_vfs`.`business_unit` (`location_id` ASC);


-- -----------------------------------------------------
-- Table `outreach_vfs`.`role_lookup`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outreach_vfs`.`role_lookup` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `outreach_vfs`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outreach_vfs`.`status` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));
  
  
-- -----------------------------------------------------
-- Table `outreach_vfs`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outreach_vfs`.`employee` (
  `employee_id` INT(11) NOT NULL,
  `emp_first_name` VARCHAR(255) NOT NULL,
  `emp_last_name` VARCHAR(255) NOT NULL,
  `emp_email` VARCHAR(255) NOT NULL,
  `emp_location_id` INT(11) NOT NULL,
  `business_unit_id` INT(11) NOT NULL,
  `evnt_volunteer_hours` INT(11) NOT NULL,
  `role_id` INT(11) NOT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `employee_status_id` INT(11) NOT NULL,
  `create_timestamp` TIMESTAMP NOT NULL,
  `update_timestamp` TIMESTAMP NOT NULL,
  `last_login` TIMESTAMP NOT NULL,
  PRIMARY KEY (`employee_id`),
  CONSTRAINT `Employee_fk0`
    FOREIGN KEY (`emp_location_id`)
    REFERENCES `outreach_vfs`.`location` (`id`),
  CONSTRAINT `Employee_fk1`
    FOREIGN KEY (`business_unit_id`)
    REFERENCES `outreach_vfs`.`business_unit` (`id`),
  CONSTRAINT `Employee_fk2`
    FOREIGN KEY (`role_id`)
    REFERENCES `outreach_vfs`.`role_lookup` (`id`),
  CONSTRAINT `Employee_fk3`
    FOREIGN KEY (`employee_status_id`)
    REFERENCES `outreach_vfs`.`status` (`id`));

CREATE INDEX `Employee_fk0` ON `outreach_vfs`.`employee` (`emp_location_id` ASC);

CREATE INDEX `Employee_fk1` ON `outreach_vfs`.`employee` (`business_unit_id` ASC);

CREATE INDEX `Employee_fk2` ON `outreach_vfs`.`employee` (`role_id` ASC);

CREATE INDEX `Employee_fk3` ON `outreach_vfs`.`employee` (`employee_status_id` ASC);

-- -----------------------------------------------------
-- Table `outreach_vfs`.`event_beneficiary`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outreach_vfs`.`event_beneficiary` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));

-- -----------------------------------------------------
-- Table `outreach_vfs`.`iiep_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outreach_vfs`.`iiep_category` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `outreach_vfs`.`event_council`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outreach_vfs`.`event_council` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `council_name` VARCHAR(255) NOT NULL,
  `location_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `Event_Council_fk0`
    FOREIGN KEY (`location_id`)
    REFERENCES `outreach_vfs`.`location` (`id`));

CREATE INDEX `Event_Council_fk0` ON `outreach_vfs`.`event_council` (`location_id` ASC);


-- -----------------------------------------------------
-- Table `outreach_vfs`.`event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outreach_vfs`.`event` (
  `id` INT(11) NOT NULL,
  `evnt_base_location` INT(11) NOT NULL,
  `evnt_benef_id` INT(11) NOT NULL,
  `evnt_name` VARCHAR(255) NOT NULL,
  `evnt_description` VARCHAR(255) NOT NULL,
  `evnt_date` DATE NOT NULL,
  `event_poc_id` INT(11) NOT NULL,
  `lives_impacted` INT(11) NOT NULL,
  `evnt_status` INT(11) NOT NULL,
  `iiep_category_id` INT(11) NOT NULL,
  `event_council_id` INT(11) NOT NULL,
  `location_id` INT(11) NOT NULL,
  `created_by_id` INT(11) NOT NULL,
  `created_timestamp` TIMESTAMP NOT NULL,
  `updated_timestamp` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `Event_fk0`
    FOREIGN KEY (`evnt_base_location`)
    REFERENCES `outreach_vfs`.`location` (`id`),
  CONSTRAINT `Event_fk1`
    FOREIGN KEY (`evnt_benef_id`)
    REFERENCES `outreach_vfs`.`event_beneficiary` (`id`),
  CONSTRAINT `Event_fk2`
    FOREIGN KEY (`event_poc_id`)
    REFERENCES `outreach_vfs`.`employee` (`employee_id`),
  CONSTRAINT `Event_fk3`
    FOREIGN KEY (`evnt_status`)
    REFERENCES `outreach_vfs`.`status` (`id`),
  CONSTRAINT `Event_fk4`
    FOREIGN KEY (`iiep_category_id`)
    REFERENCES `outreach_vfs`.`iiep_category` (`id`),
  CONSTRAINT `Event_fk5`
    FOREIGN KEY (`event_council_id`)
    REFERENCES `outreach_vfs`.`event_council` (`id`),
  CONSTRAINT `Event_fk6`
    FOREIGN KEY (`location_id`)
    REFERENCES `outreach_vfs`.`location` (`id`));

CREATE INDEX `Event_fk0` ON `outreach_vfs`.`event` (`evnt_base_location` ASC);

CREATE INDEX `Event_fk1` ON `outreach_vfs`.`event` (`evnt_benef_id` ASC);

CREATE INDEX `Event_fk2` ON `outreach_vfs`.`event` (`event_poc_id` ASC);

CREATE INDEX `Event_fk3` ON `outreach_vfs`.`event` (`evnt_status` ASC);

CREATE INDEX `Event_fk4` ON `outreach_vfs`.`event` (`iiep_category_id` ASC);

CREATE INDEX `Event_fk5` ON `outreach_vfs`.`event` (`event_council_id` ASC);

CREATE INDEX `Event_fk6` ON `outreach_vfs`.`event` (`location_id` ASC);

-- -----------------------------------------------------
-- Table `outreach_vfs`.`event_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outreach_vfs`.`event_details` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `evnt_id` INT(11) NOT NULL,
  `employee_id` INT(11) NOT NULL,
  `volunteer_hrs` INT(11) NOT NULL,
  `travel_hrs` INT(11) NOT NULL,
  `participation_status_id` INT(11) NOT NULL,
  `feedback_status_id` INT(11) NOT NULL,
  `created_by_id` INT(11) NOT NULL,
  `created_timestamp` TIMESTAMP NOT NULL,
  `updated_timestamp` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `Event_Details_fk0`
    FOREIGN KEY (`evnt_id`)
    REFERENCES `outreach_vfs`.`event` (`id`),
  CONSTRAINT `Event_Details_fk1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `outreach_vfs`.`employee` (`employee_id`),
  CONSTRAINT `Event_Details_fk2`
    FOREIGN KEY (`participation_status_id`)
    REFERENCES `outreach_vfs`.`status` (`id`),
  CONSTRAINT `Event_Details_fk3`
    FOREIGN KEY (`feedback_status_id`)
    REFERENCES `outreach_vfs`.`status` (`id`));

CREATE INDEX `Event_Details_fk0` ON `outreach_vfs`.`event_details` (`evnt_id` ASC);

CREATE INDEX `Event_Details_fk1` ON `outreach_vfs`.`event_details` (`employee_id` ASC);

CREATE INDEX `Event_Details_fk2` ON `outreach_vfs`.`event_details` (`participation_status_id` ASC);

CREATE INDEX `Event_Details_fk3` ON `outreach_vfs`.`event_details` (`feedback_status_id` ASC);


-- -----------------------------------------------------
-- Table `outreach_vfs`.`rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outreach_vfs`.`rating` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `outreach_vfs`.`feedback_options`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outreach_vfs`.`feedback_options` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `outreach_vfs`.`feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `outreach_vfs`.`feedback` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `event_detail_id` INT(11) NOT NULL,
  `rating` INT(11) NOT NULL,
  `feedback_option_id` INT(11) NOT NULL,
  `like_feedback` VARCHAR(255) NOT NULL,
  `improve_feedback` VARCHAR(255) NOT NULL,
  `admin_feedback` VARCHAR(255) NOT NULL,
  `update_id` INT(11) NOT NULL,
  `create_timestamp` TIMESTAMP NOT NULL,
  `update_timestamp` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `Feedback_fk0`
    FOREIGN KEY (`event_detail_id`)
    REFERENCES `outreach_vfs`.`event_details` (`id`),
  CONSTRAINT `Feedback_fk1`
    FOREIGN KEY (`rating`)
    REFERENCES `outreach_vfs`.`rating` (`id`),
  CONSTRAINT `Feedback_fk2`
    FOREIGN KEY (`feedback_option_id`)
    REFERENCES `outreach_vfs`.`feedback_options` (`id`),
  CONSTRAINT `Feedback_fk3`
    FOREIGN KEY (`update_id`)
    REFERENCES `outreach_vfs`.`employee` (`employee_id`));

CREATE INDEX `Feedback_fk0` ON `outreach_vfs`.`feedback` (`event_detail_id` ASC);

CREATE INDEX `Feedback_fk1` ON `outreach_vfs`.`feedback` (`rating` ASC);

CREATE INDEX `Feedback_fk2` ON `outreach_vfs`.`feedback` (`feedback_option_id` ASC);

CREATE INDEX `Feedback_fk3` ON `outreach_vfs`.`feedback` (`update_id` ASC);