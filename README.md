# CIQAutomation

### to run the tests execute below command
    mvn clean test

### to run the tests of a specific group
    mvn clean test -Dgroups=<groupname>

### to generate allure report run below commands

    allure generate allure-results -c -o allure-report
    allure open allure-report 

