create database gradeTrackerApp;
use gradeTrackerApp;

create table users (
	userName char not null,					# '7hang'
    userPassword char not null,				# 'Zxc1032002'
    userId int not null,					# '1'
    primary key (userid)			
);

create table semester (
	semesterLabel char not null,			# 'Spring-25'
    semesterNote char,						# "My Gpa be dropping bro..."
	semesterId int not null,				# '1'
    userId int not null,
    primary key (semesterId),
    foreign key (userId) references users (userId)
);

create table class (
	className char not null,				# 'Introduction to Algorithms'
    classCode char not null,				# 'CS430'
    classWeight int not null,				# '3'
    classActualGrade char,					# 'B'
    classNote char,							# "This class is taught by professor Bauer"
	classId int not null,					# '1'
    semesterId int not null,
    primary key (classId),
    foreign key (semesterId) references semester (semesterId)
);

create table gradePartition (
	partitionName char not null,			# 'Exams'
    partitionPercent numeric not null,			# '60.5%'
    partitionNote char,						# "There is three exams, each 20%!"
	partitionId int not null,				# '1'
    classId int not null,
    primary key (partitionId),
    foreign key (classId) references class (classId)
);

create table grade (
	gradeGot numeric,						# '45.5'
	gradeOutOf numeric not null,			# '50'
	gradeNote char,							# "I screwed up on this assignment..."
	gradeId int not null,
    partitionId int not null,
    primary key (gradeId),
    foreign key (partitionId) references gradePartition (partitionId)
)