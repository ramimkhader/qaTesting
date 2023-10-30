package preject_testing;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class myClass {

	ChromeDriver driver = new ChromeDriver();
	SoftAssert myAssert = new SoftAssert();
	String Pass = "ra@ra12345";
	String Email = "ramikhader711@gmail.com";
	Random myRand = new Random();

	@BeforeTest
	public void myTest()

	{

		String Pass = "ra@ra12345";
		String Email = "ramikhader711@gmail.com";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://magento.softwaretestingboard.com/");

		driver.get(
				"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(Email);
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(Pass);
		driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
	}

	@Test(priority = 1)
	public void RegesterNewAccount() throws InterruptedException {
		driver.manage().window().maximize();
		String Pass = "ra@ra12345";
		String Email = "ramikhader711@gmail.com";
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("rami");
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("khader");
		driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys(Email);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(Pass);
		driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]")).sendKeys(Pass);
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
		driver.get(
				"https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(Email);
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(Pass);
		driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
		Thread.sleep(2000);
		String welcomeMessg = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span"))
				.getText();
		System.out.println(welcomeMessg);
		Boolean ActulwelcomeMessg = welcomeMessg.contains("Welcome");
		myAssert.assertEquals(ActulwelcomeMessg, true);
		myAssert.assertAll();

	}

	@Test(priority = 2)
	public void Select_items_randomly() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String[] myItems = { "jacket", "t-shirt", "jesns for men", "jeans for women", "pants" };
		int rand = myRand.nextInt(0, myItems.length);
		System.out.println(myItems[rand]);
		WebElement searchBarValue = driver.findElement(By.xpath("//*[@id=\"search\"]"));

		searchBarValue.sendKeys(myItems[rand] + Keys.ENTER);
		Thread.sleep(2000);

		String sentText = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")).getText();
		System.out.println(sentText);

		Boolean ActulNemeItemsNew = sentText.contains(myItems[rand]);
		SoftAssert myAssertt = new SoftAssert();
		myAssertt.assertEquals(ActulNemeItemsNew, true);
		myAssertt.assertAll();

	}

	@Test(priority = 3)
	public void Add_items_test_number_3() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement itemContatiner = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span"));

		List<WebElement> Items = itemContatiner.findElements(By.className("product-item-link"));

		Thread.sleep(3000);

		String[] URL = { "https://magento.softwaretestingboard.com/radiant-tee.html",
				"https://magento.softwaretestingboard.com/breathe-easy-tank.html",
				"https://magento.softwaretestingboard.com/argus-all-weather-tank.html",
				"https://magento.softwaretestingboard.com/hero-hoodie.html",
				"https://magento.softwaretestingboard.com/fusion-backpack.html" };

		for (int i = 0; i < 5; i++) {
			driver.get(URL[i]);

			if (driver.getCurrentUrl().contains("radiant")) {

				WebElement ColorDiv = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]"));

				String[] colorLabels = { "option-label-color-93-item-50", "option-label-color-93-item-56",
						"option-label-color-93-item-57" };

				int RandomColor = myRand.nextInt(0, 3);
				List<WebElement> Size = driver.findElements(By.className("swatch-option"));
				int RandomSize = myRand.nextInt(0, 5);
				Size.get(RandomSize).click();
				Thread.sleep(3000);

				List<WebElement> Color = ColorDiv.findElements(By.tagName("div"));

				Color.get(RandomColor).click();
				driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("3");
				driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
				Thread.sleep(5000);

			} else if (driver.getCurrentUrl().contains("breathe")) {
				WebElement breatheColorDiv = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]"));
				List<WebElement> Color = breatheColorDiv.findElements(By.tagName("div"));

				Thread.sleep(5000);
				List<WebElement> Size = driver.findElements(By.className("swatch-option"));
				int RandomSize = myRand.nextInt(0, 5);
				Size.get(RandomSize).click();
				Thread.sleep(5000);
				int RandomColor = myRand.nextInt(0, 3);
				Color.get(RandomColor).click();
				driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("2");
				driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
				Thread.sleep(5000);
			} else if (driver.getCurrentUrl().contains("argus")) {
				Thread.sleep(5000);

				List<WebElement> Size = driver.findElements(By.className("swatch-option"));
				int RandomSize = myRand.nextInt(0, 5);
				Size.get(RandomSize).click();
				Thread.sleep(5000);

				driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-52\"]")).click();

				driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("4");
				driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
				Thread.sleep(5000);
			} else if (driver.getCurrentUrl().contains("hero")) {
				Thread.sleep(5000);

				WebElement colorDiv = driver
						.findElement(By.xpath("//*[@id=\"product-options-wrapper\"]/div/div/div[2]/div"));

				List<WebElement> colors = colorDiv.findElements(By.tagName("div"));

				List<WebElement> Size = driver.findElements(By.className("swatch-option"));
				int RandomSize = myRand.nextInt(0, 6);
				Size.get(RandomSize).click();
				Thread.sleep(5000);
				int RandomColor = myRand.nextInt(0, 3);

				colors.get(RandomColor).click();

				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("1");
				driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
				Thread.sleep(5000);
			} else if (driver.getCurrentUrl().contains("fusion")) {

				driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"qty\"]")).sendKeys("1");
				driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
				Thread.sleep(5000);
			}
		}

	}

	@Test(priority = 4)
	public void cheakOut() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Thread.sleep(3000);

		driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]")).click();
		Thread.sleep(3000);

		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys("rami");

		Thread.sleep(3000);

		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys("khader");

		Thread.sleep(3000);

		driver.findElement(By.name("street[0]")).sendKeys("zarqa");
		Thread.sleep(3000);

		driver.findElement(By.name("city")).sendKeys("jordan");
		Thread.sleep(3000);

		WebElement StateList = driver.findElement(By.name("region_id"));
		Select State = new Select(StateList);
		State.selectByValue("4");

		System.out.println("0000000000000000000000000000000000000000");

		Thread.sleep(3000);

		driver.findElement(By.name("postcode")).sendKeys("12345-6789");
		Thread.sleep(3000);

		WebElement countryList = driver.findElement(By.name("country_id"));
		Select country = new Select(countryList);
		country.selectByValue("JO");

		Thread.sleep(3000);

		driver.findElement(By.name("telephone")).sendKeys("0785598341");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("[value=\"flatrate_flatrate\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
		Thread.sleep(3000);

		String FinalPrice = driver
				.findElement(By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/table/tbody/tr[4]/td/strong/span")).getText();

		System.out.println(FinalPrice);
		String UFinalPrice = FinalPrice.replace("$", "");
		double doublePrice = Double.parseDouble(UFinalPrice);
		System.out.println(doublePrice);
	}

}