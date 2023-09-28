CREATE TABLE topicos (

	id bigint not null auto_increment,
	titulo varchar(50) not null unique,
	mensaje text not null,
	fecha_creacion date not null,
	estado varchar (50) not null,
	autor bigint not null,
	curso varchar ( 50) not null,
	
	primary key (id)
);