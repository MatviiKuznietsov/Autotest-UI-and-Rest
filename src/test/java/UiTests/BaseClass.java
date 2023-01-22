package UiTests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    public final String login = "MTV";
    public final String password = "24041985";
    @BeforeClass
    public void preparation (){
        Configuration.baseUrl = "https://freelance.lsrv.in.ua";
        Configuration.browser = "firefox";
        Configuration.savePageSource = false;
        Configuration.holdBrowserOpen = true;
        Configuration.downloadsFolder = "target/download/";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1500x800";
    }
}
