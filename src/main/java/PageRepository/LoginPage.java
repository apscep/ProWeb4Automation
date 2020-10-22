package PageRepository;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {


    public WebElement userIdInput(){
     return  $(By.name("username"));
    }

    public WebElement passwordInput(){
     return $(By.name("password"));
    }

    public WebElement loginButton(){
      return  $(byText("Login"));
    }

    public SelenideElement yobField(){
        return  $(By.name("code"));
    }

}
