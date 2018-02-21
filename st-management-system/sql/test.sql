CREATE DATABASE test;

use test;
/*科目*/
CREATE TABLE `subject` (
  id int AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(20),
  starttime DATETIME,
  duration int ,
  number int
);

/*教室*/
CREATE TABLE `classroom`(
  id int AUTO_INCREMENT PRIMARY KEY ,
  size int ,
  position VARCHAR(50)
);

/*监考人员*/
CREATE TABLE  `teacher`(
  id int AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(20),
  experience SET ('数学','语文','英语','物理','化学','历史','政治')
);

/*考场*/
CREATE TABLE `examroom` (
  id int AUTO_INCREMENT PRIMARY KEY ,
  rid int,
  tid int,
  number int,
  FOREIGN KEY (rid) REFERENCES classroom(id),
  FOREIGN KEY (tid) REFERENCES teacher(id)
);

/*登录注册*/
CREATE TABLE `register` (
  id int AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(20),
  email VARCHAR(50),
  pwd VARCHAR(50)
);

CREATE TABLE `student`(
  examid BIGINT PRIMARY KEY ,
  name VARCHAR(50) ,
  id VARCHAR(30),
  sid BIGINT AUTO_INCREMENT
);

CREATE TABLE `studentimformation` (
  examid BIGINT ,
  sbid int ,
  FOREIGN KEY (examid) REFERENCES student(examid),
  FOREIGN KEY (sbid) REFERENCES subject(id),
  PRIMARY KEY (examid,sbid)
 );