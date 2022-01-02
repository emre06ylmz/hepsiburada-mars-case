package com.eylmz.hepsiburada.rover.commandinterpreter;

import java.util.HashMap;

import com.eylmz.hepsiburada.rover.command.RoverCommand;

public class CommandInterpreterContext {

	private HashMap<RoverCommand, ICommandInterpreterStrategy> commandInterpreters;

	public CommandInterpreterContext() {
		commandInterpreters = new HashMap<>();
	}

	public ICommandInterpreterStrategy getCommandInterpreter(RoverCommand roverCommand) {
		return commandInterpreters.get(roverCommand);
	}

	public void addCommandInterpreter(RoverCommand roverCommand,
			ICommandInterpreterStrategy commandInterpreterStrategy) {
		commandInterpreters.put(roverCommand, commandInterpreterStrategy);
	}

}
