CREATE TABLE history_owners (
    id SERIAL PRIMARY KEY,
    car_id INT NOT NULL UNIQUE REFERENCES cars(id),
    owner_id INT NOT NULL UNIQUE REFERENCES owners(id)
);