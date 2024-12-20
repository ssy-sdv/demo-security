-- --------------------------------------------------------
-- Hôte:                         127.0.0.1
-- Version du serveur:           11.4.3-MariaDB - mariadb.org binary distribution
-- SE du serveur:                Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Listage des données de la table bestioles.animal : ~6 rows (environ)
INSERT INTO `animal` (`id`, `color`, `name`, `sex`, `species_id`) VALUES
                                                                      (1, 'Gris tacheté', 'Max', 'M', 1),
                                                                      (2, 'Blanc', 'Médor', 'M', 2),
                                                                      (3, 'Noir', 'Loulou', 'F', 1),
                                                                      (4, 'Brun', 'Zia', 'F', 2),
                                                                      (5, 'Blanc', 'Lou', 'F', 3),
                                                                      (6, 'Roux', 'Minouchette', 'M', 1);

-- Listage des données de la table bestioles.person : ~9 rows (environ)
INSERT INTO `person` (`id`, `age`, `firstname`, `lastname`, `login`, `pwd`, `active`) VALUES
                                                                                          (1, 22, 'Henri', 'Lamarque', 'hla', '*****', 1),
                                                                                          (2, 24, 'Sylvie', 'Lamarque', 'sla', '*****', 1),
                                                                                          (3, 55, 'Jean', 'Vintroi', 'jvi', '*****', 1),
                                                                                          (4, 80, 'Paul', 'Demaine', 'pde', '*****', 1),
                                                                                          (5, 45, 'Sophie', 'Nero', 'sne', '*****', 1),
                                                                                          (6, 17, 'Pierre', 'Sansane', 'sva', '*****', 1),
                                                                                          (7, 33, 'John', 'Mangolo', 'jma', '*****', 1),
                                                                                          (8, 26, 'Bill', 'Wagner', 'bwa', '*****', 1),
                                                                                          (9, 40, 'Séga', 'S', 'ssy', '{bcrypt}$2a$10$Nde.dTZsakMXm4Jw.hG3BO9hzciVCSgq6C/d2.zzdeznXe3ynL2o.', 1); -- SYLLA

-- Listage des données de la table bestioles.person_animals : ~7 rows (environ)
INSERT INTO `person_animals` (`person_id`, `animals_id`) VALUES
                                                             (2, 1),
                                                             (7, 1),
                                                             (4, 2),
                                                             (3, 3),
                                                             (5, 4),
                                                             (2, 5),
                                                             (8, 6);

-- Listage des données de la table bestioles.person_role : ~2 rows (environ)
INSERT INTO `person_role` (`person_id`, `role_id`) VALUES
                                                       (9, 2),
                                                       (9, 3);

-- Listage des données de la table bestioles.role : ~3 rows (environ)
INSERT INTO `role` (`id`, `label`) VALUES
                                       (1, 'ROLE_EMPLOYE'),
                                       (2, 'ROLE_USER'),
                                       (3, 'ROLE_ADMIN');

-- Listage des données de la table bestioles.species : ~3 rows (environ)
INSERT INTO `species` (`id`, `common_name`, `latin_name`) VALUES
                                                              (1, 'Chat', 'Felis silvestris catus'),
                                                              (2, 'Chien', 'Canis lupus familiaris'),
                                                              (3, 'Lapin', 'Oryctolagus cuniculus');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
