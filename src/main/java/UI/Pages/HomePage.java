package UI.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private SelenideElement logIn=$(By.linkText("Log in"));
    public LogInPage clicklogInSign(){
        logIn.click();
        return new LogInPage();
    }
}
