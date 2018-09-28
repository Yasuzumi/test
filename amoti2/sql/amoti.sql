set names utf8;
set foreign_key_checks=0;

drop database if exists amoti;
create database if not exists amoti;

use amoti;

create table user_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) unique not null comment "ユーザーID",
password varchar(16) not null comment "パスワード",
family_name varchar(32) not null comment "姓",
first_name varchar(32) not null comment "名",
family_name_kana varchar(32) not null comment "姓かな",
first_name_kana varchar(32) not null comment "名かな",
sex tinyint not null default 0 comment "姓別",
email varchar(32) not null comment "メールアドレス",
status tinyint not null default 0 comment "ステータス",
logined tinyint not null default 0 comment "ログインフラグ",
regist_date datetime not null comment "登録日",
update_date datetime not null comment "更新日"
)
default charset=utf8
comment="会員情報テーブル"
;

insert into user_info values
(1,"guest","guest","インターノウス","ゲストユーザー","いんたーのうす","げすとゆーざー",0,"guest@gmail.com",0,0,now(),now()),
(2,"guest2","guest2","インターノウス","ゲストユーザー2","いんたーのうす","げすとゆーざー2",0,"guest2@gmail.com",0,0,now(),now()),
(3,"guest3","guest3","インターノウス","ゲストユーザー3","いんたーのうす","げすとゆーざー3",0,"guest3@gmail.com",0,0,now(),now()),
(4,"guest4","guest4","インターノウス","ゲストユーザー4","いんたーのうす","げすとゆーざー4",0,"guest4@gmail.com",0,0,now(),now()),
(5,"guest5","guest5","インターノウス","ゲストユーザー5","いんたーのうす","げすとゆーざー5",0,"guest5@gmail.com",0,0,now(),now()),
(6,"guest6","guest6","インターノウス","ゲストユーザー6","いんたーのうす","げすとゆーざー6",0,"guest6@gmail.com",0,0,now(),now()),
(7,"guest7","guest7","インターノウス","ゲストユーザー7","いんたーのうす","げすとゆーざー7",0,"guest7@gmail.com",0,0,now(),now()),
(8,"guest8","guest8","インターノウス","ゲストユーザー8","いんたーのうす","げすとゆーざー8",0,"guest8@gmail.com",0,0,now(),now()),
(9,"guest9","guest9","インターノウス","ゲストユーザー9","いんたーのうす","げすとゆーざー9",0,"guest9@gmail.com",0,0,now(),now()),
(10,"guest10","guest10","インターノウス","ゲストユーザー10","いんたーのうす","げすとゆーざー10",0,"guest10@gmail.com",0,0,now(),now()),
(11,"guest11","guest11","インターノウス","ゲストユーザー11","いんたーのうす","げすとゆーざー11",0,"guest11@gmail.com",0,0,now(),now()),
(12,"guest12","guest12","インターノウス","ゲストユーザー12","いんたーのうす","げすとゆーざー12",0,"guest12@gmail.com",0,0,now(),now());

create table product_info(
id int primary key not null auto_increment comment "ID",
product_id int unique not null comment "商品ID",
product_name varchar(100) unique not null comment "商品名",
product_name_kana varchar(100) not null comment "商品名かな",
product_description varchar(255) not null comment "商品詳細",
category_id int not null not null comment "カテゴリID",
price int comment "価格",
image_file_path varchar(100) comment "画像ファイルパス",
image_file_name varchar(50) comment "画像ファイル名",
release_date datetime not null comment "発売年月",
release_company varchar(50) comment "発売会社",
status tinyint not null default 0 comment "ステータス",
regist_date datetime not null comment "登録日",
update_date datetime comment "更新日",
foreign key(category_id) references m_category(category_id)
)
default charset=utf8
comment="商品情報テーブル"
;

