package UiTests.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class homePage {
    private SelenideElement logIn=$(By.linkText("Log in"));
    public logInPage clicklogInSign(){
        logIn.click();
        return new logInPage();
    }
}
