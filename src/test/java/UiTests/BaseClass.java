package UiTests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    private final String login = "MTV";
    private final String password = "24041985";
    private final String name = "Hello";
    private final String Lastname = "World";
    private final String title = "New Job";
    private final String description = "Cool Job";
    private final String price = "100";

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
        Configuration.timeout = 10000;
        Configuration.browserSize = "1500x800";
    }


}
