Feature: PurchasingTwoProducts Feature
  Scenario: Verify that Two Products Are Purchased Successfully
    Given user click on login in the header
    When user enters "adhamkl" and "123" and click login
    Then verify that user logged in successfully
    And user clicks on laptops categories then user selects the first laptop and adds the first laptop to the cart
    And user clicks on the cart in the header then checks that the first laptop is added to the cart
    And click on home button in the header then user clicks on laptops categories then user clicks on the second laptop and adds the second laptop to the cart
    And user clicks on the cart in the header then checks that the second laptop is added to the cart then checks that the total price is correct
    And click on place order button and write name "Adham" and write country "Egypt" and city "Cairo" and credit card "123462" and month "12" and year "2024" and click on purchase button and click ok

