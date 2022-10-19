-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 19 Okt 2022 pada 16.43
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `brsfinal`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `agency`
--

CREATE TABLE `agency` (
  `_id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `details` varchar(255) DEFAULT NULL,
  `owner` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `agency`
--

INSERT INTO `agency` (`_id`, `code`, `name`, `details`, `owner`) VALUES
(1, 'A124', 'Arimbi', 'JDBB BUS', 1),
(2, 'A123', 'Rosalia Indah', 'JDBC BUS', 1),
(3, 'A125', 'Pahala Kencana', 'JDBW BUS', 4),
(4, 'A126', 'New Pahala Kencana', 'JDBW BUS', 4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `bus`
--

CREATE TABLE `bus` (
  `_id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `capasity` int(11) DEFAULT NULL,
  `make` varchar(255) DEFAULT NULL,
  `agency` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `bus`
--

INSERT INTO `bus` (`_id`, `code`, `capasity`, `make`, `agency`) VALUES
(1, 'A1234', 50, 'Pariwisata', 1),
(3, 'A1235', 30, 'Bisnis', 1),
(4, 'A1238', 30, 'Touring', 3),
(5, 'A1232', 30, 'Touring', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `flyway_schema_history`
--

CREATE TABLE `flyway_schema_history` (
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT current_timestamp(),
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `flyway_schema_history`
--

INSERT INTO `flyway_schema_history` (`installed_rank`, `version`, `description`, `type`, `script`, `checksum`, `installed_by`, `installed_on`, `execution_time`, `success`) VALUES
(1, '1.0', '101822-create-table', 'SQL', 'V1.0__101822-create-table.sql', 1445134597, 'root', '2022-10-18 17:07:39', 104, 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `role`
--

CREATE TABLE `role` (
  `_id` int(11) NOT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `role`
--

INSERT INTO `role` (`_id`, `role`) VALUES
(1, 'Admin User'),
(2, 'End User');

-- --------------------------------------------------------

--
-- Struktur dari tabel `stop`
--

CREATE TABLE `stop` (
  `_id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `stop`
--

INSERT INTO `stop` (`_id`, `code`, `name`, `detail`) VALUES
(1, 'A1232', 'STOP-C', 'YOGYA'),
(2, 'A1231', 'STOP-A', 'SERANG-BANTEN'),
(3, 'A1233', 'STOP-B', 'BOGOR'),
(4, 'A1235', 'STOP-D', 'JAKARTA'),
(5, 'A1239', 'STOP-E', 'JAKARTA');

-- --------------------------------------------------------

--
-- Struktur dari tabel `ticket`
--

CREATE TABLE `ticket` (
  `_id` int(11) NOT NULL,
  `seat_number` int(11) DEFAULT NULL,
  `cancellable` int(11) DEFAULT NULL,
  `journey_date` varchar(255) DEFAULT NULL,
  `passenger` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `ticket`
--

INSERT INTO `ticket` (`_id`, `seat_number`, `cancellable`, `journey_date`, `passenger`) VALUES
(1, 13, 1, '10/19/2022', 1),
(2, 13, 1, '10/19/2022', 1),
(6, 13, 1, '10/20/2022', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `trip`
--

CREATE TABLE `trip` (
  `_id` int(11) NOT NULL,
  `fare` int(11) DEFAULT NULL,
  `journey_time` varchar(255) DEFAULT NULL,
  `source_stop` int(11) DEFAULT NULL,
  `des_stop` int(11) DEFAULT NULL,
  `bus` int(11) DEFAULT NULL,
  `agency` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `trip`
--

INSERT INTO `trip` (`_id`, `fare`, `journey_time`, `source_stop`, `des_stop`, `bus`, `agency`) VALUES
(2, 150000, '120', 1, 2, 1, 1),
(3, 150000, '120', 2, 4, 1, 1),
(4, 180000, '120', 1, 2, 1, 1),
(5, 190000, '120', 2, 1, 1, 3),
(6, 190000, '120', 1, 3, 1, 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tripschedule`
--

CREATE TABLE `tripschedule` (
  `_id` int(11) NOT NULL,
  `trip_date` varchar(255) DEFAULT NULL,
  `avalable_seats` int(11) DEFAULT NULL,
  `trip_detail` int(11) DEFAULT NULL,
  `ticket_sold` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tripschedule`
--

INSERT INTO `tripschedule` (`_id`, `trip_date`, `avalable_seats`, `trip_detail`, `ticket_sold`) VALUES
(1, '10/19/2022', 78, 3, 1),
(2, '10/19/2022', 15, 2, 1),
(3, '10/8/2022', 5, 3, 1),
(7, '10/10/2022', 20, 2, 2),
(8, '10/1/2022', 20, 2, 1),
(9, '10/1/2022', 20, 2, 1),
(10, '10/20/2022', 20, 2, 1),
(11, '10/20/2022', 20, 2, 6);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `roles_id` int(11) NOT NULL,
  `mobile_number` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`_id`, `email`, `password`, `first_name`, `last_name`, `roles_id`, `mobile_number`) VALUES
(1, 'admin', '$2b$10$OgOUW8DagSKnO00mCfZAoem.vy1dbbEaA9Q465GVg8fQO1kU8rc06', 'Izaaz Azaam ', 'Syahalam', 1, '087843107132'),
(2, 'zaisyahalam@gmail.com', '$2b$10$lcNUviiTr4jLcpwNwNRS9uNqmBZz2pgL0gN9CDRHuJR0.hocr4z56', 'Izaaz Azaam ', 'Syahalam', 2, '087843107132'),
(3, 'izaazsyahalam@gmail.com', '$2b$10$tyEYAYHkX6LS/zXh2r9ryuTwIT9TDMfZ4aXcu2Y7o6lNylsexKl6i', 'Izaaz Azaam ', 'Syahalam', 2, '087843107132'),
(4, 'admin@gmail.com', '$2a$10$lVxjlZ1oXzYDS21rEk2m3O2JFA8IH/4.FcymmXBEY2o7bVfVUs3i.', 'Izaaz Azaam', 'Syahalam', 2, '087843107131'),
(5, 'superadmin', '$2b$10$WAocDZGZDxEgY7Z7k7G12.Arw7CubtPcw2mzQfCE3MpibixIcUFwu', 'Izaaz Azaam ', 'Syahalam', 1, '087843107132');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `agency`
--
ALTER TABLE `agency`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `owner` (`owner`);

--
-- Indeks untuk tabel `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `agency` (`agency`);

--
-- Indeks untuk tabel `flyway_schema_history`
--
ALTER TABLE `flyway_schema_history`
  ADD PRIMARY KEY (`installed_rank`),
  ADD KEY `flyway_schema_history_s_idx` (`success`);

--
-- Indeks untuk tabel `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`_id`);

--
-- Indeks untuk tabel `stop`
--
ALTER TABLE `stop`
  ADD PRIMARY KEY (`_id`);

--
-- Indeks untuk tabel `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `passenger` (`passenger`);

--
-- Indeks untuk tabel `trip`
--
ALTER TABLE `trip`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `agency` (`agency`),
  ADD KEY `bus` (`bus`),
  ADD KEY `source_stop` (`source_stop`),
  ADD KEY `des_stop` (`des_stop`);

--
-- Indeks untuk tabel `tripschedule`
--
ALTER TABLE `tripschedule`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `trip_detail` (`trip_detail`),
  ADD KEY `ticket_sold` (`ticket_sold`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`_id`),
  ADD KEY `roles_id` (`roles_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `agency`
--
ALTER TABLE `agency`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `bus`
--
ALTER TABLE `bus`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `role`
--
ALTER TABLE `role`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `stop`
--
ALTER TABLE `stop`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `ticket`
--
ALTER TABLE `ticket`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `trip`
--
ALTER TABLE `trip`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT untuk tabel `tripschedule`
--
ALTER TABLE `tripschedule`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `agency`
--
ALTER TABLE `agency`
  ADD CONSTRAINT `agency_ibfk_1` FOREIGN KEY (`owner`) REFERENCES `user` (`_id`);

--
-- Ketidakleluasaan untuk tabel `bus`
--
ALTER TABLE `bus`
  ADD CONSTRAINT `bus_ibfk_1` FOREIGN KEY (`agency`) REFERENCES `agency` (`_id`);

--
-- Ketidakleluasaan untuk tabel `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`passenger`) REFERENCES `user` (`_id`);

--
-- Ketidakleluasaan untuk tabel `trip`
--
ALTER TABLE `trip`
  ADD CONSTRAINT `trip_ibfk_1` FOREIGN KEY (`agency`) REFERENCES `agency` (`_id`),
  ADD CONSTRAINT `trip_ibfk_2` FOREIGN KEY (`bus`) REFERENCES `bus` (`_id`),
  ADD CONSTRAINT `trip_ibfk_3` FOREIGN KEY (`source_stop`) REFERENCES `stop` (`_id`),
  ADD CONSTRAINT `trip_ibfk_4` FOREIGN KEY (`des_stop`) REFERENCES `stop` (`_id`);

--
-- Ketidakleluasaan untuk tabel `tripschedule`
--
ALTER TABLE `tripschedule`
  ADD CONSTRAINT `tripschedule_ibfk_1` FOREIGN KEY (`trip_detail`) REFERENCES `trip` (`_id`),
  ADD CONSTRAINT `tripschedule_ibfk_2` FOREIGN KEY (`ticket_sold`) REFERENCES `ticket` (`_id`);

--
-- Ketidakleluasaan untuk tabel `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`roles_id`) REFERENCES `role` (`_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
