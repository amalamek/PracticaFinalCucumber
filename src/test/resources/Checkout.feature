Feature: probar el funcionamiento de checkout

  Background:
    Given que estoy en la pagina
    And Hago una compra
    When hago click al Checkout
#        PagesFactory.getInstance().getCheckoutPage().fillCheckoutForm("laila","la","laila@gmail.com","0987543332","hiberus","fnideq56","kondissa","fndq","93102","Morocco","Chaouen");
  Scenario Outline: Checkout como guest
    And eligir guest
    And completo el formulario del checkout guest con "<name>" y "<last>" y "<gmail>" y "<phone>" y "<company>" y "<ad1>" y "<ad2>" y "<city>" y "<post>" y "<country>" y "<region>"
    Then se redirigo a la pagina de checkout exitoso
    Examples:
    |name     |last    |gmail          |phone    |company   |ad1   |ad2    |city      |post    |country    |region|
    | Moncef  |  amza  | amza@gmail.com|09875    |  babel   | tet  | tet1  | tetouan  | 5432   |  Morocco  |  Tetouan     |


  Scenario Outline: Checkout como cliente registrado
    And eligir cliente y hacer login con "<name>" y "<gmail>"
    And completo el formulario del checkout registrado
    Then se redirigo a la pagina de checkout exitoso
    Examples:
      |name        |gmail          |
      | sabahsabah | sabah@gmail.com |

  Scenario Outline: Checkout como cliente no registrado
    And eligir register
    And completo el formulario del checkout no registrado con "<name>" y "<last>" y "<gmail>" y "<phone>" y "<pass>" y "<confipass>" y "<company>" y "<ad1>" y "<ad2>" y "<city>" y "<post>" y "<country>" y "<region>"
    Then se redirigo a la pagina de checkout exitoso
    Examples:
      |name     |last    |gmail          |phone  |pass  |confipass|company   |ad1   |ad2    |city      |post    |country    |region|
      | mohamedo |  amk  | iiiiiiii@gmail.com|09875   |   mmmmmmmm  |     mmmmmmmm    | babel   | tet  | tet1  | tetouan  | 5432   |United States  |Florida     |





