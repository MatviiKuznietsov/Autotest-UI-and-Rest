package uiTests;

import uiTests.listeners.CustomExtentReportListener;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(CustomExtentReportListener.class)
public class BaseClass {
    static {
        System.setProperty("extent.reporter.html.start", "true");
        System.setProperty("extent.reporter.html.out", "target/extentReport/Extent.Html");
    }

    private final String login = "MTV";
    private final String password = "24041985";
    private final String name = "Hello";
    private final String Lastname = "World";
    private final String title = "New Job";
    private final String description = "Cool Job";
    private final String price = "100";

    private final String jobComment = "Hello i`m your new best job";

    public String getJobComment() {
        return jobComment;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getName() {
        return name;
    }


    @BeforeClass
    public void preparation() {
        Configuration.baseUrl = "https://freelance.lsrv.in.ua";
        Configuration.browser = "firefox";
        Configuration.savePageSource = false;
        Configuration.holdBrowserOpen = true;
        Configuration.downloadsFolder = "target/download/";
        Configuration.timeout = 3000;
        Configuration.browserSize = "1500x800";
        Configuration.screenshots = true;
    }
}
