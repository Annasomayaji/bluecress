Feature: Book a package functionality
  As a user, I would like to book a package

  Background: Url is launched and the user is on the packages page
    Given I navigated to the packages page

  @regression  @author_Annapoorna
  Scenario: The user  should be able to book the Active package
    When I select the "Active" package
    And I enter the following details
           | London   | Cavendish Square | Tuesday 28 May | 10:05 AM |
    And I confirm Order Summary
    Then I should be navigated to "Order Summary" page
    And navigate to "Personal details" section


  Scenario Outline: The user should be able to book a package
    When I select the package from given sheet name "<sheetName>" and row number "<rowNumber>" with data in excel at "src/test/resources/testdata/package-data.xlsx"
    And I enter appointment details from sheet name "<sheetName>" and row number "<rowNumber>" with data in excel at "src/test/resources/testdata/package-data.xlsx"
    And I confirm Order Summary
    Then I should be navigated to "Order Summary" page
    And navigate to "Personal details" section

    Examples:
      | sheetName | rowNumber |
      | Sheet1    | 0         |
      | Sheet1    | 1         |



