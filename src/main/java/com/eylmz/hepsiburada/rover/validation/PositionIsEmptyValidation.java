package com.eylmz.hepsiburada.rover.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eylmz.hepsiburada.model.Plateau;
import com.eylmz.hepsiburada.model.Position;
import com.eylmz.hepsiburada.rover.Rover;

public class PositionIsEmptyValidation implements IPositionValidation {

	private static final Logger logger = LoggerFactory.getLogger(PositionIsEmptyValidation.class);

	@Override
	public boolean isPositionValid(Plateau plateau, Position position) {
		for (Rover rover : plateau.getRovers()) {
			if (rover.isAtThisPosition(position)) {
				logger.error("position is not valid due to there is another rover at: " + position);
				return false;
			}
		}
		return true;
	}

}
