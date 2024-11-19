ALTER TABLE history_owners
ADD COLUMN history_id INT NOT NULL REFERENCES history(id);