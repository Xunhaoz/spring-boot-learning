drop table if exists `post`;

-- 貼文
create table `post`
(
    id         int primary key auto_increment comment 'PK',
    title      varchar(255)  not null comment '標題',
    content    varchar(1000) not null comment '內容',
    createTime datetime      not null comment '新增時間',
    updateTime datetime comment '更新時間',

);