insert into aplikasi (id_aplikasi, nama_aplikasi, status_rilis_aplikasi)
value ('game_1', 'Flappy Bird', '0');

insert into aplikasi (id_aplikasi, nama_aplikasi, status_rilis_aplikasi)
value ('game_2', 'Abas Ganteng', '0');


insert into versi (id_versi, tanggal_dibuat, tanggal_rilis, versi, id_aplikasi)
value ('FlappyBird-0.0.1', '2016-1-1', '2016-1-2', '0.0.1', 'game_1');

insert into versi (id_versi, tanggal_dibuat, tanggal_rilis, versi, id_aplikasi)
value ('FlappyBird-0.0.2', '2016-2-12', '2016-2-13', '0.0.2', 'game_1');


insert into versi (id_versi, tanggal_dibuat, tanggal_rilis, versi, id_aplikasi)
value ('kamu', '2016-2-12', '2016-2-13', '0.0.3', 'game_1');

insert into versi (id_versi, tanggal_dibuat, tanggal_rilis, versi, id_aplikasi)
value ('kamu.1', '2016-2-12', '2016-2-13', '0.0.4', 'game_1');

insert into versi (id_versi, tanggal_dibuat, tanggal_rilis, versi, id_aplikasi)
value ('AbasGanteng-0.0.1', '2016-1-1', '2016-1-2', 'V-0.0.1', 'game_2');
