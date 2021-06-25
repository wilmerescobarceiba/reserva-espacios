insert into aliado ( nit, nombre) values('1234','Empresa X');
insert into categoria(codigo, nombre, fotografia) values('12345','Categoria X','base64...');
insert into espacio(codigo, nombre, descripcion, capacidad, costo, fotografia, idcategoria)
    values('1234','Espacio X','Descripcion X','10','10000','base64...',select id from categoria c where c.codigo = '12345' limit 1);
insert into espacio(codigo, nombre, descripcion, capacidad, costo, fotografia, idcategoria)
    values('12345','Espacio Y','Descripcion Y','10','10000','base64...',select id from categoria c where c.codigo = '12345' limit 1);
insert into reserva (id,fecha,idaliado,idespacio, costototal, idhorario ) values (10,now(),1, 2, 10000, 1);
insert into espacio_horario (idhorario,idespacio ) values (1, 1);
