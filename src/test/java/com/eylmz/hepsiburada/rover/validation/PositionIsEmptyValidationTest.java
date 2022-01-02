package com.eylmz.hepsiburada.rover.validation;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.eylmz.hepsiburada.exception.WrongRoverCommandException;
import com.eylmz.hepsiburada.model.Direction;
import com.eylmz.hepsiburada.model.Plateau;
import com.eylmz.hepsiburada.model.Position;
import com.eylmz.hepsiburada.rover.Rover;
import com.eylmz.hepsiburada.rover.RoverFactory;
import com.eylmz.hepsiburada.rover.command.RoverCommandIterator;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PositionIsEmptyValidationTest {

	@Test
	public void givenRover_WhenPositionIsEmpty_ThenShouldReturnTrue() throws WrongRoverCommandException {
		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position roverPosition = new Position(roverPositionX, roverPositionY);
		Position otherPosition = new Position(roverPositionX + 1, roverPositionY + 1);
		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);

		Plateau plateau = new Plateau(plateauPosition);

		Rover rover = new RoverFactory().createRover(1, roverPosition, Direction.N, plateau,
				new RoverCommandIterator("LLMMRR"));
		plateau.getRovers().add(rover);

		PositionIsEmptyValidation positionIsEmptyValidation = new PositionIsEmptyValidation();

        assertTrue(positionIsEmptyValidation.isPositionValid(plateau, otherPosition));
	}

	@Test
	public void givenRover_WhenPositionIsNotEmpty_ThenShouldReturnTrue() throws WrongRoverCommandException {
		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position roverPosition = new Position(roverPositionX, roverPositionY);
		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);

		Plateau plateau = new Plateau(plateauPosition);

		Rover rover = new RoverFactory().createRover(1, roverPosition, Direction.N, plateau,
				new RoverCommandIterator("LLMMRR"));
		plateau.getRovers().add(rover);

		PositionIsEmptyValidation positionIsEmptyValidation = new PositionIsEmptyValidation();

		assertFalse(positionIsEmptyValidation.isPositionValid(plateau, roverPosition));
	}

}
