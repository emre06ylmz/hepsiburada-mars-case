package com.eylmz.hepsiburada;

import com.eylmz.hepsiburada.exception.InvalidInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eylmz.hepsiburada.helper.IOHelper;
import com.eylmz.hepsiburada.model.Plateau;
import com.eylmz.hepsiburada.rover.Rover;
import com.eylmz.hepsiburada.rover.controller.RoverController;

@Component
public class Runner {

	private static final Logger logger = LoggerFactory.getLogger(Runner.class);

	@Autowired
	private RoverController roverController;

	@Autowired
	private IOHelper ioHelper;

	public void run(String... args) {

		logger.debug("runner is started.");

		if (args.length < 1) {
			logger.error("please supply the path of input file as a command line argument.");
			return;
		}

		// read input as plateau and landed rovers
		Plateau plateau;
		try {
			plateau = ioHelper.readInput(args[0]);

			// start to control rovers by one by with their commandIterator
			for (Rover rover : plateau.getRovers()) {
				logger.debug("rover controller started to drive the rover-" + rover.getId());
				roverController.driveRover(rover, rover.getRoverCommandIterator());
			}
		} catch (InvalidInputException e) {
			logger.error("invalid input exception. details is: " + e.getMessage());
		}

	}

}
