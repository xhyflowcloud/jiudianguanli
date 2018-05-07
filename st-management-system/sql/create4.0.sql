create Database Hotel;
use Hotel;

create TABLE Users(
    userId  int primary key AUTO_INCREMENT,
	userName varchar(200),
    userIDNum varchar(200),
    phone varchar(200)
);

create TABLE Room(
     roomId  int primary key AUTO_INCREMENT,
     roomName varchar(200),
     pURL varchar(200),
     type varchar(200)  #大床房 1  Master room 、标准间 2 Twin room 、单房单间 Single room
);


create TABLE Admin(
     adminId  int primary key AUTO_INCREMENT,
     password varchar(200),
     username varchar(200)
);

create TABLE RoomCheckIn(
    roomCheckInId  int primary key AUTO_INCREMENT,
    timeBegin DATE,
    timeEnd   DATE,
    userId  int,  #Users表主键
    roomId  int,  #Room表主键

    swimming  int,#增值服务
    gym    int,
    freeDinks   boolean, 
    totPrice    double  
);

create TABLE RoomType(
    roomTypeId  int primary key AUTO_INCREMENT,
    type varchar(200),  #大床房 1  Master room 、标准间 2 Twin room 、单房单间 Single room
    price double        #       800                400                       600      
);
