insert into employee (id_employee,email,nama,id_user)
value ('e-1','apa@apa.com','programmer 1','u003');

insert into employee (id_employee,email,nama,id_user)
value ('e-2','apa2@apa.com','tester 1','u004');

insert into employee (id_employee,email,nama,id_user)
value ('e-0','apa2@apa.com','pm 1','u002');


insert into programmer (id_programmer,id_employee)
value ('p-1','e-1');

insert into tester (id_tester,id_employee)
value ('p-1','e-2');

insert into project_manager (id_project_manager,id_employee)
value ('p-1','e-0');


insert into aplikasi (id_aplikasi, nama_aplikasi, status_rilis_aplikasi, id_project_manager)
value ('game_1', 'Flappy Bird', '0', 'p-1');

insert into aplikasi (id_aplikasi, nama_aplikasi, status_rilis_aplikasi, id_project_manager)
value ('game_2', 'Abas Ganteng', '0', 'p-1');


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


insert into severity(id, severity)
value ('s-1','harus');


insert into bug (id_bug, date_seen, deskripsi_bug, judul_bug, tanggal_fix, id_penanggung_jawab, id_resolver, id_severity, id_tester, id_versi)
value ('bug-0.0.1', '2017-1-1', 'game anu', 'bug anu', '2017-1-1','p-1','p-1','s-1','p-1','kamu');
