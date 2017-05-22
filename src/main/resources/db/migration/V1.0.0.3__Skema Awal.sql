CREATE TABLE aplikasi (
  id_aplikasi varchar(255) NOT NULL,
  nama_aplikasi varchar(255) NOT NULL,
  status_rilis_aplikasi tinyint(1) NOT NULL DEFAULT '0',
  id_project_manager varchar(255) DEFAULT NULL,
);

CREATE TABLE `versi` (
  `id_versi` varchar(255) NOT NULL,
  `tanggal_dibuat` date NOT NULL,
  `tanggal_rilis` date NOT NULL,
  `versi` varchar(255) NOT NULL,
  `id_aplikasi` varchar(255) NOT NULL,
);

CREATE TABLE `severity` (
  `id` varchar(255) NOT NULL,
  `severity` varchar(255) NOT NULL,
);

CREATE TABLE `employee` (
  `id_employee` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `id_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_employee`),
  FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`)
);

CREATE TABLE `programmer` (
  `id_programmer` varchar(255) NOT NULL,
  `id_employee` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_programmer`),
  FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id_employee`)
);


 CREATE TABLE `tester` (
  `id_tester` varchar(255) NOT NULL,
  `id_employee` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_tester`),
  FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id_employee`)
);

CREATE TABLE `project_manager` (
  `id_project_manager` varchar(255) NOT NULL,
  `id_employee` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_project_manager`),
  FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id_employee`)
);

CREATE TABLE `bug` (
  `id_bug` varchar(255) NOT NULL,
  `date_seen` date NOT NULL,
  `deskripsi_bug` varchar(255) NOT NULL,
  `judul_bug` varchar(255) NOT NULL,
  `tanggal_fix` date DEFAULT NULL,
  `id_penanggung_jawab` varchar(255) DEFAULT NULL,
  `id_resolver` varchar(255) DEFAULT NULL,
  `id_severity` varchar(255) NOT NULL,
  `id_tester` varchar(255) NOT NULL,
  `id_versi` varchar(255) NOT NULL,
  PRIMARY KEY (`id_bug`),
  FOREIGN KEY (`id_versi`) REFERENCES `versi` (`id_versi`),
  FOREIGN KEY (`id_resolver`) REFERENCES `programmer` (`id_programmer`),
  FOREIGN KEY (`id_tester`) REFERENCES `tester` (`id_tester`),
  FOREIGN KEY (`id_penanggung_jawab`) REFERENCES `programmer` (`id_programmer`),
  FOREIGN KEY (`id_severity`) REFERENCES `severity` (`id`)
);
