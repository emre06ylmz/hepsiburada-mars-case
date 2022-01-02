package com.eylmz.hepsiburada.rover.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.eylmz.hepsiburada.exception.WrongRoverCommandException;
import com.eylmz.hepsiburada.model.Plateau;
import com.eylmz.hepsiburada.model.Position;

@SpringBootTest
public class PositionIsInsideOfPlateauValidationTest {

	@Test
	public void givenRover_WhenRoverMoveInside_ThenShouldReturnTrue() throws WrongRoverCommandException {
		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position validPosition = new Position(roverPositionX, roverPositionY + 1);

		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);
		Plateau plateau = new Plateau(plateauPosition);

		PositionIsInsideOfPlateauValidation positionIsInsideOfPlateauValidation = new PositionIsInsideOfPlateauValidation();

		assertEquals(true, positionIsInsideOfPlateauValidation.isPositionValid(plateau, validPosition));
	}

	@Test
	public void givenRover_WhenRoverMoveOutside_ThenShouldReturnFalse() throws WrongRoverCommandException {
		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position inValidPosition = new Position(roverPositionX + 6, roverPositionY + 1);

		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);
		Plateau plateau = new Plateau(plateauPosition);

		PositionIsInsideOfPlateauValidation positionIsInsideOfPlateauValidation = new PositionIsInsideOfPlateauValidation();

		assertEquals(false, positionIsInsideOfPlateauValidation.isPositionValid(plateau, inValidPosition));
	}

}
