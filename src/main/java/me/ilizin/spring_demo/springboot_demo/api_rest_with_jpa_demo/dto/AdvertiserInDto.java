package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class AdvertiserInDto {

    @Schema(description = "The advertiser name", example = "")
    @NotBlank
    private String name;
    @Schema(description = "The advertiser first surname", example = "")
    @NotBlank
    private String firstSurname;
    @Schema(description = "The advertiser second surname", example = "")
    @NotBlank
    private String secondSurname;
    @Schema(description = "The advertiser email", example = "")
    @NotBlank
    private String email;
    @Schema(description = "The advertiser phone number", example = "")
    @NotBlank
    private String phoneNumber;

    public AdvertiserInDto() {}

    public AdvertiserInDto(String name, String firstSurname, String secondSurname, String email, String phoneNumber) {
        this.name = name;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.email = email;
        this.phoneNumber = phoneNumber;
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
                ", name='" + name + '\'' +
                ", firstSurname='" + firstSurname + '\'' +
                ", secondSurname='" + secondSurname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
