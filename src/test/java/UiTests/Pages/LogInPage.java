package UiTests.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LogInPage {
    private SelenideElement inputLogin = $("input#mat-input-0");
    private SelenideElement inputPassword = $("input#mat-input-1");
    private SelenideElement logiButton = $(".mat-button-wrapper");

    public LogInPage inputLogin(String login) {
        inputLogin.setValue(login);
        return new LogInPage();
    }

    public LogInPage inputPassword(String password) {
        inputPassword.setValue(password);
        return new LogInPage();
    }

    public MainPage clickLoginButton() {
        logiButton.click();
        return new MainPage();
    }
    public MainPage logInUser (String login, String password){
        inputLogin(login);
        inputPassword(password);
        clickLoginButton();
        return new MainPage();
    }

}
