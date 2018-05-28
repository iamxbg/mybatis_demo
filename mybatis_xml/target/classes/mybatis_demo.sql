create database mybatis_test default charset utf8;

create table user_t(
	id int not null auto_increment,
	`name` varchar(20) not null,
	`age` int not null,
	primary key(id)
);

insert into user_t(`name`,age) values ('wilson goodfellow',32);

select * from user_t;

commit;

use mybatis_test;

show databases;

show tables;