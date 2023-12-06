
INSERT INTO students (id, firstName, lastName, email, uTorId, faculty, major) VALUES (1001, 'Adam', 'Mainella', 'a.mainella@mail.utoronto.ca', 'mainell3','FASE','Industrial Engineering');
INSERT INTO students (id, firstName, lastName, email, uTorId, faculty, major) VALUES (1002, 'Briana', 'Vieira', 'b.vieira@mail.utoronto.ca', 'vieira1','FASE','Industrial Engineering');
INSERT INTO students (id, firstName, lastName, email, uTorId, faculty, major) VALUES (1003, 'Daniel', 'Lim', 'd.lim@mail.utoronto.ca', 'lim1','FASE','Industrial Engineering');
INSERT INTO students (id, firstName, lastName, email, uTorId, faculty, major) VALUES (1004, 'Charlotte', 'Vedrines', 'c.vedrines@mail.utoronto.ca', 'vedrine1','FASE','Industrial Engineering');
INSERT INTO students (id, firstName, lastName, email, uTorId, faculty, major) VALUES (1005, 'Shawn', 'Teh', 's.teh@mail.utoronto.ca', 'teh1','FASE','Industrial Engineering');
INSERT INTO students (id, firstName, lastName, email, uTorId, faculty, major) VALUES (1006, 'Kelvin', 'Lo', 'k.lo@mail.utoronto.ca', 'lo1','FASE','Industrial Engineering');
INSERT INTO students (id, firstName, lastName, email, uTorId, faculty, major) VALUES (1007, 'Hayden', 'Groer', 'H.Groer@mail.utoronto.ca', 'groer1','FASE','Industrial Engineering');

INSERT INTO administrators (id, firstName, lastName, email, uTorId) VALUES (2001, 'Mark', 'Chignell', 'm.chiggy@mail.utoronto.ca', 'chiggy1');
INSERT INTO administrators (id, firstName, lastName, email, uTorId) VALUES (2002, 'Janet', 'Lam', 'j.lam@mail.utoronto.ca', 'lam1');
INSERT INTO administrators (id, firstName, lastName, email, uTorId) VALUES (2003, 'Eldan', 'Cohen', 'e.cohen@mail.utoronto.ca', 'cohen1');
INSERT INTO administrators (id, firstName, lastName, email, uTorId) VALUES (2004, 'Vahid', 'Sarhanigan', 'v.sarhanigan@mail.utoronto.ca', 'sarhanigan1');
INSERT INTO administrators (id, firstName, lastName, email, uTorId) VALUES (2005, 'Emily', 'King', 'e.king@mail.utoronto.ca', 'king1');
INSERT INTO administrators (id, firstName, lastName, email, uTorId) VALUES (2006, 'Craig', 'Fernandes', 'c.fernandes@mail.utoronto.ca', 'fernandes1');

INSERT INTO studentgroups (groupId, name) VALUES (3001, 'Human Factors Interest Group');
INSERT INTO studentgroups (groupId, name) VALUES (3002, 'Skule Unicycle Club');
INSERT INTO studentgroups (groupId, name) VALUES (3003, 'U of T Toastmasters');
INSERT INTO studentgroups (groupId, name) VALUES (3004, 'Robotics for Space Exploration');
INSERT INTO studentgroups (groupId, name) VALUES (3005, 'The Lady Godiva Memorial Bnad');
INSERT INTO studentgroups (groupId, name) VALUES (3006, 'Hart House');
INSERT INTO studentgroups (groupId, name) VALUES (3007, 'UTFOLD');
INSERT INTO studentgroups (groupId, name) VALUES (3008, 'Varsity Athletics');
INSERT INTO studentgroups (groupId, name) VALUES (3009, 'Multi-Faith Centre');
INSERT INTO studentgroups (groupId, name) VALUES (3010, 'IMI UofT');
INSERT INTO studentgroups (groupId, name) VALUES (3011, 'KPE UofT');
INSERT INTO studentgroups (groupId, name) VALUES (3012, 'University of Toronto Aerospace Team');
INSERT INTO studentgroups (groupId, name) VALUES (3013, 'Blue Sky Solar Racing');
INSERT INTO studentgroups (groupId, name) VALUES (3014, 'UofT Formula SAE');
INSERT INTO studentgroups (groupId, name) VALUES (3015, 'Indy Club');
INSERT INTO studentgroups (groupId, name) VALUES (3016, 'ECE Club');

INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('HH010', 'Hart House', 'Gymnasium', 105);
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('SS1086', 'Sidney Smith Hall', 'Tutorial', 40);
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('HH020', 'Hart House', 'Barber Shop', 15);
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('GR100', 'Goldring Centre for High Performance Sport', 'Field', 500); /* Outdoor Field */
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('GR200', 'Goldring Centre for High Performance Sport', 'Gymnasium', 2000); /* Kimel Family Field House */
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('MF100', 'Multi-Faith Centre', 'Activity Hall', 75);
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('HH030', 'Hart House', 'Theatre', 300);
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('ON000', 'Online', 'your house lol', 69420);
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('AC101', 'Athletic Centre', 'Gymnasium', 50); /* AC Fieldhouse 1 */
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('AC102', 'Athletic Centre', 'Gymnasium', 50); /* AC Fieldhouse 2 */
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('AC103', 'Athletic Centre', 'Gymnasium', 50); /* AC Fieldhouse 3 */
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('AC104', 'Athletic Centre', 'Gymnasium', 50); /* AC Fieldhouse 4 */
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('AC200', 'Athletic Centre', 'Gymnasium', 200); /* AC Sports Gym */
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('BA1130', 'Bahen Centre for Information Technolgy', 'Lecture', 200);
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('BA1150', 'Bahen Centre for Information Technolgy', 'Lecture', 150);
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('BA1160', 'Bahen Centre for Information Technolgy', 'Lecture', 100);
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('BA1170', 'Bahen Centre for Information Technolgy', 'Lecture', 200);
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('BA1180', 'Bahen Centre for Information Technolgy', 'Lecture', 120);
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('BA1190', 'Bahen Centre for Information Technolgy', 'Lecture', 120);
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('MY150', 'Myhal Centre for Engineering Innovation and Entrepreneurship', 'Lecture', 450);
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('MY030', 'Myhal Centre for Engineering Innovation and Entrepreneurship', 'Computer Lab', 60);
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('MC331', 'Mechanical Engineering Building', 'Tutorial', 40);
INSERT INTO rooms (roomCode, building, roomType, capacity) VALUES ('ET000', 'External Location', 'External', 10000);

