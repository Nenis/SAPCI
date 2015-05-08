:- dynamic area/1.

area(emergencias).
area(odontologia).
area(cardiologia).

:- dynamic padecimiento/2.

padecimiento(quebradura, emergencias).
padecimiento(operacion, cardiologia).

:- dynamic doctor/3.

doctor(andres, emergencias, 3).
doctor(jose, emergencias, 2).
doctor(guillen, cardiologia, 2).

:- dynamic paciente/7.

paciente(898578, silvia, 18, femenino, 456789, quebradura, alto).
paciente(17, steve, 5, masculino, 77, quebradura, medio).
paciente(22, monica, 6, fenemino, 85, quebradura, alto).
paciente(77, mike, 4, masculino, 55, quebradura, alto).
paciente(45, mell, 4, fenemino, 22, quebradura, alto).
paciente(96, kike, 7, masculino, 85, quebradura, alto).
paciente(12, mely, 10, fenemino, 78, quebradura, alto).
paciente(99, pablo, 10, masculino, 44, quebradura, bajo).
paciente(266, kevin, 4, masculino, 85, quebradura, medio).
paciente(5115, ajaj, 3, masculino, 44, quebradura, alto).
paciente(82, ya, 3, masculino, 99, quebradura, alto).
paciente(111, kim, 4, fenemino, 88, quebradura, alto).
paciente(823, stan, 3, masculino, 88, quebradura, alto).
paciente(166, momo, 4, fenemino, 88, quebradura, alto).
paciente(455, po, 4, fenemino, 88, quebradura, alto).
paciente(358, nomi, 4, fenemino, 77, quebradura, alto).
paciente(741, keke, 4, fenemino, 85, quebradura, alto).
paciente(258, jaja, 3, masculino, 77, quebradura, alto).
paciente(16, messi, 6, masculino, 77, quebradura, alto).
paciente(9637, jime, 6, masculino, 77, quebradura, alto).
paciente(8521, yiyo, 6, masculino, 85, quebradura, alto).
paciente(785214, iker, 6, masculino, 55, quebradura, alto).
paciente(55, kier, 6, masculino, 55, quebradura, alto).
paciente(25587, hugo, 6, masculino, 77, quebradura, alto).
paciente(7456, vero, 5, fenemino, 64, quebradura, alto).
paciente(1411, wayner, 14, masculino, 88, operacion, alto).

:- dynamic cita/3.

cita(898578, andres, 2015).
cita(166, andres, 2015-5-7).
cita(455, andres, 2015-5-7).
cita(358, andres, 2015-5-7).
cita(741, andres, 2015-5-7).
cita(258, andres, 2015-5-7).
cita(16, andres, 2015-5-8).
cita(9637, andres, 2015-5-8).
cita(8521, andres, 2015-5-8).
cita(785214, jose, 2015-5-8).
cita(55, jose, 2015-5-8).
cita(25587, andres, 2015-5-11).
cita(7456, andres, 2015-5-9).
cita(1411, guillen, 2015-5-8).

