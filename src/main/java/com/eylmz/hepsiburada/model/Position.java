package com.eylmz.hepsiburada.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Position {

	private int x, y;

	@Override
	public String toString() {
		return x + ", " + y;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Position position = (Position) obj;

		return this.getX() == position.getX() && this.getY() == position.getY();
	}

}
