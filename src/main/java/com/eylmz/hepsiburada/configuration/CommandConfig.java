package com.eylmz.hepsiburada.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eylmz.hepsiburada.rover.command.RoverCommand;
import com.eylmz.hepsiburada.rover.commandinterpreter.CommandInterpreterContext;
import com.eylmz.hepsiburada.rover.commandinterpreter.ICommandInterpreterStrategy;
import com.eylmz.hepsiburada.rover.commandinterpreter.LeftCommandInterpreter;
import com.eylmz.hepsiburada.rover.commandinterpreter.MoveCommandInterpreter;
import com.eylmz.hepsiburada.rover.commandinterpreter.RightCommandInterpreter;

@Configuration
public class CommandConfig {

	@Bean("leftCommandInterpreter")
	public ICommandInterpreterStrategy leftCommandInterpreter() {
		return new LeftCommandInterpreter();
	}

	@Bean("rightCommandInterpreter")
	public ICommandInterpreterStrategy rightCommandInterpreter() {
		return new RightCommandInterpreter();
	}

	@Bean("moveCommandInterpreter")
	public ICommandInterpreterStrategy moveCommandInterpreter() {
		return new MoveCommandInterpreter();
	}

	@Bean
	public CommandInterpreterContext commandInterpreterContext() {
		CommandInterpreterContext commandInterpreterContext = new CommandInterpreterContext();
		commandInterpreterContext.addCommandInterpreter(RoverCommand.L, leftCommandInterpreter());
		commandInterpreterContext.addCommandInterpreter(RoverCommand.R, rightCommandInterpreter());
		commandInterpreterContext.addCommandInterpreter(RoverCommand.M, moveCommandInterpreter());
		return commandInterpreterContext;
	}

}
