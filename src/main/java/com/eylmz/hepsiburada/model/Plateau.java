package com.eylmz.hepsiburada.model;

import java.util.ArrayList;

import com.eylmz.hepsiburada.rover.Rover;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Plateau {

	// position is used to store max X and Y value of plateau
	private Position position;
	private ArrayList<Rover> rovers = new ArrayList<Rover>();

	public Plateau(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return this.position.getX() + " " + this.position.getY();
	}

}
