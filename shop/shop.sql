create table customer (
no int primary key auto_increment,
name varchar(10),
id varchar(100),
pw varchar(100),
addr varchar(100),
tel varchar(100)
)

select * from customer
alter table customer convert to character set utf8

create table board (
no int primary key auto_increment,
title varchar(100),
author varchar(100),
content varchar(10000),
nal date,
readCount varchar(100)
)

select * from board
alter table board convert to character set utf8
