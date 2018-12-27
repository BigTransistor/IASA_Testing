import com.google.common.collect.ImmutableMap;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
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


public class Google_Tests
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

    @Test
    public void test_1()throws Exception
    {
        String target = "IASA Job Bank | Employers | Login";
        String search_text = "IASA";

        searchInGoogle(driver ,search_text);

        int n_page =0;
        boolean findTarget;

        do {
            n_page++;
            findTarget =  keyInHedder(driver , target);
        }while( (!findTarget) & nextPage(driver));

        if (findTarget)
        {
            FileWriter fw = new FileWriter( "test1_n.txt" );
            fw.write(n_page);
            fw.close();
            get_screen(driver , "test1_page"+n_page);
        }

        Assert.assertTrue(findTarget & n_page != 1 );
    }

    @Test
    public void test_2()throws Exception
    {
        String target = "Кафедра ММСА — mmsa";
        String search_text = "ММСА";

        searchInGoogle(driver ,search_text);

        boolean findTarget =  keyInHedder(driver , target);
        if (findTarget)
            get_screen(driver , "test2");
        Assert.assertTrue(findTarget);
    }

    @Test
    public void test_3()throws Exception
    {
        String target = "ИПСА";
        String search_text = "САПР";

        searchInGoogle(driver ,search_text);

        int n_page =0;
        boolean findTarget;

        do {
            n_page++;
            findTarget =  keyInHedder(driver , target);
            get_screen(driver , "test3_page"+n_page);
        }while( (!findTarget) & nextPage(driver));

        Assert.assertFalse(findTarget );
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }



    public static void searchInGoogle(ChromeDriverExtended driver , String search_text)
    {
        driver.get("https://www.google.com/");
        WebElement searchField = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
        searchField.sendKeys(search_text);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[2]/div[2]/div/center/input[1]"));
        searchButton.click();
    }

    public static boolean nextPage(ChromeDriverExtended driver )
    {
        try
        {
            WebElement next_button = driver.findElement(By.cssSelector("#pnnext"));
            next_button.click();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    public static boolean keyInHedder(ChromeDriverExtended driver , String key)
    {
        List <WebElement> heads = driver.findElements(new By.ByClassName("rc"));
        List<String> s_heads = new ArrayList<String>(heads.size());
        for (WebElement head: heads)
            if (head.getText().contains(key))
                return true;
        return false;
    }

    public static void get_screen(ChromeDriverExtended driver , String name) throws Exception
    {
        File screenshot = driver.getFullScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("Screenshots/"+name+".png"));
    }
}
