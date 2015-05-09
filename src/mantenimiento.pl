:- dynamic area/1.

area(emergencias).
area(caridiologia).
area(odontologia).
area(laboratorio).
area(medicina_general).
area(silvia_noob).
area(rtgbrt_tybtyb).
area(hola_bebes).
area(jaja).
area(haha).
area(noooamgasfsda).
area(lol).
area(omg_culo).

:- dynamic padecimiento/2.

padecimiento(cortadura, emergencias).
padecimiento(dolor_de_pecho, emergencias).
padecimiento(dolor_de_muela, odontologia).
padecimiento(operacion_de_muelas, odontologia).
padecimiento(cambio_de_frenillos, odontologia).
padecimiento(examen_de_sangre, laboratorio).
padecimiento(examen_de_orina, laboratorio).
padecimiento(dolor_de_cabeza, medicina_general).
padecimiento(quebradura, emergencias).
padecimiento(desmayo, emergencias).

:- dynamic doctor/3.

doctor(popop, rtgbrt_tybtyb, 1).
doctor(popop, rtgbrt_tybtyb, 1).
doctor(popop, rtgbrt_tybtyb, 1).
doctor(alberto, emergencias, 4).
doctor(alejandro, caridiologia, 1).
doctor(roberto, caridiologia, 3).
doctor(juan, odontologia, 2).
doctor(melvin, odontologia, 4).
doctor(kenneth, laboratorio, 6).
doctor(gerardo, medicina_general, 6).
doctor(carolina, medicina_general, 6).
doctor(lucia, laboratorio, 6).
doctor(popop, rtgbrt_tybtyb, 1).

:- dynamic paciente/7.

paciente(1001, silvia, 20, fenemino, 86241051, cortadura, medio).
paciente(1002, pablo, 27, masculino, 82541254, dolor_de_muela, medio).
paciente(1003, ligia, 33, fenemino, 87451202, examen_de_orina, alto).
paciente(1004, rosa, 31, fenemino, 84963215, desmayo, alto).

:- dynamic cita/3.

cita(1001, alberto, 2015-5-10).
cita(1002, juan, 2015-5-10).
cita(1003, kenneth, 2015-5-8).
cita(1004, alberto, 2015-5-9).

