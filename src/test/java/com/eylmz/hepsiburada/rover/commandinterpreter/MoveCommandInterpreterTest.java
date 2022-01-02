package com.eylmz.hepsiburada.rover.commandinterpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.eylmz.hepsiburada.exception.WrongRoverCommandException;
import com.eylmz.hepsiburada.model.Direction;
import com.eylmz.hepsiburada.model.Plateau;
import com.eylmz.hepsiburada.model.Position;
import com.eylmz.hepsiburada.rover.Rover;
import com.eylmz.hepsiburada.rover.RoverFactory;
import com.eylmz.hepsiburada.rover.command.RoverCommandIterator;
import com.eylmz.hepsiburada.rover.validation.PositionValidator;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class MoveCommandInterpreterTest {

	@Mock
	private PositionValidator positionValidator;

	@BeforeAll
	public void init() {
		positionValidator = mock(PositionValidator.class);
	}

	@Test
	public void givenRover_WhenMove_ThenShouldChangeDirection()
			throws WrongRoverCommandException {
		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position roverPosition = new Position(roverPositionX, roverPositionY);
		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);

		RoverFactory roverFactory = new RoverFactory();
		Rover rover = roverFactory.createRover(1, roverPosition, Direction.N, new Plateau(plateauPosition),
				new RoverCommandIterator("LLMMRR"));
		rover.setPositionValidator(positionValidator);

		when(positionValidator.isPositionValid(rover.getPlateau(), rover.findNextPosition())).thenReturn(true);

		MoveCommandInterpreter moveCommandInterpreter = new MoveCommandInterpreter();
		moveCommandInterpreter.interpretCommand(rover);

		assertEquals(rover.getPosition(), new Position(roverPositionX, roverPositionY + 1));
	}

}
