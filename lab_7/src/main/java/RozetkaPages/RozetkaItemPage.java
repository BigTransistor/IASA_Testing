package RozetkaPages;

import objects.WebButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RozetkaItemPage
{
    WebDriver driver;
    By addToBoxButton;
    By buyButton;

    public RozetkaItemPage(WebDriver _driver)
    {
        driver = _driver;
        addToBoxButton = By.xpath("//*[@id=\"price_container\"]/div[2]/div/form/span/span/button");
        buyButton = By.id("popup-checkout");
    }

    public RozetkaOrderPage get_item_OrderPage() throws Exception
    {
        WebButton.cliclOnButton(driver ,addToBoxButton );
        Thread.sleep(3000);
        WebButton.cliclOnButton(driver ,buyButton );
        return new RozetkaOrderPage(driver);
    }
}
