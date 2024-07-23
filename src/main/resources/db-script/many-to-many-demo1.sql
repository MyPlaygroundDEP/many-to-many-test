create table course
(
    code     varchar(10) primary key,
    name     varchar(200) not null,
    duration varchar(20)  not null
);

create table student
(
    id      varchar(10) primary key,
    name    varchar(200) not null,
    address varchar(500) not null,
    contact varchar(13)  not null,
    dob     DATE         not null
);


create table student_course
(
    course_code varchar(10) not null ,
    student_id varchar(10) not null ,
    registered_by varchar(30) not null,
    date DATE not null ,
    constraint fk_course foreign key (course_code) references course(code),
    constraint fk_student foreign key (student_id) references student(id),
    constraint pk_course_student primary key (student_id,course_code)

);