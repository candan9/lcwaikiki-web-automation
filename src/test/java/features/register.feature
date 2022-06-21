@RegisterPage @Regression
Feature: Register Page

  @RegisterUnCheckContract
  Scenario Outline: Register Uncheck Contract
    Given user is opened LcWaikiki Website
    And should see "<section-login>" title next
    When click "<section-login>" button to navigate login page
    And click Register button to navigate register page
    And type "<email>" in email input
    And type "<password>" in password input
    And type "<phone>" in phone input
    And click Register button
    Then see contract error "<contract-error>"
    Examples:
      | section-login | email              | password | phone      | contract-error                                     |
      | Giriş  Yap    | emrecndn@gmail.com | test1234 | 5066368558 | Kullanım ve Gizlilik Sözleşmesini onaylamalısınız. |

  @RegisterWithoutEmail
  Scenario Outline: Register Without Email
    Given user is opened LcWaikiki Website
    And should see "<section-login>" title next
    When click "<section-login>" button to navigate login page
    And click Register button to navigate register page
    And type "<password>" in password input
    And type "<phone>" in phone input
    And check contracts
    And click Register button
    Then see email error "<email-error>"
    Examples:
      | section-login | password | phone      | email-error                                |
      | Giriş Yap     | test1234 | 5066368558 | Lütfen geçerli bir e-posta adresi giriniz. |

  @RegisterWithInvalidEmail
  Scenario Outline: Register Without Email
    Given user is opened LcWaikiki Website
    And should see "<section-login>" title next
    When click "<section-login>" button to navigate login page
    And click Register button to navigate register page
    And type "<email>" in email input
    And type "<password>" in password input
    And type "<phone>" in phone input
    And check contracts
    And click Register button
    Then see email error "<email-error>"
    Examples:
      | email | section-login | password | phone      | email-error                                |
      | assaf | Giriş Yap     | test1234 | 5066368558 | Lütfen geçerli bir e-posta adresi giriniz. |

  @RegisterWithoutPassword
  Scenario Outline: Register Without Password
    Given user is opened LcWaikiki Website
    And should see "<section-login>" title next
    When click "<section-login>" button to navigate login page
    And click Register button to navigate register page
    And type "<email>" in email input
    And type "<phone>" in phone input
    And click Register button
    Then see password error "<password-error>"
    Examples:
      | section-login | email                  | phone      | password-error        |
      | Giriş  Yap    | testemre1234@gmail.com | 5066368558 | Lütfen şifre giriniz. |

  @RegisterWithInvalidPassword
  Scenario Outline: Register Without Password
    Given user is opened LcWaikiki Website
    And should see "<section-login>" title next
    When click "<section-login>" button to navigate login page
    And click Register button to navigate register page
    And type "<email>" in email input
    And type "<password>" in password input
    And type "<phone>" in phone input
    And click Register button
    Then see password error "<password-error>"
    Examples:
      | section-login | email                  | password | phone      | password-error                                                     |
      | Giriş  Yap    | testemre1234@gmail.com | 12345678 | 5066368558 | Şifreniz harf ile rakam içermeli ve en az altı karakter olmalıdır. |
  @RegisterWithoutPhone
  Scenario Outline: Register Without Phone
    Given user is opened LcWaikiki Website
    And should see "<section-login>" title next
    When click "<section-login>" button to navigate login page
    And click Register button to navigate register page
    And type "<email>" in email input
    And type "<password>" in password input
    And click Register button
    Then see phone error "<phone-error>"
    Examples:
      | section-login | email                  | password  | phone-error                        |
      | Giriş  Yap    | testemre1234@gmail.com | test12345 | Lütfen telefon numaranızı giriniz. |