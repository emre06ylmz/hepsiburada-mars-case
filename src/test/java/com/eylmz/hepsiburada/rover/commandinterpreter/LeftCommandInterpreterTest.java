package com.eylmz.hepsiburada.rover.commandinterpreter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.eylmz.hepsiburada.exception.WrongDirectionException;
import com.eylmz.hepsiburada.exception.WrongRoverCommandException;
import com.eylmz.hepsiburada.model.Direction;
import com.eylmz.hepsiburada.model.Plateau;
import com.eylmz.hepsiburada.model.Position;
import com.eylmz.hepsiburada.rover.Rover;
import com.eylmz.hepsiburada.rover.RoverFactory;
import com.eylmz.hepsiburada.rover.command.RoverCommandIterator;

@SpringBootTest
public class LeftCommandInterpreterTest {

	@Test
	public void givenRover_WhenTurnLeft_ThenSHouldChangeDirection()
			throws WrongDirectionException, WrongRoverCommandException {
		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position roverPosition = new Position(roverPositionX, roverPositionY);
		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);

		RoverFactory roverFactory = new RoverFactory();
		Rover rover = roverFactory.createRover(1, roverPosition, Direction.N, new Plateau(plateauPosition),
				new RoverCommandIterator("LLMMRR"));

		LeftCommandInterpreter leftCommandInterpreter = new LeftCommandInterpreter();
		leftCommandInterpreter.interpretCommand(rover);

		assertEquals(rover.getCurrentDirection(), Direction.W);
	}

}
