-- data.

insert into sections(section_id, name)
VALUES (1, '1'),
       (2, '2'),
       (3, '3'),
       (4, '4'),
       (5, '5');

insert into topics (section_id, topic_id, name)
VALUES (1, 1, '1'),
       (1, 2, '2'),
       (1, 3, '3'),
       (2, 1, '1'),
       (2, 2, '2'),
       (2, 3, '3'),
       (3, 1, '1'),
       (3, 2, '2'),
       (3, 3, '3'),
       (4, 1, '1'),
       (4, 2, '2'),
       (4, 3, '3');

insert into users (user_id, login, password, reg_date, role_id, status_id)
values (1, 'login01', 'password', current_date, 1, 2),
       (2, 'login02', 'password', current_date, 2, 2),
       (3, 'login03', 'password', current_date, 2, 2),
       (4, 'login04', 'password', current_date, 2, 2),
       (5, 'login05', 'password', current_date, 2, 2),
       (6, 'login06', 'password', current_date, 3, 2),
       (7, 'login07', 'password', current_date, 3, 2),
       (8, 'login08', 'password', current_date, 3, 2),
       (9, 'login09', 'password', current_date, 4, 2),
       (10, 'login10', 'password', current_date, 4, 2);


insert into articles (section_id, topic_id, article_id, text, date)
values (1, 1, 1, 'text1', current_date),
       (1, 1, 2, 'text2', current_date),
       (1, 1, 3, 'text3', current_date),
       (1, 1, 4, 'text4', current_date),
       (1, 1, 5, 'text5', current_date);

insert into user2article (article_id, section_id, topic_id, user_id)
VALUES (1, 1, 1, 1),
       (2, 1, 1, 2),
       (3, 1, 1, 3),
       (4, 1, 1, 4),
       (5, 1, 1, 5),

       (2, 1, 1, 3),

       (3, 1, 1, 2),
       (3, 1, 1, 4);
