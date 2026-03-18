create database PontoPonto;
use PontoPonto;

create table departamento(
idDepartamento int auto_increment primary key,
nomeDepartamento varchar(50)
);

create table funcionario(
idFuncionario int auto_increment primary key,
departamentoFuncionario int,
matriculaFuncionario int,
nomeFuncionario varchar(50),
foreign key (departamentoFuncionario) references departamento(idDepartamento)
);

create table ponto(
idPonto int auto_increment primary key,
funcionarioPonto int,
dataHora dateTime,
foreign key (funcionarioPonto) references funcionario(idFuncionario)
);

insert into departamento(nomeDepartamento)
values("Departamento do ponto");

insert into funcionario(departamentoFuncionario,matriculaFuncionario,nomeFuncionario)
values(1,027,"Teste da Silva");

insert into ponto(funcionarioPonto,dataHora)
values(1,"2026-03-17 12:00:00"),(1,"2026-03-17 18:00:00"),(1,"2026-03-17 21:00:00"),(1,"2026-03-17 23:00:00");
