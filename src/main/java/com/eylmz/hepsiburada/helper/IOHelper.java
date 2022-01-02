package com.eylmz.hepsiburada.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.eylmz.hepsiburada.exception.InvalidInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eylmz.hepsiburada.exception.WrongDirectionException;
import com.eylmz.hepsiburada.exception.WrongRoverCommandException;
import com.eylmz.hepsiburada.model.Direction;
import com.eylmz.hepsiburada.model.Plateau;
import com.eylmz.hepsiburada.model.Position;
import com.eylmz.hepsiburada.rover.Rover;
import com.eylmz.hepsiburada.rover.RoverFactory;
import com.eylmz.hepsiburada.rover.command.RoverCommandIterator;

@Component
public class IOHelper {

	private static final Logger logger = LoggerFactory.getLogger(IOHelper.class);

	@Autowired
	private RoverFactory roverFactory;

	public Plateau readInput(String filePath) throws InvalidInputException {
		Plateau plateau = null;

		logger.debug("input file path given as: " + filePath);

		// open a buffered read to read input file line by line
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			// before read rovers with a loop, read first line which is information of plateau
			String[] plateauPosition = br.readLine().trim().split(" ");

			if(plateauPosition.length != 2){
				throw new InvalidInputException("wrong plateau initial position. it should be <x y>");
			}

			// position is used to store max X and Y value of Plateau
			plateau = new Plateau(
					new Position(Integer.parseInt(plateauPosition[0]), Integer.parseInt(plateauPosition[1])));

			logger.debug("plateau is created with given X and Y value: " + plateau);

			int roverId = 1;
			// with a loop read rover information, first line position then second one
			// command set
			for (String line; (line = br.readLine()) != null;) {
				RoverCommandIterator roverCommand = new RoverCommandIterator(br.readLine());
				String[] roverPosition = line.split(" ");

				if(roverPosition.length != 3){
					throw new InvalidInputException("wrong rover initial position. it should be <x y Direction>");
				}

				Position roverInitialPosition = new Position(Integer.parseInt(roverPosition[0]),
						Integer.parseInt(roverPosition[1]));

				Rover rover = roverFactory.createRover(roverId, roverInitialPosition,
						Direction.create(roverPosition[2].charAt(0)), plateau, roverCommand);

				roverId++;

				if(rover.getPositionValidator().isPositionValid(plateau, roverInitialPosition)){
					// add all rover to plateau to find if the position is empty or not in the plateau
					// when rover is moving
					plateau.getRovers().add(rover);
				}else{
					// if initial position is not available, throw an exception
					throw new InvalidInputException("initial position is not available for the rover..");
				}
			}
		} catch (WrongDirectionException e) {
			logger.error("wrong type of direction. Direction might be N, S, E or W");
			throw new InvalidInputException("wrong direction. Direction might be N, S, E or W");
		} catch (WrongRoverCommandException e) {
			logger.error("wrong type of rover command. Commands might be L, R or M");
			throw new InvalidInputException("wrong rover command. Commands might be L, R or M");
		} catch (FileNotFoundException e) {
			logger.error("input file can not be found at: " + filePath, e);
			throw new InvalidInputException("input file can not be found at: " + filePath);
		} catch (Exception e) {
			logger.error("unknown exception is occurred.", e);
			throw new InvalidInputException("unknown exception is occurred.");
		}

		return plateau;
	}

}
