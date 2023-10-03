

INSERT INTO departments (code, name, contactEmail) VALUES ('MIE', 'Mechanical and Industrial Engineering', 'reception@mie.utoronto.ca');
INSERT INTO departments (code, name, contactEmail) VALUES ('ECE', 'Electrical and Computer Engineering', 'eceinquiry@utoronto.ca');
INSERT INTO departments (code, name, contactEmail) VALUES ('MSE', 'Materials Science and Engineering', 'materials.engineering@utoronto.ca');

INSERT INTO students (id, firstName, lastName, email, initials) VALUES (1111, 'Tyrion', 'Lannister', 'tyrion.lannister@mail.univ.ca', 'T.L.');
INSERT INTO students (id, firstName, lastName, email, initials) VALUES (2222, 'Cersei', 'Lannister', 'cersei.lannister@mail.univ.ca', 'C.L.');
INSERT INTO students (id, firstName, lastName, email, initials) VALUES (3333, 'Jaime', 'Lannister', 'jaime.lannister@mail.univ.ca', 'J.L.');
INSERT INTO students (id, firstName, lastName, email, initials) VALUES (4444, 'Daenerys', 'Targaryen', 'jaime.targaryen@mail.univ.ca', 'D.T.');
INSERT INTO students (id, firstName, lastName, email, initials) VALUES (5555, 'Jon', 'Snow', 'jon.snow@mail.univ.ca', 'J.S.');

INSERT INTO professors (id, firstName, lastName, email, initials, office, salary) VALUES (1122, 'Sansa', 'Stark', 'sansa.stark@univ.ca', 'S.S.', 'BA1234', 50000);
INSERT INTO professors (id, firstName, lastName, email, initials, office, salary) VALUES (3344, 'Arya', 'Stark', 'arya.stark@univ.ca', 'A.S.', 'MC1234', 70000);
INSERT INTO professors (id, firstName, lastName, email, initials, office, salary) VALUES (5566, 'Jorah', 'Mormont', 'jorah.mormont@univ.ca', 'J.M.', 'MY1234', 60000);

INSERT INTO courses (code, name, professorId) VALUES ('GOT123', 'A Game of Thrones', 1122);
INSERT INTO courses (code, name, professorId) VALUES ('GOT456', 'A Clash of Kings', 3344);
INSERT INTO courses (code, name, professorId) VALUES ('GOT789', 'A Storm of Swords', 5566);
INSERT INTO courses (code, name, professorId) VALUES ('ANI101', 'Intro to Dragons', 3344);
INSERT INTO courses (code, name, professorId) VALUES ('ANI102', 'Intro to the Kraken', 3344);
INSERT INTO courses (code, name, professorId) VALUES ('ANI201', 'Intermediate Dragon Training', 3344);
INSERT INTO courses (code, name, professorId) VALUES ('ANI202', 'Releasing the Kraken', 3344);
INSERT INTO courses (code, name, professorId) VALUES ('SWD101', 'Introductory Sword Fighting', 5566);

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