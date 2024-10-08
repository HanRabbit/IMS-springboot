数据库创建命令:
```
create table item_approval
(
    item_name       varchar(40)                        null,
    item_id         int auto_increment
        primary key,
    approval_status tinyint  default 0                 null,
    approval_time   datetime default CURRENT_TIMESTAMP null,
    approval_reason varchar(50)                        null,
    item_number     int                                not null
);
```
