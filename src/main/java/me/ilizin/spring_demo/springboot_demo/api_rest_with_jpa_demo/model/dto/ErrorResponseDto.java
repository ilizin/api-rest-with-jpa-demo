package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.model.dto;


public class ErrorResponseDto {

    private int status;
    private String message;

    public ErrorResponseDto() {}

    public ErrorResponseDto(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
