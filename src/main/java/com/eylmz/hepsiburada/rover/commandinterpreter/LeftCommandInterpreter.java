package com.eylmz.hepsiburada.rover.commandinterpreter;

import com.eylmz.hepsiburada.rover.Rover;

public class LeftCommandInterpreter implements ICommandInterpreterStrategy {

	@Override
	public void interpretCommand(Rover rover) {
		rover.turnLeft();
	}

}
