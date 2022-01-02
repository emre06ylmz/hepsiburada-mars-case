package com.eylmz.hepsiburada.rover.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eylmz.hepsiburada.model.Plateau;
import com.eylmz.hepsiburada.model.Position;

public class PositionIsInsideOfPlateauValidation implements IPositionValidation {

	private static final Logger logger = LoggerFactory.getLogger(PositionIsInsideOfPlateauValidation.class);

	@Override
	public boolean isPositionValid(Plateau plateau, Position position) {

		if (position.getX() >= 0 && position.getY() >= 0 && position.getX() <= plateau.getPosition().getX()
				&& position.getY() <= plateau.getPosition().getY()) {
			return true;
		}

		logger.error("position is not valid due to out of plateau: " + position);
		return false;
	}

}
