Feature: login into tutorial ninja application

@All  @Ninja123
  Scenario: login to the application with valid credentials
    Given i navigate to login page of application
    When i enter email as "veera12@gmail.com" and password as "1234512345"
    And i click on login button2
    Then i login to the application
