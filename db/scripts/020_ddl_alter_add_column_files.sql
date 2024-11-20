ALTER TABLE files
ADD COLUMN file_post_id INT REFERENCES auto_post(id);