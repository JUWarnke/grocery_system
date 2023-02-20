package de.eisteemarmela.grocery_system.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table( name = "groceries" )
public class Grocery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", unique = true)
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "price")
    private Double price;

    @Column(name = "last_bought")
    private LocalDate lastBought;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "quantity")
    private Double quantity;

    @Override
    public String toString() {
        return String.format( """
                Grocery {
                    id: %d,
                    name: %s,
                    brand: %s,
                    price: %.2f,
                    lastBought: %s,
                    store: %s,
                    quantity: %.2f
                }""", id, name, brand.getName(), price, lastBought, store.getName(), quantity);
    }


}
