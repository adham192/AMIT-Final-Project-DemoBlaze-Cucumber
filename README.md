# AMIT-DemoBlaze-Final-Project-Cucumber
## DemoBlaze Automation
This project automates test cases for the [Demoblaze website](https://www.demoblaze.com/) using Java, Selenium WebDriver, and the Page Object Model (POM) design pattern. It validates key functionalities, including user signup, product purchasing, and cart operations, ensuring the system performs as expected.

Scenarios Covered
1. User Signup
- Ensures users can sign up successfully.
  - Displays a success message: "Sign up successful."
2. Purchase Two Products
- Step 1: Login
  - Validates user login with accurate credentials.

- Step 2: Add Products to Cart
  - Confirms products are successfully added to the cart.

- Step 3: Cart Validation
  - Ensures both products are displayed in the cart with correct details and prices.

- Step 4: Checkout
  - Validates the total amount calculation.
  - Completes the purchase with confirmation: "Thank you for your purchase!"

## Tools and Technologies
- Programming Language: Java
- Automation Framework: Selenium WebDriver
- Test Framework: TestNG
- Behavior-Driven Development: Cucumber (BDD)
