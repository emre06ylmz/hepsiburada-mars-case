package com.eylmz.hepsiburada.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PositionTest {

	@Test
	public void givenXY_WhenPositionCreated_ThenShouldReturnObject() {
		int x = 5, y = 5;
		Position position = new Position(x, y);

		assertEquals(position.getX(), x);
		assertEquals(position.getY(), y);
	}

}
