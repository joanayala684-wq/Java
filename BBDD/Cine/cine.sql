
-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-04-2026 a las 20:38:58
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
-- Base de datos: `cinepolis`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `codigo` int(11) NOT NULL,
  `precio` int(11) NOT NULL,
  `entradas` int(11) NOT NULL,
  `sala` int(11) NOT NULL,
  `telefono` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`codigo`, `precio`, `entradas`, `sala`, `telefono`) VALUES
(1, 12, 3, 1, 672363636),
(2, 7, 1, 2, 636248759),
(3, 40, 5, 3, 666666666),
(4, 14, 2, 3, 639838383),
(5, 7, 1, 4, 643432344),
(6, 16, 2, 3, 676666464),
(7, 16, 2, 1, 676767676),
(8, 7, 1, 4, 666336236),
(9, 18, 2, 2, 444444444),
(10, 36, 5, 2, 888888888),
(11, 27, 3, 2, 656565656),
(12, 36, 5, 2, 234343434);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salas`
--

CREATE TABLE `salas` (
  `pelicula` varchar(50) NOT NULL,
  `aforo` int(11) NOT NULL,
  `sala` int(11) NOT NULL,
  `plazas_ocupadas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `salas`
--

INSERT INTO `salas` (`pelicula`, `aforo`, `sala`, `plazas_ocupadas`) VALUES
('Michael', 50, 1, 50),
('Mortal Kombat II', 45, 2, 43),
('Torrente presidente', 30, 3, 9),
('Boulevard', 35, 4, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `clave` (`codigo`),
  ADD KEY `sala` (`sala`);

--
-- Indices de la tabla `salas`
--
ALTER TABLE `salas`
  ADD PRIMARY KEY (`sala`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`sala`) REFERENCES `salas` (`sala`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
