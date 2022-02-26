package formy;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class keyboardandmouseInput {
	
	
	public WebDriver driver;
	SoftAssert softassert = new SoftAssert();

	@BeforeTest
	public void drivers() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test(priority = 1)
	public void keypress() throws Exception {
		
		driver.get("https://formy-project.herokuapp.com/keypress");
		Thread.sleep(2000);
		
		WebElement name = driver.findElement(By.id("name"));
		name.click();
		Thread.sleep(2000);
		name.sendKeys("cheese");
		Thread.sleep(2000);
		WebElement click = driver.findElement(By.id("button"));
		click.click();
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	@Test(priority =1)
	public void scroll() throws Exception {
		driver.get("https://formy-project.herokuapp.com/scroll");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement fullname = driver.findElement(By.id("name"));
		WebElement date = driver.findElement(By.id("date"));
		Actions actions = new Actions(driver);
		actions.moveToElement(fullname);
		Thread.sleep(2000);
		fullname.click();
		Thread.sleep(2000);
		fullname.sendKeys("name");
		Thread.sleep(2000);;
		date.click();
		Thread.sleep(2000);
		date.sendKeys("28/09/2021");
		Thread.sleep(2000);	
	}
	
	@Test(priority =1)
	public void datepicker() throws Exception {
		driver.get("https://formy-project.herokuapp.com/datepicker");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement datepicker = driver.findElement(By.id("datepicker"));
		Thread.sleep(2000);
		datepicker.sendKeys("03/01/2022");
		Thread.sleep(2000);
		datepicker.sendKeys(Keys.RETURN);
		Thread.sleep(2000);
	}
	
	@Test(priority =1)
	public void dragdrop() throws Exception {
		driver.get("https://formy-project.herokuapp.com/dragdrop");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement image = driver.findElement(By.id("image"));
		WebElement box = driver.findElement(By.id("box"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(image, box).build().perform();	
		
	}
	
	@Test(priority =1)
	public void fileupload() throws Exception {
		driver.get("https://formy-project.herokuapp.com/fileupload");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement file = driver.findElement(By.id("file-upload-field"));
		file.sendKeys("recharge-receipt (2).jpg");
		
		
	}
	
	
	@Test(priority =1)
	public void switchwindow()  throws Exception {
		driver.get("https://formy-project.herokuapp.com/switch-window");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement btn = driver.findElement(By.id("new-tab-button"));
		btn.click();
		Thread.sleep(2000);
		String originalwindow = driver.getWindowHandle();
		Thread.sleep(2000);
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			//driver.switchTo().window(originalwindow);
		}
		
	}
	
	
	@Test(priority =1)
	public void alert() throws Exception {
		driver.get("https://formy-project.herokuapp.com/switch-window");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement alert = driver.findElement(By.id("alert-button"));
		alert.click();
		Thread.sleep(2000);
		
		Alert qlert = driver.switchTo().alert();
		qlert.accept();
		
	}
	
	@Test(priority =1)
	public void modal() throws Exception {
		driver.get("https://formy-project.herokuapp.com/modal");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement modal = driver.findElement(By.id("modal-button"));
		modal.click();
		//Thread.sleep(2000);
		WebElement closebtn = driver.findElement(By.id("close-button"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", closebtn);
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
