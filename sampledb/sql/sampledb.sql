drop database if exists sampledb;
create database sampledb;
use sampledb;


create table sample_table(
no int, name varchar(50),age int,mail varchar(50))

insert into sample_table values(1,"Yamada","21","xxx@yahoo.co.jp");
insert into sample_table values(2,"Sato","39","gggg@yahoo.co.jp");
insert into sample_table values(3,"Yamada","21","hhh@yahoo.co.jp");

