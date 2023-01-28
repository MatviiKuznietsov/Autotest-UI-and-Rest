package UiTests.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage {
    private SelenideElement editInfoButton = $(By.xpath("//button[.='Edit Info']"));
    private SelenideElement addJobButton = $(By.xpath("//button[.='Add job']"));
    private SelenideElement nameInput = $(By.xpath("//input[@formcontrolname=\"name\"]"));
    private SelenideElement lastNameInput = $(By.xpath("//input[@formcontrolname=\"lastname\"]"));
    private SelenideElement updateSign = $(By.xpath("//span[contains(text(),' Update ')]"));
    private SelenideElement userNameLastName = $(By.xpath("//h3[@style]"));

    private SelenideElement newJobTitle = $(By.xpath("//mat-card-title[contains(text(),'New Job')]"));

    public SelenideElement getNewJobTitle() {
        return newJobTitle;
    }

    public ProfilePage clickEditInfoButton() {
        editInfoButton.click();
        return new ProfilePage();
    }

    public ProfilePage inputName(String name) {
        nameInput.setValue(name);
        return new ProfilePage();
    }

    public ProfilePage inputLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return new ProfilePage();
    }

    public String clickUpdate() {
        updateSign.click();
        return userNameLastName.getText();
    }

    public AddJobPage clickAddJobButton() {
        addJobButton.click();
        return new AddJobPage();
    }
}
