CREATE TABLE videos (
  id SERIAL NOT NULL,
  partId INT,
  status INT NOT NULL DEFAULT 1,
  url VARCHAR(255) NOT NULL,
  CONSTRAINT partId FOREIGN KEY (partId)
    REFERENCES parts (id) MATCH FULL
  ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT pk_videos_id PRIMARY KEY (id)
);

CREATE TABLE instagram_users (
  id INT NOT NULL,
  username VARCHAR(255) NOT NULL,
  profile_picture VARCHAR(255) NOT NULL,
  full_name VARCHAR(255),
  CONSTRAINT pk_instagram_videos_id PRIMARY KEY (id)
);

CREATE TABLE instagram_videos (
  id INT NOT NULL,
  userId INT NOT NULL,
  instagram_video_id VARCHAR(255) NOT NULL,
  link VARCHAR(255) NOT NULL,
  CONSTRAINT fk_instagram_videos_id FOREIGN KEY (id)
    REFERENCES videos(id) MATCH FULL
  ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT pk_instagram_videos_user_id FOREIGN KEY (userId)
    REFERENCES instagram_users(id) MATCH FULL
  ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT pk_instagram_videos_instagram_video_id PRIMARY KEY (instagram_video_id)
);