package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import youtubeFramework.testCaseSourceCode.SearchFromHome;

public class StepDefinition {
	private final SearchFromHome searchFromHome = new SearchFromHome();
	@Given("User is on the home page {string} and not logged in")
	public void user_is_on_the_home_page_and_not_logged_in(String string) {
		searchFromHome.actionsAndWebDriverCreator();
		searchFromHome.goToHomePage(string);
	}

	@When("User attempts to search for something, e.g. (.+)$")
	public void user_attempts_to_search_for_something_e_g(String string) {
		searchFromHome.clickOnSearchBar();
		searchFromHome.sendText(string);
		searchFromHome.clickOnSearchButtonOrEnter();
	}

	@Then("User should be given a page with results for the relevant search")
	public void user_should_be_given_a_page_with_results_for_the_relevant_search() {
		boolean testSucceed = searchFromHome.confirmSearchPage();
		Assert.assertTrue(testSucceed);
	}
	@And("^Close the browser$")
	public void close_the_browser() {
		searchFromHome.closePage();
	}
}
