# Selenium POM Test Framework

UI Test Automation Framework built with **Java, Selenium WebDriver, TestNG, Maven and Allure Reports**.

This project demonstrates a scalable test automation architecture using **Page Object Model (POM)**, logging, listeners and cross-browser execution.

---

## Tech Stack

* Java 17
* Selenium WebDriver
* TestNG
* Maven
* Allure Reports
* SLF4J / Logback
* Page Object Model (POM)

---

## Project Structure

```
src
 ├── main
 │   └── java
 │       └── com.internethero
 │           ├── config
 │           │   ├── ApplicationManager
 │           │   ├── Config
 │           │   └── DriverFactory
 │           │
 │           ├── pages
 │           │   ├── BasePage
 │           │   ├── ContextMenuPage
 │           │   ├── DragAndDropPage
 │           │   ├── DropdownListPage
 │           │   ├── FileUploadPage
 │           │   ├── FramePage
 │           │   ├── HomePage
 │           │   ├── HorizontalSliderPage
 │           │   ├── HoverPage
 │           │   └── JavaScriptAlertsPage
 │           │
 │           └── utils
 │               ├── AllureUtils
 │               └── MyListener
 │               
 └── test
     └── java
         └── com.internethero.tests
             ├── ContextMenuTests
             ├── DragAndDropTests
             ├── DropdownListTests
             ├── FileUploadTests
             ├── FrameTests
             ├── HorizontalSliderTests
             ├── HoverTests
             ├── JavaScriptAlertTests
             └── TestBase
```

---

## Features

* Page Object Model architecture
* Cross-browser support
* Centralized driver configuration
* TestNG test execution
* Logging with SLF4J
* Automatic screenshots on failure
* Allure reporting

---

## Test Application

Tests are executed against:

```
https://the-internet.herokuapp.com
```

This application contains various UI elements used for automation practice.

---

## Running Tests

Run tests using Maven:

```
mvn clean test
```

---

## Generate Allure Report

After running tests, generate the report:

```
allure serve allure-results
```

This command will start a local server and open the report in your browser.

---

## Example Allure Report

The report contains:

* test execution details
* step logs
* screenshots on failure
* stack traces

---

## Author


### Maksims Panfilovs

**Software QA Automation Engineer**

Berlin, Germany
