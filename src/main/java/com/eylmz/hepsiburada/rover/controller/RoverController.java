package com.eylmz.hepsiburada.rover.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eylmz.hepsiburada.rover.Rover;
import com.eylmz.hepsiburada.rover.command.RoverCommandIterator;
import com.eylmz.hepsiburada.rover.commandinterpreter.CommandInterpreterContext;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
public class RoverController implements IRoverController {

	private static final Logger logger = LoggerFactory.getLogger(RoverController.class);

	@Autowired
	private CommandInterpreterContext commandInterpreterContext;

	public void driveRover(Rover rover, RoverCommandIterator roverCommandIterator) {

		logger.debug("rover-" + rover.getId() + " initial position: " + rover);

		while (roverCommandIterator.hasNext()) {
			commandInterpreterContext.getCommandInterpreter(roverCommandIterator.next()).interpretCommand(rover);
		}

		logger.debug("rover-" + rover.getId() + " last position: " + rover);

		logger.info(rover.toString());
	}

}
