Feature: Create new account

Background:
  Given I open website

  Scenario Outline: Enter details and create new account
     Given I enter email id "ekta.ahuja92@gmail.com"
#    When I enter "<firstname>" "<lastname>" "<password>" "<address>" "<city>" "<zip>" "<phone>" "<alias>"
    When I enter following registration details:
      | First name | <firstname> |
      | Last name  | <lastname>  |
      | Password   | <password>  |
      | Address    | <address>   |
      | City       | <city>      |
      | Zip        | <zip>       |
      | Phone      | <phone>     |
      | Alias      | <alias>     |
    Then I create new account and signout

    Examples:
      | firstname | lastname | password      | address | city | zip   | phone   | alias |
#      | Ekta      | Ahuja    | Samsung180590 | Dubai   | NY   | 10001 | 1234567 | Ekta  |
    | Sandeep   | Ahuja    | Samsung180590 | Dubai   | NY   | 10001 | 1234567 | Sandeep  |




