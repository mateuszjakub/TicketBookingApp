insert into room(id, name, row_no, seat_no)
values (1, 'Room 1', 7, 10);
insert into room(id, name, row_no, seat_no)
values (2, 'Room 2', 7, 10);
insert into room(id, name, row_no, seat_no)
values (3, 'Room 3', 7, 10);
insert into movie(id, title, duration)
values (1, 'Titanic', 120);
insert into movie(id, title, duration)
values (2, 'Braveheart', 111);
insert into movie(id, title, duration)
values (3, 'Matrix', 90);
insert into seance(id, room_id, movie_id, seance_date_time)
values (1, 1, 2, '2022-05-10 18:00:00');
insert into seance(id, room_id, movie_id, seance_date_time)
values (2, 1, 3, '2022-05-10 21:50:00');
insert into seance(id, room_id, movie_id, seance_date_time)
values (3, 2, 1, '2022-05-10 19:50:00');
insert into seance(id, room_id, movie_id, seance_date_time)
values (4, 2, 2, '2022-05-11 22:50:00');
insert into seance(id, room_id, movie_id, seance_date_time)
values (5, 3, 1, '2022-05-11 20:30:00');
insert into seance(id, room_id, movie_id, seance_date_time)
values (6, 3, 3, '2022-05-11 21:00:00');


