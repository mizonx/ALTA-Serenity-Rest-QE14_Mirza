Feature: Get single user
  Get single user with valid user
#  Positive
  @Tugas
  Scenario: Get single user with valid user
    Given Get single user with valid id 2
    When Send request get single user
    Then Status code should be 200

#    Negative
  @Tugas
  Scenario: Get single user with invalid user
    Given Get single user with invalid id "b2"
    When Send request get single user
    Then Status code should be 400