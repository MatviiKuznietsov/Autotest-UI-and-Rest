package entities;

import lombok.Data;

@Data
public class SignUpData {
    private String username;
    private String password;
    private String confirmPassword;
}
