package com.eylmz.hepsiburada.helper;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.annotation.Resource;

import com.eylmz.hepsiburada.exception.InvalidInputException;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.eylmz.hepsiburada.exception.WrongRoverCommandException;
import com.eylmz.hepsiburada.model.Direction;
import com.eylmz.hepsiburada.model.Plateau;
import com.eylmz.hepsiburada.model.Position;
import com.eylmz.hepsiburada.rover.Rover;
import com.eylmz.hepsiburada.rover.RoverFactory;
import com.eylmz.hepsiburada.rover.command.RoverCommandIterator;
import com.eylmz.hepsiburada.rover.validation.PositionValidator;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class IOHelperTest {

	@Mock
	private RoverFactory roverFactory;

	@InjectMocks
	@Resource
	private IOHelper ioHelper;

	@Mock
	private PositionValidator positionValidator;

	@BeforeAll
	public void init() {
		positionValidator = mock(PositionValidator.class);
		roverFactory = mock(RoverFactory.class);
		ioHelper = new IOHelper();
	}

	@Test
	public void givenFilePath_WhenReadInputCalled_ThenShouldReturnPlateauAndRovers() throws WrongRoverCommandException, InvalidInputException {
		int roverPositionX = 2, roverPositionY = 2, plateauPositionX = 5, plateauPositionY = 5;
		Position roverPosition = new Position(roverPositionX, roverPositionY);
		Position plateauPosition = new Position(plateauPositionX, plateauPositionY);

		Rover rover = new Rover(1, roverPosition, Direction.N, new Plateau(plateauPosition),
				new RoverCommandIterator("LLM"), null);

		when(roverFactory.createRover(anyInt(), anyObject(), anyObject(), anyObject(), anyObject())).thenReturn(rover);

		Plateau plateau = ioHelper.readInput("src/test/resources/input.txt");
		assertNotNull(plateau);
		assertEquals(2, plateau.getRovers().size());

		assertEquals(1, plateau.getRovers().get(0).getId());
		assertEquals(rover.getPosition(), plateau.getRovers().get(0).getPosition());
		assertEquals(rover.getRoverCommandIterator().getAllCommand(), plateau.getRovers().get(0).getRoverCommandIterator().getAllCommand());

		assertEquals(1, plateau.getRovers().get(1).getId());
		assertEquals(rover.getPosition(), plateau.getRovers().get(1).getPosition());
		assertEquals(rover.getRoverCommandIterator().getAllCommand(), plateau.getRovers().get(1).getRoverCommandIterator().getAllCommand());

	}

}
