package technical.task;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;


public class UlnoadSiteTest {

    WebDriver driver;


//This tests show possible solution for this problem, however Selenide already has built-in wait, which can be used to overcome this problem
// I don't know how to reproduce this issue, so I can't check it with Selenide.
    @Test
    @DisplayName("Check Page to unload JS executor")
    void checkPageUnloadJsExecutor() {
        //Open site
        Selenide.open("yoursiteName");
        //Click on the button that redirects to the next page
        $(By.xpath("*//a[@href='buttonToOpenTab']")).click();
        //Switch to the tab by the title name
        switchTo().window("Title of the window");
        //Create JS executor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        boolean eventIsUnloaded = (boolean) jsExecutor.executeScript("$( window ).unload(function() {return true};});");
        if(eventIsUnloaded){
            //continue test
        }
    }

    @Test
    @DisplayName("Check Page to unload JS executor")
    void checkPageUnloadSelenide() {
        //Open site
        Selenide.open("yoursiteName");
        //Click on the button that redirects to the next page
        $(By.xpath("*//a[@href='buttonToOpenTab']")).click();
        //Check that element disapeared
        $(By.xpath("*//a[@href='buttonToOpenTab']")).should(disappear);
        //Switch to the tab by the title name
        switchTo().window("Title of the window");
        //Check that some element is changed
        Selenide expectedElement;
        $("cssSelector").shouldHave(exactText("textChanged"));
    }
}

