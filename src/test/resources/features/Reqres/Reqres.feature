Feature: Serenity Rest QE 14

  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list user with parameter page <page>
    When Send request get list users
    Then Status code should be 200
    And Response body page should be <page>
    And Valide json schema "ListUsersJsonSchema.json"
    Examples:
      | page |
      | 1    |
      | 2    |


#//Scenario 2
  Scenario: Post create user with valid json
    Given Create user with valid json "CreateUser.json"
    When Send request create new user
    Then Status code should be 201
    And Response body page should be "Marco Polo" and job is "Qa Engineer"


#//Scenario 3
  Scenario Outline: Update user with valid json and user id
    Given Update user with valid json "<json>" and user id <id>
    When Send request update user
    Then Status code should be 200
    And Response body page should be "<name>" and job is "<job>"

    Examples:
      | id | json             | name                | job                  |
      | 1  | UpdateUser1.json | Marco Polo Update 1 | Qa Engineer Update 1 |
      | 2  | UpdateUser2.json | Marco Polo Update 2 | Qa Engineer Update 2 |
      | 3  | UpdateUser3.json | Marco Polo Update 3 | Qa Engineer Update 3 |

#//Scenario 4
  Scenario: Delete user with valid user id
    Given Delete user with user id 2
    When Send request delete user
    Then Status code should be 204