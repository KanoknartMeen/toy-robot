# Toy-Robot

This project is a Java application that simulates a toy moving on a grid. The toy can be placed on the grid, moved around, and turned left or right.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Run](#run)
- [Command](#Command)
- [Tests](#Tests)

## Prerequisites
- Java 11
- Maven

## Installation
To install this project, you need to have Java installed on your machine. Clone the repository and navigate to the project directory.

```bash
git clone https://github.com/KanoknartMeen/toy-robot.git
cd toy-robot
mvn clean install
````

## Run
To run the application, compile the Java files and then run the Main class.
```
mvn compile
mvn exec:java -Dexec.mainClass="org.example.Main" 
```

## Command
After starting the application, you can enter commands directly into the console.
- `PLACE X,Y,F` 
  - Put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST.
  - The first valid command to the robot is a PLACE command, after that, any sequence of commands may be issued, in any order, including another PLACE command. The application should discard all commands in the sequence until a valid PLACE command has been executed.
  - The origin (0,0) can be considered to be the SOUTH WEST most corner.
- `MOVE`: move the toy robot one unit forward in the direction it is currently facing.
- `LEFT` and `RIGHT`: rotate the robot 90 degrees in the specified direction without changing the position.
- `REPORT`: announce the X,Y and F of the robot.

## Tests
To run the tests for this project, use the following command:
```bash
# All
mvn test
# Execute a single test class
mvn test -Dtest="ToyControllerTest" 
```

To get the code coverage report navigate to the target > site > jacoco > index.html
