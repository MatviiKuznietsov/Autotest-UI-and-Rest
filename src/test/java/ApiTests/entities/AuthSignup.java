package ApiTests.entities;

import lombok.Data;

@Data
public class AuthSignup {
    private String username;
    private String password;
    private String confirmPassword;
}
