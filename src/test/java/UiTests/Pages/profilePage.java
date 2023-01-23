package UiTests.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class profilePage {
    private SelenideElement editInfoButton = $(By.xpath("//button[.='Edit Info']"));
    private SelenideElement addJobButton = $(By.xpath("//button[.='Add job']"));
    private SelenideElement nameInput = $(By.xpath("//input[@formcontrolname=\"name\"]"));
    private SelenideElement lastNameInput = $(By.xpath("//input[@formcontrolname=\"lastname\"]"));
    private SelenideElement updateSign = $(By.xpath("//span[contains(text(),' Update ')]"));
    private SelenideElement userNameLastName = $(By.xpath("//h3[@style]"));

    public profilePage clickEditInfoButton() {
        editInfoButton.click();
        return new profilePage();
    }

    public profilePage inputName(String name) {
        nameInput.setValue(name);
        return new profilePage();
    }

    public profilePage inputLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return new profilePage();
    }

    public String clickUpdate() {
        updateSign.click();
        return userNameLastName.getText();
    }
    public addJobPage clickAddJobButton() {
        addJobButton.click();
        return new addJobPage();
    }
}
