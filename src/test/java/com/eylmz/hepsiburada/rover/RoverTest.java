package com.eylmz.hepsiburada.rover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.eylmz.hepsiburada.exception.WrongRoverCommandException;
import com.eylmz.hepsiburada.model.Direction;
import com.eylmz.hepsiburada.model.Plateau;
import com.eylmz.hepsiburada.model.Position;
import com.eylmz.hepsiburada.rover.command.RoverCommandIterator;
import com.eylmz.hepsiburada.rover.validation.PositionValidator;

@SpringBootTest
public class RoverTest {

	@Test
	public void givenParameters_WhenRoverCreated_ThenShouldReturnObject() throws WrongRoverCommandException {

		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position roverPosition = new Position(roverPositionX, roverPositionY);
		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);

		Rover rover = new Rover(1, roverPosition, Direction.N, new Plateau(plateauPosition),
				new RoverCommandIterator("LLM"), null);

		assertEquals(rover.getPosition(), roverPosition);
		assertEquals(rover.getCurrentDirection(), Direction.N);
	}

	@Test
	public void givenRover_WhenTurnLeftCalled_ThenShouldChangeOnlyDirection() throws WrongRoverCommandException {

		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position roverPosition = new Position(roverPositionX, roverPositionY);
		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);

		Rover rover = new Rover(1, roverPosition, Direction.N, new Plateau(plateauPosition),
				new RoverCommandIterator("LLM"), null);

		rover.turnLeft();
		assertEquals(rover.getCurrentDirection(), Direction.W);
		assertEquals(rover.getPosition(), roverPosition);

		rover.turnLeft();
		assertEquals(rover.getCurrentDirection(), Direction.S);
		assertEquals(rover.getPosition(), roverPosition);

		rover.turnLeft();
		assertEquals(rover.getCurrentDirection(), Direction.E);
		assertEquals(rover.getPosition(), roverPosition);

		rover.turnLeft();
		assertEquals(rover.getCurrentDirection(), Direction.N);
		assertEquals(rover.getPosition(), roverPosition);
	}

	@Test
	public void givenRover_WhenTurnRightCalled_ThenShouldChangeOnlyDirection() throws WrongRoverCommandException {

		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position roverPosition = new Position(roverPositionX, roverPositionY);
		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);

		Rover rover = new Rover(1, roverPosition, Direction.N, new Plateau(plateauPosition),
				new RoverCommandIterator("LLM"), null);

		rover.turnRight();
		assertEquals(rover.getCurrentDirection(), Direction.E);
		assertEquals(rover.getPosition(), roverPosition);

		rover.turnRight();
		assertEquals(rover.getCurrentDirection(), Direction.S);
		assertEquals(rover.getPosition(), roverPosition);

		rover.turnRight();
		assertEquals(rover.getCurrentDirection(), Direction.W);
		assertEquals(rover.getPosition(), roverPosition);

		rover.turnRight();
		assertEquals(rover.getCurrentDirection(), Direction.N);
		assertEquals(rover.getPosition(), roverPosition);

	}

	@Test
	public void givenRover_WhenMoveCalled_ThenShouldChangeOnlyPosition() throws WrongRoverCommandException {

		PositionValidator roverPositionValidator = mock(PositionValidator.class);

		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position roverPosition = new Position(roverPositionX, roverPositionY);
		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);

		Rover rover = new Rover(1, roverPosition, Direction.N, new Plateau(plateauPosition),
				new RoverCommandIterator("LLM"), null);

		when(roverPositionValidator.isPositionValid(anyObject(), anyObject())).thenReturn(true);

		rover.setPositionValidator(roverPositionValidator);

		rover.move();
		assertEquals(rover.getCurrentDirection(), Direction.N);
		assertEquals(rover.getPosition(), new Position(roverPositionX, roverPositionY + 1));

	}

	@Test
	public void givenRover_WhenTurnAndMoveCalled_ThenShouldChangePosition() throws WrongRoverCommandException {

		PositionValidator roverPositionValidator = mock(PositionValidator.class);

		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position roverPosition = new Position(roverPositionX, roverPositionY);
		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);

		Rover rover = new Rover(1, roverPosition, Direction.N, new Plateau(plateauPosition),
				new RoverCommandIterator("LLM"), null);

		when(roverPositionValidator.isPositionValid(anyObject(), anyObject())).thenReturn(true);

		rover.setPositionValidator(roverPositionValidator);

		rover.move();
		assertEquals(rover.getPosition(), new Position(roverPositionX, roverPositionY + 1));

		rover.turnLeft();
		rover.move();
		assertEquals(rover.getPosition(), new Position(roverPositionX - 1, roverPositionY + 1));

		rover.turnLeft();
		rover.move();
		assertEquals(rover.getPosition(), new Position(roverPositionX - 1, roverPositionY));

		rover.turnLeft();
		rover.move();
		assertEquals(rover.getPosition(), new Position(roverPositionX, roverPositionY));

	}

}
