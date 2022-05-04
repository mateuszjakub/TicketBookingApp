CREATE TABLE ROOM
(
    id      INTEGER      NOT NULL AUTO_INCREMENT,
    name    VARCHAR(128) NOT NULL,
    row_no  INTEGER      NOT NULL,
    seat_no INTEGER      NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE MOVIE
(
    id       INTEGER      NOT NULL AUTO_INCREMENT,
    title    VARCHAR(128) NOT NULL,
    duration INTEGER      NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE SEANCE
(
    id               INTEGER  NOT NULL AUTO_INCREMENT,
    room_id          INTEGER  NOT NULL,
    movie_id         INTEGER  NOT NULL,
    seance_date_time datetime NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE SEANCE
    ADD CONSTRAINT seance_room_id
        FOREIGN KEY (room_id) REFERENCES room (id);
ALTER TABLE SEANCE
    ADD CONSTRAINT seance_movie_id
        FOREIGN KEY (movie_id) REFERENCES movie (id);

CREATE TABLE TICKET
(
    id         INTEGER      NOT NULL AUTO_INCREMENT,
    ticketType VARCHAR(128) NOT NULL,
    price      DECIMAL      NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE RESERVATION
(
    id          INTEGER      NOT NULL AUTO_INCREMENT,
    seance_id   INTEGER      NOT NULL,
    ticket      VARCHAR(128) NOT NULL,
    first_name  VARCHAR(128) NOT NULL,
    second_name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE RESERVATION
    ADD CONSTRAINT reservation_seance_id
        FOREIGN KEY (seance_id) REFERENCES seance (id);

CREATE TABLE RESERVATION_SEATS
(
    reservation_id INTEGER NOT NULL,
    seat_row       INTEGER NOT NULL,
    seat           INTEGER NOT NULL,
    PRIMARY KEY (reservation_id, seat_row, seat)
);
ALTER TABLE RESERVATION_SEATS
    ADD CONSTRAINT reservation_id
        FOREIGN KEY (reservation_id) REFERENCES reservation (id);
