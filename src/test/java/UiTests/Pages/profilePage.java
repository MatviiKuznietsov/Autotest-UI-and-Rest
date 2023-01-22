package UiTests.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class profilePage {
    private SelenideElement editInfoButton =$(By.xpath("//button[.='Edit Info']"));
    public profilePage clickEditInfoButton (){
        editInfoButton.click();
        return new profilePage();
    }
}
