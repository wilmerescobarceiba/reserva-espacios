insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());

insert into aliado ( nit, nombre) values('1234','Empresa X');
insert into categoria(codigo, nombre, fotografia) values('12345','Categoria X','base64...');
insert into espacio(codigo, nombre, descripcion, capacidad, costo, fotografia, idcategoria) 
        values('1234','Espacio X','Descripcion X','10','10000','base64...',select id from categoria c where c.codigo = '12345' limit 1);
insert into horario( hora) values ('07:00 AM - 08:00 AM');