
INSERT INTO students (id, firstName, lastName, email, uTorId, faculty, major) VALUES (1111, 'Adam', 'Mainella', 'a.mainella@mail.utoronto.ca', 'mainell3','FASE','Industrial Engineering');
INSERT INTO students (id, firstName, lastName, email, uTorId, faculty, major) VALUES (2222, 'Briana', 'Vieira', 'b.vieira@mail.utoronto.ca', 'vieira1','FASE','Industrial Engineering');
INSERT INTO students (id, firstName, lastName, email, uTorId, faculty, major) VALUES (3333, 'Daniel', 'Lim', 'd.lim@mail.utoronto.ca', 'lim1','FASE','Industrial Engineering');
INSERT INTO students (id, firstName, lastName, email, uTorId, faculty, major) VALUES (4444, 'Charlotte', 'Vedrines', 'c.vedrines@mail.utoronto.ca', 'vedrine1','FASE','Industrial Engineering');
INSERT INTO students (id, firstName, lastName, email, uTorId, faculty, major) VALUES (5555, 'Shawn', 'Teh', 's.teh@mail.utoronto.ca', 'teh1','FASE','Industrial Engineering');
INSERT INTO students (id, firstName, lastName, email, uTorId, faculty, major) VALUES (6666, 'Kelvin', 'Lo', 'k.lo@mail.utoronto.ca', 'lo1','FASE','Industrial Engineering');
INSERT INTO students (id, firstName, lastName, email, uTorId, faculty, major) VALUES (7777, 'Hayden', 'Groer', 'H.Groer@mail.utoronto.ca', 'groer1','FASE','Industrial Engineering');

INSERT INTO administrators (id, firstName, lastName, email, uTorId) VALUES (8888, 'Mark', 'Chignell', 'm.chiggy@mail.utoronto.ca', 'chiggy1');
INSERT INTO administrators (id, firstName, lastName, email, uTorId) VALUES (9999, 'Janet', 'Lam', 'j.lam@mail.utoronto.ca', 'lam1');

INSERT INTO studentgroups (groupId, name) VALUES (0111, 'Human Factors Interest Group');
INSERT INTO studentgroups (groupId, name) VALUES (0222, 'Skule Unicycle Club');
INSERT INTO studentgroups (groupId, name) VALUES (0333, 'U of T Toastmasters');
INSERT INTO studentgroups (groupId, name) VALUES (0444, 'Robotics for Space Exploration');
INSERT INTO studentgroups (groupId, name) VALUES (0555, 'The Lady Godiva Memorial Bnad');
INSERT INTO studentgroups (groupId, name) VALUES (0001, 'Hart House');

INSERT INTO rooms (roomCode, building, roomType,capacity) VALUES ('HH010', 'Hart House', 'Gymnasium', 105);
INSERT INTO rooms (roomCode, building, roomType,capacity) VALUES ('SS1086', 'Sidney Smith Hall', 'Tutorial', 40);
INSERT INTO rooms (roomCode, building, roomType,capacity) VALUES ('HH020', 'Hart House', 'Barber Shop', 15);
INSERT INTO rooms (roomCode, building, roomType,capacity) VALUES ('GR100', 'Goldring Centre for High Performance Sport', 'Field', 500);
INSERT INTO rooms (roomCode, building, roomType,capacity) VALUES ('MF100', 'Multi-Faith Centre', 'Activity Hall', 75);
INSERT INTO rooms (roomCode, building, roomType,capacity) VALUES ('HH030', 'Hart House', 'Theatre', 300);
INSERT INTO rooms (roomCode, building, roomType,capacity) VALUES ('ON000', 'Online', 'your house lol', 69420);

