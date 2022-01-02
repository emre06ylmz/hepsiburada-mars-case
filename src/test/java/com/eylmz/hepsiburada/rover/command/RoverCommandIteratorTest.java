package com.eylmz.hepsiburada.rover.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.eylmz.hepsiburada.exception.WrongRoverCommandException;

@SpringBootTest
public class RoverCommandIteratorTest {

	@Test
	public void givenRoverCommandStringShort_WhenRoverCommandIteratorCreated_ThenShouldReturnIterator() throws WrongRoverCommandException {
		RoverCommandIterator roverCommandIterator = new RoverCommandIterator("LLMMRR");

		assertEquals(roverCommandIterator.hasNext(), true);
		assertEquals(roverCommandIterator.next(), RoverCommand.L);

		assertEquals(roverCommandIterator.hasNext(), true);
		assertEquals(roverCommandIterator.next(), RoverCommand.L);

		assertEquals(roverCommandIterator.hasNext(), true);
		assertEquals(roverCommandIterator.next(), RoverCommand.M);

		assertEquals(roverCommandIterator.hasNext(), true);
		assertEquals(roverCommandIterator.next(), RoverCommand.M);

		assertEquals(roverCommandIterator.hasNext(), true);
		assertEquals(roverCommandIterator.next(), RoverCommand.R);

		assertEquals(roverCommandIterator.hasNext(), true);
		assertEquals(roverCommandIterator.next(), RoverCommand.R);

		assertEquals(roverCommandIterator.hasNext(), false);
	}


	@Test
	public void givenRoverCommandStringLong_WhenRoverCommandIteratorCreated_ThenShouldReturnIterator() throws WrongRoverCommandException {
		RoverCommandIterator roverCommandIterator = new RoverCommandIterator("MMRRLLMM");

		assertEquals(roverCommandIterator.hasNext(), true);
		assertEquals(roverCommandIterator.next(), RoverCommand.M);

		assertEquals(roverCommandIterator.hasNext(), true);
		assertEquals(roverCommandIterator.next(), RoverCommand.M);

		assertEquals(roverCommandIterator.hasNext(), true);
		assertEquals(roverCommandIterator.next(), RoverCommand.R);

		assertEquals(roverCommandIterator.hasNext(), true);
		assertEquals(roverCommandIterator.next(), RoverCommand.R);

		assertEquals(roverCommandIterator.hasNext(), true);
		assertEquals(roverCommandIterator.next(), RoverCommand.L);

		assertEquals(roverCommandIterator.hasNext(), true);
		assertEquals(roverCommandIterator.next(), RoverCommand.L);

		assertEquals(roverCommandIterator.hasNext(), true);
		assertEquals(roverCommandIterator.next(), RoverCommand.M);

		assertEquals(roverCommandIterator.hasNext(), true);
		assertEquals(roverCommandIterator.next(), RoverCommand.M);

		assertEquals(roverCommandIterator.hasNext(), false);
	}

}
