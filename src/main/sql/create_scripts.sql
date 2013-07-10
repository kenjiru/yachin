create table USERS(
	ID SERIAL not null unique, 
	USERNAME varchar(50) not null unique,
	PASSWORD varchar(50) not null,
	ENABLED boolean not null,
	constraint PK_USERS primary key (ID, USERNAME)
);

create table AUTHORITIES (
	ID SERIAL PRIMARY KEY,
	USER_id integer references users (id),
	AUTHORITY varchar(50) not null
);
    
CREATE TABLE LISTINGS (
    ID SERIAL PRIMARY KEY,
    TITLE VARCHAR(200) DEFAULT 'bau' NOT NULL,
    SUBMIT_DATE DATE DEFAULT NULL,
    NO_ROOMS SMALLINT DEFAULT 0, 
   	OWNER_ID integer references users (id)
);


insert into USERS(USERNAME, PASSWORD, ENABLED) values
('admin','admin',true);

insert into USERS(USERNAME, PASSWORD, ENABLED) values
('radu','panamea',true);

insert into USERS(USERNAME, PASSWORD, ENABLED) values
('ada','panamea',true);

insert into AUTHORITIES(user_id, AUTHORITY) values
(1,'ROLE_ADMIN');

insert into AUTHORITIES(user_id, AUTHORITY) values
(2,'ROLE_USER');

insert into AUTHORITIES(user_id, AUTHORITY) values
(3,'ROLE_USER');

insert into AUTHORITIES(user_id, AUTHORITY) values
(3,'ROLE_ADMIN');