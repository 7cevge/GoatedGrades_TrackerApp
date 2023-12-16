create database gradeTrackerApp;
use gradeTrackerApp;

create table users (
	userName varchar(20) not null,					# '7hang'
    userPassword varchar(20),						# 'Zxc1032002'
    userId int not null,							# '1'
    primary key (userid)			
);

create table semester (
	semesterLabel varchar(20) not null,				# 'Spring-25'
    semesterNote text,								# "My Gpa be dropping bro..."
	semesterId int not null,						# '1'
    userId int not null,
    primary key (semesterId),
    foreign key (userId) references users (userId)
);

create table class (
	className varchar(50) not null,					# 'Introduction to Algorithms'
    classCode varchar(10) not null,					# 'CS430'
    classWeight int not null,						# '3'
    classActualGrade char,							# 'B'
    classNote text,									# "This class is taught by professor Bauer"
	classId int not null,							# '1'
    semesterId int not null,
    primary key (classId),
    foreign key (semesterId) references semester (semesterId)
);

create table gradePartition (
	partitionName varchar(20) not null,				# 'Exams'
    partitionPercent numeric(9,5) not null,			# '60.5%'
    partitionNote text,								# "There is three exams, each 20%!"
	partitionId int not null,						# '1'
    classId int not null,
    primary key (partitionId),
    foreign key (classId) references class (classId)
);

create table grade (
	gradeGot numeric(9,5),							# '45.5'
	gradeOutOf numeric(9,5) not null,				# '50'
	gradeNote text,									# "I screwed up on this assignment..."
	gradeId int not null,							# '1'
    partitionId int not null,
    primary key (gradeId),
    foreign key (partitionId) references gradePartition (partitionId)
);

# testing - - - - - - - - - - - - - - - - - - - - -

insert into users
values ('7hang','','0');

insert into semester
values ('S24','','1','0');

insert into class
values ('name','label','3','','','1','1');

insert into gradePartition
values ('name','25','','1','1');

insert into grade
values ('6.75','10','fk','1','1');

select * from users;
select * from semester;
select * from class;
select * from gradePartition;
select * from grade;
