Feature: Modular Selenium tests

  Scenario: Run only login test
    Given I run the login test

  Scenario: Run checkbox and auth
    Given I run the checkboxes test
    Given I run the basic auth test

  Scenario: Run context-menu test
    When I run the context-menu test

  Scenario: Run dropdown test
    Then I run the dropdown test

  Scenario: Run new-window test
    When I run the new-window test

  Scenario: Run file-upload test
    Then I run the file-upload test

  Scenario: Run iframe test
    When I run the iframe test

  Scenario: Run infinite-scroll test
    Then I run the infinite-scroll test

  Scenario: Run JS-error-logs test
    Then I run the js-error-logs test
