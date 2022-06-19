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
    When click "<tab-categories>" tab
    And click "<category-name>" category
    And click "<sub-category-name>" sub category
    And click "<branch>" branch
    And click filter button
    And click "<filter-name>" filter
    And filter "<color>" color
    And click color filter
    And click apply filter
    Then user see products
    When click a product
    And click add to basket
    And select "<size>" size
    And click add to basket
    And close product detail
    And go to cart
    Then user verifies that product information is correct on cart
    When go to payment phase
    Then user should see payment screen
    Examples:
      | section-login | email               | password     | my-name  | tab-categories | category-name | sub-category-name | branch | color | filter-name | size |
      | Giriş Yap     | emrecndn9@gmail.com | Ee1234012400!| Emre       | Kategoriler    | Kadın         | Giyim             | Bluz   | Siyah | Renk        | M    |