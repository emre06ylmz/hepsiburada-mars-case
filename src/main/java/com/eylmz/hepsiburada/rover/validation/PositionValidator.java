package com.eylmz.hepsiburada.rover.validation;

import java.util.ArrayList;

import com.eylmz.hepsiburada.model.Plateau;
import org.springframework.stereotype.Component;

import com.eylmz.hepsiburada.model.Position;

@Component
public class PositionValidator {

	private final ArrayList<IPositionValidation> positionValidations;

	public PositionValidator() {
		positionValidations = new ArrayList<>();
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
