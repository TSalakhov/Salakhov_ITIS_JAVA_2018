DELETE FROM users;

INSERT INTO users (username, password, firstname, secondname, role)
VALUES ('user1', 'user1', 'Александр', 'Пушкин', 'USER');

INSERT INTO users (username, password, firstname, secondname, role)
VALUES ('user2', 'user2', 'Александр', 'Герцен', 'USER');

insert into event (name, description, start_date, end_date, address, image_url, status)
    VALUES ('Защита проекта', '19 мая состоится презентация проекта Entertainment Adviser',
            '2018-05-19 17:00:00'::timestamp, '2018-05-19 18:00:00'::timestamp,
    'Кремлевская 35, ауд. 1308', 'https://kpfu.ru/portal/docs/F1897406703/_ITIS_7.jpg',
    'Предстоит');