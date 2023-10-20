# SW-Assessment
## Overview of the project
I have implemented selenium as automation framework in java language which include the POM and design pattern and BDD framework to define the testcase and description. I also have implemented the allure report for reporting you can run and view the report Once the test run cycle is complete it generates the allure results following are the instruction to generate reports
  - Open the cmd as an administration and run the report using the allure server allure-results
  - Now you can view the report
  - You can view the download the demo video from this link (https://we.tl/t-FJ9auwZSv9)
- I have implemented the following test cases
  - Login 
    - Login with valid credentials
    - Login with Invalid username
    - Login with Invalid password
    - Login with Empty credentials
  - Cart
    - Add item to the cart and verify the item
    - Add multiple items to the cart and verify the items
    - Add multiple items to the cart and verify the count
    - Proceed to checkout from the cart
## Required tools 
You need the following tools 
 - Download the latest version of IntelliJ IDEA Community Edition
 - Download and install Java "17.0.1" (TM) SE Development Kit in the default folder
 - Download and Install Git Bash
## Instruction to run the project
Following are the instruction to run this project
  - Create a folder on the disk
  - open the git bash
  - Clone the project using git bash and run the command git clone https://github.com/HamzaShakil/SW-Assessment.git
  - Open the above project using IntelliJa (Please note once you clone it open the project in IntelliJ from inside the folder)
  -  Now you need to configure the SDK
    - Open File>Setting>Project Structure
    - Click edit in SDK
    - Select the path where you install the JDK
  - Now go to the POM.xml file and install the dependencies by clicking the "M" with the refresh icon
  -  Install the following plugins using Intellij
    - Cucumber for Java
    - Gherkin
 - Once all the errors resolve run the test runner file test>java>Runners>TestRunner by right click on it and select "Run TestRunner"

