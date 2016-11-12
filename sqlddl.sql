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
    mcqAnswer1 varchar(200),
    mcqAnswer2 varchar(200),
    mcqAnswer3 varchar(200),
    mcqAnswer4 varchar(200),
    mcqAnswer5 varchar(200),
    question varchar(2000),
    trueOrFalse numeric(2),
    fillInTheBlankAnswer varchar(200)
);

insert into question values (1, 2, 5, 'option 1', 'option 2', 'option 3', 'option 4', 'option 5', 
    'Question text?', -1, ''
);