This is my CS445 Object Oriented Design Final Project:

To build and deploy project:
  1) Ensure you have Apache Tomcat and Gradle installed on device
  2) Access "/bn/RBN" directory on command prompt
  3) Call the next two commands to clean and build gradle project: "./gradlew clean" "./gradlew build"
  4) The Java Project should be packaged as a .war file (rest-bn.war) and ready for deployment
  5) You can find the .war file in the "/bn/RBN/lib/build/libs" directory
  6) All API calls can be made using the "http://www.localhost:port/rest-BN/api" prefix

To access files within the project:
  1) Entity Class files and Controller can be found in the "bn\RBN\lib\src\main\java" directory
  2) Test Case file can be found in the "bn\RBN\lib\src\test\java" directory

Known Bugs within the code include Internal Server Errors that will launch when a method crashes. This was difficult catching and returning in a BAD_REQUEST.

This project was done by myself, Tabor Alemu, with the guidance of Professor Virgil Bistriceanu. Project was conducted using the knowledge gathered from my Computer Science Object Oriented Design Course taught by Prof. Bistriceanu himself.
