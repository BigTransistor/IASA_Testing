package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextField {
    protected WebElement textField;

    public TextField(By by , WebDriver driver) {
        textField = driver.findElement(by);
    }

    public void enterText(String text) throws  Exception{
        textField.sendKeys("\b\b\b\b\b\b\b\b\b\b\b\b");
        textField.sendKeys(text);
    }

    public static void enterTextInTextField(WebDriver driver ,By by , String text)throws  Exception{
        TextField textField = new TextField(by ,driver);
        textField.enterText(text);
    }
}
