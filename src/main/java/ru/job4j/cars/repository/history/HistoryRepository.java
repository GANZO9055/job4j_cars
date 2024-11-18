package ru.job4j.cars.repository.history;

import ru.job4j.cars.model.History;

import java.util.List;

public interface HistoryRepository {
    List<History> getAll();
}
