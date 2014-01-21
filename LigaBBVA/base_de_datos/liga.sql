-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 19-01-2014 a las 18:45:45
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
CREATE DATABASE IF NOT EXISTS `ligabbva` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `ligabbva`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE IF NOT EXISTS `administrador` (
  `nombreusuario` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`nombreusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `arbitro`
--

CREATE TABLE IF NOT EXISTS `arbitro` (
  `nombre` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `apellidos` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `provincia` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `fechanacimiento` date NOT NULL,
  `dni` varchar(9) NOT NULL,
  `enneverahasta` date DEFAULT NULL,
  `nombreusuario` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`dni`),
  KEY `nombreusuario` (`nombreusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `arbitrostemporada`
--

CREATE TABLE IF NOT EXISTS `arbitrostemporada` (
  `numtemporada` int(10) NOT NULL,
  `dniarbitro` varchar(9) NOT NULL,
  PRIMARY KEY (`numtemporada`,`dniarbitro`),
  KEY `dniarbitro` (`dniarbitro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clasificacion`
--

CREATE TABLE IF NOT EXISTS `clasificacion` (
  `numjornada` int(2) NOT NULL,
  `numtemporada` int(10) NOT NULL,
  `nombreeq` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `puntos` int(3) NOT NULL DEFAULT '0',
  `golesafavor` int(3) NOT NULL DEFAULT '0',
  `golesencontra` int(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`numjornada`,`numtemporada`,`nombreeq`),
  KEY `nombreeq` (`nombreeq`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `convocado`
--

CREATE TABLE IF NOT EXISTS `convocado` (
  `numtemporada` int(10) NOT NULL,
  `numjornada` int(2) NOT NULL,
  `nomeqlocal` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nomeqvisitante` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `codjug` int(11) NOT NULL,
  PRIMARY KEY (`numtemporada`,`numjornada`,`nomeqlocal`,`nomeqvisitante`,`codjug`),
  KEY `codjug` (`codjug`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE IF NOT EXISTS `equipo` (
  `nombre` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `puntos` int(3) DEFAULT '0',
  `dinero` double(12,2) unsigned DEFAULT NULL,
  `nombreusuario` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `provincia` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`nombre`),
  KEY `nombreusuario` (`nombreusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipostemporada`
--

CREATE TABLE IF NOT EXISTS `equipostemporada` (
  `numtemporada` int(10) NOT NULL,
  `nombreeq` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`numtemporada`,`nombreeq`),
  KEY `nombreeq` (`nombreeq`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadisticasjugador`
--

CREATE TABLE IF NOT EXISTS `estadisticasjugador` (
  `numtemporada` int(10) NOT NULL,
  `codjug` int(11) NOT NULL,
  `numgoles` int(3) NOT NULL DEFAULT '0',
  `numsanciones` int(3) NOT NULL DEFAULT '0',
  PRIMARY KEY (`numtemporada`,`codjug`),
  KEY `codjug` (`codjug`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `goles`
--

CREATE TABLE IF NOT EXISTS `goles` (
  `numtemporada` int(10) NOT NULL,
  `numjornada` int(2) NOT NULL,
  `nomeqafectado` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nomeqlocal` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nomeqvisitante` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `codjug` int(11) NOT NULL,
  `minuto` int(3) NOT NULL,
  `segundo` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`numtemporada`,`numjornada`,`nomeqlocal`,`nomeqvisitante`,`codjug`,`minuto`,`segundo`),
  KEY `codjug` (`codjug`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historialjugador`
--

CREATE TABLE IF NOT EXISTS `historialjugador` (
  `codjug` int(11) NOT NULL,
  `nombreeq` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`codjug`,`nombreeq`,`fecha`),
  KEY `nombreeq` (`nombreeq`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jornada`
--

CREATE TABLE IF NOT EXISTS `jornada` (
  `numjornada` int(3) NOT NULL,
  `fecha` date NOT NULL,
  `estajugada` tinyint(1) NOT NULL DEFAULT '0',
  `numtemporada` int(10) NOT NULL,
  PRIMARY KEY (`numjornada`,`numtemporada`),
  KEY `numtemporada` (`numtemporada`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE IF NOT EXISTS `jugador` (
  `codjug` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `dorsal` int(2) DEFAULT NULL,
  `estaenventa` tinyint(1) NOT NULL DEFAULT '0',
  `estaretirado` tinyint(1) NOT NULL DEFAULT '0',
  `numsanciones` int(3) NOT NULL DEFAULT '0',
  `nombreequipo` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`codjug`),
  KEY `nombreequipo` (`nombreequipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partido`
--

CREATE TABLE IF NOT EXISTS `partido` (
  `fecha` date NOT NULL,
  `golesvisitante` int(2) NOT NULL DEFAULT '0',
  `goleslocal` int(2) NOT NULL DEFAULT '0',
  `numtemporada` int(10) NOT NULL,
  `numjornada` int(3) NOT NULL,
  `nomeqlocal` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nomeqvisitante` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `dniarbitro` varchar(9) DEFAULT NULL,
  PRIMARY KEY (`numtemporada`,`numjornada`,`nomeqlocal`,`nomeqvisitante`),
  KEY `nomeqlocal` (`nomeqlocal`),
  KEY `nomeqvisitante` (`nomeqvisitante`),
  KEY `dniarbitro` (`dniarbitro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sustituciones`
--

CREATE TABLE IF NOT EXISTS `sustituciones` (
  `numtemporada` int(10) NOT NULL,
  `numjornada` int(2) NOT NULL,
  `nomeqafectado` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nomeqlocal` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nomeqvisitante` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `codjugsale` int(11) NOT NULL,
  `codjugentra` int(11) NOT NULL,
  `minuto` int(3) NOT NULL,
  `segundo` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`numtemporada`,`numjornada`,`nomeqlocal`,`nomeqvisitante`,`codjugsale`,`codjugentra`),
  KEY `codjugsale` (`codjugsale`),
  KEY `codjugentra` (`codjugentra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjetas`
--

CREATE TABLE IF NOT EXISTS `tarjetas` (
  `numtemporada` int(10) NOT NULL,
  `numjornada` int(2) NOT NULL,
  `nomeqafectado` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nomeqlocal` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nomeqvisitante` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `codjug` int(11) NOT NULL,
  `minuto` int(3) NOT NULL,
  `segundo` int(2) NOT NULL DEFAULT '0',
  `esamarilla` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`numtemporada`,`numjornada`,`nomeqlocal`,`nomeqvisitante`,`minuto`,`segundo`),
  KEY `codjug` (`codjug`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `temporada`
--

CREATE TABLE IF NOT EXISTS `temporada` (
  `numtemporada` int(10) NOT NULL AUTO_INCREMENT,
  `fechainicio` date NOT NULL,
  `fechafin` date NOT NULL,
  PRIMARY KEY (`numtemporada`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `titular`
--

CREATE TABLE IF NOT EXISTS `titular` (
  `numtemporada` int(10) NOT NULL,
  `numjornada` int(2) NOT NULL,
  `nomeqlocal` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `nomeqvisitante` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `codjug` int(11) NOT NULL,
  PRIMARY KEY (`numtemporada`,`numjornada`,`nomeqlocal`,`nomeqvisitante`,`codjug`),
  KEY `codjug` (`codjug`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `nombre` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `contrasena` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `preguntaseg` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `respuestaseg` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `estaactivo` tinyint(1) NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE IF NOT EXISTS `ventas` (
  `nombreeq` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci NOT NULL,
  `codjug` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `precio` double(10,2) NOT NULL,
  PRIMARY KEY (`nombreeq`,`codjug`,`fecha`),
  KEY `codjug` (`codjug`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD CONSTRAINT `administrador_ibfk_1` FOREIGN KEY (`nombreusuario`) REFERENCES `usuario` (`nombre`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `arbitro`
--
ALTER TABLE `arbitro`
  ADD CONSTRAINT `arbitro_ibfk_1` FOREIGN KEY (`nombreusuario`) REFERENCES `usuario` (`nombre`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `arbitrostemporada`
--
ALTER TABLE `arbitrostemporada`
  ADD CONSTRAINT `arbitrostemporada_ibfk_1` FOREIGN KEY (`numtemporada`) REFERENCES `temporada` (`numtemporada`) ON UPDATE CASCADE,
  ADD CONSTRAINT `arbitrostemporada_ibfk_2` FOREIGN KEY (`dniarbitro`) REFERENCES `arbitro` (`dni`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `clasificacion`
--
ALTER TABLE `clasificacion`
  ADD CONSTRAINT `clasificacion_ibfk_1` FOREIGN KEY (`numjornada`, `numtemporada`) REFERENCES `jornada` (`numjornada`, `numtemporada`),
  ADD CONSTRAINT `clasificacion_ibfk_2` FOREIGN KEY (`nombreeq`) REFERENCES `equipo` (`nombre`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `convocado`
--
ALTER TABLE `convocado`
  ADD CONSTRAINT `convocado_ibfk_1` FOREIGN KEY (`numtemporada`, `numjornada`, `nomeqlocal`, `nomeqvisitante`) REFERENCES `partido` (`numtemporada`, `numjornada`, `nomeqlocal`, `nomeqvisitante`),
  ADD CONSTRAINT `convocado_ibfk_2` FOREIGN KEY (`codjug`) REFERENCES `jugador` (`codjug`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `equipo_ibfk_1` FOREIGN KEY (`nombreusuario`) REFERENCES `usuario` (`nombre`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `equipostemporada`
--
ALTER TABLE `equipostemporada`
  ADD CONSTRAINT `equipostemporada_ibfk_1` FOREIGN KEY (`numtemporada`) REFERENCES `temporada` (`numtemporada`) ON UPDATE CASCADE,
  ADD CONSTRAINT `equipostemporada_ibfk_2` FOREIGN KEY (`nombreeq`) REFERENCES `equipo` (`nombre`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `estadisticasjugador`
--
ALTER TABLE `estadisticasjugador`
  ADD CONSTRAINT `estadisticasjugador_ibfk_1` FOREIGN KEY (`numtemporada`) REFERENCES `temporada` (`numtemporada`) ON UPDATE CASCADE,
  ADD CONSTRAINT `estadisticasjugador_ibfk_2` FOREIGN KEY (`codjug`) REFERENCES `jugador` (`codjug`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `goles`
--
ALTER TABLE `goles`
  ADD CONSTRAINT `goles_ibfk_1` FOREIGN KEY (`numtemporada`, `numjornada`, `nomeqlocal`, `nomeqvisitante`) REFERENCES `partido` (`numtemporada`, `numjornada`, `nomeqlocal`, `nomeqvisitante`),
  ADD CONSTRAINT `goles_ibfk_2` FOREIGN KEY (`codjug`) REFERENCES `jugador` (`codjug`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `historialjugador`
--
ALTER TABLE `historialjugador`
  ADD CONSTRAINT `historialjugador_ibfk_1` FOREIGN KEY (`codjug`) REFERENCES `jugador` (`codjug`) ON UPDATE CASCADE,
  ADD CONSTRAINT `historialjugador_ibfk_2` FOREIGN KEY (`nombreeq`) REFERENCES `equipo` (`nombre`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `jornada`
--
ALTER TABLE `jornada`
  ADD CONSTRAINT `jornada_ibfk_1` FOREIGN KEY (`numtemporada`) REFERENCES `temporada` (`numtemporada`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD CONSTRAINT `jugador_ibfk_1` FOREIGN KEY (`nombreequipo`) REFERENCES `equipo` (`nombre`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `partido`
--
ALTER TABLE `partido`
  ADD CONSTRAINT `partido_ibfk_1` FOREIGN KEY (`numtemporada`, `numjornada`) REFERENCES `jornada` (`numtemporada`, `numjornada`),
  ADD CONSTRAINT `partido_ibfk_2` FOREIGN KEY (`nomeqlocal`) REFERENCES `equipo` (`nombre`) ON UPDATE CASCADE,
  ADD CONSTRAINT `partido_ibfk_3` FOREIGN KEY (`nomeqvisitante`) REFERENCES `equipo` (`nombre`) ON UPDATE CASCADE,
  ADD CONSTRAINT `partido_ibfk_4` FOREIGN KEY (`dniarbitro`) REFERENCES `arbitro` (`dni`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `sustituciones`
--
ALTER TABLE `sustituciones`
  ADD CONSTRAINT `sustituciones_ibfk_1` FOREIGN KEY (`numtemporada`, `numjornada`, `nomeqlocal`, `nomeqvisitante`) REFERENCES `partido` (`numtemporada`, `numjornada`, `nomeqlocal`, `nomeqvisitante`),
  ADD CONSTRAINT `sustituciones_ibfk_2` FOREIGN KEY (`codjugsale`) REFERENCES `jugador` (`codjug`) ON UPDATE CASCADE,
  ADD CONSTRAINT `sustituciones_ibfk_3` FOREIGN KEY (`codjugentra`) REFERENCES `jugador` (`codjug`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `tarjetas`
--
ALTER TABLE `tarjetas`
  ADD CONSTRAINT `tarjetas_ibfk_1` FOREIGN KEY (`numtemporada`, `numjornada`, `nomeqlocal`, `nomeqvisitante`) REFERENCES `partido` (`numtemporada`, `numjornada`, `nomeqlocal`, `nomeqvisitante`),
  ADD CONSTRAINT `tarjetas_ibfk_2` FOREIGN KEY (`codjug`) REFERENCES `jugador` (`codjug`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `titular`
--
ALTER TABLE `titular`
  ADD CONSTRAINT `titular_ibfk_1` FOREIGN KEY (`numtemporada`, `numjornada`, `nomeqlocal`, `nomeqvisitante`) REFERENCES `partido` (`numtemporada`, `numjornada`, `nomeqlocal`, `nomeqvisitante`),
  ADD CONSTRAINT `titular_ibfk_2` FOREIGN KEY (`codjug`) REFERENCES `jugador` (`codjug`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`nombreeq`) REFERENCES `equipo` (`nombre`) ON UPDATE CASCADE,
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`codjug`) REFERENCES `jugador` (`codjug`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
