create table members (
    mb_id varchar2(20)
        CONSTRAINT members_mb_id_pk primary key
        constraint members_mb_id_nn not null,
    mb_type char(1),
    mb_pwd varchar2(30)
        constraint members_mb_pwd_nn not null,
    mb_indate date default sysdate
        constraint members_mb_indate_nn not null,
    mb_email varchar2(50)
       constraint members_mb_email_nn not null
);    