Feature: Register User


  #Positive
  #Regisgter_Succesful
  @Tugas
  Scenario Outline: Post Register succesful
    Given Register user with valid json "RegisterUserValid.json"
    When Send request post login
    Then Status should be 200
    And Response body name should be <id>
    And Validate json schema "RegisterValidSchema.json"
    Examples:
      | id |  |
      | 4  |  |


    #Negative
    #Register_UnSuccesful
  @Tugas
  Scenario Outline: Post Register uncessfull
    Given Register user with invalid json "<JSON>"
    When Send request post login
    Then Status should be 404
    Examples:
      | JSON                                     |
      | RegisterUserInvalidEmail.json            |
      | RegistetUserInvalidPassword.json         |
      | RegisterUserInvalidEmailAndPassword.json |


