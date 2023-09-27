CREATE TABLE `foro_alura`.`usuarios` (
  `id` int NOT NULL UNIQUE auto_increment,
  `nombre` VARCHAR(50) NOT NULL UNIQUE,
  `email` VARCHAR(100) NOT NULL UNIQUE,
  `contraseña` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
)