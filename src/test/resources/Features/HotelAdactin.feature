Feature: Hotel Booking Process on Adactin Hotel App
    
  Scenario: Login, Book Hotel, and Cancel Booking
  	Given I have launched the browser
    And I have navigated to the Adactin Hotel App login page
    When I take a screenshot of the login page
    And I validate that the login page is launched successfully
    And I get the page text to the console on loginpage
    And I enter the valid username and password
    And I click on the login button
    Then I should be logged into the website successfully
    And I get the page text to the console on searchhotelpage
    When I take a screenshot of the searchhotelpage
    And I select the location
    And I select the hotel
    And I select the room type
    And I select the number of rooms
    And I enter the check-in date
    And I enter the check-out date
    And I select the number of adults per room
    And I select the number of children per room
    And I click on the search button
    Then I should be on the select hotel page
    And I get the page text to the console on select hotel page
    When I take a screenshot of the current page on select hotel page
    And I select the hotel by clicking on the radio button
    And I click on the continue button
    Then I should be on the book a hotel page
    And I get the page text to the console on book a hotel page
    When I take a screenshot of the current page on book a hotel page
    And I enter the first name
    And I enter the last name
    And I enter the billing address
    And I enter the credit card number
    And I enter the CVV
    And I select the credit card type
    And I select the expiry date
    And I click on the book now button
    Then I should be on the booking confirmation page
    And I get the page text to the console on booking confirmation page
    When I take a screenshot of the current page on booking confirmation page
    And I verify that all the given booking details are correct
    When I click on my itinerary
    And I select my booking and click on the cancel button
    And I handle the confirmation alert by clicking OK to cancel the booking
    When I take a screenshot of the cancellation confirmation
    And I click on the logout button
    Then I should be logged out of the application
    And I click on the login button again
    When I take a screenshot of the current page
	