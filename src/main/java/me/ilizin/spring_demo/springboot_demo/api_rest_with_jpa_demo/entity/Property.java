package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="advertisement")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="province")
    private String province;

    @Column(name="municipality")
    private String municipality;

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

    public Property() {}

    public Property(String title, String province, String municipality, String country, String address, double price, String description,
                    int size) {
        this.title = title;
        this.province = province;
        this.municipality = municipality;
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

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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
                ", province='" + province + '\'' +
                ", municipality='" + municipality + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
