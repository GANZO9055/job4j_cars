package ru.job4j.cars.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "history_owners")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HistoryOwners {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private int carId;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private int ownerId;

    @ManyToOne
    @JoinColumn(name = "history_id")
    private int historyId;
}
