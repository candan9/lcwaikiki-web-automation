@e2e @Reggression
Feature: Login Page

  @e2eMakeOrder
  Scenario Outline: e2e making order test
    Given user is opened LcWaikiki App
    And should see "<section-login>" title next
    When click "<section-login>" button to navigate login page
    And type "<email>" in email input
    And type "<password>" in password input
    And click login button
    Then user see logged in that "<my-name>" on top of page
    When focus "<category-name>" category
    And click "<branch>" branch
    And filter "<color>" color
    Then user see products
    When click a product
    And select "<size>" size
    And click add to basket
    And go to cart
    Then user verifies that product information is correct on cart
    When go to payment phase
    Then user should see payment screen
    Examples:
      | section-login | email               | password     | my-name | category-name | sub-category-name | branch | color | filter-name | size |
      | Giriş Yap     | emrecndn9@gmail.com | Ee1234012400!| Emre    | Kadın         | Giyim             | Bluz   | Siyah | Renk        | M    |