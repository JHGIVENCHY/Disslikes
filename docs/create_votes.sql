create table votes (
    vt_id varchar2(20)
        constraint votes_vt_id_nn not null,
    vt_name varchar2(50)
        constraint votes_vt_name_nn not null,
    vt_img_name varchar2(100)
        constraint votes_vt_img_name_nn not null,
    vt_img_path varchar2(100)
        constraint votes_vt_img_path_nn not null,
    vt_ag_name varchar(30)
        constraint votes_vt_ag_name_nn not null,
    vt_total_num number(10),
    vt_ag_num number(5)
        constraint votes_vt_ag_num_nn not null,
    vt_dag_num number(5)
        constraint votes_vt_dag_num_nn not null,
    vt_indate date default sysdate 
        constraint votes_vt_indate_nn not null,
    vt_stdate date
        constraint votes_vt_stdate_nn not null,
    vt_enddate date
        constraint votes_vt_enddate_nn not null,
    vt_type varchar2(10)
        constraint votes_vt_type_nn not null,
    vt_dtype varchar2(20)
        constraint votes_vt_dtype_nn not null
);