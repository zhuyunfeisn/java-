drop database if exists servlet_blog;

create database servlet_blog character set utf8mb4;

use servlet_blog;

create table user (
 id int primary key auto_increment,
 username varchar (20) not null unique,
 password varchar (20) not null,
 nickname varchar(20),
 sex bit,
 birthday date,
 head varchar (50) comment '头像'
);

create table article(
id int primary key auto_increment,
title varchar (20)  not null comment'标题',
content mediumtext  not null comment '正文' ,
create_time timestamp default now(),
view_count int default 0,
user_id int ,
foreign key (user_id) references user(id)
);

insert into user(username,password) values
('张三','1001'),
('李四','1002'),
('王五','1003');

insert into article( title, content,  user_id) values
('快速排序','public...',1),
('冒泡排序','public...',1),
('选择排序','public...',1),
('归并排序','public...',2),
('插入排序','public...',2);

select id, username, password, sex, birthday, head from user where username='a';
select  id,title from article where user_id=1;
delete from article where id in (4,5);
insert into article(title,content,user_id) values
(?,?,?);

select id,title,content from article where id=?;