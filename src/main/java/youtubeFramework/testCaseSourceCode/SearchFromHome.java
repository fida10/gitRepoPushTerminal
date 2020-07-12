package youtubeFramework.testCaseSourceCode;

import bluePrints.main.testCaseBluePrints.searchFromHome;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import youtubeFramework.coreClasses.InitializerMethods;
import youtubeFramework.pageObjectModels.YoutubeHomePage;

public class SearchFromHome implements searchFromHome {
	Actions a;
	WebDriver dr;
	YoutubeHomePage y;
	String searchText = "";

	@Override
	public void actionsAndWebDriverCreator() {
		InitializerMethods i = new InitializerMethods();
		y = new YoutubeHomePage(i.dr);
		this.dr = i.dr;
		a = new Actions(dr);
	}

	@Override
	public void goToHomePage(String homePage) {
		dr.get(homePage);
	}

	@Override
	public void clickOnSearchBar() {
		a
				.moveToElement(y.getSearchBar())
				.click()
				.build()
				.perform();
	}

	@Override
	public void sendText(String text) {
		a
				.sendKeys(text)
				.build()
				.perform();
		this.searchText = text;
	}

	@Override
	public void clickOnSearchButtonOrEnter() {
		a
				.sendKeys(Keys.ENTER)
				.build()
				.perform();
	}

	@Override
	public boolean confirmSearchPage() {
		a
				.moveToElement(y.getConfirmationOnSearchPage())
				.build()
				.perform();
		boolean testPass = y.getConfirmationOnSearchPage().isDisplayed();
		if(testPass){
			System.out.println("Test has passed"); //log4j
		} else {
			System.out.println("Test has failed, search elements not visible");
		}
		return testPass;
	}

	@Override
	public void closePage() {
		dr.quit();
	}
}
