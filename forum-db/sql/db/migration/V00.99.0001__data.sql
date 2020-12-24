-- data.


insert into sections(section_id, name)
VALUES (1, '1'),
       (2, '2'),
       (3, '3'),
       (4, '4'),
       (5, '5');





insert into topics (section_id, name, topic_id)
VALUES (1, '1', 1);

insert into users (user_id, login, password, reg_date, role_id, status_id)
values (1, 'login1', 'password', current_date, 1, 1),
       (2, 'login2', 'password', current_date, 1, 1),
       (3, 'login3', 'password', current_date, 1, 1),
       (4, 'login4', 'password', current_date, 1, 1),
       (5, 'login5', 'password', current_date, 1, 1),
       (6, 'login6', 'password', current_date, 1, 1),
       (7, 'login7', 'password', current_date, 1, 1),
       (8, 'login8', 'password', current_date, 1, 1),
       (9, 'login9', 'password', current_date, 1, 1),
       (10, 'login10', 'password', current_date, 1, 1);


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
