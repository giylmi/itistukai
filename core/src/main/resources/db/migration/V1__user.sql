CREATE table users (
  id SERIAL not null,
  login VARCHAR(255) not null,
  password VARCHAR(255) not null,
  CONSTRAINT pk_id PRIMARY KEY (id)
);

CREATE TABLE personnel_information (
  userId int not null,
  firstName VARCHAR(255) not null,
  middleName VARCHAR(255),
  lastName VARCHAR(255) not null,
  CONSTRAINT fk_userId FOREIGN KEY (userId)
    REFERENCES users (id) MATCH FULL
    ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT pk_userId PRIMARY KEY (userId)
);