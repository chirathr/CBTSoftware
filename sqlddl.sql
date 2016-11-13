create table Student(
    id numeric(10) primary key,
    name varchar(100),
    username varchar(100),
    password varchar(100),
    email varchar(100),
    semster numeric(2)
);

insert into student values(1, 'Chirath R', 'chirath', '1234', 'chirath.02@gmail.com', 5);

create table Teacher(
    id numeric(10) primary key,
    name varchar(100),
    username varchar(100),
    password varchar(100),
    email varchar(100),
    depatment varchar(20)
);

insert into teacher values(1, 'Chirath R', 'chirath', '1234', 'chirath.02@gmail.com', 'CSE');

create table question(
    id numeric(10) primary key,
    type numeric(2),
    numerOfChoices numeric(2),
    choice1 varchar(200),
    choice2 varchar(200),
    choice3 varchar(200),
    choice4 varchar(200),
    choice5 varchar(200),
    question varchar(2000),
    mcqanswer numeric(2),
    trueOrFalse numeric(2),
    fillInTheBlankAnswer varchar(200),
    mark numeric(5),
    teacherId numeric references teacher
);

insert into question values (1, 2, 5, 'option 1', 'option 2', 'option 3', 'option 4', 'option 5', 
    'Question text?', 1, -1, '', 2, 1
);

create table exam(
    id numeric(10) primary key,
    examName varchar(100),
    dateOfExam varchar(100),
    teacherId numeric references teacher,
    totalMark float
);

insert into exam values(1, 'online exam 1', '13-11-2016', 1, 10);

create table examination(
    examId numeric(10) references exam,
    questionId numeric(10) references question
);

insert into examination values(1,1);

create table result(
    studentId numeric(10) references student,
    examName varchar(100),
    examId numeric(10),
    marks float,
    total float
);

insert into result values(1, 'online exam 1', 1, 10);