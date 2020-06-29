@API

Feature: Search for the Department for Work and Pensions
  As a User, I want to perform search using API
  So that the displayed results are accurate and will be correctly populated on the UI

  Background: User has to be on the base uri
    Given user is on the base URI

  Scenario Outline: Search with the valid city
    When the user searches with the city "<City>" string
    Then the success code 200 should be displayed to the user along with the Success message and the correct response headers

    Examples:
      | City       |
      | Manchester |
      | London     |

  Scenario Outline: Search city with the wrong manually entered incorrect location path
    When the user searches with the city "<City>" string
    Then the error code 404 should be displayed to the user along with the error message "<error_message>" and the correct response headers

    Examples:
      | City        | error_message                                 |
      | /Manchester | The requested URL was not found on the server |

  @Positive
  Scenario: Check the response code and response body for the Instruction
    When the user sends the get request to fetch the instructions
    Then the success code 200 along with the correct response body and the correct response headers should be displayed

  @Positive
  Scenario Outline: Search with the valid User ID
    When the user searches with the id "<USERID>"
    Then the success code 200 along with the matching user record and the correct response headers should be displayed

    Examples:
      | USERID |
      | 15     |
      | 16     |


  @Negative
  Scenario Outline: Search with the valid User ID
    When the user searches with the id "<USERID>"
    Then the error code 404 along with the error message "<error_message>" and the correct response headers should be displayed

    Examples:
      | USERID | error_message                                 |
      | sd     | Id sd doesn't exist                           |


  @Positive
  Scenario: Get all the available users from the systemresponse code and response body for the users
    When the user sends the get request to fetch all the users
    Then the success code 200 along with all the available users and the correct response headers should be displayed