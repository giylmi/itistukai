ALTER TABLE vk_video
   DROP COLUMN owner_id;

CREATE table vk_owner
(
id BIGINT,
owner_id BIGINT,
owner_photo VARCHAR (511),
owner_name VARCHAR (511),
CONSTRAINT vk_owner_pk PRIMARY KEY (id)
);

ALTER TABLE vk_video
   ADD COLUMN vk_owner_id BIGINT,
   ADD  CONSTRAINT vk_video_id_fk FOREIGN KEY (vk_owner_id)
      REFERENCES vk_owner (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;