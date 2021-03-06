insert into user (id, email, password, nickname, regdate) VALUES (1, 'test', '{bcrypt}$2a$10$qS48/8nM2fSagy1di.whF.tutE/VZ9/wwOkGBcm.Ty8mOKLfwpv/G', '아이스베어', now());
insert into user (id, email, password, nickname, regdate) VALUES (2, 'test2', '{bcrypt}$2a$10$qS48/8nM2fSagy1di.whF.tutE/VZ9/wwOkGBcm.Ty8mOKLfwpv/G', '갈색곰', now());
insert into user (id, email, password, nickname, regdate) VALUES (3, 'test3', '{bcrypt}$2a$10$qS48/8nM2fSagy1di.whF.tutE/VZ9/wwOkGBcm.Ty8mOKLfwpv/G', '판다', now());

insert into user_roles(id, role_name, user_id) VALUES (1, 'USER', 1);
insert into user_roles(id, role_name, user_id) VALUES (2, 'ADMIN', 1);
insert into user_roles(id, role_name, user_id) VALUES (3, 'USER', 2);
insert into user_roles(id, role_name, user_id) VALUES (4, 'ADMIN', 2);
insert into user_roles(id, role_name, user_id) VALUES (5, 'USER', 3);

insert into channel (id, name, regdate) VALUES (1, 'room number 1', now());
insert into channel (id, name, regdate) VALUES (2, 'room number 2', now());
insert into channel (id, name, regdate) VALUES (3, 'room number 3', now());
insert into channel (id, name, regdate) VALUES (4, 'room number 4', now());

insert into channel_user (id, user_id, channel_id) VALUES (1, 1, 1);
insert into channel_user (id, user_id, channel_id) VALUES (2, 1, 2);
insert into channel_user (id, user_id, channel_id) VALUES (3, 1, 3);
insert into channel_user (id, user_id, channel_id) VALUES (4, 1, 4);

insert into channel_user (id, user_id, channel_id) VALUES (5, 2, 1);
insert into channel_user (id, user_id, channel_id) VALUES (6, 2, 2);

insert into channel_user (id, user_id, channel_id) VALUES (7, 3, 3);
insert into channel_user (id, user_id, channel_id) VALUES (8, 3, 4);