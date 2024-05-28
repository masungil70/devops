CREATE DATABASE IF NOT EXISTS `koreatech_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

drop TABLE `code`;

CREATE TABLE `code` (
	`grp_cd` VARCHAR(10) NOT NULL COLLATE 'utf8mb4_general_ci',
	`cd` VARCHAR(10) NOT NULL COLLATE 'utf8mb4_general_ci',
	`grp_cd_nm` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`cd_nm` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`sort_order` INT(11) NULL DEFAULT '0',
	`make_date` TIMESTAMP NULL DEFAULT current_timestamp(),
	`use_yn` char(1) NULL DEFAULT 'Y',
	PRIMARY KEY (`grp_cd`, `cd`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;



INSERT INTO `code` (`grp_cd`, `cd`, `grp_cd_nm`, `cd_nm`, `sort_order`) VALUES ('group', 'gp1', '그룹코드', '그룹1', 1);
INSERT INTO `code` (`grp_cd`, `cd`, `grp_cd_nm`, `cd_nm`, `sort_order`) VALUES ('group', 'gpo2', '그룹코드', '그룹2', 2);
INSERT INTO `code` (`grp_cd`, `cd`, `grp_cd_nm`, `cd_nm`, `sort_order`) VALUES ('lang', 'java', '개발언어', '자바', 2);
INSERT INTO `code` (`grp_cd`, `cd`, `grp_cd_nm`, `cd_nm`, `sort_order`) VALUES ('lang', 'js', '개발언어', '자바스크립트', 1);
INSERT INTO `code` (`grp_cd`, `cd`, `grp_cd_nm`, `cd_nm`, `sort_order`) VALUES ('lang', 'jsp', '개발언어', 'JSP', 3);

