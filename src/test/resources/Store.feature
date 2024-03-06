Feature: Agregar producto al carrito de compras
  Scenario: Añadir producto al carrito
    Given que estoy en la pagina
    When anadir al carrito de productos al azar
    Then se agrega el numero de productos del carrito


  Scenario: Eliminar un producto del carrito de compras
    Given que estoy en la pagina
    When anadir un producto al carrito
    When hago clic en el botón de eliminar junto al producto que deseo quitar
    Then el producto es eliminado del carrito de compras

    Scenario Outline: Cambiar la divisa
      Given que estoy en la pagina
      When eligo la divida en "<divisa>"
      Then se muestran los productos con la divisa eligida
      Examples:
        |divisa|
        |      "€ Euro"|
        |£ Pound Sterling|
        | $ US Dollar    |










