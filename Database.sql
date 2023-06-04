CREATE TABLE `hbh`.`users` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `f_name` VARCHAR(45) NOT NULL,
  `cnic` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`iduser`),
  INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `f_name` (`f_name` ASC) VISIBLE,
  INDEX `cnic` (`cnic` ASC) VISIBLE
);   

-- many users can book many rooms
-- one user can book many rooms in differnt hostel
-- one room is connected to only one hostel 

CREATE TABLE `hbh`.`hostel` (
  `idhostel` INT NOT NULL AUTO_INCREMENT,
  `hostel_name` VARCHAR(45) NOT NULL,
  `hostel_address` VARCHAR(45) NOT NULL,
  `hostel_email` VARCHAR(45) NOT NULL,
  `hostel_fee` INT NOT NULL,
  `hostel_rooms` INT NOT NULL,
  `hostel_type` VARCHAR(45) NOT NULL,
  `mess` VARCHAR(10) NOT NULL,
  `small_url` VARCHAR(45) NOT NULL,
  `large_url` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idhostel`),
  UNIQUE INDEX `hostel_email_UNIQUE` (`hostel_email` ASC) VISIBLE,
  INDEX `hostel_name` (`hostel_name` ASC) VISIBLE,
  INDEX `hostel_fee` (`hostel_fee` ASC) VISIBLE
);
CREATE TABLE `hbh`.`booking` (
  `idbooking` INT NOT NULL AUTO_INCREMENT,
  `hid` INT NOT NULL DEFAULT 0,
  `hname` VARCHAR(45) NOT NULL,
  `hemail` VARCHAR(45) NOT NULL,
  `hfee` INT NOT NULL,
  `uid` INT NOT NULL,
  `uname` VARCHAR(45) NOT NULL,
  `uemail` VARCHAR(45) NOT NULL,
  `ucnic` VARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  `time` TIME NOT NULL,
  PRIMARY KEY (`idbooking`),
  INDEX `hname_idx` (`hname` ASC) VISIBLE,
  INDEX `hemail_idx` (`hemail` ASC) VISIBLE,
  INDEX `hid_idx` (`hid` ASC) VISIBLE,
  INDEX `uid_idx` (`uid` ASC) VISIBLE,
  INDEX `uname_idx` (`uname` ASC) VISIBLE,
  INDEX `uemail_idx` (`uemail` ASC) VISIBLE,
  INDEX `ucnic_idx` (`ucnic` ASC) VISIBLE,
  INDEX `hfee_idx` (`hfee` ASC) VISIBLE,
  CONSTRAINT `hname`
    FOREIGN KEY (`hname`)
    REFERENCES `hbh`.`hostel` (`hostel_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `hemail`
    FOREIGN KEY (`hemail`)
    REFERENCES `hbh`.`hostel` (`hostel_email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `hid`
    FOREIGN KEY (`hid`)
    REFERENCES `hbh`.`hostel` (`idhostel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `uid`
    FOREIGN KEY (`uid`)
    REFERENCES `hbh`.`users` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `uname`
    FOREIGN KEY (`uname`)
    REFERENCES `hbh`.`users` (`f_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `uemail`
    FOREIGN KEY (`uemail`)
    REFERENCES `hbh`.`users` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT `ucnic`
    FOREIGN KEY (`ucnic`)
    REFERENCES `hbh`.`users` (`cnic`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE `hbh`.`room` (
  `idroom` INT NOT NULL,
  `no_of_bed` INT NOT NULL,
  `hostel_id` INT NOT NULL,
  PRIMARY KEY (`idroom`),
  INDEX `hostel_id_idx` (`hostel_id` ASC) VISIBLE,
  CONSTRAINT `hostel_id`
    FOREIGN KEY (`hostel_id`)
    REFERENCES `hbh`.`hostel` (`idhostel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE `hbh`.`rooms_fees` (
  `idrooms_fees` INT NOT NULL,
  `one_seater` INT NOT NULL,
  `two_seater` INT NOT NULL,
  `three_seater` INT NOT NULL,
  `four_seater` INT NOT NULL,
  PRIMARY KEY (`idrooms_fees`),
  CONSTRAINT `idrooms_fees`
    FOREIGN KEY (`idrooms_fees`)
    REFERENCES `hbh`.`hostel` (`idhostel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

INSERT INTO hostel VALUES(
	0,'Qasim Boys Hostel','Wah','qasimhostel@gmail.com',10000,15,"Boys","Yes",
	"D:\\HBH\\images\\boys\\1.png",
    "D:\\HBH\\images\\boys\\h1.png"
);

INSERT INTO rooms_fees VALUES(1,10000,9000,8000,7500);

INSERT INTO hostel VALUES(
	0,'Simab Boys Hostel','Rawalpindi','simabhosetl@gmail.com',9000,12,"Boys","No",
	"D:\\HBH\\images\\boys\\2.png",
    "D:\\HBH\\images\\boys\\h2.png"
    );
    
INSERT INTO rooms_fees VALUES(2,9000,8000,7500,7000);

INSERT INTO hostel VALUES(
	0,'Awais Boys Hostel','Lahore','awaishosetl@gmail.com',12000,25,"Boys","Yes",
	"D:\\HBH\\images\\boys\\3.png",
    "D:\\HBH\\images\\boys\\h3.png"
);

INSERT INTO rooms_fees VALUES(3,12000,11000,9000,8000);

INSERT INTO hostel VALUES(
	0,'Musab Boys Hostel','Rawalpindi','musabhosetl@gmail.com',9000,18,"Boys","No",
	"D:\\HBH\\images\\boys\\4.png", 
    "D:\\HBH\\images\\boys\\h4.png"
    );
    
INSERT INTO rooms_fees VALUES(4,9000,8000,7000,6000);

INSERT INTO hostel VALUES(
	0,'Ahmed Boys Hostel','Wah','ahmedhosetl@gmail.com',8000,8,"Boys","Yes",
	"D:\\HBH\\images\\boys\\5.png",
    "D:\\HBH\\images\\boys\\h5.png"
);

INSERT INTO rooms_fees VALUES(5,8000,7000,6000,5000);

INSERT INTO hostel VALUES(
	0,'Atif Boys Hostel','Lahore','atifhosetl@gmail.com',12500,10,"Boys","No",
	"D:\\HBH\\images\\boys\\6.png", 
    "D:\\HBH\\images\\boys\\h6.png" 
);

INSERT INTO rooms_fees VALUES(6,12500,10500,9000,8000);

INSERT INTO hostel VALUES(
	0,'New Girls Hostel','Wah','newgilshostel@gmail.com',8500,5,"Girls","Yes",
    "D:\\HBH\\images\\girls\\1.png",
    "D:\\HBH\\images\\girls\\h1.png"
);

INSERT INTO rooms_fees VALUES(7,8500,7000,6000,5000);

INSERT INTO hostel VALUES(
	0,'Nadia Girls Hostel','Rawalpindi','nadiahostel@gmail.com',10000,8,"Girls","No",
    "D:\\HBH\\images\\girls\\2.png",
    "D:\\HBH\\images\\girls\\h2.png"
    );
    
INSERT INTO rooms_fees VALUES(8,10000,9000,8500,7000);

INSERT INTO hostel VALUES(
	0,'Fatima Girls Hostel','Lahore','fatimahostel@gmail.com',12000,15,"Girls","Yes",
    "D:\\HBH\\images\\girls\\3.png",
    "D:\\HBH\\images\\girls\\h3.png"
    );
    
INSERT INTO rooms_fees VALUES(9,12000,10500,9000,8000);

INSERT INTO hostel VALUES(
	0,'Iqra Girls Hostel','Rawalpindi','iqrahostel@gmail.com',10000,10,"Girls","No",
    "D:\\HBH\\images\\girls\\4.png",
    "D:\\HBH\\images\\girls\\h4.png"
    );
    
INSERT INTO rooms_fees VALUES(10,10000,9000,8000,7000);

INSERT INTO hostel VALUES(
	0,'Zara Girls Hostel','Wah','zarahostel@gmail.com',11000,20,"Girls","Yes",
    "D:\\HBH\\images\\girls\\5.png",
    "D:\\HBH\\images\\girls\\h5.png"
    );
    
INSERT INTO rooms_fees VALUES(11,11000,9000,8000,7000);

INSERT INTO hostel VALUES(
	0,'The Girls Hostel','Lahore','thegirlshostel@gmail.com',7500,16,"Girls","No",
    "D:\\HBH\\images\\girls\\6.png",
    "D:\\HBH\\images\\girls\\h6.png"
    );
    
INSERT INTO rooms_fees VALUES(12,7500,6000,5000,4000);

INSERT INTO hostel VALUES(
	0,'Akram Office Hostel','Wah','akramhostel@gmail.com',8500,20,"Office","Yes",
    "D:\\HBH\\images\\office\\1.png",
	"D:\\HBH\\images\\office\\h1.png"
     );
     
INSERT INTO rooms_fees VALUES(13,8500,7500,6500,5500);

INSERT INTO hostel VALUES(
	0,'Ali Office Hostel','Rawalpindi','alihostel@gmail.com',7000,8,"Office","No",
    "D:\\HBH\\images\\office\\2.png",
	"D:\\HBH\\images\\office\\h2.png"
    );
    
INSERT INTO rooms_fees VALUES(14,7000,6000,5000,4000);

INSERT INTO hostel VALUES(
	0,'Khan Office Hostel','Lahore','khanhostel@gmail.com',15000,15,"Office","Yes",
    "D:\\HBH\\images\\office\\3.png",
     "D:\\HBH\\images\\office\\h3.png"
    );
    
INSERT INTO rooms_fees VALUES(15,15000,13000,10000,9000);

INSERT INTO hostel VALUES(
	0,'Rawalpindi Office Hostel','Rawalpindi','rawalpinidhostel@gmail.com',9000,10,"Office","No",
    "D:\\HBH\\images\\office\\4.png",
     "D:\\HBH\\images\\office\\h4.png"
    );
INSERT INTO rooms_fees VALUES(16,9000,8000,7000,6500);

INSERT INTO hostel VALUES(
	0,'Raja Office Hostel','Wah','rajahostel@gmail.com',8500,25,"Office","Yes",
    "D:\\HBH\\images\\office\\5.png",
     "D:\\HBH\\images\\office\\h5.png"
    );
    
INSERT INTO rooms_fees VALUES(17,8500,7500,7000,6000);

INSERT INTO hostel VALUES(
	0,'Hamza Office Hostel','Lahore','hamzahostel@gmail.com',13000,12,"Office","No",
    "D:\\HBH\\images\\office\\6.png",
     "D:\\HBH\\images\\office\\h6.png"
    );
    
INSERT INTO rooms_fees VALUES(18,13000,11500,10000,9000);

-- INSERT INTO users VALUES(0,'musab@gmail.com','Musab Akram','123-3423232-1','musab','123');
-- INSERT INTO users VALUES(0,'ahmed@gmail.com','Ahmed Khan','123-3423232-1','ahmed','123');
-- INSERT INTO users VALUES(0,'atif@gmail.com','Muhammad Atif','123-3423232-1','atif','123');

-- INSERT INTO room VALUES(1,4,1);
-- INSERT INTO room VALUES(2,2,1);
-- INSERT INTO room VALUES(3,3,1);
-- INSERT INTO room VALUES(4,6,2);
-- INSERT INTO room VALUES(5,5,3);
-- INSERT INTO room VALUES(6,45,3);


-- SELECT AVG(hbh.booking.hfee) FROM hbh.booking;
-- SELECT COUNT(hbh.hostel.idhostel), hostel_name, hbh.hostel.hostel_type FROM hbh.hostel GROUP BY hbh.hostel.hostel_type;
-- SELECT MAX(hbh.hostel.hostel_fee) AS highestfee FROM hbh.hostel;
-- SELECT MIN(hbh.hostel.hostel_fee) AS lowestfee FROM hbh.hostel;
-- SELECT SUM(hbh.hostel.hostel_fee) FROM hbh.hostel;
-- SELECT * FROM hbh.hostel ORDER BY hbh.hostel.hostel_type;

-- SELECT SUM(hbh.hostel.hostel_fee), hostel_name, hbh.hostel.hostel_type FROM hbh.hostel GROUP BY hbh.hostel.hostel_type;

-- SELECT SUM(hbh.hostel.hostel_fee), hostel_name, hbh.hostel.hostel_type FROM hbh.hostel GROUP BY hbh.hostel.hostel_type ORDER BY hbh.hostel.hostel_type;

-- SELECT COUNT(hbh.hostel.idhostel), hostel_name, hbh.hostel.hostel_type FROM hbh.hostel GROUP BY hbh.hostel.hostel_type HAVING COUNT(hbh.hostel.idhostel)>4;


-- SELECT * FROM hbh.hostel AS hos CROSS JOIN hbh.booking AS booking;
-- SELECT * FROM hbh.hostel AS hos NATURAL JOIN hbh.booking AS booking;

-- SELECT hos.hostel_name, hos.idhostel, book.idbooking, book.hname FROM hbh.hostel AS hos INNER JOIN hbh.booking AS book ON (hos.hostel_name = book.hname);


-- SELECT * FROM hbh.users AS us LEFT JOIN hbh.booking AS book ON (us.iduser = book.uid) ORDER BY book.idbooking;

-- SELECT * FROM hbh.booking AS book RIGHT JOIN hbh.hostel AS hos ON (book.hid = hos.idhostel);

-- SELECT * FROM hbh.room AS ro FULL OUTER JOIN hbh.hostel AS hos ON (ro.hostel_id = hos.idhostel) WHERE hos.idhostel=1;-- 

-- DROP TABLE hbh.hostel;
-- DROP TABLE hbh.booking;
-- DROP TABLE hbh.users;
-- DROP TABLE hbh.room;
-- DROP TABLE hbh.rooms_fees;
-- UPDATE hbh.users SET pass = "whisper" WHERE email = "hammadali9566@gmail.com";

-- select * from hbh.users;
-- select * from hbh.hostel;
-- select * from hbh.booking;
-- select * from hbh.room;
-- select * from hbh.rooms_fees;

-- DELETE FROM hbh.users where iduser = 10;

-- DELETE FROM hbh.booking where idbooking = 10;



