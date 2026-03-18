create database PontoPonto;
use PontoPonto;

create table departamento(
idDepartamento int identity primary key,
nomeDepartamento varchar(50)
);

create table funcionario(
idFuncionario int identity primary key,
departamentoFuncionario int,
matriculaFuncionario int,
nomeFuncionario varchar(50),
foreign key (departamentoFuncionario) references departamento(idDepartamento)
);

create table ponto(
idPonto int identity primary key,
funcionarioPonto int,
dataHora dateTime,
foreign key (funcionarioPonto) references funcionario(idFuncionario)
);

insert into departamento(nomeDepartamento)
values('Departamento do ponto');

insert into funcionario(departamentoFuncionario,matriculaFuncionario,nomeFuncionario)
values(1,027,'Teste da Silva');

insert into ponto(funcionarioPonto,dataHora)
values(1,'20260317 12:00:00'),(1,'20260317 18:00:00'),(1,'20260317 21:00:00'),(1,'20260317 23:00:00');

select * from funcionario

select * from departamento

select * from ponto