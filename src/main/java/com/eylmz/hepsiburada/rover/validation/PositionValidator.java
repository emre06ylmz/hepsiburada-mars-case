package com.eylmz.hepsiburada.rover.validation;

import java.util.ArrayList;

import com.eylmz.hepsiburada.model.Plateau;
import org.springframework.stereotype.Component;

import com.eylmz.hepsiburada.model.Position;
import com.eylmz.hepsiburada.rover.Rover;

@Component
public class PositionValidator {

	private ArrayList<IPositionValidation> positionValidations;

	public PositionValidator() {
		positionValidations = new ArrayList<IPositionValidation>();
		positionValidations.add(new PositionIsEmptyValidation());
		positionValidations.add(new PositionIsInsideOfPlateauValidation());
	}

	public boolean isPositionValid(Plateau plateau, Position position) {
		for (IPositionValidation iPositionValidation : positionValidations) {
			if (!iPositionValidation.isPositionValid(plateau, position)) {
				return false;
			}
		}
		return true;
	}

}
