Feature: Cart and account actions

Background:
  Given I open website

@ekta
  Scenario Outline: Add item to cart
    Given I enter "<email>" and "<password>"
    When I open home page
    Then I select item and add to cart
    Examples:
      | email                  | password      |
      | ekta.ahuja90@gmail.com | Samsung180590 |


  Scenario Outline: Adding new address
    Given I enter "<email>" and "<password>" and I click on address
    When I enter details of address "<address>" "<city>" "<zip>" "<phone>" "<alias>"
    Then address is added and logout

    Examples:
      | email                  | password      |address | city | zip   | phone     | alias |
      | ekta.ahuja90@gmail.com | Samsung180590 |Texas12   | TX   |10001  |528379698  |Office1 |



  Scenario Outline: Send message using contact us button
    Given I enter "<email>" and "<password>" and I click on contact us
    When I enter details anc send
    Then I see successful message
    Examples:
      | email                  | password      |
      | ekta.ahuja90@gmail.com | Samsung180590 |


  Scenario Outline: Subscribe to newsletter
    Given I login using "<email>" and "<password>"
    When I enter "<email>" in text box
    Then I see successful message and I logout
  Examples:
  | email                  | password      |
  | ekta.ahuja90@gmail.com | Samsung180590 |

  Scenario Outline: check credit slips
    Given I login using "<email>" and "<password>"
    And I open credit slip page
    When I see message of no credit slips
    Then I logout
  Examples:
  | email                  | password      |
  | ekta.ahuja90@gmail.com | Samsung180590 |


@Notworking
  Scenario Outline: Add to wishlist
    Given I login using "<email>" and "<password>"
    When I open particular item
    Then I click on Add to wishlist
    And I logout


    Examples:
      | email                  | password      |
      | ekta.ahuja90@gmail.com | Samsung180590 |


  Scenario Outline: View my wishlist
    Given I login using "<email>" and "<password>"
    When I open wishlist and click on view
    Then Click on send and enter email addresses "<email1>" "<email2>"
    And click on send
    And I logout

    Examples:
      | email                  | password      |  email1               | email2      |
      | ekta.ahuja90@gmail.com | Samsung180590 |ekta.ahuja90@gmail.com |test@test.com|


  Scenario Outline: verify cart with empty message
    Given I login using "<email>" and "<password>"
    When I open cart and verify message
    Then If cart is Empty I sign out

    Examples:
      | email                  | password      |
      | ekta.ahuja90@gmail.com | Samsung180590 |


