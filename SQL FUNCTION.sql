create database springdalecollege;
use springdalecollege;

select * from studentDetails;

create table IF NOT EXISTS teacherDetails(
	uid CHAR(8) Primary key,
    name VARCHAR(50) NOT NULL,
   --  classes JSON NOT NULL,
    classTeacherOf VARCHAR(3) NOT NULL,
    -- subjects JSON NOT NULL,
    type INT not null
);
drop table teacherDetails;
insert into teacherDetails values("kr003438","Harman","XIA",2);
select * from teacherDetails;

create table IF NOT EXISTS studentDetails(
	uid CHAR(8) Primary Key,
    name VARCHAR(50) not null,
    class INT not null,
    section char(1) not null,
    dob date not null,
    f_name Varchar(50) not null,
    m_name varchar(50) not null,
    phn_num varchar(10) not null,
    type int not null,
    constraint uid_check check (uid like "%kr%" OR "%gm%" OR "%in%"),
    constraint class_check check (class>=0 AND class<=12),
    constraint phone_check check(length(phn_num) = 10),
    constraint not_empty check(length(name) or length(f_name) or length(m_name) > 0)
);
select * from studentDetails;
drop table studentDetails;

insert into teacherDetails VALUES("KR004028","Harman","[11,12]","11A","['Hindi', 'English']");
drop table teacherDetails;