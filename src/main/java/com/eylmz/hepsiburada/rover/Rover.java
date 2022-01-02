package com.eylmz.hepsiburada.rover;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eylmz.hepsiburada.model.Direction;
import com.eylmz.hepsiburada.model.Plateau;
import com.eylmz.hepsiburada.model.Position;
import com.eylmz.hepsiburada.rover.command.RoverCommandIterator;
import com.eylmz.hepsiburada.rover.validation.PositionValidator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Rover implements RoverAction {

	private int id;
	private Position position;
	private Direction currentDirection;
	private Plateau plateau;
	private RoverCommandIterator roverCommandIterator;
	private PositionValidator positionValidator;

	private static final Logger logger = LoggerFactory.getLogger(Rover.class);

	public boolean isAtThisPosition(Position position) {
		return this.position.getX() == position.getX() && this.position.getY() == position.getY();
	}

	@Override
	public String toString() {
		return this.position.getX() + " " + this.position.getY() + " " + this.currentDirection.toString();
	}

	@Override
	public void turnLeft() {
		setCurrentDirection(this.currentDirection.left());
		logger.debug("rover-" + id + " turn left " + this);
	}

	@Override
	public void turnRight() {
		setCurrentDirection(this.currentDirection.right());
		logger.debug("rover-" + id + " turn right " + this);
	}

	@Override
	public void move() {
		if (positionValidator.isPositionValid(getPlateau(), findNextPosition())) {
			switch (this.currentDirection) {
			case N:
				this.moveNorth();
				break;
			case E:
				this.moveEast();
				break;
			case S:
				this.moveSouth();
				break;
			case W:
				this.moveWest();
				break;
			}
		}
	}

	public void moveNorth() {
		this.position.setY(this.position.getY() + 1);
		logger.debug("rover-" + id + " move north " + this);
	}

	public void moveSouth() {
		this.position.setY(this.position.getY() - 1);
		logger.debug("rover-" + id + " move south " + this);
	}

	public void moveEast() {
		this.position.setX(this.position.getX() + 1);
		logger.debug("rover-" + id + " move east " + this);
	}

	public void moveWest() {
		this.position.setX(this.position.getX() - 1);
		logger.debug("rover-" + id + " move west " + this);
	}


	/*
	 * this method finds the next position of the rover to check is valid or not
	 */
	public Position findNextPosition() {
		Position position = new Position(this.getPosition().getX(), this.getPosition().getY());
		switch (this.getCurrentDirection()) {
			case N:
				position = new Position(this.getPosition().getX(), this.getPosition().getY() + 1);
				break;
			case E:
				position = new Position(this.getPosition().getX() + 1, this.getPosition().getY());
				break;
			case S:
				position = new Position(this.getPosition().getX(), this.getPosition().getY() - 1);
				break;
			case W:
				position = new Position(this.getPosition().getX() - 1, this.getPosition().getY());
				break;
		}
		return position;
	}

}
