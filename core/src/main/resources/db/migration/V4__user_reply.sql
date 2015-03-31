CREATE SEQUENCE user_reply_seq
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;
ALTER TABLE user_reply_seq
OWNER TO postgres;

CREATE TABLE public.userreply
(
  id           BIGINT                  NOT NULL,
  reply_type   INTEGER,
  date_sent    DATE                    NOT NULL,
  views_number BIGINT DEFAULT 0        NOT NULL,
  user_email   CHARACTER VARYING(255)  NOT NULL,
  user_name    CHARACTER VARYING(255)  NOT NULL,
  reply_text   CHARACTER VARYING(1023) NOT NULL
)
WITH (
OIDS = FALSE
);
ALTER TABLE userreply
OWNER TO postgres