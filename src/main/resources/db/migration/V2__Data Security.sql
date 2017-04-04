insert into user (id_user, enabled, password, username)
values ('u001', '1', '123', 'admin');

insert into user (id_user, enabled, password, username)
values ('u002', '1', '123', 'ciazhar');

insert into role (id_role, nama_role, label_role)
values ('r001', 'STAFF', 'Staf Administrasi');

insert into role (id_role, nama_role, label_role)
values ('r002', 'SUPERVISOR', 'Supervisor');

insert into permission (id_permission, nama_permission, label_permission)
values ('p001', 'READ', 'Melihat data');

insert into permission (id_permission, nama_permission, label_permission)
values ('p002', 'EDIT', 'Mengubah data');

insert into user_role (id_user, id_role)
values ('u001', 'r001');

insert into user_role (id_user, id_role)
values ('u001', 'r002');

insert into user_role (id_user, id_role)
values ('u002', 'r001');

insert into role_permission (id_role, id_permission)
values ('r001', 'p001');

insert into role_permission (id_role, id_permission)
values ('r002', 'p001');

insert into role_permission (id_role, id_permission)
values ('r002', 'p002');