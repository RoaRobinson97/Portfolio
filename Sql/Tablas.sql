create user fase2 identified by 1234;
grant all privileges to fase2;
connect fase2/1234;

set serveroutput on;

Create Table Contenido(
	id number PRIMARY KEY check (id>-1),
	nombre varchar2(20) NOT NULL,
	ano_lanzamiento number check (ano_lanzamiento > -1),
	es_contenido_original varchar2(1) check (es_contenido_original IN ('Y','N','y','n')) 
);

Create Table Pelicula (
	id_pelicula number PRIMARY KEY check (id_pelicula>-1),
	mins_duracion number check (mins_duracion >-1),
	ganadora_premios varchar2(1) check (ganadora_premios IN ('Y','N','y','n')),
	sinopsis varchar2(256)
);
Alter table Pelicula MODIFY(FOREIGN KEY (id_pelicula) REFERENCES Contenido(id));
Alter table Pelicula MODIFY(sinopsis varchar2(512));

Create Table Serie (
	id_serie number PRIMARY KEY check (id_serie>-1),
	descripcion varchar2(256)
);
Alter table Serie MODIFY(FOREIGN KEY (id_serie) REFERENCES Contenido(id));
Alter table Serie MODIFY(descripcion varchar2(512));


Create Table Genero (
	id_genero number PRIMARY KEY check (id_genero>-1),
	nombre varchar2(20) NOT NULL,
	descripcion varchar2(256)
);

Create Table Actor (
	id_actor number PRIMARY KEY check (id_actor>-1),
	nombre varchar2(20) NOT NULL,
	anos_exp number check (anos_exp>-1),
	edad number check (edad>-1),
	sexo varchar2(3) check (sexo IN ('M','F','m','f', 'N/A', 'n/a')) 
);

Create Table Temporada (
	id_temporada number PRIMARY KEY check (id_temporada >-1),
	numero number check (numero>-1),
	descripcion varchar2(100),
	id_serie number check (id_serie>-1),
    FOREIGN KEY (id_serie) REFERENCES Serie(id_serie)
);
Alter table Temporada MODIFY(descripcion varchar2(512));


Create Table Episodio (
	id_episodio number PRIMARY KEY check (id_episodio >-1),
	nombre varchar2(20) NOT NULL,
	numero number check (numero>-1),
	descripcion varchar2(100),
	id_temporada number check (id_temporada>-1),
	FOREIGN KEY (id_temporada) REFERENCES Temporada(id_temporada)
);
Alter table Episodio MODIFY(descripcion varchar2(512));
Alter table Episodio MODIFY(nombre varchar2(32));



Create Table Pais (
	id_pais number PRIMARY KEY check (id_pais >-1),
	nombre varchar2(20) NOT NULL,
	descripcion varchar2(256)
);

Create Table Ciudad (
	id_pais number check (id_pais >0),
	FOREIGN KEY (id_pais) REFERENCES Pais(id_pais),
	id_ciudad number PRIMARY KEY check (id_ciudad >-1),
	nombre varchar2(20) NOT NULL,
	descripcion varchar2(256)
);

Create Table Usuario (
	id_usuario number PRIMARY KEY check (id_usuario >0),
	nombre_usuario varchar2(20) NOT NULL UNIQUE,
	email varchar2(30) NOT NULL,
	contrasena varchar2(12) NOT NULL,
	nombre varchar2(20) NOT NULL,
	apellido varchar2(20) NOT NULL,
	edad number check (edad>0),
	sexo varchar2(1) check (sexo IN ('M','F','m','f')), 
	id_pais number check (id_pais>-1),
	id_ciudad number check (id_ciudad>-1),
	FOREIGN KEY (id_pais) REFERENCES Pais(id_pais),
	FOREIGN KEY (id_ciudad) REFERENCES Ciudad(id_ciudad)
);
Alter table Usuario MODIFY(nombre_usuario varchar2(32));
Alter table Usuario MODIFY(email varchar2(32));



Create Table Perfil (
	id_perfil number PRIMARY KEY check (id_perfil >-1),
	id_usuario number check (id_usuario >-1),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
	nombre varchar2(20) NOT NULL
);
Alter table Perfil MODIFY(nombre varchar2(32));


Create Table Tiene (
	id_contenido number check (id_contenido >-1),
	FOREIGN KEY (id_contenido) REFERENCES Contenido(id),
	id_genero number check (id_genero >-1),
	FOREIGN KEY (id_genero) REFERENCES Genero(id_genero)
);

Create Table Actua (
	id_contenido number check (id_contenido >-1),
	FOREIGN KEY (id_contenido) REFERENCES Contenido(id),
	id_actor number check (id_actor >-1),
	FOREIGN KEY (id_actor) REFERENCES Actor(id_actor),
	es_protagonista varchar2(1) check (es_protagonista IN ('Y','N','y','n')),
	premios number check (premios >-1)
);

Create Table Visualiza (
	id_usuario number check (id_usuario >-1),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
	id_perfil number check (id_perfil >-1),
	FOREIGN KEY (id_perfil) REFERENCES Perfil(id_perfil),
	id_pelicula number check (id_pelicula >-1),
	FOREIGN KEY (id_pelicula) REFERENCES Pelicula(id_pelicula),
	id_episodio number check (id_episodio >-1),
	FOREIGN KEY (id_episodio) REFERENCES Episodio(id_episodio),
	calificacion number check (calificacion >0 and calificacion <6)
);

Create Table Suscripcion (
	id_suscripcion number PRIMARY KEY check (id_suscripcion>-1),
	nombre varchar2(20) NOT NULL,
	tipo varchar2(20),
	descripcion varchar2(256),
	tarifa number check (tarifa>-1)
);
Alter table Suscripcion MODIFY(tipo number check (tipo>0 and tipo <4));

Create Table Contrata (
	id_usuario number check (id_usuario >-1),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
	id_suscripcion number check (id_suscripcion >-1),
	FOREIGN KEY (id_suscripcion) REFERENCES Suscripcion(id_suscripcion),
	fecha_inicio date,
	fecha_fin date
);

Create Table Requiere(
	id_contenido number check (id_contenido >-1),
	FOREIGN KEY (id_contenido) REFERENCES Contenido(id),
	id_suscripcion number check (id_suscripcion >-1),
	FOREIGN KEY (id_suscripcion) REFERENCES Suscripcion(id_suscripcion)
);

Create Table Recomendada(
	id_usuario number check (id_usuario >-1),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id_usuario),
	id_perfil number check (id_perfil >-1),
	FOREIGN KEY (id_perfil) REFERENCES Perfil(id_perfil),
	id_pelicula number check (id_pelicula >-1),
	FOREIGN KEY (id_pelicula) REFERENCES Pelicula(id_pelicula)
);