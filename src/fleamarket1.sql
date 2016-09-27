/*删除fleamarket1数据库,如果存在*/
drop database if exists fleamarket1;
/*创建数据库,并设置编码*/
create database fleamarket1 default character set utf8;

use fleamarket1;

drop table if exists admin;

drop table if exists goods;

drop table if exists goodstype;

drop table if exists subtype;

drop table if exists user;

drop table if exists usercollect;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `pass` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
)


/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/
create table goods
(
   id                   int not null auto_increment,
   sid                  int,
   uid                  int,
   goodsName            varchar(30),
   releaseDate          timestamp,
   count                int,
   price                int,
   hit                  int,
   usetime              varchar(12),
   address              varchar(30),
   descriptionUrl       varchar(100),
   tag                  varchar(1),
   bizType              varchar(1),
   imgUrl               varchar(100),
   primary key (id)
);

/*==============================================================*/
/* Table: goodstype                                             */
/*==============================================================*/
create table goodstype
(
   id                   int not null auto_increment,
   goodsTypeName        varchar(12),
   primary key (id)
);

/*==============================================================*/
/* Table: subtype                                               */
/*==============================================================*/
create table subtype
(
   id                   int not null auto_increment,
   gid                  int,
   subTypeName          varchar(12),
   primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   int not null auto_increment,
   username             varchar(12),
   password             varchar(15),
   phoneNumber          varchar(20),
   qq                   varchar(11),
   email                varchar(20),
   primary key (id)
);

/*==============================================================*/
/* Table: usercollect                                           */
/*==============================================================*/
create table usercollect
(
   id                   int not null auto_increment,
   uid                  int,
   gid                  int,
   collectDate          timestamp,
   primary key (id)
);

alter table usercollect add constraint FK_user_collect foreign key (uid)
      references user (id) on delete cascade on update cascade;



select * from admin;
select * from user;
select * from goodstype;
select * from subtype;
select * from usercollect;
select * from goods;



