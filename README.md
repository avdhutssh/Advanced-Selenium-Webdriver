# Advanced Selenium WebDriver Framework

This repository contains an advanced Selenium WebDriver framework built using TestNG.

## Overview

The framework implements a full-stack test automation approach, following best practices such as the Page Object Model (POM) and utilizing tools like Log4j for logging, TestNG for testing, and data-driven testing techniques. The framework is designed to be modular, scalable, and maintainable, allowing easy extension and integration with CI/CD pipelines.

## Features

- **Selenium Base Test**: A base test class that sets up the Selenium WebDriver environment.
- **Page Object Model (POM)**: All web pages are represented as classes with methods that interact with the elements on the page.
- **TestUtilities**: Utility classes to handle common tasks like taking screenshots, reading data from files, and interacting with browser cookies.
- **Browser Driver Factory**: Factory pattern implementation for initializing WebDriver instances for different browsers.
- **Parallel Test Execution**: TestNG is configured to run tests in parallel, improving execution time.
- **Data-Driven Testing**: Supports testing with data from CSV files, Excel spreadsheets, and TestNG DataProviders.
- **Logging with Log4j**: Detailed logging of test execution for easier debugging and analysis.
- **Headless Browser Testing**: Supports running tests in headless mode for faster execution in CI/CD environments.
- **Test Reports**: TestNG and custom listeners generate detailed test reports.

## Project Structure

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
