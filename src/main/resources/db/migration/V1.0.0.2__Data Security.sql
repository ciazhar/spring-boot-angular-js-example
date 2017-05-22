insert into user (id_user, enabled, password, username)
values ('u001', '1', '$2a$04$v1UZ4q0SCMTX695Wyowu/eVW9pT3giQivAElwH0A9BuvXktpd/qTq', 'admin');

insert into user (id_user, enabled, password, username)
values ('u002', '1', '$2a$12$gdXt7RKK3NteyWd2Z8K5T./ptvupi0MBG0ylW1WBO0/oEsMsGShbm', 'pm');

insert into user (id_user, enabled, password, username)
values ('u003', '1', '$2a$12$mDfe5KMd/kni1QotPNEr6.vmGY2puAlw4uqoAziUU0lSJWg9I0lai', 'programmer');

insert into user (id_user, enabled, password, username)
values ('u004', '1', '$2a$12$qEco5G1EU1tF7llL7l2kf.vrWsFtwohI4I690guWEDJ.Zzh8LbG.i', 'tester');


insert into role (id_role, nama_role, label_role)
values ('r001', 'ADMIN', 'Admin Sistem');

insert into role (id_role, nama_role, label_role)
values ('r002', 'PM', 'Project Manager');

insert into role (id_role, nama_role, label_role)
values ('r003', 'TESTER', 'Tester');

insert into role (id_role, nama_role, label_role)
values ('r004', 'PROGRAMMER', 'Programmer');


insert into permission (id_permission, nama_permission, label_permission)
values ('p001', 'RILIS_APLIKASI', 'Rilis Aplikasi');

insert into permission (id_permission, nama_permission, label_permission)
values ('p002', 'ASSIGNMENT_BUG', 'Asignment Bug ke Programmer');

insert into permission (id_permission, nama_permission, label_permission)
values ('p003', 'REPORT', 'Mendapatkan Report');

insert into permission (id_permission, nama_permission, label_permission)
values ('p004', 'MAKE_ISSUE', 'Membuat Issue Bug');

insert into permission (id_permission, nama_permission, label_permission)
values ('p005', 'RILIS_VERSI', 'Rilis Versi');

insert into permission (id_permission, nama_permission, label_permission)
values ('p006', 'SOLVE_BUG', 'Soliving Bug');


insert into user_role (id_user, id_role)
values ('u001', 'r001');

insert into user_role (id_user, id_role)
values ('u001', 'r002');

insert into user_role (id_user, id_role)
values ('u001', 'r003');

insert into user_role (id_user, id_role)
values ('u001', 'r004');

insert into user_role (id_user, id_role)
values ('u002', 'r002');

insert into user_role (id_user, id_role)
values ('u003', 'r003');

insert into user_role (id_user, id_role)
values ('u004', 'r004');


insert into role_permission (id_role, id_permission)
values ('r001', 'p001');

insert into role_permission (id_role, id_permission)
values ('r001', 'p002');

insert into role_permission (id_role, id_permission)
values ('r001', 'p003');

insert into role_permission (id_role, id_permission)
values ('r001', 'p004');

insert into role_permission (id_role, id_permission)
values ('r001', 'p005');

insert into role_permission (id_role, id_permission)
values ('r001', 'p006');

insert into role_permission (id_role, id_permission)
values ('r002', 'p001');

insert into role_permission (id_role, id_permission)
values ('r002', 'p002');

insert into role_permission (id_role, id_permission)
values ('r002', 'p003');

insert into role_permission (id_role, id_permission)
values ('r003', 'p004');

insert into role_permission (id_role, id_permission)
values ('r004', 'p005');

insert into role_permission (id_role, id_permission)
values ('r004', 'p006');
