# CollectionTester program

## Introduction
This program goal is to run different performance test against different collection implementations

## Usage
If you want to run the program, you have to install maven and java to your system. After that use the following command:
```mvn clean install tomcat7:run```

## Extension
If you want to extend the program, just inherit **AbstractTestCase** class abstract methods. The **init** method run before every test, the **run** method implement the test. The **getName** method identify the test case.

![uml](https://raw.githubusercontent.com/taz1988/SelfDevelopment/master/CollectionTester/CollectionTesterUml.png)
