Feature: probar el funcionamiento de login
Background:
  Given que estoy en la pagina
  And estoy dirigido a la pagina de Login

  Scenario Outline: Login user exitoso

    When completo el formulario de inicio de sesión con el correo electrónico "<gmail>" y la contraseña "<pass>"
    And hago login
    Then se dirigo a la pagina login

    Examples:
      | gmail           | pass      |
      | sabah@gmail.com | sabahsabah|

  Scenario Outline: Login user fallado

    When completo el formulario de inicio de sesión con el correo electrónico "<gmail>" y la contraseña "<pass>"
    And hago login
    Then se muestra un mensaje de error
    Examples:
      | gmail           | pass      |
      | sabah@gmail.com | sabahsa|