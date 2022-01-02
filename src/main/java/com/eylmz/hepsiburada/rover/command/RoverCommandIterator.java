package com.eylmz.hepsiburada.rover.command;

import java.util.Iterator;

import com.eylmz.hepsiburada.exception.WrongRoverCommandException;

/*
 * stores the rover command 
 * example: LMLRMLLM
 */
public class RoverCommandIterator implements Iterator<RoverCommand> {

	private final String str;
	private final RoverCommand[] commands;
	private int pos = 0;

	public RoverCommandIterator(String str) throws WrongRoverCommandException {
		this.str = str;
		this.commands = new RoverCommand[str.length()];

		for (int i = 0; i < str.length(); i++) {
			this.commands[i] = RoverCommand.create(str.charAt(i));
		}

	}

	public boolean hasNext() {
		return pos < str.length();
	}

	public RoverCommand next() {
		return commands[pos++];
	}
	
	public String getAllCommand() {
		return str;
	}
}