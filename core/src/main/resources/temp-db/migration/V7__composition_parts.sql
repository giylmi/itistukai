CREATE table compositions (
  id SERIAL not null,
  name VARCHAR(255) not null,
  status int not null default 1,
  CONSTRAINT pk_compositions_id PRIMARY KEY (id)
);

CREATE TABLE parts (
  id SERIAL not null,
  compositionId int not null,
  text TEXT not null,
  CONSTRAINT compositionId FOREIGN KEY (compositionId)
    REFERENCES compositions (id) MATCH FULL
    ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT pk_parts_id PRIMARY KEY (id)
);