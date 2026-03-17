create database ponto;

use ponto;

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