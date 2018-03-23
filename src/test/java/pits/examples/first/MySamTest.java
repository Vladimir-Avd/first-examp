package pits.examples.first;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test; org.testng.
//import org.testng
//import org.testng.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertFalse;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;


/**
 * Created by
 */
public class MySamTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private FirefoxBinary bin;

    @BeforeMethod
    public void setUp() throws Exception {
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
    }

    @Test
    public void mySamTest() throws Exception {
// comm
// Проверка того что верхнее меню появляется на главной странице

        driver.get("https://new.ahml.test");
        //String mValue = ".//div/div[1]/address";
        String mValue = "(.//*[@class='news-promo__date'])[2]";
        WebElement myWebEl =  driver.findElement(By.xpath(mValue));
        Actions actions = new Actions(driver);
        actions.moveToElement(myWebEl).build().perform();
// Прокрутка страницы вверх
        for (int j = 0; j< 5 ;j++) {
            actions.sendKeys(Keys.ARROW_UP).build().perform();
        }

        mValue = ".head-content_active a[href='/media/'][class= 'main-drop__opener  hidden-lg-down']";
        myWebEl = wait.until(elementToBeClickable(By.cssSelector(mValue)));
        myWebEl.click();
//  Проверка того что страница Медиа загрузилась
        myWebEl = driver.findElements(By.cssSelector(".col-xs-12 .h_spacer")).get(0);
        String menuName = myWebEl.getAttribute("textContent");
        Assert.assertTrue(menuName.equals("Медиа"));
    }

    @AfterMethod
    public void tearDown() throws Exception {
//        driver.quit();

    }
}
