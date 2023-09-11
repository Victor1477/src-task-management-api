create database taskmanagement;

use taskManagement;

create table tasks(
id int auto_increment,
code varchar(255),
description varchar(255),
feature_flag_name varchar(100),
created_date date,
notes varchar(255),
is_active boolean,
primary key(id)
);

create table attachments (
id int primary key auto_increment,
file_name varchar(255),
content_type varchar(255),
file_data longblob,
task_id integer,
foreign key (task_id) references tasks(id)
);