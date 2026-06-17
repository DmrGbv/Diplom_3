package model;

import lombok.Data;

@Data

public class UserModelAPI {
    private String name;
    private String email;
    private String password;

    public UserModelAPI(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
