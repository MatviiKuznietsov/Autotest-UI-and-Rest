package UiTests.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class JobPages {
    private SelenideElement addCommetsFiled = $(By.xpath("//textarea[@formcontrolname=\"message\"]"));
    private SelenideElement leaveCommentButton = $(By.xpath("//button[.=' Leave comment ']"));
    public JobPages fillComment(){
        addCommetsFiled.setValue("Hello World");
        return new JobPages();
    }
    public void clickButton(){
    leaveCommentButton.click();
    }
    public void addComment(){
        fillComment();
        clickButton();
    }

}
