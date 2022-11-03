package technical.task;

import ActionsRepository.SerPageActions;
import com.codeborne.selenide.ex.ElementShould;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.utility.BaseTest;


public class StaleElementExceptionSolutionTest extends BaseTest {
    SerPageActions serCheckPageAct = new SerPageActions();

//After running this test, web-site for automation testing will be approach and this exception will be caught by clicking on buttons, note that Selenide wrap SER in his own class
    @Test
    @DisplayName("Catch SER exception")
    void checkAndCatchSer(){
        ElementShould exception = Assertions.assertThrows(ElementShould.class, () -> {
            serCheckPageAct.open();
            serCheckPageAct.clickButtons();
        });
        Assertions.assertTrue(exception.getMessage().contains("Element should be visible or transparent"));
    }
// Check that handling works fine, all 3 buttons are clicked.
    @Test
    @DisplayName("Handle SER exception")
    void handleSerException(){
        serCheckPageAct.open();
        Assertions.assertEquals(serCheckPageAct.checkAllButtonsAreClicked(),3);
    }



}
