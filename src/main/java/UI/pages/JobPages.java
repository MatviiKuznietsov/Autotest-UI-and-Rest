package ui.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class JobPages {
    private SelenideElement addCommetsFiled = $(By.xpath("//textarea[@formcontrolname=\"message\"]"));
    private SelenideElement leaveCommentButton = $(By.xpath("//button[.=' Leave comment ']"));
    private SelenideElement jobComment = $(By.xpath("(//mat-card-content)[2]"));

    public JobPages fillComment(String jobComment) {
        addCommetsFiled.setValue(jobComment);
        return new JobPages();
    }

    public void clickButton() {
        leaveCommentButton.click();
    }

    public String addComment(String jobComment1) {
        fillComment(jobComment1);
        clickButton();
        return jobComment.getText();
    }


}
