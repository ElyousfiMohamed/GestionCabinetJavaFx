-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 20 jan. 2022 à 14:26
-- Version du serveur :  10.4.19-MariaDB
-- Version de PHP : 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_cabinet`
--

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

CREATE TABLE `consultation` (
  `ID_CONSULTATION` int(11) NOT NULL,
  `ID_PATIENT` int(11) NOT NULL,
  `ID_MEDECIN` int(11) NOT NULL,
  `DATE_CONSULTATION` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

CREATE TABLE `medecin` (
  `ID_MEDECIN` int(11) NOT NULL,
  `NOM_MEDECIN` text DEFAULT NULL,
  `PRENOM_MEDECIN` text DEFAULT NULL,
  `EMAIL_MEDECIN` text DEFAULT NULL,
  `TELE_MEDECIN` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `ID_PATIENT` int(11) NOT NULL,
  `NOM_PATIENT` text DEFAULT NULL,
  `PRENOM_PATIENT` text DEFAULT NULL,
  `CIN_PATIENT` text DEFAULT NULL,
  `TELEPHONE_PATIENT` text DEFAULT NULL,
  `EMAIL_PATIENT` text DEFAULT NULL,
  `DATE_NAISSANCE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD PRIMARY KEY (`ID_CONSULTATION`);

--
-- Index pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD PRIMARY KEY (`ID_MEDECIN`),
  ADD UNIQUE KEY `EMAIL_MEDECIN` (`EMAIL_MEDECIN`,`TELE_MEDECIN`) USING HASH;

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`ID_PATIENT`),
  ADD UNIQUE KEY `CIN_PATIENT` (`CIN_PATIENT`,`TELEPHONE_PATIENT`,`EMAIL_PATIENT`) USING HASH;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
