CREATE DATABASE IF NOT EXISTS `koreatech_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

drop TABLE `code`;

CREATE TABLE `code` (
	`grp_cd` VARCHAR(10) NOT NULL COLLATE 'utf8mb4_general_ci',
	`cd` VARCHAR(10) NOT NULL COLLATE 'utf8mb4_general_ci',
	`grp_cd_nm` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`cd_nm` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`sort_order` INT(11) NULL DEFAULT '0',
	`make_date` TIMESTAMP NULL DEFAULT current_timestamp(),
	`use_yn` BIT(1) NULL DEFAULT b'1',
	PRIMARY KEY (`grp_cd`, `cd`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;



INSERT INTO `code` (`grp_cd`, `cd`, `grp_cd_nm`, `cd_nm`, `sort_order`, `make_date`, `use_yn`) VALUES ('group', 'gp1', '그룹코드', '그룹1', 1, '2023-10-24 18:25:22', b'1');
INSERT INTO `code` (`grp_cd`, `cd`, `grp_cd_nm`, `cd_nm`, `sort_order`, `make_date`, `use_yn`) VALUES ('group', 'gpo2', '그룹코드', '그룹2', 2, '2023-10-24 19:47:56', b'1');
INSERT INTO `code` (`grp_cd`, `cd`, `grp_cd_nm`, `cd_nm`, `sort_order`, `make_date`, `use_yn`) VALUES ('lang', 'java', '개발언어', '자바', 2, '2023-10-24 19:46:54', b'1');
INSERT INTO `code` (`grp_cd`, `cd`, `grp_cd_nm`, `cd_nm`, `sort_order`, `make_date`, `use_yn`) VALUES ('lang', 'js', '개발언어', '자바스크립트', 1, '2023-10-24 18:24:41', b'1');
INSERT INTO `code` (`grp_cd`, `cd`, `grp_cd_nm`, `cd_nm`, `sort_order`, `make_date`, `use_yn`) VALUES ('lang', 'jsp', '개발언어', 'JSP', 3, '2023-10-24 19:47:10', b'1');

