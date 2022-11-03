package technical.task;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import test.utility.BaseTest;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class SwitchTabTest extends BaseTest {
    WebDriver driver;
    Wait wait;

    @Test
    @DisplayName("Switch tab Selenide")
    void switchTabSelenide() {
        //Open site
        Selenide.open("yoursiteName");
        //Click on the button which switch to the new tab
        $(By.xpath("*//a[@href='buttonToOpenTab']")).click();
        //Switch to the tab by the title name
        switchTo().window("Title of the window");
        //Switch to the previous tab
        switchTo().defaultContent();
    }

    @Test
    @DisplayName("Switch tab Selenium")
    void switchTabSelenium() {
    //Store the ID of the original window
    String originalWindow = driver.getWindowHandle();

    //Check we don't have other windows open already
    assert driver.getWindowHandles().size() == 1;

    //Click the link which opens in a new window
    driver.findElement(By.linkText("new window")).click();

    //Wait for the new window or tab
    wait.until(numberOfWindowsToBe(2));

    //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    //Wait for the new tab to finish loading content
        wait.until(titleIs("Selenium documentation"));
    }
}
