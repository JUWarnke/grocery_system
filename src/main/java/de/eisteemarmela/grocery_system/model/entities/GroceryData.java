package de.eisteemarmela.grocery_system.model.entities;

import java.time.LocalDate;
import java.util.Date;

public class GroceryData {

    private String name;
    private String brand;
    private String store;
    private double price;
    private double quantity;
    private LocalDate lastBought;

    public GroceryData( String name, String brand, String store, double price, double quantity, LocalDate lastBought ) {
        this.name = name;
        this.brand = brand;
        this.store = store;
        this.price = price;
        this.quantity = quantity;
        this.lastBought = lastBought;
    }

    public GroceryData() {
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand( String brand ) {
        this.brand = brand;
    }

    public String getStore() {
        return store;
    }

    public void setStore( String store ) {
        this.store = store;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice( double price ) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity( double quantity ) {
        this.quantity = quantity;
    }

    public LocalDate getLastBought() {
        return lastBought;
    }

    public void setLastBought( LocalDate lastBought ) {
        this.lastBought = lastBought;
    }

    @Override
    public String toString() {
        return "GroceryData{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", store='" + store + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", lastBought=" + lastBought +
                '}';
    }
}
