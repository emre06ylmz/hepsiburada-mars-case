package com.eylmz.hepsiburada.rover.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.eylmz.hepsiburada.exception.WrongRoverCommandException;
import com.eylmz.hepsiburada.model.Direction;
import com.eylmz.hepsiburada.model.Plateau;
import com.eylmz.hepsiburada.model.Position;
import com.eylmz.hepsiburada.rover.Rover;
import com.eylmz.hepsiburada.rover.command.RoverCommand;
import com.eylmz.hepsiburada.rover.command.RoverCommandIterator;
import com.eylmz.hepsiburada.rover.commandinterpreter.CommandInterpreterContext;
import com.eylmz.hepsiburada.rover.commandinterpreter.ICommandInterpreterStrategy;
import com.eylmz.hepsiburada.rover.commandinterpreter.LeftCommandInterpreter;
import com.eylmz.hepsiburada.rover.commandinterpreter.MoveCommandInterpreter;
import com.eylmz.hepsiburada.rover.commandinterpreter.RightCommandInterpreter;
import com.eylmz.hepsiburada.rover.validation.PositionValidator;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class RoverControllerTest {

	@InjectMocks
	@Resource
	private RoverController roverController;

	@Mock
	private PositionValidator positionValidator;

	@Mock
	private CommandInterpreterContext commandInterpreterContext;

	@BeforeAll
	public void init() {
		positionValidator = mock(PositionValidator.class);
		commandInterpreterContext = mock(CommandInterpreterContext.class);
		roverController = new RoverController();
	}

	@Test
	public void givenXY_WhenPositionCreated_ThenShouldReturnObject() throws WrongRoverCommandException {
		MockitoAnnotations.initMocks(this);

		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position roverPosition = new Position(roverPositionX, roverPositionY);
		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);

		Rover rover = new Rover(1, roverPosition, Direction.N, new Plateau(plateauPosition),
				new RoverCommandIterator("LLM"), positionValidator);

		ICommandInterpreterStrategy leftCommandInterpreter = new LeftCommandInterpreter();
		ICommandInterpreterStrategy rightCommandInterpreter = new RightCommandInterpreter();
		ICommandInterpreterStrategy moveCommandInterpreter = new MoveCommandInterpreter();

		when(commandInterpreterContext.getCommandInterpreter(RoverCommand.L)).thenReturn(leftCommandInterpreter);
		when(commandInterpreterContext.getCommandInterpreter(RoverCommand.R)).thenReturn(rightCommandInterpreter);
		when(commandInterpreterContext.getCommandInterpreter(RoverCommand.M)).thenReturn(moveCommandInterpreter);
		roverController.setCommandInterpreterContext(commandInterpreterContext);

		when(positionValidator.isPositionValid(rover.getPlateau(), rover.findNextPosition())).thenReturn(true);

		roverController.driveRover(rover, new RoverCommandIterator("LLMLLMMRMRMM"));

	}
}
