package uiTests;

import ui.pages.HomePage;
import ui.pages.JobPages;
import ui.pages.ProfilePage;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class UiTests extends BaseClass {
    @Test
    public void useCase1EditeProfile() {
        open("/home");
        HomePage homePage = new HomePage();
        String nameLastname = homePage.clicklogInSign()
                .logInUser(getLogin(), getPassword())
                .goToProfilePage()
                .clickEditInfoButton()
                .inputName(getName())
                .inputLastName(getLastname())
                .clickUpdate();
        Selenide.closeWindow();
        Assert.assertEquals(nameLastname, getName() + " " + getLastname());
    }

    @Test
    public void useCase2CreateNewJob() {
        open("/home");
        HomePage homePage = new HomePage();
        String nameLastname = homePage.clicklogInSign()
                .logInUser(getLogin(), getPassword())
                .goToProfilePage()
                .clickAddJobButton()
                .fillNewJob(getTitle(), getDescription(), getPrice());
        ProfilePage profilePage = new ProfilePage();
        Assert.assertEquals(profilePage.getNewJobTitle().getText(), nameLastname);
        Selenide.closeWindow();
    }

    @Test
    public void useCase3AddComment() {
        open("/home");

        HomePage homePage = new HomePage();
        String jobComment = homePage.clicklogInSign()
                .logInUser(getLogin(), getPassword())
                .openJobOffer()
                .addComment(getJobComment());
        Assert.assertEquals(jobComment, getJobComment());
        Selenide.closeWindow();
    }

    @Test
    public void useCase4DeleteJob() {
        open("/home");
        HomePage homePage = new HomePage();
        int captureOfJobBegin = homePage.clicklogInSign()
                .logInUser(getLogin(), getPassword())
                .goToProfilePage()
                .scrollPage()
                .removeJobSign()
                .getCaptureOfJob();
        Selenide.closeWindow();

        open("/home");
        HomePage homePage2 = new HomePage();
        int captureOfJobEnd = homePage2.clicklogInSign()
                .logInUser(getLogin(), getPassword())
                .goToProfilePage()
                .getCaptureOfJob();

        Assert.assertEquals(captureOfJobBegin - 1, captureOfJobEnd);

    }
}
