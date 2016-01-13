use test;

drop table if exists article;
CREATE TABLE article (
  articleId int(20) NOT NULL auto_increment,
  title varchar(128) NOT NULL,
  articleType int not null,
  summary varchar(1024) default null,
  content text not null,
  createBy varchar(32) NOT NULL,
  createTime long not NULL,
  lastUpdBy varchar(32) NOT NULL,
  lastUpdTime long not NULL,
  
  PRIMARY KEY  (articleId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

drop table if exists tag;
CREATE TABLE tag (
  tagId int(20) not null auto_increment,
  tagName varchar(64) not null,
  tagType int not null,
  
  PRIMARY KEY  (tagId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

drop table if exists article_tags;
CREATE TABLE article_tags (
  articleId int(20) NOT NULL,
  tagId int(20) not null
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists clicks;
CREATE TABLE clicks (
  articleId int(20) unique NOT NULL,
  clicks int(32) not null
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists comments;
CREATE TABLE comments (
  commentId int(20) not null auto_increment,
  articleId int(20) default -1,
  content varchar(5000) not null,
  status int not null,
  createTime long not NULL,
  
  PRIMARY KEY  (commentId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

drop table if exists subject;
CREATE TABLE subject (
  subjectId int(20) not null auto_increment,
  articleId int(20) not null,
  difficulty int not null,
  timeLimit int not null,
  memoryLimit int not null,
  otherLimit varchar(256) default null,
  
  PRIMARY KEY  (subjectId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create table loginAccount
(
   id                   int(128) not null auto_increment,
   loginAccount         varchar(64) not null,
   password             varchar(64) not null,
   role                 int(1) not null,
   mobilePhone          varchar(32),
   sex                  int(1) comment '0-女
            1-男',
   nickname             varchar(64),
   headimgurl           varchar(512),
   country              varchar(64),
   city                 varchar(64),
   province             varchar(64),
   createTime           datetime not null,
   status               int(1) not null comment '0-无效
            1-有效',
   primary key (id)
);

create table loginLog
(
   logId                int(11) not null auto_increment,
   loginAccount         int(64),
   loginType            int(2) comment '1-登录
            2-主动退出
            3-被动退出',
   oprTime              datetime,
   ip                   varchar(64),
   os                   varchar(64),
   browser              varchar(64),
   primary key (logId)
);


