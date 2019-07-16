drop table if exists pelicula;

create table pelicula ( 
  id int auto_increment primary key, 
  nombre varchar(50) not null,
  minutos int not null,
  genero varchar(50) not null,
  director varchar(50) not null
);

insert into pelicula (nombre, minutos, genero, director) values
('Dark Knight', 152, 'ACCION', 'Christopher Nolan') ,
('Memento', 113, 'DRAMA', 'Christopher Nolan') ,
('Matrix', 136, 'ACCION', 'Wachowski brothers') ;

