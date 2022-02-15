/***************************************************************************
*================== Copyright by ASPIRE SOFTWARE COPORATION ================
****************************************************************************
* Title        : testcase.java
* Description  : All steps to running test cases
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

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class testcases {
	
	public static commonlib test = new commonlib();
	
	/**
	 * This test will be setup environment before testing: launch browser and open page base url
	 * @param BROWSER
	 * @param URL
	 * @throws InterruptedException
	 */
	@Parameters({"BROWSE","URL"})
	@BeforeTest
	public void settingEnvironment(String BROWSER, String URL) throws InterruptedException {
		test.launchBrowser(BROWSER, URL);
	}

	
	/**
	 * This step login to web application via user and pass 
	 * @param USER
	 * @param PASS
	 * @throws InterruptedException
	 */
	@Parameters({"USER", "PASS"})
	@Test
	public void Step01(String USER, String PASS) throws InterruptedException {
		test.Step1_Login(USER, PASS);
	}


	/**
	 * This test will navigate to Inventory menu
	 * @throws InterruptedException
	 */
	@Test
	public void Step02() throws InterruptedException {
		test.Step2_NavigateToInventory();
	}
	

	/**
	 * This test will create a new product base on product name and internal reference
	 * @param PRODUCT_NAME
	 * @param INTERNAL_REF
	 * @throws InterruptedException
	 */
	@Parameters({"PRODUCT_NAME", "INTERNAL_REF"})
	@Test
	public void Step03(String PRODUCT_NAME, String INTERNAL_REF) throws InterruptedException {
		test.Step3_CreateNewProduct(PRODUCT_NAME, INTERNAL_REF);
	}
	

	/**
	 * This test will update the product quantity base the input number	
	 * @param PRODUCT_QUANTITY
	 * @throws InterruptedException
	 */
	@Parameters({"PRODUCT_QUANTITY"})
	@Test
	public void Step04(String PRODUCT_QUANTITY) throws InterruptedException {
		test.Step4_UpdateQuantityMoreThan10(PRODUCT_QUANTITY);
	}
	

	/**
	 * This test will be back to Application menu
	 * @throws InterruptedException
	 */
	@Test	
	public void Step05() throws InterruptedException {
		test.Step5_BackToApplicationMenu();		
	}


	/**
	 * This test will be create a manufacturing with name and internal reference
	 * @param PRODUCT_NAME
	 * @param INTERNAL_REF
	 * @throws InterruptedException
	 */
	@Parameters({"PRODUCT_NAME", "INTERNAL_REF"})
	@Test
	public void Step06(String PRODUCT_NAME, String INTERNAL_REF) throws InterruptedException {
		test.Step6_CreateManfacturingWithProductAtStep3(PRODUCT_NAME, INTERNAL_REF);		
	}
	

	/**
	 * This test will be update order to Done
	 * @throws InterruptedException
	 */
	@Test
	public void Step07() throws InterruptedException {
		test.Step7_UpdateOrdersToDone();
	}
	

	/**
	 * This test will be validate manufacturing order after update satatus to Done
	 * @param PRODUCT_NAME
	 * @param INTERNAL_REF
	 * @throws InterruptedException
	 */
	@Parameters({"PRODUCT_NAME", "INTERNAL_REF"})
	@Test
	public void Step08(String PRODUCT_NAME, String INTERNAL_REF) throws InterruptedException {
		test.Step8_ValidateManufacturingOrder(PRODUCT_NAME, INTERNAL_REF);
	}
	

	/**
	 * This test will be clean environment after testing
	 * @param BROWSER
	 * @param URL
	 * @throws InterruptedException
	 */
	@AfterTest
	public void cleanEnvironment(String BROWSER, String URL) throws InterruptedException {
		test.closeBrowser();
	}
}