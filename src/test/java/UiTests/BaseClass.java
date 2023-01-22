package UiTests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    @BeforeClass
    public void preparation (){
        Configuration.baseUrl = "https://freelance.lsrv.in.ua/home";
        Configuration.browser = "firefox";
        Configuration.savePageSource = false;
        Configuration.holdBrowserOpen = true;
        Configuration.downloadsFolder = "target/download/";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1500x800";
    }
}
