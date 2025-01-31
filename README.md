# SelXPro

## Overview

This is a Selenium-based automation framework designed using the Page Object Model (POM) pattern. It ensures maintainability, scalability, and reusability by separating locators from test logic. The framework includes explicit waits, logging, and structured reporting using ExtentReports.

## Project Structure

```
|-- src/test/java
|   |-- basepack
|   |   |-- BaseTest.java  # Handles browser setup and teardown
|   |   |-- BasePage.java  # Handles all page specific common methods
|   |   |-- I.java         # Wrapper class for Selenium actions
|   |-- pageobjects
|   |   |-- LoginPage.java  # Example Page Object Class (Only locators)
|   |   |-- HomePage.java   # Example Page Object Class (Only locators)
|   |-- scripts
|   |   |-- LoginTest.java  # Example Test Class
|   |-- extentUtils      # Extent reports configuration classes
|   |-- utils            # Common utility classes
|-- testng.xml
|-- build.gradle
|-- gradlew.bat
|-- README.md
```

## Design Guidelines

- **Page Classes:** Store only locators for UI elements. Do not add test logic or event-specific methods.
- **Wrapper Class (****`I.java`****)**: Contains reusable methods for UI interactions (e.g., click, sendKeys, scrollTo) with embedded explicit waits and logging.
- **BaseTest:** Handles browser setup, teardown, and test initialization.

## Dependencies

- **Selenium WebDriver**
- **TestNG**
- **Gradle**
- **ExtentReports**

## Running Tests

Tests are grouped using tags (`@Smoke`, `@Regression`, `@Bug`, etc.). Use the following command to execute specific test groups:

```sh
./gradlew.bat clean --info test -PincludeGroupNames="smoke,regression" -PexcludeGroupNames="bug"
```

## Logging & Reporting

- **Logging:** Every UI interaction is logged using ExtentReports.
- **Reports:** Detailed test execution reports are available under the `reports/` directory.

## Adding New Test Cases

1. Create a new test class under `src/test/java/tests/`.
2. Use `@Test(groups = { "smoke" })` to categorize your test.
3. Utilize the `I` class methods for UI interactions instead of writing raw Selenium code.
4. Execute tests using the Gradle command mentioned above.

## Contributing

1. Ensure all new locators are added only to the respective Page Object classes.
2. Use existing wrapper methods in `I.java` for UI actions instead of adding direct Selenium calls.
3. Follow the POM structure to maintain consistency across test cases.

---

This framework provides a structured approach to UI test automation with maintainability, scalability, and efficiency in mind.

