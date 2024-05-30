# Created by Kristina Stoyanova at 28.05.24
Feature: User can successfully add and remove products from the cart. Can complete purchase.

  Background:
    Given user is logged in

  Scenario: Card verification
    When the product page is opened
    And user add products to the card
      | product               |
      | Sauce Labs Bike Light |
      | Sauce Labs Onesie     |
      Then the cart is displayed correctly on the product page
        | cart counter |
        | 2            |
    And user remove the products from the cart
      | product               |
      | Sauce Labs Bike Light |
      | Sauce Labs Onesie     |
      Then the cart is displayed correctly on the product page
        | cart counter |
        | null         |
    And user add products to the card
      | product                  |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Bolt T-Shirt  |
      Then the cart is displayed correctly on the product page
        | cart counter |
        | 2            |
    And user navigates to Cart page
      Then the products are displayed correctly
        | product                  | description                                                                                                                                                            | price  |
        | Sauce Labs Fleece Jacket | It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office. | $49.99 |
        | Sauce Labs Bolt T-Shirt  | Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.                        | $15.99 |
    And user navigates to Checkout page
    And user submit the checkout form
      Then the error message is displayed correctly
    And user clears the checkout form
    And user fills in the checkout form
      | first name | last name | code  |
      | Test first | Test last | 12345 |
    And user continue to the checkout overview
      Then the products are displayed correctly
        | product                  | description                                                                                                                                                            | price  |
        | Sauce Labs Fleece Jacket | It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office. | $49.99 |
        | Sauce Labs Bolt T-Shirt  | Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.                        | $15.99 |
      Then the payment information is displayed correctly
        | payment info     | shipping info               | items total        | tax        | total price   |
        | SauceCard #31337 | Free Pony Express Delivery! | Item total: $65.98 | Tax: $5.28 | Total: $71.26 |
    And user finish the order
      Then the order is successful
        | successful order title    | successful order message                                                                |
        | Thank you for your order! | Your order has been dispatched, and will arrive just as fast as the pony can get there! |
    And user logged out






