-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2018-05-09 18:13:04.473

-- tables
-- Table: Event
CREATE TABLE Event (
    name varchar(255)  NOT NULL,
    description varchar(255)  NOT NULL,
    date varchar(255)  NOT NULL,
    address varchar(255)  NOT NULL,
    image varchar(255)  NOT NULL,
    status varchar(255)  NOT NULL,
    CONSTRAINT Event_pk PRIMARY KEY (name)
);

-- Table: User
CREATE TABLE "User" (
    id bigserial  NOT NULL,
    password bigint  NOT NULL,
    name varchar(255)  NOT NULL,
    second_name varchar(255)  NOT NULL,
    city varchar(255)  NOT NULL,
    CONSTRAINT User_pk PRIMARY KEY (id)
);

-- Table: event_tags
CREATE TABLE event_tags (
    Event_name varchar(255)  NOT NULL,
    tags_id bigint  NOT NULL
);

-- Table: tags
CREATE TABLE tags (
    id bigserial  NOT NULL,
    text varchar(255)  NOT NULL,
    CONSTRAINT tags_pk PRIMARY KEY (id)
);

-- Table: user_tags
CREATE TABLE user_tags (
    User_id bigint  NOT NULL,
    tags_id bigint  NOT NULL
);

-- foreign keys
-- Reference: event_tags_Event (table: event_tags)
ALTER TABLE event_tags ADD CONSTRAINT event_tags_Event
    FOREIGN KEY (Event_name)
    REFERENCES Event (name)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: event_tags_tags (table: event_tags)
ALTER TABLE event_tags ADD CONSTRAINT event_tags_tags
    FOREIGN KEY (tags_id)
    REFERENCES tags (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: tags_User (table: user_tags)
ALTER TABLE user_tags ADD CONSTRAINT tags_User
    FOREIGN KEY (User_id)
    REFERENCES "User" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: tags_tags (table: user_tags)
ALTER TABLE user_tags ADD CONSTRAINT tags_tags
    FOREIGN KEY (tags_id)
    REFERENCES tags (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

