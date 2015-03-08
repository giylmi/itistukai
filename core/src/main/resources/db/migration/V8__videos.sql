CREATE TABLE videos (
  id SERIAL NOT NULL,
  partId INT,
  status INT NOT NULL DEFAULT 1,
  url VARCHAR(255) NOT NULL,
  date VARCHAR(255) NOT NULL,
  CONSTRAINT partId FOREIGN KEY (partId)
    REFERENCES parts (id) MATCH FULL
  ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT pk_videos_id PRIMARY KEY (id)
);

CREATE TABLE instagram_users (
  user_id VARCHAR(255) NOT NULL,
  username VARCHAR(255) NOT NULL,
  profile_picture VARCHAR(255) NOT NULL,
  full_name VARCHAR(255),
  CONSTRAINT pk_instagram_videos_id PRIMARY KEY (user_id)
);

CREATE TABLE instagram_videos (
  id INT NOT NULL,
  user_id VARCHAR(255) NOT NULL,
  instagram_video_id VARCHAR(255) NOT NULL,
  link VARCHAR(255) NOT NULL,
  CONSTRAINT fk_instagram_videos_id FOREIGN KEY (id)
    REFERENCES videos(id) MATCH FULL
  ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT pk_instagram_videos_user_id FOREIGN KEY (user_id)
    REFERENCES instagram_users(user_id) MATCH FULL
  ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT pk_instagram_videos_instagram_video_id PRIMARY KEY (instagram_video_id)
);