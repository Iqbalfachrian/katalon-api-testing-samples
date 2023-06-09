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

@tag1
Feature: PUT API TESTING
  I want to use this template for my feature file

  @tag2
  Scenario: Testing API PUT Method
    Given I want to update a user
    When I send a PUT request to 'https://reqres.in/api/users/2' with the following data:
      | key         | value              |
      | name        | Iqbal Fachrian     |
      | job         | Senior QA Engineer |
    Then the PUT response status code should be 200
