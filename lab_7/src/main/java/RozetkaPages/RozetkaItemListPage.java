package RozetkaPages;

import objects.HtmlLabel;
import objects.TextField;
import objects.WebButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RozetkaItemListPage
{
    WebDriver driver;
    By min_price_by ;
    By max_price_by ;
    By submit_price_button_by ;
    By first_item_by ;

    public RozetkaItemListPage(WebDriver _driver)
    {
        driver = _driver;
        min_price_by = By.id("price[min]");
        max_price_by = By.id("price[max]");
        submit_price_button_by = By.id("submitprice");
        first_item_by = By.cssSelector("#catalog_goods_block > div > div:nth-child(5) > div.over-wraper > div > div > div > div.g-i-tile-i-title.clearfix > a");
    }

    public void price_filter(int min_price , int max_price)throws Exception
    {
        TextField.enterTextInTextField(driver , min_price_by ,Integer.toString(min_price) );
        TextField.enterTextInTextField(driver , max_price_by ,Integer.toString(max_price) );

        WebButton.cliclOnButton(driver ,submit_price_button_by );
        Thread.sleep(3000);
    }
    public RozetkaItemPage move_to_first_item()
    {
        WebButton.cliclOnButton(driver ,first_item_by );
        return new RozetkaItemPage(driver);
    }
}