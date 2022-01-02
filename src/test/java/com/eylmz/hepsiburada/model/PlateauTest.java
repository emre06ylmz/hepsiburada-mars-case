package com.eylmz.hepsiburada.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlateauTest {

	@Test
	public void givenPosition_WhenPlateauCreated_ThenShouldReturnObject() {
		Position position = new Position(5, 5);
		Plateau plateau = new Plateau(position);

		plateau.getRovers().add(null);
		plateau.getRovers().add(null);
		plateau.getRovers().add(null);

		assertEquals(position.getX(), plateau.getPosition().getX());
		assertEquals(position.getY(), plateau.getPosition().getY());
		assertEquals(3, plateau.getRovers().size());
	}

}
