insert into espacio_horario (idespacio, idhorario)
select :idespacio, h.id from horario h;
