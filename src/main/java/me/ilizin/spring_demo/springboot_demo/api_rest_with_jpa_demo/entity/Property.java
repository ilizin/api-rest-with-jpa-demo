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

    @Column(name="floor")
    private Integer floor;

    @Column(name="totalRooms")
    private int totalRooms;

    @Column(name="totalFlatmates")
    private int totalFlatmates;

    @Column(name="totalBathrooms")
    private int totalBathrooms;

    @Column(name="flatmatesGender")
    private String flatmatesGender;

    @Column(name="flatmatesMinAge")
    private Integer flatmatesMinAge;

    @Column(name="flatmatesMaxAge")
    private Integer flatmatesMaxAge;

    @Column(name="isLgbtFriendly")
    private Boolean isLgbtFriendly;

    @Column(name="hasLift")
    private Boolean hasLift;

    public Property() {}

    public Property(int id, String title, String province, String municipality, String country, String address, double price,
                    String description, int size, Integer floor, int totalRooms, int totalFlatMates, int totalBathrooms,
                    String flatMatesGender, Integer flatmatesMinAge, Integer flatmatesMaxAge, Boolean isLgbtFriendly, Boolean hasLift) {
        this.id = id;
        this.title = title;
        this.province = province;
        this.municipality = municipality;
        this.country = country;
        this.address = address;
        this.price = price;
        this.description = description;
        this.size = size;
        this.floor = floor;
        this.totalRooms = totalRooms;
        this.totalFlatmates = totalFlatMates;
        this.totalBathrooms = totalBathrooms;
        this.flatmatesGender = flatMatesGender;
        this.flatmatesMinAge = flatmatesMinAge;
        this.flatmatesMaxAge = flatmatesMaxAge;
        this.isLgbtFriendly = isLgbtFriendly;
        this.hasLift = hasLift;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
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

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public int getTotalFlatmates() {
        return totalFlatmates;
    }

    public void setTotalFlatmates(int totalFlatmates) {
        this.totalFlatmates = totalFlatmates;
    }

    public int getTotalBathrooms() {
        return totalBathrooms;
    }

    public void setTotalBathrooms(int totalBathrooms) {
        this.totalBathrooms = totalBathrooms;
    }

    public String getFlatmatesGender() {
        return flatmatesGender;
    }

    public void setFlatmatesGender(String flatMatesGender) {
        this.flatmatesGender = flatMatesGender;
    }

    public Integer getFlatmatesMinAge() {
        return flatmatesMinAge;
    }

    public void setFlatmatesMinAge(Integer flatmatesMinAge) {
        this.flatmatesMinAge = flatmatesMinAge;
    }

    public Integer getFlatmatesMaxAge() {
        return flatmatesMaxAge;
    }

    public void setFlatmatesMaxAge(Integer flatmatesMaxAge) {
        this.flatmatesMaxAge = flatmatesMaxAge;
    }

    public Boolean getLgbtFriendly() {
        return isLgbtFriendly;
    }

    public void setLgbtFriendly(Boolean lgbtFriendly) {
        isLgbtFriendly = lgbtFriendly;
    }

    public Boolean getHasLift() {
        return hasLift;
    }

    public void setHasLift(Boolean hasLift) {
        this.hasLift = hasLift;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", province='" + province + '\'' +
                ", municipality='" + municipality + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", size=" + size +
                ", floor=" + floor +
                ", totalRooms=" + totalRooms +
                ", totalFlatmates=" + totalFlatmates +
                ", totalBathrooms=" + totalBathrooms +
                ", flatMatesGender=" + flatmatesGender +
                ", flatmatesMinAge=" + flatmatesMinAge +
                ", flatmatesMaxAge=" + flatmatesMaxAge +
                ", isLgbtFriendly=" + isLgbtFriendly +
                ", hasLift=" + hasLift +
                '}';
    }
}
