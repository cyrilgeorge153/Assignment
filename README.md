# Assignment

Selenium-Maven-TestNG framework.

Used properties file to read url,username and password and other datas.

Implemented Plain Page Object Model.

Added Extent Reporting in addition to the TestNG inbuild Reports. Report will be generated with timestamp in TestReport folder.

Added Log 4j Api to generate log files.

Given support to chrome,firefox,ie,edge,headless chrome,headless firefox with parallel execution.

**Maven Project Execution without using any IDE after downloading project to local system-> Select CMD and go to project path where pom.xml file is loacted and execute following commands:**

To execute in chrome->mvn test -Dbrowsername=chrome

To execute in headless chrome->mvn test -Dbrowsername=headlesschrome

To execute in firefox->mvn test -Dbrowsername=firefox

To execute in headlessfirefox->mvn test -Dbrowsername=headlessfirefox

To execute in microsoft edge->mvn test -Dbrowsername=edge

To execute in headless microsoft edge->mvn test -Dbrowsername=headlessedge

To execute in opera->mvn test -Dbrowsername=opera

**Extent Reports(Testng.xml):Assignment/TestReport**

**Log File location:Assignment/all.log

**Test cases covered-Orange HRM-https://opensource-demo.orangehrmlive.com/**

1.Verify forgot password button is displayed or not

2.Verify login with invalid data

3.Verify home page title

4.Verify orange hrm logo is displayed in homepage after login

**Test execution gif->**![wUTWSgniC5](https://user-images.githubusercontent.com/52770689/145929474-97723a6f-fc8a-4ab2-aee4-00620c7dfb63.gif)

**Extent Report Screenshots**
![image](https://user-images.githubusercontent.com/52770689/145929780-b0cf0041-7df9-4f58-939a-b36cb00dfeb6.png)
![image](https://user-images.githubusercontent.com/52770689/145929889-ea43edc9-c84a-4ff3-9bcd-a9237570f5b5.png)

**Prerequisites**

1. Java 8/+ should be present and environment variable should be set in the local system.
2. Maven should be present and environment variable should be set in the local system.
3. All browsers mentioned above should be present in the local system.





