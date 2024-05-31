# Selenium Cucumber Test Automation Project


## Overview
This project is a test automation framework built using Selenium, Cucumber, and TestNG. It is designed to automate the UI testing of a web application.


## Prerequisites
- JDK 17
- Maven
- ChromeDriver (ensure it's compatible with your Chrome browser version)


## Project Structure
The project is organized into the following packages:
- **actions**: Contains classes with actions for each page.
- **pages**: Contains classes for locating elements on each page.
- **steps**: Contains classes with the implemented steps.
- **runner**: Contains the class for Cucumber runner setups.
- **features**: Contains feature files written in Gherkin syntax.


## Dependencies
- **Java 17**
- **Maven**
- **Selenium 4.16.1**
- **Cucumber 7.18.0**
- **TestNG 7.10.2**


## Running the Tests
- Add the correct path to the features directory "{path-to-the-project}/src/main/resources/features"}
- You can run the Cucumber tests directly from your IDE by right-clicking on the CucumberRunnerTests class and selecting Run 'CucumberRunnerTests'.

