package UI.Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.PressEnter;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.WheelInput;

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
    private SelenideElement removeJobButton = $(By.xpath("//span[contains(text(),' Remove Job ')]"));

    private SelenideElement profile = $(By.xpath("//*[.='Profile']"));
    private SelenideElement logout = $(By.xpath("//*[.='Logout']"));

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

    public void removeJobSign() {
        removeJobButton.click();
        Selenide.actions().sendKeys("Enter").perform();
    }

    public ProfilePage scrollPage() {
        Selenide.actions().scrollByAmount(0,10000).perform();
        return new ProfilePage();
    }
    public ProfilePage clicklinkProfile() {
        profile.click();
        return new ProfilePage();
    }
    public ProfilePage clicklinkLogOut() {
        logout.click();
        return new ProfilePage();
    }
    public void logOut() {
        clicklinkProfile();
        clicklinkLogOut();
    }
}
