package bluePrints.main.testCaseBluePrints;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public interface searchFromHome {
	void actionsAndWebDriverCreator();
	void goToHomePage(String homePage);
	void clickOnSearchBar();
	void sendText(String text);
	void clickOnSearchButtonOrEnter();
	boolean confirmSearchPage();
	void closePage();
}
