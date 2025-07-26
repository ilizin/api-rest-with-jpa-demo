package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

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

    public PropertyInDto() {}

    public PropertyInDto(String title, String province, String municipality, String country, String address, double price, String description,
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

    @Override
    public String toString() {
        return "AdvertisementInDto {" +
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
