insert into user (id, email, password, nickname, regdate) VALUES (1, 'test', '{bcrypt}$2a$10$qS48/8nM2fSagy1di.whF.tutE/VZ9/wwOkGBcm.Ty8mOKLfwpv/G', '라쿤', now());
insert into user (id, email, password, nickname, regdate) VALUES (2, 'test2', '{bcrypt}$2a$10$qS48/8nM2fSagy1di.whF.tutE/VZ9/wwOkGBcm.Ty8mOKLfwpv/G', '오리', now());
insert into user_roles(id, role_name, user_id) VALUES (1, 'USER', 1);
insert into user_roles(id, role_name, user_id) VALUES (2, 'ADMIN', 1);
insert into user_roles(id, role_name, user_id) VALUES (3, 'USER', 2);
insert into user_roles(id, role_name, user_id) VALUES (4, 'ADMIN', 2);