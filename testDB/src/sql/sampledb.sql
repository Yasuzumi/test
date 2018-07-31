drop database if exists sampledb;
create database sampledb;
use sampledb;

create table sample_table(
No int, name varchar(50),
age int, Mail varchar(50));




insert into sample_table values(1,"taro","123","xxx@yahoo.co.jp");
insert into sample_table values(2,"huh","456","gggg@yahoo.co.jp");
insert into sample_table values(3,"kkkk","789","ggg@yahoo.co.jp");