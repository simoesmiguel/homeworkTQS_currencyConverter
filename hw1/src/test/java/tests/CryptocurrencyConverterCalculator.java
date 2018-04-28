/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * @author Miguel Simões
 */

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CryptocurrencyConverterCalculator {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    //driver = new FirefoxDriver
    System.setProperty("webdriver.chrome.driver", "C:\\googleDriver\\chromedriver.exe");

    driver = new ChromeDriver(); //or other driver which you want
    baseUrl = "http://localhost:8080/hw1/";
    driver.get(baseUrl);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCryptocurrencyConverterCalculator() throws Exception {
    driver.findElement(By.name("value")).click();
    driver.findElement(By.name("value")).clear();
    driver.findElement(By.name("value")).sendKeys("10");
    driver.findElement(By.name("selectFrom")).click();
    new Select(driver.findElement(By.name("selectFrom"))).selectByVisibleText("EUR");
    driver.findElement(By.name("selectFrom")).click();
    driver.findElement(By.name("selectTo")).click();
    new Select(driver.findElement(By.name("selectTo"))).selectByVisibleText("PLN");
    driver.findElement(By.name("selectTo")).click();
    driver.findElement(By.xpath("//input[@value='Convert']")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  
  public static void main(String[] args) throws Exception, Exception {
       CryptocurrencyConverterCalculator cv = new CryptocurrencyConverterCalculator();
       cv.setUp();
       cv.testCryptocurrencyConverterCalculator();
       cv.tearDown();
    }
}
