/***************************************************************************
*================== Copyright by ASPIRE SOFTWARE COPORATION ================
****************************************************************************
* Title        : commonlib.java
* Description  : All common functions to running test cases
* Environment  : selenium-java-4.1.2, openjdk version "1.8.0_222", Eclipse 
* 				 Version: 2021-12 (4.22.0), TestNG for Eclipse Plugin 
* Author  	   : Tran, Tien Le
* Version	   : 1.0 draft version
* Update	   : Updated by Tran, Tien Le on draft version	
* Guidelines   : readme.md
* Template name: Selenium Java and testNG
****************************************************************************
****************************************************************************/

package testscript;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.edge.EdgeDriver;

public class commonlib {

	public static WebDriver driver;	

	/**
	 * Launch browser base on setting from BROWSE variable [chorme/firefox/edge/safari/opera]
	 * @param BROWSE
	 * @param URL
	 * @throws InterruptedException
	 */
	public void launchBrowser(String BROWSE, String URL) throws InterruptedException {		
		
		switch(BROWSE) {
		
			case "chrome":		
				System.setProperty("webdriver.chrome.driver", ".\\lib\\browserdriver\\chromedriver.exe");		
				driver = new ChromeDriver();		
			break;		 
			
			case "firefox":		
				System.setProperty("webdriver.gecko.driver",".\\lib\\browserdriver\\geckodriver.exe");		
				driver = new FirefoxDriver();		
			break;
			 
			
			case "edge":		
				System.setProperty("webdriver.edge.driver",".\\lib\\browserdriver\\msedgedriver.exe");		
				driver = new EdgeDriver();		
			break;
		
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
	}

	
	  //==========================================================================================================\\
	 //============================COMMON FUNCTION USING FOR TESTING SCRIPTS=======================================\\	
	//==============================================================================================================\\

	
	/**
	 * Login with username and password
	 * @param USER
	 * @param PASS
	 * @throws InterruptedException
	 */
	public void Step1_Login(String user, String pass) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		username.sendKeys(user); password.sendKeys(pass);		
	
		WebElement loginbnt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Log in']")));
		loginbnt.click();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);		
	}
	
	
	/**
	 * Navigate to Inventory menu
	 * @throws InterruptedException
	 */
	public void Step2_NavigateToInventory() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement inventory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='result_app_1']//div[@class='o_app_icon']")));
		inventory.click();		
	}	
		

	/**
	 * Create a new product base on product name and internal reference
	 * @param PRODUCT_NAME
	 * @param INTERNAL_REF
	 * @throws InterruptedException
	 */
	public void Step3_CreateNewProduct(String PRODUCT_NAME, String INTERNAL_REF) throws InterruptedException {	
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Products']")));
		product.click();Thread.sleep(500);
		
		WebElement product1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Products']")));
		product1.click();
		
		//CREATE PRODUCT:
		WebElement create = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Create']")));
		create.click();Thread.sleep(1000);		

		WebElement productName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='o_field_input_11']")));productName.clear();
		productName.sendKeys(PRODUCT_NAME);		
		
		//Create a product:
		WebElement producttype = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='o_field_input_15']"))); producttype.click();Thread.sleep(1000);
		producttype.sendKeys("Storable Product"); producttype.sendKeys(Keys.ENTER);		

		WebElement unitOfMeasure = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='o_field_input_17']"))); unitOfMeasure.click();Thread.sleep(500);
		unitOfMeasure.clear();unitOfMeasure.sendKeys("cm");Thread.sleep(500);unitOfMeasure.sendKeys(Keys.ENTER);

		WebElement unitUoM = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='o_field_input_18']"))); unitUoM.click();
		Thread.sleep(500);unitUoM.clear();
		unitUoM.sendKeys("cm");Thread.sleep(500); unitUoM.sendKeys(Keys.ENTER);

		WebElement salesPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='o_field_input_19']")));
		Thread.sleep(500);salesPrice.click();		

		WebElement cost = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='o_field_input_20']")));
		cost.clear();cost.sendKeys("20.00");			
		
		WebElement productCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='o_field_input_21']"))); productCategory.click();
		Thread.sleep(1000);
		productCategory.sendKeys(Keys.ARROW_DOWN); productCategory.sendKeys(Keys.ENTER);			

		WebElement InternalReference = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='o_field_input_22']")));
		InternalReference.clear();
		InternalReference.sendKeys(INTERNAL_REF);InternalReference.sendKeys(Keys.TAB);Thread.sleep(1000);
			
		try {
		    driver.findElement(By.xpath("//button[normalize-space()='Ok']"));
		    driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();
		} catch (NoSuchElementException e) {}		

		WebElement barcode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='o_field_input_23']")));			
		barcode.sendKeys("1234567890");barcode.clear();		

		WebElement internalNotes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@placeholder='This note is only for internal purposes.']")));
		internalNotes.clear();
		internalNotes.sendKeys("this product only for testing ...");			

		WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save']")));
		save.click();
			
		//Handle message:
		try {
		    driver.findElement(By.xpath("//button[normalize-space()='Ok']"));
		    driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();
		} catch (NoSuchElementException e) {}	
	}	

	
	/**
	 * Update product quantity with a number 
	 * @param PRODUCT_QUANTITY
	 * @throws InterruptedException
	 */
	public void Step4_UpdateQuantityMoreThan10(String PRODUCT_QUANTITY) throws InterruptedException {	
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement edit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Edit']")));
		edit.click();
		
		//UPDATE QUANTITY
		WebElement updateQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Update Quantity']")));
		updateQuantity.click();
		
		//CREATE button:
		WebElement createupdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Create']")));
		createupdate.click();
	
		//Counted Quantity:
		WebElement countedQuantity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='inventory_quantity']")));
		countedQuantity.clear(); countedQuantity.sendKeys(PRODUCT_QUANTITY);Thread.sleep(1000);
		
		//SAVE button
		WebElement saveUpdated = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save']")));
		saveUpdated.click();
	}	
	
			
	/**
	 * Navigate to Application menu		
	 * @throws InterruptedException
	 */
	public void Step5_BackToApplicationMenu() throws InterruptedException {	
		
		WebDriverWait wait = new WebDriverWait(driver, 10);			
		
		//Application icon
		WebElement application = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Home menu']"))); application.click();	
	}
	
	/**
	 * Create a Manufactory with product name and internal reference.
	 * @param PRODUCT_NAME
	 * @param INTERNAL_REF
	 * @throws InterruptedException
	 */
	@Parameters({"PRODUCT_NAME", "INTERNAL_REF"})
	public void Step6_CreateManfacturingWithProductAtStep3(String PRODUCT_NAME, String INTERNAL_REF) throws InterruptedException {
		
		String manufacturingName = "[" + INTERNAL_REF + "]" + " " + PRODUCT_NAME;
		
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		//Manufacturing
		WebElement manufacturing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='result_app_2']//div[@class='o_app_icon']"))); manufacturing.click();
		
		//CREATE MANUFACTURING:
		WebElement createMan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Create']")));	createMan.click();
		
		WebElement createPro = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@name='product_id']//input[@type='text']")));
		createPro.sendKeys(manufacturingName);Thread.sleep(1000); createPro.sendKeys(Keys.ARROW_DOWN); createPro.sendKeys(Keys.ENTER);
	
		//CONFIRM:
		WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Confirm']"))); confirm.click();		
	}
		

	/**
	 * Update existing order to Done
	 * @throws InterruptedException
	 */
	public void Step7_UpdateOrdersToDone() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement done = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']//span[contains(text(),'Mark as Done')]"))); done.click();
		
		//HANDLE NOTIFY MESSAGE IF EXISTED
		try {
			WebElement confirmOK = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Ok']")));
			confirmOK.click();
		} catch (NoSuchElementException e) {}
		
		//APPLY
		try {
			WebElement confirmApply = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Apply']")));
			confirmApply.click();
		} catch (NoSuchElementException e) {}
		
	}
	
	
	/**
	 * Validation the manufacturing after changing status to Done
	 * @param PRODUCT_NAME
	 * @param INTERNAL_REF
	 * @throws InterruptedException
	 */
	public void Step8_ValidateManufacturingOrder(String PRODUCT_NAME, String INTERNAL_REF) throws InterruptedException {	
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String manufacturingName = "[" + INTERNAL_REF + "]" + " " + PRODUCT_NAME;
		String sXpathName = "//span[contains(.,'" + manufacturingName + "')]"; //"//span[contains(.,'[Testing Product] Product test 1')]"
		
		//Verify Manufacturing Orders Information
		WebElement productOder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sXpathName)));		
		Assert.assertTrue(productOder.getText().contains(manufacturingName));
		
		//DONE Status Verify
		WebElement statusDoneVeiry = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Done')]")));
		Assert.assertTrue(statusDoneVeiry.getText().contains("Done"));
		
		
		//Save Button:
		WebElement savebnt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Save']")));
		savebnt.click();
	}
	
	/**
	 * Close browser	
	 */
	 @AfterTest 
	 public void closeBrowser() { 
		 driver.quit(); 
	}
	 
}
