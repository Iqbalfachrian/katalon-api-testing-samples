#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: API TESTING
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Testing API GET Method
    Given I want to retrieve user information
    When I send a GET request to "https://reqres.in/api/users/2"
    Then the response status code should be 200
    And the response body should contain the following data:

    Examples: 
       | id | 2     |
      | email | janet.weaver@reqres.in |
      | first_name | Janet |
      | last_name | Weaver |
      | avatar | https://reqres.in/img/faces/2-image.jpg |