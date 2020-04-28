This repository Contains Test Driven Development Framework with Page object Design pattern(POM) with TESTNG annotaion build on Maven project.

POM concept : As name suggest in this pattern no of classes is created for every pages in functionality in pages package and same no of classes are 
created in test package.

Classes created in "Page" package basically consist of "Page factory" and "Action Methods".
Classes created in "Test" package calls the method created in from Page classes, which is loaded with TestNG annotation.

Flow of process: Project is build upon "Maven", Using Selenium with JAVA binding, and Wrap with TDD framework using POM design pattern   				 				withTESTNG annotation.Extends report is used to generate the Reports. GIT is used for Source code management and integrated     				with JENKINS for triggering CI. 


Dependency Used : Selenium, TestNG, Extends report, Junit.

Used Of TESTNG : a) Implemented ITestListener interface to capture the screenshot if any test method in class failed.
                 b) Implemented 


Introduction 

1) Folder Structure - Consist of two main Source folder scr/main/java and src/test/java

a)Main java folder contains various package such as Base, config, pages, utils, extend report packages.

Base package: It cosist of TestBase class which is acting as a super class for each classes in both package i.e main/java and test/java
              In Constructor of this class config file is initiated.
              Initialization method is called the desired browser.
              
Config package: It consist of Config file which is used to define the Enviroment variable.

utils package : It is acting as a library. All resuable codes are define in this package. For Ex: JavaScriptMethod class conist of basic                   				java script method such as scroll which can be used throughout the framework.
                Also WebDriver event listner is define.
                
ExtendedReport package: It consist of file for extended driver functionality

Page pacakge : It consist of classes which are build for each pages in functionality need to be tested.


b) Test java Folder contains one package as named Testcases. It consist of classes with same names which were created in pages package with Test keyword.

In test java folder, we have created the testng runner file which can be used to create the project jar file.


In this project 2 main XML file is created 
1) Simple XML file : i.e testng.XML which contain all the classes
2) Regression XML file, which will run all the critical functionality method


                     
