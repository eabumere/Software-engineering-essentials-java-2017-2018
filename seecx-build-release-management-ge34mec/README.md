# Build and Release Management Exercise

In this exercise you will configure the build and dependency management tool **Maven** for a given Java Project. Therefore you have to configure a **`pom.xml`** file.

**Important**: Make sure you have installed Java **JDK** Version > **1.8.0_65**. Otherwise the used UI Framework (JavaFX) will not work and you will get compile errors. You can check your Java Version using in the terminal/cmd the command: java -version.

You have the following tasks in this exercise:


1. ✅Click on “Launch Exercise” below. You are redirected to ArTEMiS.
      1. Click “Start Exercise”. The system will create a personal repository for you. This may take a minute. Please wait!
      2. Use the “Clone Repository” button to clone your repository using SourceTree.
      3. Import the project in Eclipse or your favourite IDE.
  
  
2. ✅Run the **`UniversityApp`** (Right click "UniversityApp" --> Run As --> Java Application). You should see a window with one Button. (If this is not the case, you have a too old Java version. Please upgrade to the newest one!)


3. ✅Configure Maven to run the tests (UniversityAppTest). Open the pom.xml and add the following line within the **`<build>`** section: ``<testSourceDirectory>${project.basedir}/test</testSourceDirectory>``
    This tells Maven the directory of the test files.
    
    **Note:** Eclipse has a built-in pom.xml editor. To edit the raw pom.xml file, use the tab "pom.xml" as shown on the screenshot:
    
    ![Screenshot](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/f0222ad5a624572a2c91105671e0557a/asset-v1:TUMx+SEECx+3T_2017+type@asset+block/seecx-brm-screenshot.png "Eclipse Screenshot")


4. ✅Execute the tests using Maven. Right click on the Project (SEECx Build and Release Management Exercise) --> Run As --> Maven test. This will execute the command  **`mvn test`**. You will see the output of Maven in the Console window of Eclipse and recognize that the test case in **`UniversityAppTest`** does not pass.


5. ✅Fix the problem by changing the implementation of getButtonText() in UniversityApp. Have a look at the source code of UniversityAppTest to get the correct specification of the method. (This is one example of test driven development)


6. ✅**Note:** Do **not** change the test case in **`UniversityAppTest`**!


7. ✅Execute the test case again using Maven. Now you should get a **BUILD SUCCESS** message in the Console.


8. ✅Create an executable application for potential end users. In Java, we can create an executable and distributable JAR file using Maven package.


9. ✅Edit the pom.xml again and add the following into the **`<plugins>`** section (within the **`<build>`** section):

````
        <plugin>
            <artifactId>maven-assembly-plugin</artifactId>
            <executions>
                <execution>
                    <id>create-my-bundle</id>
                    <phase>package</phase>
                    <goals>
                        <goal>single</goal>
                    </goals>
                    <configuration>
                        <appendAssemblyId>false</appendAssemblyId>
                        <archive>
                            <manifest>
                                <mainClass> ... </mainClass>
                            </manifest>
                        </archive>
                        <descriptorRefs>
                            <descriptorRef>jar-with-dependencies</descriptorRef>
                        </descriptorRefs>
                    </configuration>
                </execution>
            </executions>
        </plugin>
````

10. ✅Configure the **`<mainClass>`** attribute correctly. (Hint: Have a look on slide 11 of the Build Management video).


11. ✅Create the JAR file using **`mvn package`**. To execute the "package" goal in Eclipse, right click the project --> Run As --> 2 Maven build...


Edit the configuration as shown in the screenshot below.

![Screenshot](https://courses.edx.org/asset-v1:TUMx+EASEx+2T2017+type@asset+block@seecx-brm-screenshot-package.png "Eclipse Screenshot")


12. ✅Have a look at the Console output. If everything works correctly, you should see **Building jar**: **[...]/target/EASE1617_BUILD_AND_RELEASE_MANAGEMENT-1.0-SNAPSHOT.jar** in the log.


13. ✅Execute the created JAR file (in the target directory) by double clicking on it. The UniversityApp launches and you should see the window.


14. ✅We want to add some Logging to the UniversityApp. To save time, we want to reuse an external component, the logging framework Log4j. Follow [these instructions](https://howtodoinjava.com/log4j/how-to-configure-log4j-using-maven/) to add **Log4j** as external Maven dependency in the pom.xml file (starting at step 3 in the tutorial).


15. ✅Do some reasonable logging within the **`UniversityApp`** class. Give out a log message using Log4j when the app starts.


16. ✅Commit and push your code.
      1. Our Build Server will run the Maven tasks (**`mvn test`** and **`mvn package`**).
      2. Go to ArTEMiS. Check if all tests are passing.
      3. Download the JAR file (created by the continuous integration server) using the link "**Download Build Result**".
      4. Execute the file to check if everything worked correctly. (Depending on your operating system, you need to enable the execution of jar files)
      5. Deliver this application to your users (e.g. your friends and colleagues)