INSERT INTO events (eventCode, eventName, studentGroup, roomCode, date, duration, description, eventType, eventCapacity, externalURL) VALUES (1, 'Pickleball', 3006, 'HH010', '2023-11-23', 1.33, 'Visit the fitness information desk to collect a wristband to play', 'Athletic', 16, 'https://harthouse.ca/');
INSERT INTO events (eventCode, eventName, studentGroup, roomCode, date, duration, description, eventType, eventCapacity, externalURL) VALUES (2, 'Origami Workshop', 3007, 'SS1086', '2023/12/01 16:00:01', 2, 'Drop in and fold origami!', 'Arts', 60, 'https://utfold.com/');
INSERT INTO events (eventCode, eventName, studentGroup, roomCode, date, duration, description, eventType, eventCapacity, externalURL) VALUES (3, 'Barbershop', 3006, 'HH020', '2023/12/04 12:00:01', 4, 'Black Futures Presents: Barbershop – Bi-weekly hair services right on campus. Whether you need to refresh your fade, or crisp up that line. Barbershop has got you covered.', 'Arts', 15, 'https://harthouse.ca/');
INSERT INTO events (eventCode, eventName, studentGroup, roomCode, date, duration, description, eventType, eventCapacity, externalURL) VALUES (4, 'Varsity Games', 3008, 'GR200', '2023/12/05 10:10:01', 2, 'Come watch the best of the best of U of T athletics compete against other universities from across Canada', 'Athletic', 2000, 'https://varsityblues.ca/');
INSERT INTO events (eventCode, eventName, studentGroup, roomCode, date, duration, description, eventType, eventCapacity, externalURL) VALUES (5, 'Interfaith Movies & Connections', 3009, 'MF100', '2023/12/07 15:30:01', 2, 'Interfaith movie nights are a fun opportunity to relax and connect. Every month we will show films highlighting a diverse array of faith traditions and experiences.', 'Religous', 100, '');
INSERT INTO events (eventCode, eventName, studentGroup, roomCode, date, duration, description, eventType, eventCapacity, externalURL) VALUES (6, 'Interfaith Meals Pongal Celebration', 3009, 'MF100', '2024/01/15 12:00:01', 2, 'As part of the Interfaith Meals program, the Multi-Faith Centre and Centre for International Experience will be hosting a lunch in honour of Pongal on Monday 15th, from 12:00-2:00pm.', 'Religous', 75, '');
INSERT INTO events (eventCode, eventName, studentGroup, roomCode, date, duration, description, eventType, eventCapacity, externalURL) VALUES (7, 'The Art of Belly Dance', 3006, 'HH030', '2023/11/23 17:00:01', 2, 'Learn technique through the culture of the anatomy, the mental and physical benefits for the mind and body, and the conception of one of the first forms of dance known to mankind amid the first civilizations as we know it.', 'Athletic', 20, 'https://harthouse.ca/');
INSERT INTO events (eventCode, eventName, studentGroup, roomCode, date, duration, description, eventType, eventCapacity, externalURL) VALUES (8, 'IMI Big Data & Artificial Intelligence Competition', 3010, 'ON000', '2023/11/25 11:30:01', 1.5, 'This competition is free to enter and is open to graduate students and undergrads with big data/AI experience from any academic discipline in any year of their academic career at the University of Toronto.', 'Academic', 100, '');
INSERT INTO events (eventCode, eventName, studentGroup, roomCode, date, duration, description, eventType, eventCapacity, externalURL) VALUES (9, 'Drop-In Volleyball', 3011, 'AC104', '2023/11/29 18:00:01', 4, 'Come play drop in volleyball', 'Athletic', 50, 'https://kpe.utoronto.ca/welcome-sport-rec-u-t');
INSERT INTO events (eventCode, eventName, studentGroup, roomCode, date, duration, description, eventType, eventCapacity, externalURL) VALUES (10, 'Drop-In Basketball', 3011, 'AC102', '2023/12/05 20:00:00', 2, 'Come play drop in basketball', 'Athletic', 20, 'https://kpe.utoronto.ca/welcome-sport-rec-u-t');
INSERT INTO events (eventCode, eventName, studentGroup, roomCode, date, duration, description, eventType, eventCapacity, externalURL) VALUES (11, 'Indy PEY Panel', 3015, 'ON000', '2023/11/23 19:00:00', 2, 'Discover the keys to success in landing leading companies!', 'Professional', 50, '');
INSERT INTO events (eventCode, eventName, studentGroup, roomCode, date, duration, description, eventType, eventCapacity, externalURL) VALUES (12, 'Indy Club Valorant Tournament', 3015, 'ON000', '2023/11/06 13:00:00', 4, 'Come show your skills in Valorant!', 'Gaming', 40, '');
INSERT INTO events (eventCode, eventName, studentGroup, roomCode, date, duration, description, eventType, eventCapacity, externalURL) VALUES (13, 'Indy Club First Year Student Midterm Prep', 3015, 'MC331', '2023/10/19 18:00:00', 1, 'Come show first years midterm tips and tricks', 'Academic', 40, '');
INSERT INTO events (eventCode, eventName, studentGroup, roomCode, date, duration, description, eventType, eventCapacity, externalURL) VALUES (14, 'MIE Dinner Dance', 3015, 'ET000', '2023/11/03 18:30:00', 6, 'Come dine and dance at the Warehouse Event Venue!', 'Party', 300, '');
INSERT INTO events (eventCode, eventName, studentGroup, roomCode, date, duration, description, eventType, eventCapacity, externalURL) VALUES (15, 'ECE Dinner Dance', 3016, 'ET000', '2024/02/16 18:00:00', 6, 'Come dine and dance at the Chateau le Jardin!', 'Party', 300, '');

INSERT INTO rsvps (studentId, eventCode) VALUES (1001, 1);
INSERT INTO rsvps (studentId, eventCode) VALUES (1002, 1);
INSERT INTO rsvps (studentId, eventCode) VALUES (1003, 2);
INSERT INTO rsvps (studentId, eventCode) VALUES (1007, 8);
INSERT INTO rsvps (studentId, eventCode) VALUES (1002, 9);
INSERT INTO rsvps (studentId, eventCode) VALUES (1007, 3);
INSERT INTO rsvps (studentId, eventCode) VALUES (1007, 7);
INSERT INTO rsvps (studentId, eventCode) VALUES (1001, 3);
INSERT INTO rsvps (studentId, eventCode) VALUES (1001, 5);
INSERT INTO rsvps (studentId, eventCode) VALUES (1003, 4);
INSERT INTO rsvps (studentId, eventCode) VALUES (1003, 9);


