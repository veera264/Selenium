Feature: Register account in tutorialsNinja
@Reg
  Scenario: Register with valid data
    Given i navigate to register page
    When i enter below details
      | firstname | vickram          |
      | lastname  | k                |
      | email     | vick23@gmail.com |
      | Telephone |         83247239 |
      | password  |           123123 |
    And i select check box
    And i click continue
