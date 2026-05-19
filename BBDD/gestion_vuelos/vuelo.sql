-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-05-2026 a las 21:50:00
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestion_vuelos`
--
-- Forzamos la creación limpia de la base de datos
--
CREATE DATABASE IF NOT EXISTS `gestion_vuelos` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `gestion_vuelos`;

-- --------------------------------------------------------
-- LIMPIEZA DE TABLAS PREVIAS (Para evitar errores de existencia)
-- --------------------------------------------------------
-- Eliminamos primero la tabla con claves foráneas para que MySQL nos deje borrar las demás
DROP TABLE IF EXISTS `reservas_confirmadas`;
DROP TABLE IF EXISTS `pasajeros`;
DROP TABLE IF EXISTS `vuelos_disponibles`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajeros`
--

CREATE TABLE `pasajeros` (
  `pasaporte` varchar(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `nacionalidad` varchar(30) NOT NULL,
  `puntos_fidelidad` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`pasaporte`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pasajeros`
--

INSERT INTO `pasajeros` (`pasaporte`, `nombre`, `nacionalidad`, `puntos_fidelidad`) VALUES
('12345678A', 'Juan Perez', 'Española', 150),
('87654321B', 'Marie Curie', 'Francesa', 50),
('45678912C', 'Carlos Sainz', 'Española', 210),
('98765432D', 'John Doe', 'Americana', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vuelos_disponibles`
--

CREATE TABLE `vuelos_disponibles` (
  `codigo_vuelo` varchar(6) NOT NULL,
  `destino` varchar(50) NOT NULL,
  `precio_billete` decimal(10,2) NOT NULL,
  `fecha_salida` datetime NOT NULL,
  `asientos_libres` int(11) NOT NULL,
  PRIMARY KEY (`codigo_vuelo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vuelos_disponibles`
--

INSERT INTO `vuelos_disponibles` (`codigo_vuelo`, `destino`, `precio_billete`, `fecha_salida`, `asientos_libres`) VALUES
('BA0422', 'Londres', '180.00', '2026-07-01 10:00:00', 12),
('FR8821', 'Roma', '45.50', '2026-06-20 14:15:00', 2),
('IB3240', 'Paris', '120.00', '2026-06-15 08:30:00', 45),
('VY1122', 'Paris', '85.00', '2026-06-16 19:45:00', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas_confirmadas`
--

CREATE TABLE `reservas_confirmadas` (
  `id_reserva` int(11) NOT NULL AUTO_INCREMENT,
  `pasaporte_pasajero` varchar(9) NOT NULL,
  `codigo_vuelo` varchar(6) NOT NULL,
  `precio_final` decimal(10,2) NOT NULL,
  `fecha_reserva` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id_reserva`),
  KEY `pasaporte_pasajero` (`pasaporte_pasajero`),
  KEY `codigo_vuelo` (`codigo_vuelo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reservas_confirmadas`
--

INSERT INTO `reservas_confirmadas` (`id_reserva`, `pasaporte_pasajero`, `codigo_vuelo`, `precio_final`, `fecha_reserva`) VALUES
(1, '12345678A', 'FR8821', '45.50', '2026-05-10 11:20:00'),
(2, '87654321B', 'IB3240', '120.00', '2026-05-12 09:05:14'),
(3, '12345678A', 'BA0422', '180.00', '2026-05-14 16:40:22');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `reservas_confirmadas`
--
ALTER TABLE `reservas_confirmadas`
  ADD CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`pasaporte_pasajero`) REFERENCES `pasajeros` (`pasaporte`),
  ADD CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`codigo_vuelo`) REFERENCES `vuelos_disponibles` (`codigo_vuelo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;