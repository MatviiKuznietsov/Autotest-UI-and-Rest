package UiTests;

import UiTests.Pages.homePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class UiTests extends BaseClass {
    @Test
    public void useCase1() {
        open("/home");
        homePage homePage = new homePage();
        String nameLastname = homePage.clicklogInSign()
                .inputLogin(getLogin())
                .inputPassword(getPassword())
                .clickLoginButton()
                .clickProfileIcon()
                .clicklinkText()
                .clickEditInfoButton()
                .inputName(getName())
                .inputLastName(getLastname())
                .clickUpdate();
        System.out.println(nameLastname);
        System.out.println(getName()+getLastname());
        Assert.assertEquals(nameLastname, getName()+" "+getLastname());
    }

    @Test
    public void useCase2() {
        open("/home");
        homePage homePage = new homePage();
        homePage.clicklogInSign();
    }

    @Test
    public void useCase3() {
        open("/home");
        homePage homePage = new homePage();
        homePage.clicklogInSign();
    }

    @Test
    public void useCase4() {
        open("/home");
        homePage homePage = new homePage();
        homePage.clicklogInSign();
    }
}
