create table addrbook.users (
ID int NOT NULL AUTO_INCREMENT,
logon_id varchar(256) NOT NULL,
password varchar(1024) NOT NULL,
last_update timestamp default now(),
PRIMARY KEY(id)
);

create table addrbook.contacts (
id int NOT NULL AUTO_INCREMENT,
firstname varchar(256) NOT NULL,
lastname varchar(256) NOT NULL,
email varchar(256) NOT NULL,
address varchar(512) NOT NULL,
phone varchar(32) NOT NULL,
last_update timestamp default now(),
user_id int,
PRIMARY KEY(id),
CONSTRAINT fk_users_id FOREIGN KEY (user_id) REFERENCES addrbook.users(id)
);

INSERT INTO addrbook.users (logon_id, password)
VALUES ('saran', 'pass123');

INSERT INTO addrbook.users (logon_id, password)
VALUES ('vij', 'pass123');

INSERT INTO addrbook.users (logon_id, password)
VALUES ('raj', 'pass123');

INSERT INTO addrbook.users (logon_id, password)
VALUES ('sara', 'pass123');

INSERT INTO addrbook.contacts (firstname, lastname, email, address, phone, user_id)
VALUES ('Jony', 'S', 'jony@gmail.com', '111 Main ST', '9283923892', 1);

INSERT INTO addrbook.contacts (firstname, lastname, email, address, phone, user_id)
VALUES ('Alex', 'S', 'alexaamz@gmail.com', '441 Stain ST', '875875343', 1);

