package ru.job4j.cars.repository.histories;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.HistoryOwners;
import ru.job4j.cars.repository.CrudRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class HibernateHistoryOwnersRepository implements HistoryOwnersRepository {

    private final CrudRepository crudRepository;

    @Override
    public List<HistoryOwners> findAll() {
        return crudRepository.query(
                "FROM HistoryOwners",
                HistoryOwners.class
        );
    }
}
