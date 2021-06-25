select eh.id, eh.idhorario, eh.idespacio
from espacio_horario eh inner join espacio e on eh.idespacio = e.id
