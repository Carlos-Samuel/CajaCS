-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql_caja_cs:3306
-- Tiempo de generación: 05-11-2023 a las 05:48:52
-- Versión del servidor: 8.2.0
-- Versión de PHP: 8.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `CajaCS`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Facturas`
--

CREATE TABLE `Facturas` (
  `idFacturas` int NOT NULL AUTO_INCREMENT,
  `Prefijo` varchar(45) DEFAULT NULL,
  `NumFactura` varchar(45) DEFAULT NULL,
  `ValorFactura` varchar(45) DEFAULT NULL,
  `Terminado` tinyint DEFAULT NULL,
  `fechaRegistrada` datetime DEFAULT NULL,
  `fechaTerminada` datetime DEFAULT NULL,
  PRIMARY KEY (`idFacturas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Metodos_de_pago`
--

CREATE TABLE `Metodos_de_pago` (
  `idMetodos_de_pago` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) DEFAULT NULL,
  `Cuenta` varchar(45) DEFAULT NULL,
  `Imagen` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idMetodos_de_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Pagos_Facturas`
--

CREATE TABLE `Pagos_Facturas` (
  `Facturas_idFacturas` int NOT NULL,
  `Metodos_de_pago_idMetodos_de_pago` int NOT NULL,
  `Cantidad` int DEFAULT NULL,
  `Usuarios_idUsuarios` int NOT NULL,

  PRIMARY KEY(`Facturas_idFacturas`, `Metodos_de_pago_idMetodos_de_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Permisos`
--

CREATE TABLE `Permisos` (
  `idPermisos` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idPermisos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuarios`
--

CREATE TABLE `Usuarios` (
  `idUsuarios` int NOT NULL AUTO_INCREMENT,
  `Cedula` varchar(45) DEFAULT NULL,
  `Nombres` varchar(45) DEFAULT NULL,
  `Apellidos` varchar(45) DEFAULT NULL,
  `Correo` varchar(45) DEFAULT NULL,
  `Password` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`idUsuarios`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuarios_has_Pagos_Facturas`
--

CREATE TABLE `Usuarios_has_Pagos_Facturas` (
  `Usuarios_idUsuarios` int NOT NULL,
  `Pagos_Facturas_Facturas_idFacturas` int NOT NULL,
  `Pagos_Facturas_Metodos_de_pago_idMetodos_de_pago` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Usuarios_has_Permisos`
--

CREATE TABLE `Usuarios_has_Permisos` (
  `Usuarios_idUsuarios` int NOT NULL,
  `Permisos_idPermisos` int NOT NULL,
  PRIMARY KEY (`Usuarios_idUsuarios`, `Permisos_idPermisos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Pagos_Facturas`
--
ALTER TABLE `Pagos_Facturas`
  ADD PRIMARY KEY (`Facturas_idFacturas`,`Metodos_de_pago_idMetodos_de_pago`),
  ADD KEY `fk_Facturas_has_Metodos_de_pago_Metodos_de_pago1_idx` (`Metodos_de_pago_idMetodos_de_pago`),
  ADD KEY `fk_Facturas_has_Metodos_de_pago_Facturas1_idx` (`Facturas_idFacturas`),
  ADD KEY `fk_Pagos_Facturas_Usuarios1_idx` (`Usuarios_idUsuarios`);

--
-- Indices de la tabla `Usuarios_has_Pagos_Facturas`
--
ALTER TABLE `Usuarios_has_Pagos_Facturas`
  ADD KEY `fk_Usuarios_has_Pagos_Facturas_Pagos_Facturas1_idx` (`Pagos_Facturas_Facturas_idFacturas`,`Pagos_Facturas_Metodos_de_pago_idMetodos_de_pago`),
  ADD KEY `fk_Usuarios_has_Pagos_Facturas_Usuarios1_idx` (`Usuarios_idUsuarios`);

--
-- Indices de la tabla `Usuarios_has_Permisos`
--
ALTER TABLE `Usuarios_has_Permisos`
  ADD PRIMARY KEY (`Usuarios_idUsuarios`,`Permisos_idPermisos`),
  ADD KEY `fk_Usuarios_has_Permisos_Permisos1_idx` (`Permisos_idPermisos`),
  ADD KEY `fk_Usuarios_has_Permisos_Usuarios_idx` (`Usuarios_idUsuarios`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Pagos_Facturas`
--
ALTER TABLE `Pagos_Facturas`
  ADD CONSTRAINT `fk_Facturas_has_Metodos_de_pago_Facturas1` FOREIGN KEY (`Facturas_idFacturas`) REFERENCES `Facturas` (`idFacturas`),
  ADD CONSTRAINT `fk_Facturas_has_Metodos_de_pago_Metodos_de_pago1` FOREIGN KEY (`Metodos_de_pago_idMetodos_de_pago`) REFERENCES `Metodos_de_pago` (`idMetodos_de_pago`),
  ADD CONSTRAINT `fk_Pagos_Facturas_Usuarios1` FOREIGN KEY (`Usuarios_idUsuarios`) REFERENCES `Usuarios` (`idUsuarios`);

--
-- Filtros para la tabla `Usuarios_has_Pagos_Facturas`
--
ALTER TABLE `Usuarios_has_Pagos_Facturas`
  ADD CONSTRAINT `fk_Usuarios_has_Pagos_Facturas_Pagos_Facturas1` FOREIGN KEY (`Pagos_Facturas_Facturas_idFacturas`,`Pagos_Facturas_Metodos_de_pago_idMetodos_de_pago`) REFERENCES `Pagos_Facturas` (`Facturas_idFacturas`, `Metodos_de_pago_idMetodos_de_pago`),
  ADD CONSTRAINT `fk_Usuarios_has_Pagos_Facturas_Usuarios1` FOREIGN KEY (`Usuarios_idUsuarios`) REFERENCES `Usuarios` (`idUsuarios`);

--
-- Filtros para la tabla `Usuarios_has_Permisos`
--
ALTER TABLE `Usuarios_has_Permisos`
  ADD CONSTRAINT `fk_Usuarios_has_Permisos_Permisos1` FOREIGN KEY (`Permisos_idPermisos`) REFERENCES `Permisos` (`idPermisos`),
  ADD CONSTRAINT `fk_Usuarios_has_Permisos_Usuarios` FOREIGN KEY (`Usuarios_idUsuarios`) REFERENCES `Usuarios` (`idUsuarios`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;



/* Nuevas cosas */

ALTER TABLE `Facturas`
ADD COLUMN `estado` BOOLEAN DEFAULT TRUE;
