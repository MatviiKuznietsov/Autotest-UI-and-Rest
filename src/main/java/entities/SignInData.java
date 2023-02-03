package entities;

import lombok.Data;

@Data
public class SignInData {
    private String username = "test";
    private String password = "pass12345";

    private String token;

}
