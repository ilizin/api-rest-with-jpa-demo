package me.ilizin.spring_demo.springboot_demo.api_rest_with_jpa_demo.dto;

public class AdvertiserDto {

    private int id;
    private String name;

    public AdvertiserDto() {}

    public AdvertiserDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AdvertiserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
