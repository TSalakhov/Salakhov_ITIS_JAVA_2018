INSERT INTO poll (title) VALUES ('Ваш возраст?');
INSERT INTO poll (title) VALUES ('Ваше образование?');

INSERT INTO answer (text, poll_id, votes_count) VALUES ('Младше 21', 1, 0);
INSERT INTO answer (text, poll_id, votes_count) VALUES ('Старше 21', 1, 0);

INSERT INTO answer (text, poll_id, votes_count) VALUES ('Неокнченое среднее', 2, 0);
INSERT INTO answer (text, poll_id, votes_count) VALUES ('Среднее', 2, 0);
INSERT INTO answer (text, poll_id, votes_count) VALUES ('Неокнченое высшее', 2, 0);
INSERT INTO answer (text, poll_id, votes_count) VALUES ('Высшее', 2, 0);