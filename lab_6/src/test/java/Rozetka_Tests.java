import com.google.common.collect.ImmutableMap;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Rozetka_Tests
{
    private static ChromeDriverExtended driver;

    @BeforeClass
    public static void setup() throws Exception
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriverExtended();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test()throws Exception
    {
        driver.get("https://rozetka.com.ua/mobile-phones/c80003/preset=smartfon/");

        WebElement priceField = driver.findElement(By.xpath("//*[@id=\"price[max]\"]"));
        int max_price = get_prices(driver).get(0);
        priceField.sendKeys(Integer.toString(max_price));

        WebElement okButton = driver.findElement(By.xpath("//*[@id=\"sort_price\"]/div[1]/span/span"));
        okButton.click();
        driver.get("https://rozetka.com.ua/mobile-phones/c80003/preset=smartfon;price=0-"+max_price+"/");

        List<Integer> prices = get_prices(driver);
        for(int price : get_prices(driver))
            Assert.assertTrue(prices.toString(), price <= max_price);
    }

    public static List<Integer> get_prices(ChromeDriverExtended driver)
    {
        List<Integer> int_prices = new ArrayList<Integer>();
        for (WebElement price: driver.findElements(new By.ByClassName("g-price-uah")))
            int_prices.add(Integer.parseInt(price.getText().replaceAll("[^0-9]*", "")));
        return int_prices;
    }

}
