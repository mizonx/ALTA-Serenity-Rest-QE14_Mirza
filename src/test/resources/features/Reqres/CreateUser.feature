Feature: Create user


  @Tugas
  #Positive
  #Create User
  Scenario Outline: Post create user wih valid json
    Given Create user with Valid json "CreateUserTugas.json"
    When Send request Create new user
    Then Status code should be 201
    And Response body name should be <name> and "<job>"
    And Validate json schema "CreateUserTugasSchema.json"
    Examples:
      | name   | job    |  |
      | Ranger | Silver |  |

  @Tugas
   #Negative
  Scenario Outline: Post create user wih invalid json
    Given Create user with Valid json "CreateUserTugas.json"
    When Send request Create new user
    Then Status code should be 200





