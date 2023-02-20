package de.eisteemarmela.grocery_system.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table( name = "brands" )
public class Brand {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column( name = "name" )
    private String name;

    @ManyToOne
    @JoinColumn( name = "store_id" )
    private Store storeId;

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", storeId=" + storeId +
                '}';
    }
}
