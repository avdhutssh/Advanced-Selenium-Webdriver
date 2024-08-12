<!--
    #/**
    # * @author Avdhut Shirgaonkar
    # * Email: avdhut.ssh@gmail.com
    # * LinkedIn: https://www.linkedin.com/in/avdhut-shirgaonkar-811243136/
    # */
    #/***************************************************/
-->

---

# 💻 Advanced Selenium WebDriver Framework

## 📑 Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Running Tests](#running-tests)
- [Test Reports](#test-reports)
- [Contributions](#contributions)
- [Contacts](#contacts)

## 📖 Introduction

This repository contains an advanced Selenium WebDriver framework built using TestNG.

## 🚀 Features

- **Selenium Base Test**: A base test class that sets up the Selenium WebDriver environment.
- **Page Object Model (POM)**: All web pages are represented as classes with methods that interact with the elements on the page.
- **TestUtilities**: Utility classes to handle common tasks like taking screenshots, reading data from files, and interacting with browser cookies.
- **Browser Driver Factory**: Factory pattern implementation for initializing WebDriver instances for different browsers.
- **Parallel Test Execution**: TestNG is configured to run tests in parallel, improving execution time.
- **Data-Driven Testing**: Supports testing with data from CSV files, Excel spreadsheets, and TestNG DataProviders.
- **Logging with Log4j**: Detailed logging of test execution for easier debugging and analysis.
- **Headless Browser Testing**: Supports running tests in headless mode for faster execution in CI/CD environments.
- **Test Reports**: TestNG and custom listeners generate detailed test reports.

## 📁 Project Structure

```plaintext
src/
├── main/
│   ├── java/
│   │   ├── base/                # Base classes for the framework
│   │   ├── pages/               # Page Object classes
│   │   ├── utils/               # Utility classes for various tasks
│   └── resources/               # Configuration files (e.g., log4j.properties)
└── test/
    ├── java/
    │   ├── tests/               # Test classes
    └── resources/
        ├── testng.xml           # TestNG suite configuration file
        └── data/                # Data files for data-driven testing
```

## ▶️ Getting Started

### Prerequisites

- Java JDK 8 or higher
- Maven
- WebDriver binaries and dependencies in pom.xml
- IDE (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/avdhutssh/Advanced-Selenium-Webdriver.git
   cd Advanced-Selenium-Webdriver
   ```

2. Install dependencies:

   ```bash
   mvn clean install
   ```


## 🚀 Running Tests

You can run the tests using the following Maven command:

```bash
mvn test
```

Alternatively, you can run specific test suites using TestNG XML files:

```bash
mvn test -DsuiteXmlFile=src/test/resources/testng.xml
```

## 📊 Test Reports

TestNG generates a default report in the `target/surefire-reports` directory. You can configure custom reports by integrating tools like Allure or Extent Reports.

## 💡 Contributions

Contributions are welcome! Please fork the repository and submit a pull request to propose changes.


## 📧 Contacts

- [![Email](https://img.shields.io/badge/Email-avdhut.ssh@gmail.com-green)](mailto:avdhut.ssh@gmail.com)
- [![LinkedIn](https://img.shields.io/badge/LinkedIn-Profile-blue)](https://www.linkedin.com/in/avdhut-shirgaonkar-811243136/)

Feel free to reach out if you have any questions or suggestions.

Happy Learning!!!