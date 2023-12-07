-- auto-generated definition
create table if not exists
    straycat_user_info (
        USER_ID DECIMAL NOT NULL COMMENT '用户ID',
        LOGIN_NAME varchar(30) NOT NULL COMMENT '登录名',
        CELL_PHONE varchar(30) DEFAULT NULL COMMENT '手机号码'
    );

