package assignment1.dto;

import assignment1.entities.UserRole;

import java.sql.Date;

public class UserDto {
    private Long id;
    private String username;
    private String gender;
    private String address;
    private String name;
    private Date birthDate;
    private UserRole userRole;

    public UserDto() {
    }

    public UserDto(Long id, String username, String gender, String address, String name, Date birthDate, UserRole userRole) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.address = address;
        this.name = name;
        this.birthDate = birthDate;
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
