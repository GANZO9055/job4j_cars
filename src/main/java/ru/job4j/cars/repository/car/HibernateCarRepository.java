package ru.job4j.cars.repository.car;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Car;
import ru.job4j.cars.repository.CrudRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class HibernateCarRepository implements CarRepository {

    private final CrudRepository crudRepository;
    private final Logger logger = LoggerFactory.getLogger(HibernateCarRepository.class);

    @Override
    public List<Car> getAll() {
        return crudRepository.query(
                "FROM Car",
                Car.class
        );
    }

    @Override
    public Optional<Car> findCarById(int id) {
        return crudRepository.optional(
                "FROM Car WHERE id = :id",
                Car.class,
                Map.of("id", id)
        );
    }

    @Override
    public Car saveCar(Car car) {
        try {
            crudRepository.run(session -> session.persist(car));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return car;
    }
}
