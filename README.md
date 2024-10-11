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
)
    engine = InnoDB;

create table item_statuses
(
    item_id            int auto_increment
        primary key,
    statusid           int  null,
    status             int  null,
    status_change_data date null
)
    engine = InnoDB;

create table item_transactions
(
    transaction_id   int auto_increment
        primary key,
    item_id          int         null,
    transaction_type varchar(50) not null,
    transaction_date date        not null,
    quantity_changed int         not null
)
    engine = InnoDB;

create table items
(
    item_id    int auto_increment
        primary key,
    item_name  varchar(100)  not null,
    category   varchar(50)   not null,
    quantity   int           not null,
    location   varchar(100)  null,
    needRepair int default 0 null
)
    engine = InnoDB;

create table repair_item
(
    repair_id     int auto_increment
        primary key,
    item_name     varchar(30)      null,
    item_quantity tinyint unsigned null,
    location      varchar(30)      null,
    reason        varchar(20)      null,
    state         tinyint unsigned null,
    create_time   datetime         null,
    repair_time   datetime         null,
    user_name     varchar(30)      null,
    repairer      varchar(30)      null
)
    engine = InnoDB;

create table users
(
    user_id     int auto_increment
        primary key,
    username    varchar(50)   not null,
    password    varchar(255)  not null,
    email       varchar(100)  not null,
    permissions int default 1 null,
    constraint email
        unique (email),
    constraint username
        unique (username)
)
    engine = InnoDB;

```
