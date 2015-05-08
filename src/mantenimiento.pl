:- dynamic area/1.

area(emergencias).
area(odontologia).

:- dynamic padecimiento/2.

padecimiento(quebradura, emergencias).

:- dynamic doctor/3.

doctor(andres, emergencias, 3).

:- dynamic paciente/7.

paciente(898578, silvia, 18, femenino, 456789, quebradura, alto).

:- dynamic cita/3.

cita(898578, andres, 2015).

