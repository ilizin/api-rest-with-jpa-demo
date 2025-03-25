package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="advertisement")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="city")
    private String city;

    @Column(name="country")
    private String country;

    @Column(name="address")
    private String address;

    @Column(name="price")
    private double price;

    @Column(name="description")
    private String description;

    @Column(name="size")
    private int size;

    public Advertisement() {}

    public Advertisement(String title, String city, String country, String address, double price, String description,
                         int size) {
        this.title = title;
        this.city = city;
        this.country = country;
        this.address = address;
        this.price = price;
        this.description = description;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
