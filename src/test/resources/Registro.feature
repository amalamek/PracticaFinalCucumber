Feature: probar el funcionamieto de register

  Scenario Outline: Registering a new user with success
    Given que estoy en la pagina
    And  estoy dirigido a la pagina de registracion
    When I fill in the registration form with valid information with "<name>" and "<last>" and "<email>" and "<phone>" and "<pass>" and "<confp>"
    And I submit the registration form
    Then I should see a confirmation message

    Examples:
      | name     | last  | email            | phone    | pass     |confp    |
      | abd    | slam | abdslam@gmail.com | 08764321 | 12345678  | 12345678|

  Scenario Outline: Registering a new user with failed username or lastname
    Given que estoy en la pagina
    And  estoy dirigido a la pagina de registracion
    When I fill in the registration form with valid information with "<name>" and "<last>" and "<email>" and "<phone>" and "<pass>" and "<confp>"
    And I submit the registration form
    Then I should see a error message about the number of caracters

    Examples:
      | name     | last  | email            | phone    | pass      |confp    |
      |      |           | malika@gmail.com | 08764321 | 12345678    |12345678  |

  Scenario Outline: Registering a new user with unmatched passwords
    Given que estoy en la pagina
    And  estoy dirigido a la pagina de registracion
    When I fill in the registration form with valid information with "<name>" and "<last>" and "<email>" and "<phone>" and "<pass>" and "<confp>"
    And I submit the registration form
    Then I should see a error message about the incorrect passwords

    Examples:
      | name     | last  | email            | phone    | pass      |confp    |
      | nore      | yasin | register@gmail.com | 08764321 | 12  |123  |
    #  | omar      | chrif | omarchrif@gmail.com | 08764321 | 12  |12 |

