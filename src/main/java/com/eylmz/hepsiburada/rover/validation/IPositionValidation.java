package com.eylmz.hepsiburada.rover.validation;

import com.eylmz.hepsiburada.model.Plateau;
import com.eylmz.hepsiburada.model.Position;

public interface IPositionValidation {

	boolean isPositionValid(Plateau plateau, Position position);

}
