
import RozetkaPages.RozetkaItemListPage;
import RozetkaPages.RozetkaItemPage;
import RozetkaPages.RozetkaOrderPage;
import objects.WebButton;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Rozetka_Tests
{
    private static ChromeDriver driver;

    @BeforeClass
    public static void setup() throws Exception
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test()throws Exception
    {
        driver.get("https://rozetka.com.ua/gadzhety-i-podarki/c80017/filter/");

        RozetkaItemListPage itemListPage = new RozetkaItemListPage(driver);
        itemListPage.price_filter(100 ,2000);
        RozetkaItemPage itemPage =  itemListPage.move_to_first_item();

        RozetkaOrderPage orderPage = itemPage.get_item_OrderPage();

        orderPage.fillFields("Rozetka Testing", "0777777777");
        WebButton targetbutton = orderPage.get_item_buy_button();

        Assert.assertTrue(targetbutton.isEnabled());
    }

}
