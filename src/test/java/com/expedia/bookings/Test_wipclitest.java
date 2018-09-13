package com.expedia.bookings;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Test_wipclitest {
	public static String baseUrl = ("https://wip.staging.ijetcorp.com");
	String driverPath = "C:\\Users\\rassools\\OneDrive - iJET International, Inc\\ChromeD\\chromedriver.exe";
	public static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\rassools\\OneDrive - iJET International, Inc\\ChromeD\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://wip.staging.ijetcorp.com";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("rassools");
		driver.findElement(By.id("password")).sendKeys(new String[] { "ilikephotosandcars" });
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(7000);
		driver.switchTo().frame(driver.findElement(By.id("duo_iframe")));
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement button = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".positive.auth-button[type='submit']")));
		button.click();
		
		System.out.println("Test1 - pass duo");

		// driver.switchTo().parentFrame();

		Thread.sleep(9000);
		driver.findElement(By.linkText("Sources")).click();
		System.out.println("Test2 - click source collection");

		Thread.sleep(2000);
		driver.findElement(By.linkText("New source")).click();
		Thread.sleep(2000);
		System.out.println("Test3 - new source");
		
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}}
	