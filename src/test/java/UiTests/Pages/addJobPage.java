package UiTests.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class addJobPage {
    public SelenideElement titleInput = $(By.xpath("//input[@formcontrolname=\"title\"]"));
    public SelenideElement descriptionTitle = $(By.xpath("//textarea[@formcontrolname=\"description\"]"));
    public SelenideElement priceInput = $(By.xpath("//input[@formcontrolname=\"price\"]"));
    public SelenideElement createJobButton = $(By.xpath("//button[.=' Create job ']"));
    public addJobPage inputTitle(String title){
        titleInput.setValue(title);
        return new addJobPage();
    }
    public addJobPage inputDescription(String description){
        descriptionTitle.setValue(description);
        return new addJobPage();}
    public addJobPage inputPrice(String price){
        priceInput.setValue(price);
        return new addJobPage();}
    public addJobPage clickJobButton(){
        createJobButton.click();
        return new addJobPage();}
    public  addJobPage fillNewJob(String title, String description, String price){
        inputTitle(title);
        inputDescription(description);
        inputPrice(price);
        clickJobButton();
        return new addJobPage();}
}
