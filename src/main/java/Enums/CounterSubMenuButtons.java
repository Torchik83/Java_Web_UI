package Enums;

import Base.SubMenuButtons;
import org.openqa.selenium.By;

public enum CounterSubMenuButtons implements SubMenuButtons {

    CONTACTS(".//span[@class='title' and text()='Контактные лица']");

    private final By by;

    CounterSubMenuButtons (String xpath){
        this.by = By.xpath(xpath);
    }

    public By getBy(){return by;}
}
