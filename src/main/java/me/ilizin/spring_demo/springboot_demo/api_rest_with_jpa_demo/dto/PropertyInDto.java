package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.enums.FlatMatesGender;

public class PropertyInDto {

    @Schema(description = "A title which describes the advertisement", example = "A studio in Culture Thonglor")
    @NotBlank
    private String title;
    @Schema(description = "The province where the property is located", example = "Bangkok")
    @NotBlank
    private String province;
    @Schema(description = "The province where the property is located", example = "Bangkok")
    @NotBlank
    private String municipality;
    @Schema(description = "The municipality where the property is located", example = "Bangkok")
    @NotBlank
    private String country;
    @Schema(description = "The address where the property is located", example = "Soi Yanat")
    @NotBlank
    private String address;
    @Schema(description = "The property price in local currency", example = "8550700")
    @Positive
    @NotNull
    private Double price;
    @Schema(description = "The advertisement description", example = "A studio apartment available for Sale")
    @NotBlank
    private String description;
    @Schema(description = "The property size", example = "120")
    @Positive
    @NotNull
    private Integer size;
    @Schema(description = "The property floor", example = "2")
    @PositiveOrZero
    private Integer floor;
    @Schema(description = "The property total number of rooms", example = "4")
    @Positive
    private int totalRooms;
    @Schema(description = "The property total number of flatmates", example = "4")
    @Positive
    private int totalFlatMates;
    @Schema(description = "The property total number of bathrooms", example = "2")
    @Positive
    private int totalBathrooms;
    @Schema(description = "The flatmates genders", allowableValues = {"ONLY_MEN", "ONLY_WOMEN", "MEN_AND_WOMEN", "NOT_SPECIFIED"}, example = "MEN_AND_WOMEN")
    @NotNull
    private FlatMatesGender flatMatesGender;
    @Schema(description = "The flatmates range ages")
    private FlatmatesAgeRangeDto flatMatesAge;
    @Schema(description = "True if the property is lgbt friendly", example = "true")
    private Boolean isLgbtFriendly;
    @Schema(description = "True if the property has a lift", example = "true")
    @NotNull
    private Boolean hasLift;

    public PropertyInDto() {}

    public PropertyInDto(String title, String province, String municipality, String country, String address,
                         Double price, String description, Integer size, Integer floor, int totalRooms,
                         int totalFlatMates, int totalBathrooms, FlatMatesGender flatMatesGender,
                         FlatmatesAgeRangeDto flatMatesAge, Boolean isLgbtFriendly, Boolean hasLift) {
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
        this.totalFlatMates = totalFlatMates;
        this.totalBathrooms = totalBathrooms;
        this.flatMatesGender = flatMatesGender;
        this.flatMatesAge = flatMatesAge;
        this.isLgbtFriendly = isLgbtFriendly;
        this.hasLift = hasLift;
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

    public int getTotalFlatMates() {
        return totalFlatMates;
    }

    public void setTotalFlatMates(int totalFlatMates) {
        this.totalFlatMates = totalFlatMates;
    }

    public int getTotalBathrooms() {
        return totalBathrooms;
    }

    public void setTotalBathrooms(int totalBathrooms) {
        this.totalBathrooms = totalBathrooms;
    }

    public FlatMatesGender getFlatMatesGender() {
        return flatMatesGender;
    }

    public void setFlatMatesGender(FlatMatesGender flatMatesGender) {
        this.flatMatesGender = flatMatesGender;
    }

    public FlatmatesAgeRangeDto getFlatMatesAge() {
        return flatMatesAge;
    }

    public void setFlatMatesAge(FlatmatesAgeRangeDto flatMatesAge) {
        this.flatMatesAge = flatMatesAge;
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
        return "PropertyInDto{" +
                "title='" + title + '\'' +
                ", province='" + province + '\'' +
                ", municipality='" + municipality + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", size=" + size +
                ", floor=" + floor +
                ", totalRooms=" + totalRooms +
                ", totalFlatMates=" + totalFlatMates +
                ", totalBathrooms=" + totalBathrooms +
                ", flatMatesGender=" + flatMatesGender +
                ", flatMatesAge=" + flatMatesAge +
                ", isLgbtFriendly=" + isLgbtFriendly +
                ", hasLift=" + hasLift +
                '}';
    }
}
