Feature: life of a software tester							#Feature file

@Smoke
  Scenario: i am good tester boss loves me
    Given i am a "good" software tester 
    When i go to work
    And i "inolve" with it
    Then my boss "loves" me
@Smoke @All
  Scenario: i am not a good tester boss hate me
    Given i am a "average" software tester
    When i go to work
    And i "work" with it
    Then my boss "ignores" me

  Scenario: i am bad tester boss hate me
    Given i am a "bad" software tester
    When i go to work
    And i "mess" with it
    Then my boss "hates" me