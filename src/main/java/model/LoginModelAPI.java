package model;

import lombok.Data;

@Data

public class LoginModelAPI {
    private String email;
    private String password;

    public LoginModelAPI(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
