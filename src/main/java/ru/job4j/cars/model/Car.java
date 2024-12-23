package ru.job4j.cars.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "cars")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Car {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Brand brand;
    
    @ManyToOne
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Engine engine;
    
    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Owner owner;

    @OneToMany(mappedBy = "cars")
    private Set<HistoryOwners> historyOwners;
}