create database testModule3;
use testModule3;

create table class
(
	id int primary key auto_increment,
    className varchar(255) not null
);

create table student
(
	id int primary key auto_increment,
    studentName varchar(255) not null,
    dateOfBirth date not null,
    email varchar(255) unique not null,
    address varchar(255) not null,
    phone varchar(10) not null,
    classId int not null,
    foreign key (classId) references class(Id)
);

insert into class(className)
value ("C0823H1"),
("C0923G1"),
("C1023F1");

insert into student(studentName, dateOfBirth, email, address, phone, classId)
value ("Nguyen Van A",
	"1995-01-15",
	"nguyenvana@gmail.com",
	"Ha Noi",
	"0987654321",
    1
),
	("Nguyen Van B",
	"1997-11-22",
	"nguyenvanb@gmail.com",
	"Ha Noi",
	"0987655321",
    2
);

select s.id, s.studentName, s.dateOfBirth, s.email, s.address, s.phone, c.className from student s 
join class c on s.classId = c.id;
