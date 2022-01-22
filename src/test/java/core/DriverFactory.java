package core;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	private static WebDriver driver;

	private DriverFactory() {
	}

	public static WebDriver getDriver() {

		if (driver == null) {
			switch (Propriedades.browser) {
			case FIREFOX:
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + File.separator + "resources" + File.separator + "Driver" + File.separator
								+ "geckodriver.exe");
				FirefoxOptions optionsFox = new FirefoxOptions();

				driver = new FirefoxDriver(optionsFox);
				break;

			case CHROME:
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + File.separator + "resources" + File.separator + "Driver" + File.separator
								+ "chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--lang=" + "pt-br");
				driver = new ChromeDriver(options);
				break;

			case IE:
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + File.separator + "resources" + File.separator + "Driver" + File.separator
								+ "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			}

		}
		try {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Falha em maximizar navegador Chrome");
		}

		return driver;

	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
			BaseTest.contadorPassos = 1;
		}
	}

}
