create schema page_test;

create table student
(
    id               bigint(11) auto_increment comment '主键',
    student_name     varchar(50)   default '' not null comment '学生姓名',
    age              int           default 0  null comment '年龄',
    student_describe varchar(4000) default '' null comment '学生描述',
    classroom_id     bigint                   null comment '关联id',
    constraint student_pk
        primary key (id)
)
    comment '学生表';

insert into student (student_name, age, student_describe, classroom_id) value ('张三', 18, '坏坏的一个人', 1);
insert into student (student_name, age, student_describe, classroom_id) value ('张之分', 18, '牛逼的人', 1);
insert into student (student_name, age, student_describe, classroom_id) value ('李佳芮', 19, '很好的女孩子', 2);

create table classroom
(
    id                 bigint(11) auto_increment comment '主键',
    classroom_name     varchar(50)   default '' not null comment '班级名',
    classroom_describe varchar(4000) default '' null comment '班级描述',
    constraint classroom_pk
        primary key (id)
)
    comment '班级表';

insert into classroom(classroom_name, classroom_describe) value ('普通班', '里面的人有好有坏');
insert into classroom(classroom_name, classroom_describe) value ('尖子班', '里面的人都是牛逼的人物');