INSERT INTO events (eventCode, eventName, studentGroup, roomCode, date, duration, description, eventType, eventCapacity) VALUES (1, 'Pickleball', 0001, 'HH010', '2023-11-23', 1.33, 'Visit the fitness information desk to collect a wristband to play', 'Athletic', 16);
/*
INSERT INTO events (eventCode, eventName, studentGroup, room, dateTime, duration, description, eventType, eventCapacity) VALUES (2, 'Origami Workshop', UTFOLD, SS1086, '2023/12/01 16:00:01', 2, 'Drop in and fold origami!', 'Arts', 60);
INSERT INTO events (eventCode, eventName, studentGroup, room, dateTime, duration, description, eventType, eventCapacity) VALUES (3, 'Barbershop', HartHouse, HartGym, '2023/12/04 12:00:01', 4, 'Black Futures Presents: Barbershop – Bi-weekly hair services right on campus. Whether you need to refresh your fade, or crisp up that line. Barbershop has got you covered.', 'Arts');
INSERT INTO events (eventCode, eventName, studentGroup, room, dateTime, duration, description, eventType, eventCapacity) VALUES (4, 'Varsity Games', Varsity, Goldring, '2023/12/05 10:10:01', 2, 'Come watch the best of the best of U of T athletics compete against other universities from across Canada', 'Athletic');
INSERT INTO events (eventCode, eventName, studentGroup, room, dateTime, duration, description, eventType, eventCapacity) VALUES (5, 'Interfaith Movies & Connections', MultiFaithCentre, MFCMainActivityHall, '2023/12/07 15:30:01', 2, 'Interfaith movie nights are a fun opportunity to relax and connect. Every month we will show films highlighting a diverse array of faith traditions and experiences.', 'Religous');
INSERT INTO events (eventCode, eventName, studentGroup, room, dateTime, duration, description, eventType, eventCapacity) VALUES (6, 'Interfaith Meals Pongal Celebration', MultiFaithCentre, MFCMainActivityHall, '2024/01/15 12:00:01', 2, 'As part of the Interfaith Meals program, the Multi-Faith Centre and Centre for International Experience will be hosting a lunch in honour of Pongal on Monday 15th, from 12:00-2:00pm.', 'Religous');
INSERT INTO events (eventCode, eventName, studentGroup, room, dateTime, duration, description, eventType, eventCapacity) VALUES (7, 'The Art of Belly Dance', HartHouse, HartStage, '2023/11/23 17:00:01', 2, 'Learn technique through the culture of the anatomy, the mental and physical benefits for the mind and body, and the conception of one of the first forms of dance known to mankind amid the first civilizations as we know it.', 'Athletic');
INSERT INTO events (eventCode, eventName, studentGroup, room, dateTime, duration, description, eventType, eventCapacity) VALUES (8, 'IMI Big Data & Artificial Intelligence Competition', IMIUofT, Online, '2023/11/25 11:30:01', 1.5, 'This competition is free to enter and is open to graduate students and undergrads with big data/AI experience from any academic discipline in any year of their academic career at the University of Toronto. Please note this is geared towards graduate and undergraduate students with experience in big data and artificial intelligence.', 'Academic', 100);
*/

/*these will not be used and we can delete*/
/*
INSERT INTO marks(studentId, courseCode, mark) VALUES(1111, 'GOT123', 80);
INSERT INTO marks(studentId, courseCode, mark) VALUES(2222, 'GOT123', 85);
INSERT INTO marks(studentId, courseCode, mark) VALUES(3333, 'GOT456', 90);
INSERT INTO marks(studentId, courseCode, mark) VALUES(4444, 'GOT456', 95);
INSERT INTO marks(studentId, courseCode, mark) VALUES(5555, 'GOT789', 100);
INSERT INTO marks(studentId, courseCode, mark) VALUES(5555, 'GOT123', 80);
INSERT INTO marks(studentId, courseCode, mark) VALUES(5555, 'GOT456', 90);

INSERT INTO classrooms(code, capacity) VALUES('GB144', 85);
INSERT INTO classrooms(code, capacity) VALUES('GB150', 90);
INSERT INTO classrooms(code, capacity) VALUES('MB123', 100);
INSERT INTO classrooms(code, capacity) VALUES('BA1130', 300);
INSERT INTO classrooms(code, capacity) VALUES('MY150', 450);
INSERT INTO classrooms(code, capacity) VALUES('BA1190', 250);
INSERT INTO classrooms(code, capacity) VALUES('BA1200', 75);
INSERT INTO classrooms(code, capacity) VALUES('MP103', 220);
 */