ALTER TABLE video
 ADD COLUMN video_type VARCHAR (63);
 -- make it non-null
UPDATE video set video_type='INSTAGRAM';