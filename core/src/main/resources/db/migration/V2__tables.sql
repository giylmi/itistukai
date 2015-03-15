CREATE TABLE users
(
  id bigint NOT NULL,
  email character varying(255),
  login character varying(255),
  password character varying(255),
  firstname character varying(255),
  lastname character varying(255),
  middlename character varying(255),
  role integer,
  salt character varying(255),
  CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE users
  OWNER TO postgres;

CREATE TABLE composition
(
  id bigint NOT NULL,
  name character varying(255),
  status integer,
  CONSTRAINT composition_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE composition
  OWNER TO postgres;

CREATE TABLE part
(
  id bigint NOT NULL,
  "number" bigint,
  text character varying(255),
  composition_id bigint,
  CONSTRAINT part_pkey PRIMARY KEY (id),
  CONSTRAINT fk_8d9uiywaelp40pf5lirtjs5m3 FOREIGN KEY (composition_id)
      REFERENCES composition (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE part
  OWNER TO postgres;

CREATE TABLE video
(
  id bigint NOT NULL,
  date timestamp without time zone,
  preloaderurl character varying(255),
  status integer,
  url character varying(255),
  part_id bigint,
  CONSTRAINT video_pkey PRIMARY KEY (id),
  CONSTRAINT fk_hscm4fwxxcqtv7vqbj7wntmjy FOREIGN KEY (part_id)
      REFERENCES part (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE video
  OWNER TO postgres;

CREATE TABLE instagramuser
(
  id character varying(255) NOT NULL,
  fullname character varying(255),
  profilepicture character varying(255),
  username character varying(255),
  CONSTRAINT instagramuser_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE instagramuser
  OWNER TO postgres;

CREATE TABLE instagramvideo
(
  instagramid character varying(255),
  instagramurl character varying(255),
  id bigint NOT NULL,
  instagramuser_id character varying(255),
  CONSTRAINT instagramvideo_pkey PRIMARY KEY (id),
  CONSTRAINT fk_irux5o0628g0iurgiilgg471a FOREIGN KEY (instagramuser_id)
      REFERENCES instagramuser (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_nyqdks02u4i980u5k5xa8br67 FOREIGN KEY (id)
      REFERENCES video (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE instagramvideo
  OWNER TO postgres;
