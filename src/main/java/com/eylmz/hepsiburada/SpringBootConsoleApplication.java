package com.eylmz.hepsiburada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * this is a simple command line application with use spring boot library with command CommandLineRunner
 * the application expects one argument for input file path, then processes input and write expected output.
 */
@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

	@Autowired
	private Runner runner;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConsoleApplication.class, args);
	}

	@Override
	public void run(String... args){
		runner.run(args);
	}

}