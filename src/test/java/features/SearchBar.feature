Feature: Search Bar

  Scenario Outline: Attempt to search for something
    Given User is on the home page "http://youtube.com" and not logged in
    When User attempts to search for something, e.g. <search_term>
    Then User should be given a page with results for the relevant search
    And Close the browser

    Examples:
    |search_term       |
    |the supreme bal  |
    |the fire bal      |
    |the bal of lords |