
use test;
/*科目*/
CREATE TABLE `subject` (
  id int AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(20),
  starttime BIGINT,
  endtime BIGINT,
  bmstarttime BIGINT,
  bmendtime BIGINT,
  maxnumber int,
  minnumber int
);

/*教室*/
CREATE TABLE `classroom`(
  id int AUTO_INCREMENT PRIMARY KEY ,
  size int ,
  starttime BIGINT,
  endtime BIGINT,
  position VARCHAR(50),
  isEnable BOOL
);

/*监考人员*/
CREATE TABLE  `teacher`(
  id int AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(20),
  starttime BIGINT,
  endtime BIGINT,
  isInvigilator BOOL,
  numInvigilator INT,
  accInvigilator BOOL
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
  identy VARCHAR(15) NOT NULL ,
  pwd VARCHAR(50)
);

CREATE TABLE `student`(
  sid INT,
  name VARCHAR(50) ,
  id VARCHAR(30),
  subjectId INT ,
  FOREIGN KEY (subjectId) REFERENCES subject(id),
  PRIMARY KEY (sid)
);

CREATE TABLE `studentexamroominfo` (
  subjectId INT ,
  examroomId INT ,
  studentId int ,
  FOREIGN KEY (studentId) REFERENCES student(sid),
  FOREIGN KEY (subjectId) REFERENCES subject(id),
  PRIMARY KEY (subjectId,studentId)
);

CREATE TABLE `root` (
  id int AUTO_INCREMENT PRIMARY KEY ,
  email VARCHAR(50),
  auth INTEGER,
  enable BOOL
)
