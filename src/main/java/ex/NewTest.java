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
    public WebDriver driver;
    String baseUrl = "https://www.seleniumeasy.com/test/basic-first-form-demo.html";
    String InputMsgXPath = "//*[@id=\"user-message\"]";
    String ShowMsgButtonXpath = "//*[@id=\"get-input\"]/button";
    String MsgDisplayXpath = "//*[@id=\"display\"]";
    String InputAValue = "//*[@id=\"sum1\"]";
    String InputBValue = "//*[@id=\"sum2\"]";
    String GetResultButton = "//*[@id=\"gettotal\"]/button";
    String Result = "//*[@id=\"displayvalue\"]";

  @DataProvider
    public static Object[][] dataFromExcel() throws IOException{
    	System.out.println("DataProvider:dataFromExcel");
    	return DataReader.readExcel("data\\data.xls", "Sheet2");
  }
  @DataProvider
  	public static Object[][] dataFromExcel2() throws IOException{
  		System.out.println("DataProvider:dataFromExcel");
  		return DataReader.readExcel("data\\data.xls", "Sheet1");
}
  @Test(groups={"test1", "asrx"}, dataProvider="dataFromExcel2")
  public void f(String inputData) {    
	  System.out.println("Testing testing 123");
	  driver.get(baseUrl);
	  WebElement input = driver.findElement(By.xpath(InputMsgXPath));
      WebElement button = driver.findElement(By.xpath(ShowMsgButtonXpath));
      input.sendKeys(inputData);
      button.click();
      
      String result = driver.findElement(By.xpath(MsgDisplayXpath)).getText();
      Assert.assertEquals(result,inputData); 	
  }
  @Test(groups={"no"},dataProvider="dataFromExcel")
  public void f1(String inputInt1, String inputInt2) {    
	  System.out.println("Testing testing 456");
      driver.get(baseUrl);
      WebElement input = driver.findElement(By.xpath(InputAValue));
      WebElement input1 = driver.findElement(By.xpath(InputBValue));
      WebElement button = driver.findElement(By.xpath(GetResultButton));
      input.sendKeys(inputInt1);
      input1.sendKeys(inputInt2);
      button.click();
      int inputtotal = Integer.parseInt(inputInt1) + Integer.parseInt(inputInt2);
      String result = driver.findElement(By.xpath(Result)).getText();
      int sum = Integer.parseInt(result);
      Assert.assertTrue(inputtotal == sum);
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