package youtubeFramework.coreClasses;

import bluePrints.main.initializers.InitialMethodsInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class InitializerMethods implements InitialMethodsInterface {
	public WebDriver dr;
	private String absolutePath;
	Properties properties = new Properties();
	public InitializerMethods(){
		propertiesFileInitializer("/src/resources/properties/staticProperties.properties");
		this.dr = browserInitializer();
	}

	@Override
	public void propertiesFileInitializer(String localPathToProps) {
		absolutePath = System.getProperty("user.dir");
		File file = new File(absolutePath.concat("//" + localPathToProps));
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			properties.load(fileInputStream);
		} catch (IOException e){
			System.out.println("IO exception thrown, file invalid"); //log4j
		}
	}

	@Override
	public WebDriver browserInitializer() {
		if(properties.getProperty("browser").equalsIgnoreCase("chrome")){
			System.out.println("Using chrome browser"); //log4j
			System.setProperty("webdriver.chrome.driver", absolutePath.concat("/src/resources/browserDrivers/chromedriver"));
			dr = new ChromeDriver();
		} else if(properties.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.out.println("Using firefox browser"); //log4j
			System.setProperty("webdriver.gecko.driver", absolutePath.concat("/src/resources/browserDrivers/geckodriver"));
			dr = new FirefoxDriver();
		} else {
			System.out.println("Invalid browser"); //log4j
		}
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return dr;
	}
}
