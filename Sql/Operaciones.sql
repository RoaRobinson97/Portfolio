--CONSULTA A 
select nombre
from contenido
where id in
	(select id_pelicula
	from visualiza
	where  calificacion > all
			(select avg(calificacion) as promedio
			from visualiza)
			and id_pelicula in
				(select id_pelicula
				from pelicula
				where (mins_duracion > 150)
				intersect
				(select id_pelicula
				from pelicula
				where (ganadora_premios = 'Y' or ganadora_premios = 'y')
				intersect
				(select id_pelicula
				from pelicula
				intersect
				select id_contenido
				from tiene
				where id_genero in
				(select id_genero
				from genero
				where nombre = 'Drama')))))
				Order by ano_lanzamiento asc;

--CONSULTA B (FUNCIONA)
WITH  r1 as(select id
			from contenido
			where es_contenido_original = 'y' or es_contenido_original = 'Y'
			and id in (select id_serie from serie)),
      r2 as(select id_usuario, id_episodio
			from visualiza),
	  r3 as (select id_usuario, id_temporada
			from (r2 JOIN episodio on r2.id_episodio = episodio.id_episodio)),
	  r4 as (select id_temporada, id_serie
			from temporada
			where id_serie in (select id from r1)),
	  r5 as (select id_usuario, id_temporada
			from r3
			where id_temporada in (select id_temporada from r4)),
	  r6 as (select id_usuario, id_serie
			from (r5 JOIN temporada on r5.id_temporada = temporada.id_temporada)),
      r7 as (select id_usuario, count(id_serie) as caps
			from r6
			group by id_usuario),
	  r8 as(select id_usuario, caps from r7
			where caps= all(select max(caps) from r7)),
	  r10 as (select id_usuario, pais.nombre as "Pais ",caps
			  from (pais JOIN r8 on pais.id_pais in (select id_pais
													 from usuario
													  where id_usuario in(select id_usuario
																		  from r8)))),
	  r9 as (select nombre ,apellido, edad, sexo, nombre_usuario, email, "Pais " , caps
			 from (r10 JOIN usuario on r10.id_usuario = usuario.id_usuario))
select *from r9;

--CONSULTA C
with r1 as (SELECT *FROM VISUALIZA
			WHERE id_pelicula in(select id_pelicula from recomendada)), 
	 r2 as (SELECT id_usuario, id_pelicula FROM r1
			WHERE id_usuario in(select id_usuario from recomendada)),
	 r3 as (SELECT id_usuario, id_pelicula FROM recomendada),
	 r4 as ((select id_usuario, id_pelicula from r2) intersect (select id_usuario, id_pelicula from  r3)),
	 r5 as (select id_usuario, count(id_pelicula) as Peliculas
			from r4
			group by id_usuario
			order by Peliculas desc),
	 r6 as (select *from usuario
			where id_usuario in(select id_usuario from r5)
			and ROWNUM <6)
			select *from r6;


--CONSULTA D (FUNCIONA)
with r1 as (SELECT id_serie, count(id_episodio)
			FROM (temporada JOIN episodio ON temporada.id_temporada =episodio.id_temporada )
			group by id_serie
			having count(id_episodio) > 10),
	 r2 as (SELECT id_serie,id_episodio
		    FROM (temporada JOIN episodio ON temporada.id_temporada =episodio.id_temporada)
			where id_serie in (select id_serie from r1)),
	 r3 as (select id_usuario
			from visualiza
			where id_episodio in (select id_episodio from r2)),
	 r4 as (select id_pais
			from usuario
			where id_usuario in (select id_usuario from r3))
select nombre 
from pais 
where id_pais in(select id_pais from r4);
			 
--CONSULTA E (FUNCIONA)
with r1 as (SELECT id_serie,id_episodio
		    FROM (temporada JOIN episodio ON temporada.id_temporada =episodio.id_temporada)
			where id_episodio in (select id_episodio from visualiza)),
	 r2 as (select id_episodio, avg(calificacion) as prom
			from visualiza
			group by id_episodio),
	 r3 as (select id_serie, avg(prom) as proma
			from (r1 JOIN r2 on r1.id_episodio = r2.id_episodio)
			group by id_serie),
	 r4 as (select id_serie from r3
			WHERE ROWNUM <= 3
			order by proma desc),
	 r5 as (select *from contenido
			where id in (select id_serie from r4))
select *from r5;

--CONSULTA F (FUNCIONA)
with r1 as (select id_contenido
			from actua
			where id_actor in 
			(select id_actor 
			from actor 
			where nombre = 'Daniel Bruhl')),
	 r2 as (select id_contenido 
			from r1
			where id_contenido in(select id_pelicula from pelicula)),
	 r3 as (select id_pelicula, avg(calificacion) as prom
			from visualiza
			where id_pelicula in (select id_contenido from r2)
			group by id_pelicula),
	 r4 as (select avg(calificacion) as prom
			from visualiza),
	 r5 as (select id_pelicula, avg(calificacion) as gat
			from visualiza
			group by id_pelicula),
	 r6 as	(select id_pelicula, gat 
			from r5
			where gat > all(select *from r4)
			and id_pelicula in (select id_pelicula from r3))
select *from contenido 
where id in 
	(select id_pelicula 
	from r6);

--CONSULTA G 
with r1 as (select id
			from contenido
			where id in (select id_contenido
						 from requiere)),
     r2 as (select id_usuario
			from usuario
			where nombre like '%aDRi%'
			and sexo ='f' or sexo ='F'),
	 r3 as (select current_date as fecha
			from dual),
     r4 as (select id_usuario 
			from contrata
			where fecha_inicio < all(select current_date from r3)
			and fecha_fin > all(select current_date from r3)),
	 r5 as (select id_usuario 
			from r4
			where id_usuario in (select id_usuario from r2)),
	 r6 as (select *from visualiza
			where id_pelicula in(select id from r1)
			or  id_episodio in(select id from r1)),
	 r7 as (select id_usuario, id_pelicula, id_episodio
			from r6
			where id_usuario in (select id_usuario from r5)),
	 r8 as (select id_usuario, count(id_pelicula)+count(id_episodio) as contenidos
			from r7
			group by id_usuario),
	 r9 as (select id_usuario
			from r8
			where contenidos >1)
	select *from usuario
	where id_usuario in(select id_usuario from r9);


