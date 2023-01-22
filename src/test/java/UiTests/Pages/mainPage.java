package UiTests.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class mainPage {
    private SelenideElement iconProfile = $(".mat-focus-indicator.mat-menu-trigger");
    private SelenideElement profile = $(By.xpath("//*[.='Profile']"));

    public mainPage clickProfileIcon() {
        iconProfile.click();
        return new mainPage();
    }

    public void clicklinkText() {
        profile.click();
    }
}
