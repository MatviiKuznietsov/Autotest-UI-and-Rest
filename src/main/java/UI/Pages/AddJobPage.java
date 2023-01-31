package UI.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AddJobPage {
    public SelenideElement titleInput = $(By.xpath("//input[@formcontrolname=\"title\"]"));
    public SelenideElement descriptionTitle = $(By.xpath("//textarea[@formcontrolname=\"description\"]"));
    public SelenideElement priceInput = $(By.xpath("//input[@formcontrolname=\"price\"]"));
    public SelenideElement createJobButton = $(By.xpath("//button[.=' Create job ']"));
    public AddJobPage inputTitle(String title){
        titleInput.setValue(title);
        return new AddJobPage();
    }
    public AddJobPage inputDescription(String description){
        descriptionTitle.setValue(description);
        return new AddJobPage();}
    public AddJobPage inputPrice(String price){
        priceInput.setValue(price);
        return new AddJobPage();}
    public AddJobPage clickJobButton(){
        createJobButton.click();
        return new AddJobPage();}
    public  String fillNewJob(String title, String description, String price){
        inputTitle(title);
        inputDescription(description);
        inputPrice(price);
        clickJobButton();
        return title;}
}
