ALTER TABLE cars
ADD COLUMN brand_id INT REFERENCES brands(id);