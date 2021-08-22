Feature: login omayo.blogsport
@Smoke11
  Scenario Outline: usershould be login only when give valid credentials
    Given i ender into application
    When i scrool down and find "<username>" and "<password>" into fields
    And i click on login button
    Then i login to the "<condition>" selenium143 page

    Examples:                              # sending multiple data            
    
      | username       | password | condition |
      | veera          |     1234 | Fail      |						
      | SeleniumByArun | Test143$ | pass      |

 