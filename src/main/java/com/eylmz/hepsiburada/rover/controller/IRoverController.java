package com.eylmz.hepsiburada.rover.controller;

import com.eylmz.hepsiburada.rover.Rover;
import com.eylmz.hepsiburada.rover.command.RoverCommandIterator;

public interface IRoverController {

	void driveRover(Rover rover, RoverCommandIterator roverCommandIterator);

}
