package com.eylmz.hepsiburada.rover.validation;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.eylmz.hepsiburada.model.Plateau;
import com.eylmz.hepsiburada.model.Position;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PositionIsInsideOfPlateauValidationTest {

	@Test
	public void givenRover_WhenRoverMoveInside_ThenShouldReturnTrue() {
		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position validPosition = new Position(roverPositionX, roverPositionY + 1);

		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);
		Plateau plateau = new Plateau(plateauPosition);

		PositionIsInsideOfPlateauValidation positionIsInsideOfPlateauValidation = new PositionIsInsideOfPlateauValidation();

		assertTrue(positionIsInsideOfPlateauValidation.isPositionValid(plateau, validPosition));
	}

	@Test
	public void givenRover_WhenRoverMoveOutside_ThenShouldReturnFalse() {
		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position inValidPosition = new Position(roverPositionX + 6, roverPositionY + 1);

		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);
		Plateau plateau = new Plateau(plateauPosition);

		PositionIsInsideOfPlateauValidation positionIsInsideOfPlateauValidation = new PositionIsInsideOfPlateauValidation();

		assertFalse(positionIsInsideOfPlateauValidation.isPositionValid(plateau, inValidPosition));
	}

}
