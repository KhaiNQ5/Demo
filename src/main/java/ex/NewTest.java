package ex;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewTest {
    private WebDriver driver;
    
  @Test
  public void f() {
      String baseUrl = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
	  driver.get(baseUrl);
      String InputMsgXPath = "//*[@id=\"user-message\"]";
      String ShowMsgButtonXpath = "//*[@id=\"get-input\"]/button";
      String MsgDisplayXpath = "//*[@id=\"display\"]";
      String InputText = "hsdifeeekdue";
	  WebElement input = driver.findElement(By.xpath(InputMsgXPath));
      WebElement button = driver.findElement(By.xpath(ShowMsgButtonXpath));
      input.sendKeys(InputText);
      button.click();
      
      String result = driver.findElement(By.xpath(MsgDisplayXpath)).getText();
      Assert.assertEquals(result,InputText); 	
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Ruby27-x64\\bin\\chromedriver.exe");
		driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();

}
}