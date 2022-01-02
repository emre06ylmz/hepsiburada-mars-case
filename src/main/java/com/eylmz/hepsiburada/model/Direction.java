package com.eylmz.hepsiburada.model;

import java.util.HashMap;

import com.eylmz.hepsiburada.exception.WrongDirectionException;

public enum Direction {

	N, E, S, W;

	public static final HashMap<Character, Direction> directions;
	public static final HashMap<Direction, Direction> leftOfDirection;
	public static final HashMap<Direction, Direction> rightOfDirection;

	static {
		directions = new HashMap<>();
		directions.put('N', N);
		directions.put('E', E);
		directions.put('S', S);
		directions.put('W', W);

		leftOfDirection = new HashMap<>();
		leftOfDirection.put(Direction.N, Direction.W);
		leftOfDirection.put(Direction.E, Direction.N);
		leftOfDirection.put(Direction.S, Direction.E);
		leftOfDirection.put(Direction.W, Direction.S);

		rightOfDirection = new HashMap<>();
		rightOfDirection.put(Direction.N, Direction.E);
		rightOfDirection.put(Direction.E, Direction.S);
		rightOfDirection.put(Direction.S, Direction.W);
		rightOfDirection.put(Direction.W, Direction.N);
	}

	public static Direction create(Character character) throws WrongDirectionException {
		if (directions.containsKey(character)) {
			return directions.get(character);
		}
		throw new WrongDirectionException("wrong direction: " + character);
	}

	/*
	 * returns the left direction of given direction
	 */
	public Direction left() {
		return leftOfDirection.get(this);
	}

	/*
	 * returns the right direction of given direction
	 */
	public Direction right() {
		return rightOfDirection.get(this);
	}

}
