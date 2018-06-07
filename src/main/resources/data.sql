insert into user values(10001, SYSDATE(), 'Alex');
insert into user values(10002, SYSDATE(), 'Tomy');
insert into user values(10003, SYSDATE(), 'Jim');

insert into post values(50001, 'post 1', SYSDATE(), 10001);
insert into post values(50002, 'post 2', SYSDATE(), 10001);
insert into post values(50003, 'post 3', SYSDATE(), 10002);