-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Gegenereerd op: 24 okt 2017 om 09:28
-- Serverversie: 10.1.26-MariaDB
-- PHP-versie: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `photobooth`
--

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `foto`
--

CREATE TABLE `foto` (
  `id` int(11) NOT NULL,
  `sessieID` int(11) NOT NULL,
  `path` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `foto`
--

INSERT INTO `foto` (`id`, `sessieID`, `path`) VALUES
(20, 6, 'images/IMG0.jpg'),
(21, 6, 'images/IMG1.jpg'),
(22, 6, 'images/IMG2.jpg'),
(23, 7, 'images/IMG3.jpg'),
(24, 7, 'images/IMG4.jpg'),
(25, 8, 'images/IMG5.jpg');

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `sessie`
--

CREATE TABLE `sessie` (
  `id` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  `locatie` varchar(255) NOT NULL,
  `temperatuur` int(11) NOT NULL,
  `aantal` int(11) NOT NULL,
  `tijd` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Gegevens worden geëxporteerd voor tabel `sessie`
--

INSERT INTO `sessie` (`id`, `code`, `locatie`, `temperatuur`, `aantal`, `tijd`) VALUES
(6, 'CTcT7W', 'Alkmaar', 13, 3, '2017-10-13 17:45:35'),
(7, 'BvS9en', 'Amsterdam', 15, 2, '2017-10-13 22:00:44'),
(8, 'shwQ6s', 'Amsterdam', 15, 1, '2017-10-13 22:28:19');

--
-- Indexen voor geëxporteerde tabellen
--

--
-- Indexen voor tabel `foto`
--
ALTER TABLE `foto`
  ADD PRIMARY KEY (`id`);

--
-- Indexen voor tabel `sessie`
--
ALTER TABLE `sessie`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT voor geëxporteerde tabellen
--

--
-- AUTO_INCREMENT voor een tabel `foto`
--
ALTER TABLE `foto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT voor een tabel `sessie`
--
ALTER TABLE `sessie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
