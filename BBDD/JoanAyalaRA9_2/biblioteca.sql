-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-05-2026 a las 22:26:56
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
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `isbn` varchar(13) NOT NULL,
  `titulo` varchar(40) NOT NULL,
  `autor` varchar(20) NOT NULL,
  `editorial` varchar(20) NOT NULL,
  `numejemplares` int(11) NOT NULL,
  `prestados` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`isbn`, `titulo`, `autor`, `editorial`, `numejemplares`, `prestados`) VALUES
('9782222222222', 'La grieta del silencio', 'Javier Castillo', 'Alfaguara', 1, 0),
('9783333333333', 'Las 7 hermanas', 'Lucinda Riley', 'Alfaguara', 1, 1),
('9788888888888', 'El huésped misterioso', 'Nita Prose', 'Duomo', 1, 1),
('9791111111111', 'Maldita Roma', 'Santiago Posteguillo', 'Leemos', 2, 1),
('9794444444444', 'En agosto nos vemos', 'Gabriel García Márqu', 'Casiopea', 2, 0),
('9799999999999', 'El quinto invitado', 'Jenny Knigth', 'Renata', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `codigousuario` int(11) NOT NULL,
  `isbnlibro` varchar(13) NOT NULL,
  `fechadevolucion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `prestamos`
--

INSERT INTO `prestamos` (`codigousuario`, `isbnlibro`, `fechadevolucion`) VALUES
(1, '9788888888888', '2026-06-01'),
(1, '9799999999999', '2026-05-21'),
(2, '9783333333333', '2026-05-27'),
(5, '9791111111111', '2026-05-31');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `numero` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `tipo` varchar(1) NOT NULL,
  `penalizado` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`numero`, `nombre`, `apellidos`, `tipo`, `penalizado`) VALUES
(1, 'Saul', 'Olailo', 'N', 0),
(2, 'Pepa', 'Pig', 'I', 0),
(3, 'Luisa', 'Lada', 'N', 1),
(4, 'Pier', 'Nodoyuna', 'I', 0),
(5, 'Jose', 'Sanz', 'N', 0),
(6, 'Mar', 'Salada', 'I', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`isbn`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`codigousuario`,`isbnlibro`),
  ADD KEY `isbnlibro` (`isbnlibro`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`numero`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `numero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `prestamos_ibfk_1` FOREIGN KEY (`codigousuario`) REFERENCES `usuarios` (`numero`),
  ADD CONSTRAINT `prestamos_ibfk_2` FOREIGN KEY (`isbnlibro`) REFERENCES `libros` (`isbn`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
