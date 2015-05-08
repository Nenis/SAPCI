:- dynamic area/1.

area(emergencias).
area(wayner).
area(mierda).

:- dynamic padecimiento/2.

padecimiento(gonorrea1,emergencias).
padecimiento(gonorrea2,emergencias).
padecimiento(gonorrea3,emergencias).
padecimiento(gonorrea4,emergencias).
padecimiento(a,emergencias).
padecimiento(gogasnorrea2,emergencias).
padecimiento(gonofasdrrea3,emergencias).
padecimiento(gonorrefadsa4,emergencias).
padecimiento(cancer,wayner).
padecimiento(cancer2,wayner).
padecimiento(cancer3,wayner).

padecimiento(gripe,mierda).
padecimiento(mocos,mierda).
padecimiento(gripe6,mierda).

:- dynamic doctor/3.

doctor(andres,emergencias,3).
doctor(roberto,wayner,3).
doctor(noob,wayner,3).
doctor(dios,emergencias,3).
doctor(goku,mierda,3).


:- dynamic paciente/7.
paciente(13,kenafdsneth,19,masculino,898989,gonorrea1,alto).
paciente(14,kenfasneth,19,masculino,898989,gonorrea2,bajo).
paciente(11,kennesfdth,19,masculino,898989,gonorrea3,alto).
paciente(12,kennafsdeth,19,masculino,898989,gonorrea4,medio).

:- dynamic cita/3.

cita(13,andres,1234).
cita(14,roberto,142312).
cita(11,noob,113).
