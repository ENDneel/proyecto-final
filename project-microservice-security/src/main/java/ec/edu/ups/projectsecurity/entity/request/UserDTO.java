package ec.edu.ups.projectsecurity.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {


    @JsonProperty
    private String name;
    @JsonProperty
    private String username;
    @JsonProperty
    private String password;
    @JsonProperty
    private String confirmPassword;

    public UserDTO(){}

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDTO(String name, String username, String password, String confirmPassword) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
