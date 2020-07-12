package youtubeFramework.pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YoutubeHomePage {
	WebDriver dr;
	@FindBy(xpath = "//html")
	WebElement corePageElement;
	@FindBy(xpath = "//input[@id='search']")
	WebElement searchBar;
	@FindBy(xpath = "//ytd-video-renderer")
	WebElement confirmationOnSearchPage;
	@FindBy(xpath = "//div[@id='buttons']//paper-button[@aria-label='Sign in']")
	WebElement signInButton;
	public YoutubeHomePage(WebDriver driver){
		this.dr = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getConfirmationOnSearchPage() {
		return confirmationOnSearchPage;
	}
}
