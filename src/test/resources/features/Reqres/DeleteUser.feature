Feature: Delete User

  #Delete User
  @Tugas
  Scenario Outline: Delete user with valid user id
    Given Delete user with valid user id <id>
    When Send request delete user
    Then Status code should be 204
    Examples:
      | id |
      | 1  |