package RozetkaPages;

import objects.TextField;
import objects.WebButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RozetkaOrderPage
{
    WebDriver driver;
    By buyNameField;
    By buymobilePhoneField;
    By buyButtonNext;
    By buyMakeOrder;

    public RozetkaOrderPage(WebDriver _driver)
    {
        driver = _driver;
        buyNameField = By.xpath("//*[@id=\"reciever_name\"]");
        buymobilePhoneField = By.xpath("//*[@id=\"reciever_phone\"]");
        buyButtonNext = By.cssSelector("#step_contacts > div > div.check-step-part > div.clearfix.f-i.grid-box-top > div > span > button");
        buyMakeOrder = By.id("make-order");
    }

    public void  fillFields(String name , String mobilePhone)throws Exception {
        TextField.enterTextInTextField(driver , buyNameField ,name );
        TextField.enterTextInTextField(driver , buymobilePhoneField ,mobilePhone );
        Thread.sleep(2000);
        WebButton.cliclOnButton(driver ,buyButtonNext );
        Thread.sleep(2000);
        //fill other fields
    }

    public WebButton get_item_buy_button() { return new WebButton(driver,buyMakeOrder); }
}