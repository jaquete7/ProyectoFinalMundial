CREATE SCHEMA `proyectofinalbd` ;
USE proyectofinalbd;

DROP TABLE IF EXISTS `administrador`;
CREATE TABLE `administrador` (
  `identificacion` varchar(50) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `correoElectronico` varchar(45) DEFAULT NULL,
  `nombreUsuario` varchar(45) DEFAULT NULL,
  `contrasena` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `identificacion` varchar(20) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `correoElectronico` varchar(45) DEFAULT NULL,
  `nombreUsuario` varchar(45) DEFAULT NULL,
  `contrasena` varchar(45) DEFAULT NULL,
  `avatar` varchar(45) DEFAULT NULL,
  `equipoFavorito` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

DROP TABLE IF EXISTS `equipo`;
CREATE TABLE `equipo` (
  `codigoEquipo` varchar(20) NOT NULL,
  `nombrePais` varchar(45) DEFAULT NULL,
  `ranking` int DEFAULT NULL,
  `bandera` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`codigoEquipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

SELECT * FROM administrador;
INSERT INTO administrador VALUES('10', 'Andres', 'Lopez', 'lopes@gmail.com','Andres1','fufi123', 'Curridabat');

SELECT * FROM usuario;
INSERT INTO usuario VALUES('15', 'Luis', 'Gutierritos', 'gutierritos@gmail.com','guti15','gutiguti123', 'Tijuana', 'Mexico');

SELECT * FROM equipo;
INSERT INTO equipo VALUES('P12', 'Peru', 28, 'aa213');

SELECT nombreUsuario, contrasena  FROM administrador;
SELECT nombreUsuario, contrasena  FROM usuario;