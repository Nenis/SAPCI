:- dynamic area/1.

area(emergencias).
area(odontologia).

:- dynamic padecimiento/2.

padecimiento(quebradura, emergencias).
padecimiento(55, k).

:- dynamic doctor/3.

doctor(andres, emergencias, 3).
doctor(jose, emergencias, 2).

:- dynamic paciente/7.

paciente(898578, silvia, 18, femenino, 456789, quebradura, alto).
paciente(17, steve, 5, masculino, 77, quebradura, medio).
paciente(22, monica, 6, fenemino, 85, quebradura, alto).
paciente(77, mike, 4, masculino, 55, quebradura, alto).
paciente(45, mell, 4, fenemino, 22, quebradura, alto).
paciente(96, kike, 7, masculino, 85, quebradura, alto).
paciente(12, mely, 10, fenemino, 78, quebradura, alto).
paciente(99, pablo, 10, masculino, 44, quebradura, bajo).

:- dynamic cita/3.

cita(898578, andres, 2015).
cita(45, andres, 2015-5-8).
cita(96, andres, 2015-5-8).
cita(12, andres, 2015-5-8).
cita(99, andres, 2015-5-22).

