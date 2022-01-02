package com.eylmz.hepsiburada.rover.commandinterpreter;

import com.eylmz.hepsiburada.rover.Rover;

public class MoveCommandInterpreter implements ICommandInterpreterStrategy {

	@Override
	public void interpretCommand(Rover rover) {
		rover.move();
	}

}
