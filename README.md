Selenium-Maven-TestNG framework.

Used properties file to read url,username and password.

Implemented Page Object Model and used page factory.

Added Extent Reporting in addition to the TestNG inbuild Reports.

Added Log 4j Api to generate log files.

Added groups concept in testng.xml file.

Given support to chrome,firefox,ie,edge,headless chrome,headless firefox.

Maven Project Execution without using any IDE after downloading project to local system-> Select CMD and go to project path where pom.xml file is loacted and execute following commands:

To execute in chrome->mvn test -Dbrowsername=chrome

To execute in headless chrome->mvn test -Dbrowsername=headlesschrome

To execute in firefox->mvn test -Dbrowsername=firefox

To execute in headlessfirefox->mvn test -Dbrowsername=headlessfirefox

To execute in microsoft edge->mvn test -Dbrowsername=edge

To execute in headless microsoft edge->mvn test -Dbrowsername=headlessedge

To execute in opera->mvn test -Dbrowsername=opera

Extent Reports(Testng.xml):/Assignment/test-output/ExtentReport.html

Log File location:/Assignment/log/testlog.log.

Extent Report Screenshots
![Extent Report 1](https://user-images.githubusercontent.com/52770689/87049243-5d641600-c21a-11ea-8d66-f00a47185d70.png)
![Extent Report 2](https://user-images.githubusercontent.com/52770689/87049270-63f28d80-c21a-11ea-9aaa-28cd344686e3.png)

