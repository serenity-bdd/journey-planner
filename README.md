# Serenity Cucumber Starter project

[![CircleCI](https://circleci.com/gh/serenity-bdd/serenity-cucumber-starter.svg?style=svg)](https://circleci.com/gh/serenity-bdd/serenity-cucumber-starter)

This is a simple demo project illustrating Serenity BDD and Cucumber web testing.

## Get the code

Git:

    git clone https://github.com/serenity-bdd/serenity-cucumber-starter.git
    cd serenity-cucumber-starter


Or simply [download a zip](https://github.com/serenity-bdd/serenity-cucumber-starter/archive/master.zip) file.

## Use Maven

Open a command window and run:

    mvn clean verify

This runs Cucumber features using Cucumber's JUnit runner. The `@RunWith(CucumberWithSerenity.class)` annotation on the `CucumberTestSuite`
class tells JUnit to kick off Cucumber.

## Use Gradle

Open a command window and run:

    gradlew test aggregate

This runs Cucumber features using Cucumber's JUnit runner. The `@RunWith(CucumberWithSerenity.class)` annotation on the `CucumberTestSuite`
class tells JUnit to kick off Cucumber.

## Viewing the reports

Both of the commands provided above will produce a Serenity test report in the `target/site/serenity` directory. Go take a look!
