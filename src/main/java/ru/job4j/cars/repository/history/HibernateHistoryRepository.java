package ru.job4j.cars.repository.history;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.History;
import ru.job4j.cars.repository.CrudRepository;

import java.util.List;


@Repository
@AllArgsConstructor
public class HibernateHistoryRepository implements HistoryRepository {

    private final CrudRepository crudRepository;

    @Override
    public List<History> getAll() {
        return crudRepository.query(
                "FROM History",
                History.class
        );
    }
}
