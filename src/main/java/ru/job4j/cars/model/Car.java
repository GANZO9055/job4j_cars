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
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Engine engine;
    
    @ManyToOne
    @JoinColumn(name = "owner_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Owner owner;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "history_owners",
            joinColumns = {
                    @JoinColumn(
                            name = "car_id",
                            foreignKey = @ForeignKey(name = "ENGINE_ID_FK")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "owner_id",
                            foreignKey = @ForeignKey(name = "ENGINE_ID_FK")
                    )
            }
    )
    private Set<Owner> owners;
}