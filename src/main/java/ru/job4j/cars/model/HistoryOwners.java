package ru.job4j.cars.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @JoinColumn(name = "car_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Car car;

    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Owner owner;

    private LocalDateTime startAt = LocalDateTime.now().withNano(0);
    private LocalDateTime endAt = LocalDateTime.now().withNano(0);
}
