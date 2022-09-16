DROP TABLE IF EXISTS `club`;

CREATE TABLE `club` (
	`id` BIGINT AUTO_INCREMENT,
	`club_name` VARCHAR(255) NOT NULL,
	`club_nationality` VARCHAR(255) NOT NULL,
	`club_titles` INT NOT NULL,
	PRIMARY KEY(`id`)
);