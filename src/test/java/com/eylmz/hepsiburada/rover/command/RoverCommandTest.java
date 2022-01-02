package com.eylmz.hepsiburada.rover.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.boot.test.context.SpringBootTest;

import com.eylmz.hepsiburada.exception.WrongRoverCommandException;

@SpringBootTest
public class RoverCommandTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void givenCharacter_WhenRoverCommandCreated_ThenShouldReturnEnum() throws WrongRoverCommandException {
		assertEquals(RoverCommand.create('L'), RoverCommand.L);
		assertEquals(RoverCommand.create('R'), RoverCommand.R);
		assertEquals(RoverCommand.create('M'), RoverCommand.M);
		assertNotEquals(RoverCommand.create('L'), RoverCommand.M);
	}

	@Test
	public void givenWrongCharacter_WhenRoverCommandCreated_ThenShouldThrowError() throws WrongRoverCommandException {
		exceptionRule.expect(WrongRoverCommandException.class);
		exceptionRule.expectMessage("wrong rover command: A");
		RoverCommand.create('A');
	}

}
