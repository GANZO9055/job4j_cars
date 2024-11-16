ALTER TABLE auto_post
ADD COLUMN car_id INT REFERENCES cars(id);