## Toy Robot Simulation
**Dev/Implementation Notes**
* Since the application is all about receiving and executing commands, I'm going with Command pattern which makes it
easy to extend in case we have a new command later.
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
* Once the application is compiled and packaged find the Main runner class in target/classes and use java ToyRobotCommandRunner to start executing the commands.
* use EXIT/exit command to quit from the application.
