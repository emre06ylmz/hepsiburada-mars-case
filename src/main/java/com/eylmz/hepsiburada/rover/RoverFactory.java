package com.eylmz.hepsiburada.rover;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eylmz.hepsiburada.model.Direction;
import com.eylmz.hepsiburada.model.Plateau;
import com.eylmz.hepsiburada.model.Position;
import com.eylmz.hepsiburada.rover.command.RoverCommandIterator;
import com.eylmz.hepsiburada.rover.validation.PositionValidator;

@Component
public class RoverFactory {

	private static final Logger logger = LoggerFactory.getLogger(RoverFactory.class);

	@Autowired
	private PositionValidator positionValidator;

	public Rover createRover(int roverId, Position position, Direction direction, Plateau plateau,
			RoverCommandIterator roverCommandIterator) {

		Rover rover = new Rover(roverId, position, direction, plateau, roverCommandIterator, positionValidator);
		logger.debug("a rover created with id " + roverId + " and initial position " + rover);

		return rover;
	}
}
