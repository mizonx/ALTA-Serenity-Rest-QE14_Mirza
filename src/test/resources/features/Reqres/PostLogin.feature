Feature: Login user


  # Positive
  # Login - Succesful
  @Tugas
  Scenario: Login succesful
    Given Login user with email and password with valid json "LoginUserValid.json"
    When Send request post login
    Then Status should be 200
    And Validate json schema "LoginEmailPasswordSchema.json"



  # Negative
  # Login - Unssuccesful
  @Tugas
  Scenario Outline: Post login user with invalid email
    Given : Login user with invalid "<JSON>"
    When Send request post login
    Then Status should be 200
    Examples:
      |                                   | JSON                                    |
      | Invalid Email  and Valid Password | LoginUserInvalidEmail.json              |
      | Invalid Email  and Valid Password | LoginUserInvalidPassword.json           |
      | Invalid Email  and Valid Password | LoginUserInvalidAndInvalidPassword.json |