:- dynamic area/1.

area(odontologia).
area(medicina_general).
area(pediatria).
area(emergencias).
area(laboratorio).
area(cardiologia).
area(nueva_area_).

:- dynamic padecimiento/2.

padecimiento(dolor_de_muela, odontologia).
padecimiento(desmayo, emergencias).
padecimiento(quebradura, emergencias).
padecimiento(inyeccion, pediatria).

:- dynamic doctor/3.

doctor(sillvia_alpizar, odontologia, 5).
doctor(valery_alpizar, medicina_general, 5).
doctor(dario_rivera, emergencias, 2).

:- dynamic paciente/7.

paciente(103, marco_rivera, 8, masculino, 98376434, dolor_de_muela, medio).
paciente(101, silvia_alpiza, 16, fenemino, 87267365, desmayo, alto).
paciente(102, rosa_rivera, 30, fenemino, 98765432, quebradura, medio).
paciente(103, marco_rivera, 8, masculino, 98376434, dolor_de_muela, medio).

:- dynamic cita/3.

cita(103, sillvia_alpizar, 2015-5-11).
cita(101, dario_rivera, 2015-5-9).
cita(102, dario_rivera, 2015-5-11).
cita(103, sillvia_alpizar, 2015-5-11).

