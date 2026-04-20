Feature: Checkout with valid payment on nopCommerce demo
  As a registered customer on nopCommerce
  I want to complete my purchase with a valid payment method
  So that I can successfully place an order

  Background:
    Given the user has added a product to the shopping cart

  Scenario: Successful checkout with valid credit card
    When the user navigates to the shopping cart
    And clicks on "Checkout"
    And enters valid billing address details
    And selects "Ground" as Shipping Method
    And selects "Check" as the payment method
    And clicks on "Confirm"
    And finally clicks on "Continue"
    Then the system should display an order confirmation message
    And show an order number