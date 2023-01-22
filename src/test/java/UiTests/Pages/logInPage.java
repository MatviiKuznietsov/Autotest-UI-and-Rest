package UiTests.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class logInPage {
    private SelenideElement inputLogin = $("input#mat-input-0");
    private SelenideElement inputPassword = $("input#mat-input-1");
    private SelenideElement logiButton = $(".mat-button-wrapper");

    public logInPage inputLogin(String login) {
        inputLogin.setValue(login);
        return new logInPage();
    }

    public logInPage inputPassword(String password) {
        inputPassword.setValue(password);
        return new logInPage();
    }

    public mainPage clickLoginButton() {
        logiButton.click();
        return new mainPage();
    }
    public mainPage logInUser (String login, String password){
        inputLogin(login);
        inputPassword(password);
        clickLoginButton();
        return new mainPage();
    }

}
