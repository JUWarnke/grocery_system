package de.eisteemarmela.grocery_system.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table( name = "stores" )
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return String.format( """
                Store {
                    id: %d,
                    name: %s
                }""", id, name);
    }

}
