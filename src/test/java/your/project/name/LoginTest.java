package your.project.name;

import ActionsRepository.GetProperty;
import ActionsRepository.LoginPageActions;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LoginTest extends BaseTest {

LoginPageActions lpa = new LoginPageActions();


   @Test
   @DisplayName("Check ability of user see 2fa page after entering valid credentials")
     void userCanLoginWithValidCredentialsOpen2Fa(){
     lpa.open();
     lpa.enterUserId(GetProperty.loadProperty("userId"));
     lpa.enterPassword(GetProperty.loadProperty("passcode"));
     lpa.clickSubmitButton();
     Assertions.assertTrue(lpa.yobIsDisplayed());
    }

    @Test
    @DisplayName("Check ability of user enter special characters in 2FA")
    void userCanEnterSpecialCharactersIn2Fa (){
        lpa.enterInputYob(GetProperty.loadProperty("specialCharacters"));
        //Assertions.assertEquals("", lpa.getYobAtribute());
        Assert.assertTrue(lpa.checkInputYob());
    }
}
