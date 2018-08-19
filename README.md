## Toy Robot Simulation
**Dev/Implementation Notes**
* Since the application is all about receiving and executing commands, Command Design pattern makes it
easy to extend in case we have a new command to be added in the future.
* Made sure that the Unit test coverage is close to 100 percent using Junit and Mockito tests.
* Used Interface Seggregation principle - Having two seperate interface for the Command pattern: Command and OutPutCommand. Commans which need a output to be produced will implement the OutPutCommand interface and rest all with implement the basic Command interface. For Example REPORT command needs a String output back and it implements the inteface OutPutCommans,
* The models required for this program has been built keeping in mind the SRP principle.
* Used the TDD approach to fix bugs found after the initial development phase.
* This program has favoured the usage of small intuitive functions where applicable. 
* Added TODO comments where applicable. Especially with the command output as the specification mentioned satndard output.
* Project dependencies are managed by Maven.

## Running/packaging the application
* **ToyRobotCommandRunner** is the application entry point which accepts the user input from command line.
* Project can be compiled using **mvn compile**
* Tests can be run using the command **mvn test**
* Application can be packaged to jar using **mvn package**
* **To run the commands**:  mvn exec:java (Main class has been set in pom.xml. There is no need to pass it again)
