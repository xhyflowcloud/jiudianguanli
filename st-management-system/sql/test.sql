use test;
/*科目*/
CREATE TABLE `subject` (
  id int AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(20),
  starttime BIGINT,
  duration int ,
  number int
);

/*教室*/
CREATE TABLE `classroom`(
  id int AUTO_INCREMENT PRIMARY KEY ,
  size int ,
  position VARCHAR(50),
  isEnable BOOLEAN
);

/*监考人员*/
CREATE TABLE  `teacher`(
  id int AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(20),
  isInvigilator BOOLEAN,
  numInvigilator INT,
  accInvigilator BOOLEAN
);

/*考场*/
CREATE TABLE `examroom` (
  id int AUTO_INCREMENT PRIMARY KEY ,
  rid int,
  tid int,
  number int,
  sid int,
  FOREIGN KEY (rid) REFERENCES classroom(id),
  FOREIGN KEY (tid) REFERENCES teacher(id),
  FOREIGN KEY (sid) REFERENCES subject(id)
);

/*登录注册*/
CREATE TABLE `register` (
  id int AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(20),
  email VARCHAR(50),
  pwd VARCHAR(50)
);

CREATE TABLE `student`(
  examid INT,
  name VARCHAR(50) ,
  id VARCHAR(30),
  sid INT AUTO_INCREMENT PRIMARY KEY
);


CREATE TABLE `studentinformation` (
  examid INT ,
  sbid int ,
  FOREIGN KEY (examid) REFERENCES student(examid),
  FOREIGN KEY (sbid) REFERENCES subject(id),
  PRIMARY KEY (examid,sbid)
 );

CREATE TABLE `root` (
  id int AUTO_INCREMENT PRIMARY KEY ,
  email VARCHAR(50),
  auth INTEGER,
  enable BOOLEAN
)
