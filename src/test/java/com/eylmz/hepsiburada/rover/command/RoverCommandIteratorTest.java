package com.eylmz.hepsiburada.rover.command;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.eylmz.hepsiburada.exception.WrongRoverCommandException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RoverCommandIteratorTest {

	@Test
	public void givenRoverCommandStringShort_WhenRoverCommandIteratorCreated_ThenShouldReturnIterator() throws WrongRoverCommandException {
		RoverCommandIterator roverCommandIterator = new RoverCommandIterator("LLMMRR");

        assertTrue(roverCommandIterator.hasNext());
		assertEquals(roverCommandIterator.next(), RoverCommand.L);

        assertTrue(roverCommandIterator.hasNext());
		assertEquals(roverCommandIterator.next(), RoverCommand.L);

        assertTrue(roverCommandIterator.hasNext());
		assertEquals(roverCommandIterator.next(), RoverCommand.M);

        assertTrue(roverCommandIterator.hasNext());
		assertEquals(roverCommandIterator.next(), RoverCommand.M);

        assertTrue(roverCommandIterator.hasNext());
		assertEquals(roverCommandIterator.next(), RoverCommand.R);

        assertTrue(roverCommandIterator.hasNext());
		assertEquals(roverCommandIterator.next(), RoverCommand.R);

        assertFalse(roverCommandIterator.hasNext());
	}


	@Test
	public void givenRoverCommandStringLong_WhenRoverCommandIteratorCreated_ThenShouldReturnIterator() throws WrongRoverCommandException {
		RoverCommandIterator roverCommandIterator = new RoverCommandIterator("MMRRLLMM");

        assertTrue(roverCommandIterator.hasNext());
		assertEquals(roverCommandIterator.next(), RoverCommand.M);

        assertTrue(roverCommandIterator.hasNext());
		assertEquals(roverCommandIterator.next(), RoverCommand.M);

        assertTrue(roverCommandIterator.hasNext());
		assertEquals(roverCommandIterator.next(), RoverCommand.R);

        assertTrue(roverCommandIterator.hasNext());
		assertEquals(roverCommandIterator.next(), RoverCommand.R);

        assertTrue(roverCommandIterator.hasNext());
		assertEquals(roverCommandIterator.next(), RoverCommand.L);

        assertTrue(roverCommandIterator.hasNext());
		assertEquals(roverCommandIterator.next(), RoverCommand.L);

        assertTrue(roverCommandIterator.hasNext());
		assertEquals(roverCommandIterator.next(), RoverCommand.M);

        assertTrue(roverCommandIterator.hasNext());
		assertEquals(roverCommandIterator.next(), RoverCommand.M);

        assertFalse(roverCommandIterator.hasNext());
	}

}
