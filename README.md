# Selenium Automation Test Suite

This project is a Java-based Selenium automation test suite for interacting with various web components on [The Internet Herokuapp](https://the-internet.herokuapp.com/). It uses Cucumber for behavior-driven development (BDD) and includes end-to-end UI tests with feature definitions, step implementations, hooks, and test runners.

## 📂 Project Structure

- `App.java` – Core class that runs a variety of standalone Selenium tests like login, checkboxes, basic auth, alerts, dropdowns, file upload, iframe interaction, and JS error logging.
- `TestActions.java` – Helper class containing common Selenium interactions for reuse across step definitions.
- `StepDefinitions.java` – Step implementations linked to Gherkin feature files.
- `seleniumTests.feature` – Cucumber feature file describing test scenarios in Gherkin syntax.
- `Hooks.java` – Cucumber hooks to set up and tear down WebDriver before/after each scenario.
- `TestRunner.java` – JUnit test runner class for executing Cucumber feature files.
- `AppTest.java` – Sample unit test file (can be extended for further testing).

## 🚀 Getting Started

### Prerequisites

- Java 11+
- Maven or Gradle
- Chrome Browser
- ChromeDriver (make sure it's available in your system `PATH` or in the project root)

✅ Sample Output
pgsql
Copy
Edit
Login Test Passed: true  
Basic Auth Success: true  
Context Menu Alert: You selected a context menu  
Dropdown selected: Option 2  
New window title: New Window  
File Upload Success: true  
IFrame input verified  
Scroll completed  
JavaScript error logged  
All tasks executed!



### Setup


1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/selenium-automation-suite.git
   cd selenium-automation-suite

## Run Cucumber BDD Tests

- mvn test


