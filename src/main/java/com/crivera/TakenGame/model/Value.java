package com.crivera.TakenGame.model;

import com.crivera.TakenGame.utils.TakenUtils;
import com.google.common.base.Preconditions;

public class Value {
	private String value;

	public Value(int number, int length) {
		Preconditions.checkArgument((number >= 0), "El numero debe ser positivo");
		Preconditions.checkArgument((length > 0), "El tamaño debe ser positivo");
		if (number == 0) {
			this.value = TakenUtils.stringSpaces(length);
		} else {
			String format = String.format("%%0%dd", length);
			String result = String.format(format, number);
			this.value = result;
		}
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Value other = (Value) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return value;
	}

}
