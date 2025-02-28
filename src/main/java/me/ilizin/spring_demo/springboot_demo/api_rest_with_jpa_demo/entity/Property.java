package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="property")
public class Property {

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
    private long price;

    @Column(name="description")
    private String description;

    public Property() {}

    public Property(String title, String city, String country, String address, long price, String description) {
        this.title = title;
        this.city = city;
        this.country = country;
        this.address = address;
        this.price = price;
        this.description = description;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
