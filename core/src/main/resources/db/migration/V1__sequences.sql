CREATE SEQUENCE composition_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 2
  CACHE 1;
ALTER TABLE composition_sequence
  OWNER TO postgres;

CREATE SEQUENCE part_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 124
  CACHE 1;
ALTER TABLE part_sequence
  OWNER TO postgres;

CREATE SEQUENCE user_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 2
  CACHE 1;
ALTER TABLE user_sequence
  OWNER TO postgres;

CREATE SEQUENCE video_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 262
  CACHE 1;
ALTER TABLE video_sequence
  OWNER TO postgres;
