package homeWork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class XpathCssTestAssert {

	WebDriver driver;
	WebDriverWait Ex;

	@BeforeTest
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Ex = new WebDriverWait(driver, 6);
	}

	@Test(priority = 0)
	public void openurl() {
		driver.get("http://automationpractice.com/index.php");
	}

	@Test(priority = 1, dependsOnMethods = { "openurl" })
	public void signin() {

		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();// Here we using X-path
																								// rule number 1.
		String ExpectedURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		String ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpectedURL);
		System.out.println("Assert passed");
	}

	@Test(priority = 2)
	public void enteremail() {

		driver.findElement(By.xpath("//input[@id='email_create'][@name='email_create']"))
				.sendKeys("Hurayra@hotmail.com");// Here we using x-path rule number 2.
		String ExpectedForm = "create-account_form";
		String ActualForm = driver.findElement(By.id("create-account_form")).getAttribute("id");
		Assert.assertEquals(ActualForm, ExpectedForm);
		System.out.println("Form was found");

	}

	@Test(priority = 3, dependsOnMethods = { "enteremail" })
	public void clicksubmit() {

		WebElement SubmitCreate = driver.findElement(By.xpath("//button[contains(@id,'SubmitCreate')]"));
		SubmitCreate.click();
		Assert.assertEquals(true, SubmitCreate.isEnabled());
		System.out.println("Submit Create button enable");

	}

	@Test(priority = 4, dependsOnMethods = { "clicksubmit" })
	public void personalinfo() {

		String ExpectedURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
		Ex.until(ExpectedConditions.urlToBe(ExpectedURL));
		String ExpectedForm = "account-creation_form";
		String ActualForm = driver.findElement(By.id("account-creation_form")).getAttribute("id");
		Assert.assertEquals(ActualForm, ExpectedForm);
		System.out.println("Form was found");
	}

	@Test(priority = 5)
	public void selectRadio() {

		WebElement genderMale = driver.findElement(By.xpath("//input[starts-with(@id,'id_gender1')]"));
		genderMale.click();

	}

	@Test(priority = 6)
	public void enterFirstName() {

		WebElement firstName = driver
		.findElement(By.xpath("//input[starts-with(@data-validate,'isName')and(@id='customer_firstname')]"));// Rule
																														// no_
																														// 5.

		firstName.sendKeys("khanjada");

	}

	@Test(priority = 7)
	public void enterLastName() {

		WebElement lastName = driver.findElement(By.xpath("//*[@id='customer_lastname']"));// rule no-7

		lastName.sendKeys("Hurayra");

	}

	@Test(priority = 8)
	public void enterPass() {

		WebElement pass = driver.findElement(By.xpath("//*[@id='passwd' or @name='passwd']"));// using x-path rule no-8

		pass.sendKeys("12345");

	}

	@Test(priority = 9)
	public void selectdays() {

		WebElement drpdays = driver.findElement(By.id("days"));
		// Ex.until(ExpectedConditions.elementToBeClickable(drpdays));
		drpdays.click();
		Select days = new Select(drpdays);
		days.selectByVisibleText("5  ");
		String option = days.getFirstSelectedOption().getText();
		Assert.assertEquals("5  ", option);
	}

	@Test(priority = 10)
	public void checkNewsLetter() {

		WebElement newsLetter = driver.findElement(By.cssSelector("#newsletter"));// Css rule 5
		newsLetter.click();
	}

	@Test(priority = 11)
	public void checkReceiveSpecial() {

		WebElement receiveSpecial = driver
				.findElement(By.xpath("//*[@type='checkbox' and @name='optin' or @id='optin']"));// x-path rule no-10
		receiveSpecial.click();
	}

	@Test(priority = 12)
	public void company() {
		WebElement company = driver.findElement(By.id("company"));
		company.sendKeys("ABC Co");
		String Expected = "ABC Co";
		String Actual = driver.findElement(By.id("company")).getAttribute("value");
		Assert.assertEquals(Actual, Expected);
		System.out.println(Actual);

	}

	@Test(priority = 13)
	public void address() {

		WebElement address1 = driver.findElement(By.id("address1"));
		address1.sendKeys("8954 ,queens village");

		String expected = "address1";
		String actual = driver.findElement(By.id("address1")).getAttribute("id");
		Assert.assertEquals(actual, expected);
		System.out.println("Assertion address1 is passed");

	}

	@Test(priority = 14)
	public void city() {

		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("Jamaica");

		String expected = "city";
		String actual = driver.findElement(By.id("city")).getAttribute("id");
		Assert.assertEquals(actual, expected);
		System.out.println("Assertion City is passed");

	}

	@Test(priority = 15)
	public void state() {

		WebElement drpState = driver.findElement(By.id("id_state"));
		drpState.click();
		Select states = new Select(drpState);
		states.selectByVisibleText("New York");
		String option = states.getFirstSelectedOption().getText();
		Assert.assertEquals("New York", option);

	}

	@Test(priority = 16)
	public void zipcode() {

		WebElement postCode = driver.findElement(By.id("postcode"));
		postCode.sendKeys("11355");

		String expected = "postcode";
		String actual = driver.findElement(By.id("postcode")).getAttribute("id");
		Assert.assertEquals(actual, expected);
		System.out.println("Assertion Zip code is passed");

	}

	@Test(priority = 17)
	public void country() {

		WebElement drpCountry = driver.findElement(By.id("id_country"));
		drpCountry.click();
		Select countrys = new Select(drpCountry);
		countrys.selectByVisibleText("United States");
		String option = countrys.getFirstSelectedOption().getText();
		Assert.assertEquals("United States", option);

	}

	@Test(priority = 18)
	public void additionalInfo() {

		WebElement addInfo = driver.findElement(By.id("other"));
		addInfo.sendKeys("Nothing have to add");

		String expected = "other";
		String actual = driver.findElement(By.id("other")).getAttribute("id");
		Assert.assertEquals(actual, expected);
		System.out.println("Assert additional  is passed");

	}

	@Test(priority = 19)
	public void mobilephone() {

		WebElement mobilephone = driver.findElement(By.id("phone_mobile"));
		Assert.assertEquals(true, mobilephone.isDisplayed());
		System.out.println("---- isDisplayed Assertion Passed");
		mobilephone.sendKeys("857-000-0006");
		Assert.assertEquals(true, mobilephone.isEnabled());
		System.out.println("---- isEnabled Assertion Passed");
		Assert.assertEquals(false, mobilephone.isSelected());

		System.out.println("---- isSelected Assertion Passed");
		String Expectedvalue = "857-000-0006";
		String Actualvalue = driver.findElement(By.id("phone_mobile")).getAttribute("value");
		Assert.assertEquals(Actualvalue, Expectedvalue);
		System.out.println(Actualvalue + "----Assertion Passed");

		int mobilenumber = driver.findElements(By.id("phone_mobile")).size();

		if (mobilenumber == 0) {
			System.out.println("******phone_mobile***** this element found 1 time");
		} else if (mobilenumber >= 1) {
			System.out.println("******phone_mobile***** this element found more then 1 time");
		}

		else {
			System.out.println("----Mobilenumber is not verified ");
		}
	}

	@Test(priority = 20)
	public void assignAddAlias() {

		WebElement address = driver.findElement(By.id("alias"));
		address.sendKeys("13534, maple ave");

		String expected = "alias";
		String actual = driver.findElement(By.id("alias")).getAttribute("id");
		Assert.assertEquals(actual, expected);
		System.out.println("Assertion alias is passed");

	}

	@AfterTest
	public void close() {
		driver.quit();
	}

}
