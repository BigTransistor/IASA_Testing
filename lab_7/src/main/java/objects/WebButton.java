package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebButton {
    protected WebElement button;

    public WebButton(WebDriver driver,By by ) {
        button = driver.findElement(by);
    }

    public void click(){ button.click(); }

    public boolean isEnabled(){ return button.isEnabled(); }

    public static void cliclOnButton( WebDriver driver, By by ){
        WebButton button = new WebButton(driver , by);
        button.click();
    }
}