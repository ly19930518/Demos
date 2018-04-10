SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Indexes */

DROP INDEX index1 ON dictionary;



/* Drop Tables */

DROP TABLE IF EXISTS dictionary;




/* Create Tables */

CREATE TABLE dictionary
(
	id int NOT NULL AUTO_INCREMENT,
	-- 字
	word varchar(2) NOT NULL COMMENT '字',
	-- 拼音
	pinyin varchar(10) NOT NULL COMMENT '拼音',
	time varchar(20) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE (id),
	UNIQUE (word, pinyin)
);



/* Create Indexes */

CREATE INDEX index1 ON dictionary (word ASC, pinyin ASC);



