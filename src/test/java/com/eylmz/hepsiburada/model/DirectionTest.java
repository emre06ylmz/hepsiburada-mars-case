package com.eylmz.hepsiburada.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.test.context.SpringBootTest;

import com.eylmz.hepsiburada.exception.WrongDirectionException;

@SpringBootTest
public class DirectionTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void givenCharacter_WhenDirectionCreated_ThenShouldReturnEnum() throws WrongDirectionException {
		assertEquals(Direction.create('N'), Direction.N);
		assertEquals(Direction.create('E'), Direction.E);
		assertEquals(Direction.create('S'), Direction.S);
		assertEquals(Direction.create('W'), Direction.W);
		assertNotEquals(Direction.create('W'), Direction.E);
	}

	@Test
	public void givenDirection_WhenLeftCalled_ThenShouldReturnLeftOfDirection() {
		assertEquals(Direction.N.left(), Direction.W);
		assertEquals(Direction.W.left(), Direction.S);
		assertEquals(Direction.S.left(), Direction.E);
		assertEquals(Direction.E.left(), Direction.N);

		assertNotEquals(Direction.E.left(), Direction.E);
	}

	@Test
	public void givenDirection_WhenRightCalled_ThenShouldReturnLeftOfDirection() {
		assertEquals(Direction.N.right(), Direction.E);
		assertEquals(Direction.W.right(), Direction.N);
		assertEquals(Direction.S.right(), Direction.W);
		assertEquals(Direction.E.right(), Direction.S);
		assertNotEquals(Direction.E.right(), Direction.E);
	}

	@Test
	public void givenWrongCharacterA_WhenRoverCommandCreated_ThenShouldThrowException() throws WrongDirectionException {
		exceptionRule.expect(WrongDirectionException.class);
		exceptionRule.expectMessage("wrong direction: A");
		Direction.create('A');
	}

	@Test
	public void givenWrongCharacterB_WhenRoverCommandCreated_ThenShouldThrowException() throws WrongDirectionException {
		exceptionRule.expect(WrongDirectionException.class);
		exceptionRule.expectMessage("wrong direction: B");
		Direction.create('B');
	}

}
