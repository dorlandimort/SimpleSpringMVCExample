create database cuentas;
use cuentas;

create table persona(id int auto_increment primary key , nombre varchar(50), email varchar(50), estado varchar(10));
create table perfil(id int auto_increment primary key, nombre varchar(50), descripcion varchar(100), estado varchar(10));
create table cuenta(id int auto_increment primary key, usuario varchar(50), contrasena varchar(100), estado varchar(10), persona_id int, perfil_id int,
foreign key (persona_id) references persona(id), foreign key (perfil_id) references perfil(id));

insert into persona(nombre, email, estado) values ('Bruce Wayne', 'wayne@inc.com', 'activo');
insert into persona(nombre, email, estado) values ('Elliot Anderson', 'f#ck@s0ci3ty.com', 'activo');
insert into persona(nombre, email, estado) values ('Tyrel Wellick', 'evil@corp.com', 'activo');

insert into perfil(nombre, descripcion, estado) values ('Manager', 'Manager de ventas', 'activo');
insert into perfil(nombre, descripcion, estado) values ('Jefe', 'Security Chief', 'activo');
insert into perfil(nombre, descripcion, estado) values ('Jefe', 'Chief Technology Officer', 'activo');

insert into cuenta(usuario, contrasena, estado, persona_id, perfil_id) values ('wayne', '12345', 'activo', 1, 1);
insert into cuenta(usuario, contrasena, estado, persona_id, perfil_id) values ('elliot', '12345', 'activo', 2, 2);
insert into cuenta(usuario, contrasena, estado, persona_id, perfil_id) values ('tyrel', '12345', 'activo', 3, 3);
