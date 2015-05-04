:- dynamic area/1.

area(emergencias).
area(wayner).
area(mierda).

:- dynamic padecimiento/2.

padecimiento(gonorrea1,emergencias).
padecimiento(gonorrea2,emergencias).
padecimiento(gonorrea3,emergencias).
padecimiento(gonorrea4,emergencias).

padecimiento(cancer,wayner).
padecimiento(cancer2,wayner).
padecimiento(cancer3,wayner).

padecimiento(gripe,mierda).

:- dynamic nivelIntensidad/1.

nivelIntensidad(bajo).
nivelIntensidad(medio).
nivelIntensidad(alto).

%:- dynamic doctor/3.

%doctor(N,A,C):- area(A).

%:- dynamic paciente/7.

%paciente(ID,N,E,G,T,P,NI):- nivelIntensidad(NI), padecimiento(P,X).



%:- dynamic asignarCita/3


%asignarCita()



%buscarCita(ID,X,NI,FI).

%buscarCita(ID,A,NI,FI):- doctor(N,A,C), fechaSegunDoctor(N,C,NI,FI,F).

%citasDoc(D,LP,F,0).

%fechaSegunDoctor(D,C,NI,FI,F):- NI =:= bajo, Y is FI + 2, estoyEnElDia(D,C,FI,F).

%estoyEnElDia(D,0,FI,F):- doctor(N,_,C),Y is FI + 1 , estoyEnElDia(D,C,Y,F).
%estoyEnElDia(D,C,FI,F):- citasDoc(D,_,FI), Y is C - 1,estoyEnElDia(D,Y,FI,F).
%si esto retorna false entonces
%estoyEnElDia(D,C,FI,FI).


%buscarFecha(D,NI,C,FI):- citasDoc(D,_,F), F =



%cita(D,P,F):- doctor(D,_,_),paciente(P,_,_).
%asignarPaciente(I,P,NI):- padecimiento(P,X), doctor(N,X,C),
