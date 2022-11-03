package test.utility;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

public abstract class  BaseTest  {
    static {
        Configuration.baseUrl = "http://localhost:8282";
        Configuration.browser = "chrome";
        Configuration.screenshots = true;
        Configuration.startMaximized = true;
        Configuration.savePageSource = false;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

    }


}
