package ActionsRepository;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class SerPageActions extends BasePageActions {

    public SerPageActions open() {
        Selenide.open("http://the-internet.herokuapp.com/challenging_dom");
        return this;
    }

    public void clickButtons() {
        for (SelenideElement button : scp.buttons) {
            button.click();
        }
    }

    public Integer checkAllButtonsAreClicked() {
        int index = 0;
        for (SelenideElement element : scp.buttons) {
            if (element.isDisplayed()) {
                element.click();
                } else {
                scp.buttons.get(index).click();
            }
            index++;
        }
        return index;
    }
}

