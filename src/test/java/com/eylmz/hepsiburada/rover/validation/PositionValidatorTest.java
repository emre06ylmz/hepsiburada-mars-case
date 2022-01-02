package com.eylmz.hepsiburada.rover.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.eylmz.hepsiburada.exception.WrongRoverCommandException;
import com.eylmz.hepsiburada.model.Direction;
import com.eylmz.hepsiburada.model.Plateau;
import com.eylmz.hepsiburada.model.Position;
import com.eylmz.hepsiburada.rover.Rover;
import com.eylmz.hepsiburada.rover.RoverFactory;
import com.eylmz.hepsiburada.rover.command.RoverCommandIterator;

@SpringBootTest
public class PositionValidatorTest {

	@Test
	public void givenRover_WhenRoverDirectionIsNorth_ThenShouldReturnValidationResult()
			throws WrongRoverCommandException {
		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position roverPosition = new Position(roverPositionX, roverPositionY);
		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);

		Plateau plateau = new Plateau(plateauPosition);

		Rover rover = new RoverFactory().createRover(1, roverPosition, Direction.N, plateau,
				new RoverCommandIterator("LLMMRR"));

		plateau.getRovers().add(rover);

		PositionValidator positionValidator = new PositionValidator();

		rover.setCurrentDirection(Direction.N);
		rover.setPosition(new Position(1, 1));
		assertEquals(true, positionValidator.isPositionValid(rover.getPlateau(), rover.findNextPosition()));
		rover.setPosition(new Position(2, 5));
		assertEquals(false, positionValidator.isPositionValid(rover.getPlateau(), rover.findNextPosition()));

	}

	@Test
	public void givenRover_WhenRoverDirectionIsSouth_ThenShouldReturnValidationResult()
			throws WrongRoverCommandException {
		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position roverPosition = new Position(roverPositionX, roverPositionY);
		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);

		Plateau plateau = new Plateau(plateauPosition);

		Rover rover = new RoverFactory().createRover(1, roverPosition, Direction.N, plateau,
				new RoverCommandIterator("LLMMRR"));

		plateau.getRovers().add(rover);

		PositionValidator positionValidator = new PositionValidator();

		rover.setCurrentDirection(Direction.S);
		rover.setPosition(new Position(1, 1));
		assertEquals(true, positionValidator.isPositionValid(rover.getPlateau(), rover.findNextPosition()));
		rover.setPosition(new Position(4, 0));
		assertEquals(false, positionValidator.isPositionValid(rover.getPlateau(), rover.findNextPosition()));

	}

	@Test
	public void givenRover_WhenRoverDirectionIsEast_ThenShouldReturnValidationResult()
			throws WrongRoverCommandException {
		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position roverPosition = new Position(roverPositionX, roverPositionY);
		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);

		Plateau plateau = new Plateau(plateauPosition);

		Rover rover = new RoverFactory().createRover(1, roverPosition, Direction.N, plateau,
				new RoverCommandIterator("LLMMRR"));

		plateau.getRovers().add(rover);

		PositionValidator positionValidator = new PositionValidator();

		rover.setCurrentDirection(Direction.E);
		rover.setPosition(new Position(1, 1));
		assertEquals(true, positionValidator.isPositionValid(rover.getPlateau(), rover.findNextPosition()));
		rover.setPosition(new Position(5, 3));
		assertEquals(false, positionValidator.isPositionValid(rover.getPlateau(), rover.findNextPosition()));

	}

	@Test
	public void givenRover_WhenRoverDirectionIsWest_ThenShouldReturnValidationResult()
			throws WrongRoverCommandException {
		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position roverPosition = new Position(roverPositionX, roverPositionY);
		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);

		Plateau plateau = new Plateau(plateauPosition);

		Rover rover = new RoverFactory().createRover(1, roverPosition, Direction.N, plateau,
				new RoverCommandIterator("LLMMRR"));

		plateau.getRovers().add(rover);

		PositionValidator positionValidator = new PositionValidator();

		rover.setCurrentDirection(Direction.W);
		rover.setPosition(new Position(1, 1));
		assertEquals(true, positionValidator.isPositionValid(rover.getPlateau(), rover.findNextPosition()));
		rover.setPosition(new Position(0, 3));
		assertEquals(false, positionValidator.isPositionValid(rover.getPlateau(), rover.findNextPosition()));

	}

}
