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

	public void drivers() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	
	public void keypress() throws Exception {
		
		driver.get("https://formy-project.herokuapp.com/keypress");
		Thread.sleep(2000);
		
		WebElement name = driver.findElement(By.id("name"));
		name.click();
		
		name.sendKeys("cheese");
	
		WebElement click = driver.findElement(By.id("button"));
		click.click();
		
		driver.quit();
		
	}
	

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
		
		fullname.sendKeys("name");
		
		date.click();
		
		date.sendKeys("28/09/2021");
			
	}
	

	public void datepicker() throws Exception {
		driver.get("https://formy-project.herokuapp.com/datepicker");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement datepicker = driver.findElement(By.id("datepicker"));
		
		datepicker.sendKeys("03/01/2022");
		
		datepicker.sendKeys(Keys.RETURN);
		
	}
	

	public void dragdrop() throws Exception {
		driver.get("https://formy-project.herokuapp.com/dragdrop");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement image = driver.findElement(By.id("image"));
		WebElement box = driver.findElement(By.id("box"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(image, box).build().perform();	
		
	}
	

	public void fileupload() throws Exception {
		driver.get("https://formy-project.herokuapp.com/fileupload");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement file = driver.findElement(By.id("file-upload-field"));
		file.sendKeys("recharge-receipt (2).jpg");
		
		
	}
	
	

	public void switchwindow()  throws Exception {
		driver.get("https://formy-project.herokuapp.com/switch-window");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement btn = driver.findElement(By.id("new-tab-button"));
		btn.click();
		String originalwindow = driver.getWindowHandle();
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			driver.switchTo().window(originalwindow);
		}
		
	}
	
	
	public void alert() throws Exception {
		driver.get("https://formy-project.herokuapp.com/switch-window");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		WebElement alert = driver.findElement(By.id("alert-button"));
		alert.click();
		
		Alert qlert = driver.switchTo().alert();
		qlert.accept();
		
	}
	
	
	public void modal() throws Exception {
		driver.get("https://formy-project.herokuapp.com/modal");
		driver.manage().window().maximize();
		WebElement modal = driver.findElement(By.id("modal-button"));
		modal.click();
		WebElement closebtn = driver.findElement(By.id("close-button"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", closebtn);
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
