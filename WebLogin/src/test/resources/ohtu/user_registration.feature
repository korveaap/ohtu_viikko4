Feature: A new user account can be created if a proper unused username and password are given

  Scenario: creation succesful with correct username and password
    Given new user is selected
    When correct username "aapo" and correct password "aapo0opaa" and correct passwordconfirmation "aapo0opaa" are given
    Then user is created and welcome page is displayed

  Scenario: creation fails with too short username and valid passord
    Given new user is selected
    When incorrect username "ap" and correct password "aapo0opaa" and correct passwordconfirmation "aapo0opaa" are given
    Then user is not created and error "username should have at least 3 characters" is reported

  Scenario: creation fails with correct username and too short password
    Given new user is selected
    When correct username "aapo" and short password "aapo0" and passwordconfirmation "aapo0" are given
    Then user is not created and error "password should have at least 8 characters" is reported

  Scenario: creation fails with correct username and password consisting of letters
    Given new user is selected
    When correct username "aapo" and simple password "aapoopaa" and passwordconfirmation "aapoopaa" are given
    Then user is not created and error "password can not contain only letters" is reported

  Scenario: creation fails with already taken username and valid pasword
    Given new user is selected
    When existing username "jukka" and correct password "aapo0opaa" and correct passwordconfirmation "aapo0opaa" are given
    Then user is not created and error "username is already taken" is reported

  Scenario: creation fails when password and password confirmation do not match
    Given new user is selected
    When correct username "aapo" and correct password "aapo0opaa" and incorrect passwordconfirmation "aapo0opaaa" are given
    Then user is not created and error "password and password confirmation do not match" is reported

  Scenario: user can login with succesfully generated account
    Given user with username "liisa" with password "salainen1" is succesfully created
    And login is selected
    When correct username "liisa" and password "salainen1" are given
    Then user is logged in

  Scenario: user can not login with account that is not succesfully created
    Given user with username "aa" and password "bad" is unsuccesfully created
    And login is selected
    When nonexistent username "aa" and password "bad" are given
    Then user is not logged in and error message is given
