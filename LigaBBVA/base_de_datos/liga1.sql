-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 20-01-2014 a las 17:59:23
-- Versión del servidor: 5.5.34
-- Versión de PHP: 5.4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `ligabbva`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jornada`
--
-- Creación: 19-01-2014 a las 16:40:25
--

CREATE TABLE IF NOT EXISTS `jornada` (
  `numjornada` int(3) NOT NULL,
  `fecha` date NOT NULL,
  `estajugada` tinyint(1) NOT NULL DEFAULT '0',
  `numtemporada` int(10) NOT NULL,
  PRIMARY KEY (`numjornada`,`numtemporada`),
  KEY `numtemporada` (`numtemporada`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `jornada`
--
ALTER TABLE `jornada`
  ADD CONSTRAINT `jornada_ibfk_1` FOREIGN KEY (`numtemporada`) REFERENCES `temporada` (`numtemporada`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
