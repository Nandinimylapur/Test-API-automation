Feature: Add Authors

  @Author
  Scenario: Add Author in the Author list
    Given Author id is 1
    And Author book id is "2"
    And Author firstname is "Dakshesh"
    And Author lastname is "Dalwadi"

  @Author1
  Scenario Outline: Add authors in list
    Given Author details are like id: <id> and bookId <bookId> and firstname <firstname> and lastname <lastname>
    When Perform the POST call on Authors api
    Then Verify response of Authors api
    Examples:
      | id | bookId | firstname | lastname |
      | 1  | 2      | "Dakshesh"  | "Dalwadi"  |
      | 2  | 3      | "Nandini"   | "Maylapur" |
      | 5  | 5      | "ABC"   | "ABC" |




