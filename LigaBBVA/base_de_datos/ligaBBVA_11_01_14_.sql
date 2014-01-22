-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 22-01-2014 a las 09:58:24
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
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE IF NOT EXISTS `equipo` (
  `nombre` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `dinero` double(12,2) unsigned DEFAULT NULL,
  `nombreusuario` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `provincia` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`nombre`),
  KEY `nombreusuario` (`nombreusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`nombre`, `dinero`, `nombreusuario`, `provincia`) VALUES
('Athletic', 1000.00, 'AdminAthletic', 'Vizcaya'),
('Atletico', 1000.00, 'AdminAtletico', 'Madrid'),
('Barcelona', 1000.00, 'AdminBarcelona', 'Barcelona'),
('Betis', 1000.00, 'AdminBetis', 'Sevilla'),
('Madrid', 1000.00, 'AdminMadrid', 'Madrid'),
('Real', 1000.00, 'AdminReal', 'Guipúzcoa'),
('Sevilla', 1000.00, 'AdminSevilla', 'Sevilla'),
('Valencia', 1000.00, 'AdminValencia', 'Valencia');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `equipo_ibfk_1` FOREIGN KEY (`nombreusuario`) REFERENCES `usuario` (`nombre`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
