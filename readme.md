# hepsiburada Mars Case

This is a command line project which is an implementation of hepsiburada mars case study.

## Detail of Project

To create this project, spring boot library and command line runner interface.  

## Running Code

To run this project, need to give input file path as command line argument.

To build and create artifact, maven and spring boot maven plugin need to be used together. With the following command, a fat jar <which has required spring libraries> is created.

```
     > mvn clean package spring-boot:repackage
```
After build operation, runnable fat jar, can be run as following with the path of input file.

```
     > java -jar hepsiburada-0.0.1-SNAPSHOT.jar <pat-of-input-file>
```

## Project Structure
```
├── inputs
│   ├── input.txt
│   └── invalidinput.txt
├── pom.xml
├── readme.md
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── eylmz
    │   │           └── hepsiburada
    │   │               ├── Runner.java
    │   │               ├── SpringBootConsoleApplication.java
    │   │               ├── configuration
    │   │               │   └── CommandConfig.java
    │   │               ├── exception
    │   │               │   ├── InvalidInputException.java
    │   │               │   ├── WrongDirectionException.java
    │   │               │   └── WrongRoverCommandException.java
    │   │               ├── helper
    │   │               │   └── IOHelper.java
    │   │               ├── model
    │   │               │   ├── Direction.java
    │   │               │   ├── Plateau.java
    │   │               │   └── Position.java
    │   │               └── rover
    │   │                   ├── Rover.java
    │   │                   ├── RoverAction.java
    │   │                   ├── RoverFactory.java
    │   │                   ├── command
    │   │                   │   ├── RoverCommand.java
    │   │                   │   └── RoverCommandIterator.java
    │   │                   ├── commandinterpreter
    │   │                   │   ├── CommandInterpreterContext.java
    │   │                   │   ├── ICommandInterpreterStrategy.java
    │   │                   │   ├── LeftCommandInterpreter.java
    │   │                   │   ├── MoveCommandInterpreter.java
    │   │                   │   └── RightCommandInterpreter.java
    │   │                   ├── controller
    │   │                   │   ├── IRoverController.java
    │   │                   │   └── RoverController.java
    │   │                   └── validation
    │   │                       ├── IPositionValidation.java
    │   │                       ├── PositionIsEmptyValidation.java
    │   │                       ├── PositionIsInsideOfPlateauValidation.java
    │   │                       └── PositionValidator.java
    │   └── resources
    │       └── logback.xml
    └── test
        ├── java
        │   └── com
        │       └── eylmz
        │           └── hepsiburada
        │               ├── AppTest.java
        │               ├── exception
        │               │   └── ExceptionTest.java
        │               ├── helper
        │               │   └── IOHelperTest.java
        │               ├── model
        │               │   ├── DirectionTest.java
        │               │   ├── PlateauTest.java
        │               │   └── PositionTest.java
        │               └── rover
        │                   ├── RoverFactoryTest.java
        │                   ├── RoverTest.java
        │                   ├── command
        │                   │   ├── RoverCommandIteratorTest.java
        │                   │   └── RoverCommandTest.java
        │                   ├── commandinterpreter
        │                   │   ├── LeftCommandInterpreterTest.java
        │                   │   ├── MoveCommandInterpreterTest.java
        │                   │   └── RightCommandInterpreterTest.java
        │                   ├── controller
        │                   │   └── RoverControllerTest.java
        │                   └── validation
        │                       ├── PositionIsEmptyValidationTest.java
        │                       ├── PositionIsInsideOfPlateauValidationTest.java
        │                       └── PositionValidatorTest.java
        └── resources
            └── input.txt

```

## Example Input and explanation
```
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```
First line is the plateau position

Then all tuple line such as line 2 and 3, line 4 and 5 are the rover position/direction and command. for this input line 2 and 3 for the first row and line 4 and 5 for the second rover.
  line 2 is the first rover position and direction. line 3 is the first rover commands.
  line 4 is the first rover position and direction. line 5 is the first rover commands

## Execution of input explanation

All rover read and placed the plateau. If rover positions are overlapping, an error is printed.

Then with the placing order of rovers, rover commands are interpreted one by one. When interpreting commands, if there will be an overlapping or out of plateau problem, again an example is printed.

## Expected Output and explanation
```
1 3 N
5 1 E
```
For all rover one line is printed as output. The final position and direction of rover.