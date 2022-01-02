package com.eylmz.hepsiburada.rover.commandinterpreter;

import com.eylmz.hepsiburada.rover.Rover;

public class RightCommandInterpreter implements ICommandInterpreterStrategy {

	@Override
	public void interpretCommand(Rover rover) {
		rover.turnRight();
	}

}
