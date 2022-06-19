@e2e @Reggression
Feature: e2e make order tests

  @e2eMakeOrder
  Scenario Outline: e2e make order test
    Given user is opened LcWaikiki Website
    And should see "<section-login>" title next
    When click "<section-login>" button to navigate login page
    And type "<email>" in email input
    And type "<password>" in password input
    And click login button
    Then user see logged in that "<my-account>" on top of page
    When focus "<category-name>" category
    And click "<branch>" branch
    And filter "<color>" color
    Then user see products
    When click a product
    And select "<size>" size
    And click add to basket
    And go to cart
    Then user verifies that product information,product code,"<count>","<size>" , is correct on cart
    When go to payment phase
    Then user should see payment screen
    Examples:
      | section-login | email               | password     | my-account | category-name | branch | color | size | count |
      | Giriş Yap     | emrecndn9@gmail.com | Ee1234012400!| Hesabım    | KADIN         | Bluz   | Siyah | M    | 1     |