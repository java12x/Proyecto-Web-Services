create database Academica;

use Academica;

create table Docente(
	id serial primary key not null, 
	codigo varchar(20),
	nombre varchar(60),
	direccion varchar(60),
	telefono varchar(60)
);

create table facultad(
	id serial primary key not null, 
	nombre varchar(60),
	telefono varchar(60),
	email varchar(60)
);

create table carrera(
	id serial primary key not null, 
	idFacultad int,
	codigo varchar(20),
	nombre varchar(60),
	foreign key(idFacultad) references facultad(id)
);

create table contrato(
	id serial primary key not null, 
	idDocente int,
	idFacultad int,
	fechaIni date,
    fechaFin date,
	sueldo float,
	vigente int,
	foreign key(idDocente) references Docente(id),
	foreign key(idFacultad) references facultad(id)
);