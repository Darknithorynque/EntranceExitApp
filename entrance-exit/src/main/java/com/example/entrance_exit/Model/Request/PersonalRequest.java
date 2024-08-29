package com.example.entrance_exit.Model.Request;


public class PersonalRequest {
    private String name;
    private String role;

    public PersonalRequest(String name, String role, Integer minAge, Integer maxAge) {
        this.name = name;
        this.role = role;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    private Integer minAge;
    private Integer maxAge;
}
