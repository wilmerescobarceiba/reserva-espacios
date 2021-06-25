create table aliado (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 nit varchar(45) not null,
 primary key (id)
);

create table categoria (
 id int(11) not null auto_increment,
 codigo varchar(100) not null,
 nombre varchar(100) not null,
 fotografia text not null,
 primary key (id)
);

create table horario (
 id int(11) not null auto_increment,
 hora varchar(20) not null,
 primary key (id)
);

create table espacio (
 id int(11) not null auto_increment,
codigo varchar(20) not null,
nombre varchar(100) not null,
descripcion  varchar(200) not null,
capacidad int(11) not null,
costo double not null,
fotografia text not null,
idcategoria int(11) not null,
 primary key (id)
);

create table reserva (
 id int(11) not null auto_increment,
fecha date not null,
idaliado int(11) not null,
idespacio int(11) not null,
costototal double not null,
idhorario int(11) not null,
 primary key (id)
);

create table espacio_horario (
 id int(11) not null auto_increment,
idespacio int(11) not null,
idhorario int(11) not null,
 primary key (id)
);
insert into horario( hora) values ('07:00 AM - 08:00 AM');
insert into horario( hora) values ('08:00 AM - 08:00 AM');
insert into horario( hora) values ('09:00 AM - 10:00 AM');
insert into horario( hora) values ('10:00 AM - 11:00 AM');
insert into horario( hora) values ('11:00 AM - 12:00 M');
insert into horario( hora) values ('01:00 PM - 02:00 PM');
insert into horario( hora) values ('02:00 PM - 03:00 PM');
insert into horario( hora) values ('03:00 PM - 04:00 PM');
insert into horario( hora) values ('04:00 PM - 05:00 PM');
