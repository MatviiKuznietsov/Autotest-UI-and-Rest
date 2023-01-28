package ApiTests;

import ApiTests.Controllers.AuthController;
import ApiTests.entities.AuthSignIn;
import ApiTests.entities.AuthSignup;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ApiTests {
    @Test
    public void signUP() throws IOException {
        AuthSignup authSignup = new AuthSignup();
        authSignup.setUsername("user3");
        authSignup.setPassword("Pass12345");
        authSignup.setConfirmPassword("Pass12345");
        AuthController authController = new AuthController();
        authController.signUp(authSignup);
    }

    @Test
    public void signIn() throws IOException {
        AuthSignIn authSignIN = new AuthSignIn();
        authSignIN.setUsername("user3");
        authSignIN.setPassword("Pass12345");
        AuthController authController = new AuthController();
        authController.signIn(authSignIN);
    }
}