set foreign_key_checks=0;
insert into product_info values
( 1, 1,"Illustration1","いらすと１","Illustration１の商品詳細",2,100,"./images","illust1.jpg",now(),"発売会社",0,now(),now()),
( 2, 2,"Illustration2","いらすと２","Illustration２の商品詳細",2,200,"./images","illust2.jpg",now(),"発売会社",0,now(),now()),
( 3, 3,"Illustration3","いらすと３","Illustration３の商品詳細",2,300,"./images","illust3.jpg",now(),"発売会社",0,now(),now()),
( 4, 4,"Illustration4","いらすと４","Illustration４の商品詳細",2,100,"./images","illust4.jpg",now(),"発売会社",0,now(),now()),
( 5, 5,"Illustration5","いらすと５","Illustration５の商品詳細",2,200,"./images","illust5.jpg",now(),"発売会社",0,now(),now()),
( 6, 6,"Picture1","ぴくちゃー１","Picture１の商品詳細",3,100,"./images","picture1.jpg",now(),"発売会社",0,now(),now()),
( 7, 7,"Picture2","ぴくちゃー２","Picture２の商品詳細",3,200,"./images","picture2.jpg",now(),"発売会社",0,now(),now()),
( 8, 8,"Picture3","ぴくちゃー３","Picture３の商品詳細",3,300,"./images","picture3.jpg",now(),"発売会社",0,now(),now()),
( 9, 9,"Picture4","ぴくちゃー４","Picture４の商品詳細",3,100,"./images","picture4.jpg",now(),"発売会社",0,now(),now()),
( 10, 10,"Picture5","ぴくちゃー５","Picture５の商品詳細",3,200,"./images","picture5.jpg",now(),"発売会社",0,now(),now()),
( 11, 11,"Photography1","ふぉと１","Photography１の商品詳細",4,100,"./images","photo1.jpg",now(),"発売会社",0,now(),now()),
( 12, 12,"Photography2","ふぉと２","Photography２の商品詳細",4,200,"./images","photo2.jpg",now(),"発売会社",0,now(),now()),
( 13, 13,"Photography3","ふぉと３","Photography３の商品詳細",4,300,"./images","photo3.jpg",now(),"発売会社",0,now(),now()),
( 14, 14,"Photography4","ふぉと４","Photography４の商品詳細",4,100,"./images","photo4.jpg",now(),"発売会社",0,now(),now()),
( 15, 15,"Photography5","ふぉと５","Photography５の商品詳細",4,200,"./images","photo5.jpg",now(),"発売会社",0,now(),now()),
( 16, 16,"Others1","そのた１","Others１の商品詳細",5,100,"./images","others1.jpg",now(),"発売会社",0,now(),now()),
( 17, 17,"Others2","そのた２","Others２の商品詳細",5,200,"./images","others2.jpg",now(),"発売会社",0,now(),now()),
( 18, 18,"Others3","そのた３","Others３の商品詳細",5,300,"./images","others3.jpg",now(),"発売会社",0,now(),now()),
( 19, 19,"Others4","そのた４","Others４の商品詳細",5,100,"./images","others4.jpg",now(),"発売会社",0,now(),now()),
( 20, 20,"Others5","そのた５","Others５の商品詳細",5,200,"./images","others5.jpg",now(),"発売会社",0,now(),now());

create table cart_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
temp_user_id varchar(16) comment "仮ユーザーID",
product_id int not null comment "商品ID",
product_count int not null comment "個数",
price int not null comment "金額",
regist_date datetime not null comment "登録日",
update_date datetime comment "更新日"
)
default charset=utf8
comment="カート情報テーブル"
;

create table purchase_history_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
product_id int not null comment "商品ID",
product_count int not null comment "個数",
price int not null comment "金額",
destination_id int not null comment "宛先情報ID",
regist_date datetime not null comment "登録日",
update_date datetime not null comment "更新日",
foreign key(user_id) references user_info(user_id),
foreign key(product_id) references product_info(product_id)
)
default charset=utf8
comment="購入履歴情報テーブル";

create table destination_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
family_name varchar(32) not null comment "姓",
first_name varchar(32) not null comment "名",
family_name_kana varchar(32) not null comment "姓かな",
first_name_kana varchar(32) not null comment "名かな",
email varchar(32) not null comment "メールアドレス",
tel_number varchar(13) not null comment "電話番号",
user_address varchar(50) not null comment "住所",
regist_date datetime not null comment "登録日",
update_date datetime not null comment "更新日"
)
default charset=utf8
comment="宛先情報テーブル";

insert into destination_info values
(1,"guest","インターノウス","テストユーざー","いんたーのうす","てすとゆーざー","guest@internous.co.jp","080-1234-5678","東京都千代田区三番町１ー１　ＫＹ三番町ビル１Ｆ",now(),"0000-00-00 00:00:00");

create table m_category(
id int primary key not null comment "ID",
category_id int not null unique comment "カテゴリID",
category_name varchar(20) not null unique comment "カテゴリ名",
category_description varchar(100) comment "カテゴリ詳細",
insert_date datetime not null comment "登録日",
update_date datetime comment "更新日"
)
default charset=utf8
comment="カテゴリマスタテーブル"
;

insert into m_category values
(1,1,"全てのカテゴリー","Illustration/Picture/Photography/Others全てのカテゴリーが対象となります",now(), null),
(2,2,"Illustration","Illustrationに関するカテゴリーが対象となります",now(),null),
(3,3,"Picture","Pictureに関するカテゴリーが対象となります",now(),null),
(4,4,"Photography","Photographyに関するカテゴリーが対象となります",now(),null),
(5,5,"Others","Othersに関するカテゴリーが対象となります",now(),null);