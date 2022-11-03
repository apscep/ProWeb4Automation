package PageRepository;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.$$x;

public class SerCheckPage {
  public  ElementsCollection buttons = $$x(".//a[contains(@class,'button')]");

}
