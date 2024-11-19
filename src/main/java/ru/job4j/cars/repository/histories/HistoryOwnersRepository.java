package ru.job4j.cars.repository.histories;

import ru.job4j.cars.model.HistoryOwners;

import java.util.List;

public interface HistoryOwnersRepository {
    List<HistoryOwners> findAll();
}
