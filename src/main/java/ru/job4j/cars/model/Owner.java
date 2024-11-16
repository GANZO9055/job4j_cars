package ru.job4j.cars.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "owners")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Owner {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private User user;
}
