update espacio
set nombre = :nombre,
	codigo = :codigo,
	descripcion = :descripcion,
	capacidad = :capacidad,
	costo = :costo,
	fotografia = :fotografia,
	idcategoria = :idcategoria
where id = :id