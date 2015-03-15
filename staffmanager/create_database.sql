-- 직원
ALTER TABLE `staffs`
	DROP PRIMARY KEY; -- 직원 기본키

-- 직원
DROP TABLE IF EXISTS `staffs` RESTRICT;

-- 직원
CREATE TABLE `staffs` (
	`eno`      INTEGER     NOT NULL, -- 직원번호
	`position` VARCHAR(10) NOT NULL, -- 직급
	`name`     VARCHAR(50) NOT NULL, -- 이름
	`phone`    INTEGER     NOT NULL, -- 전화번호
	`email`    VARCHAR(40) NOT NULL  -- 이메일
);

-- 직원
ALTER TABLE `staffs`
	ADD CONSTRAINT `PK_staffs` -- 직원 기본키
		PRIMARY KEY (
			`eno` -- 직원번호
		);

ALTER TABLE `staffs`
	MODIFY COLUMN `eno` INTEGER NOT NULL AUTO_INCREMENT;

ALTER TABLE `staffs`
	AUTO_INCREMENT = 1;