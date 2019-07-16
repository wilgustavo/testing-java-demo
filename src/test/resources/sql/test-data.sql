create table if not exists pelicula ( 
  id int auto_increment primary key, 
  nombre varchar(50) not null,
  minutos int not null,
  genero varchar(50) not null
);

insert into pelicula (nombre, minutos, genero) values
('Dark Knight', 152, 'ACCION') ,
('Memento', 113, 'DRAMA') ,
('Matrix', 136, 'ACCION') ;

