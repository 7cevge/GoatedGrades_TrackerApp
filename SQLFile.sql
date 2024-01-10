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
    semesterPosition int not null,
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
    classPosition int not null,
	classId int not null,							# '1'
    semesterId int not null,
    primary key (classId),
    foreign key (semesterId) references semester (semesterId)
);

create table gradePartition (
	partitionName varchar(20) not null,				# 'Exams'
    partitionPercent numeric(9,5) not null,			# '60.5%'
    partitionNote text,								# "There is three exams, each 20%!"
    partitionPosition int not null,
	partitionId int not null,						# '1'
    classId int not null,
    primary key (partitionId),
    foreign key (classId) references class (classId)
);

create table grade (
	gradeGot numeric(9,5),							# '45.5'
	gradeOutOf numeric(9,5) not null,				# '50'
	gradeNote text,									# "I screwed up on this assignment..."
    gradePrediction boolean not null,				# 'false'
    gradePosition int not null,
	gradeId int not null,							# '1'
    partitionId int not null,
    primary key (gradeId),
    foreign key (partitionId) references gradePartition (partitionId)
);

create table timeline (
    yy int,
    mm int,
    dd int,
    gradeId int not null,
    timeId int not null,
    primary key (timeId),
    foreign key (gradeId) references grade (gradeId)
);

# testing - - - - - - - - - - - - - - - - - - - - -

insert into users 
values ('7hang', 'zxc123', 1);

insert into semester
values ('Spring25', 'very busy this sem!', 1, 1, 1);

insert into class
values ('intro to algo', 'CS430', 3, 'B', 'This class is taught by bauer', 1, 1, 1);

insert into gradePartition
values ('exams', 60.5, '3 exams', 1, 1, 1);

insert into grade
values (37.75, 50, 'not too bad?', false, 1, 1, 1);

insert into timeline
values (23, 10, 16, 1, 1); 

select * from users;
select * from semester;
select * from class;
select * from gradePartition;
select * from grade;
select * from timeline;