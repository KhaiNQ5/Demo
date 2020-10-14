package ex;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.Assert;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewTest {
    private WebDriver driver;
    String baseUrl = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
    String InputMsgXPath = "//*[@id=\"user-message\"]";
    String ShowMsgButtonXpath = "//*[@id=\"get-input\"]/button";
    String MsgDisplayXpath = "//*[@id=\"display\"]";
    String InputText = "hsdifeeekdue";
  @DataProvider
    public static Object[][] dataFromExcel() throws IOException{
    	System.out.println("DataProvider:dataFromExcel");
    	return DataReader.readExcel("data\\data.xls", "Sheet1");
  }
  @Test(groups={"easy"},dataProvider="dataFromExcel")
  public void f(String inputData) {      
	  driver.get(baseUrl);
	  WebElement input = driver.findElement(By.xpath(InputMsgXPath));
      WebElement button = driver.findElement(By.xpath(ShowMsgButtonXpath));
      input.sendKeys(inputData);
      button.click();
      
      String result = driver.findElement(By.xpath(MsgDisplayXpath)).getText();
      Assert.assertEquals(result,inputData); 	
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