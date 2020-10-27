package ActionsRepository;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import java.util.Objects;

public class LoginPageActions extends BasePageActions {

  public  LoginPageActions open(){
      Selenide.open("/");
      return this;
  }
    @Step("Input user Id")
    public void enterUserId(String inputText) {
        lp.userIdInput().sendKeys(inputText);
    }

    @Step("Input user password")
    public void enterPassword(String inputText) {
        lp.passwordInput().sendKeys(inputText);
    }

    @Step("Click submit button")
    public void clickSubmitButton() {
        lp.loginButton().click();
    }

    @Step("YOB is displayed")
    public boolean yobIsDisplayed () {
      return lp.yobField().shouldBe(Condition.appears).isDisplayed();
    }

    @Step("Enter input YOB")
    public void enterInputYob(String input) {
        lp.yobField().sendKeys(input);
    }

    @Step("Get yob atribute")
    public String getYobAtribute(){return lp.yobField().getAttribute("value");}

    @Step("Get yob atribute")
    public boolean checkInputYob(){
         return Objects.requireNonNull(lp.yobField().getAttribute("value")).isEmpty();}

}
