package com.eylmz.hepsiburada.rover.command;

import java.util.HashMap;

import com.eylmz.hepsiburada.exception.WrongRoverCommandException;

public enum RoverCommand {

	L, R, M;

	public static final HashMap<Character, RoverCommand> roverCommands;

	static {
		roverCommands = new HashMap<>();
		roverCommands.put('L', L);
		roverCommands.put('R', R);
		roverCommands.put('M', M);

	}

	public static RoverCommand create(Character character) throws WrongRoverCommandException {
		if (roverCommands.containsKey(character)) {
			return roverCommands.get(character);
		}
		throw new WrongRoverCommandException("wrong rover command: " + character);
	}

}
