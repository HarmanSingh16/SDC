create database springdalecollege;
use springdalecollege;

select * from studentDetails;
CREATE USER IF NOT EXISTS 'kr004028''@''%' IDENTIFIED BY 'hs@160201';

create table IF NOT EXISTS teacherDetails(
	uid CHAR(8) Primary key,
    name VARCHAR(50) NOT NULL,
    classes JSON NOT NULL,
    classTeacherOf VARCHAR(3) NOT NULL,
    subjects JSON NOT NULL,
    type INT not null
);
create table IF NOT EXISTS studentDetails(
	uid CHAR(8) Primary Key,
    name VARCHAR(50) not null,
    class INT not null,
    section char(1) not null,
    type int not null,
    check (uid like "KR" OR "GM" OR "IN"),
    check (class>=0 AND class<=12)
);


drop table teacherDetails;