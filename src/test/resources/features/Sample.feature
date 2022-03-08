#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios. // Suite : 
#Scenario: Business rule through list of steps with arguments. // test
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios // before test
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Addition two numbers
  I am performing addition of two numbers

  @tag1
  Scenario: Add two numbers
    Given Passing two number to addition
    Then Numbers added successfully

  @tag2
  Scenario Outline: Add two numbers
    Given I want to add <Number1> and <Number2>
    Then Addition should be <Answer>

    Examples: 
      | Number1  | Number2 | Answer  |
      | 15		 	 |     15  | 30 		 |
      | 30 			 |     30  | 60      |
      | 12		 	 |     16  | 10 		 |
      | 33 			 |     37  | 20      |
      | 14		 	 |     18  | 80 		 |
      | 35 			 |     39  | 90      |
