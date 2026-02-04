package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class AdvertiserInDto {

    @Schema(description = "The advertiser type", allowableValues = {"OWNER", "FLATMATE", "AGENCY"}, example = "OWNER")
    @NotBlank
    private AdvertiserType advertiserType;
    @Schema(description = "The advertiser name", example = "John")
    @NotBlank
    private String name;
    @Schema(description = "The advertiser first surname", example = "Smith")
    @NotBlank
    private String firstSurname;
    @Schema(description = "The advertiser second surname", example = "Brown")
    @NotBlank
    private String secondSurname;
    @Schema(description = "The advertiser email", example = "john.smith@gmail.com")
    @NotBlank
    private String email;
    @Schema(description = "The advertiser phone number", example = "+34666778866")
    @NotBlank
    private String phoneNumber;

    public AdvertiserInDto() {}

    public AdvertiserInDto(AdvertiserType advertiserType, String name, String firstSurname, String secondSurname, String email, String phoneNumber) {
        this.advertiserType = advertiserType;
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public AdvertiserType getAdvertiserType() {
        return advertiserType;
    }

    public void setAdvertiserType(AdvertiserType advertiserType) {
        this.advertiserType = advertiserType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "AdvertiserInDto{" +
                "advertiserType=" + advertiserType +
                ", name='" + name + '\'' +
                ", firstSurname='" + firstSurname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
