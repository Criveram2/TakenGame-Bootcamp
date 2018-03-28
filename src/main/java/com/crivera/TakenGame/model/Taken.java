package com.crivera.TakenGame.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Preconditions;

public class Taken {

	private static final int UP = 1;
	private static final int DOWN = 4;
	private static final int RIGHT = 3;
	private static final int LEFT = 2;

	private int size;
	private Map<Position, Value> map = new LinkedHashMap<Position, Value>();

	public Taken(int n) {
		Preconditions.checkArgument((n >= 3), "El valor de n debe ser mayor a 2");
		this.size = n;

		List<Position> listPositions = createListPositions(n);
		int lenghtMax = Integer.toString(n * n).length();
		createMapCells(listPositions, lenghtMax);

	}

	public Taken moveSpace(int option) {
		Position positionSpace = this.positionSpace();
		Value valueDSpace = this.map.get(positionSpace);
		Taken copyTake = this;
		
		switch (option) {
		case UP:
			Position positionUp = new Position(positionSpace.x - 1, positionSpace.y);
			if (PositionIsValide(positionUp)) {
				Value valueUp = this.map.get(positionUp);
				copyTake.map.replace(positionSpace, valueUp);
				copyTake.map.replace(positionUp, valueDSpace);
			}
			break;
		case DOWN:
			Position positionDown = new Position(positionSpace.x + 1, positionSpace.y);
			if (PositionIsValide(positionDown)) {
				Value valueDown = this.map.get(positionDown);
				copyTake.map.replace(positionSpace, valueDown);
				copyTake.map.replace(positionDown, valueDSpace);
			}
			break;
		case RIGHT:
			Position positionRight = new Position(positionSpace.x, positionSpace.y + 1);
			if (PositionIsValide(positionRight)) {
				Value valueRight = this.map.get(positionRight);
				copyTake.map.replace(positionSpace, valueRight);
				copyTake.map.replace(positionRight, valueDSpace);
			}
			break;
		case LEFT:
			Position positionLeft = new Position(positionSpace.x, positionSpace.y - 1);
			if (PositionIsValide(positionLeft)) {
				Value valueLeft = this.map.get(positionLeft);
				copyTake.map.replace(positionSpace, valueLeft);
				copyTake.map.replace(positionLeft, valueDSpace);
			}
			break;

		default:
			return this;
		}
		return copyTake;
	}

	private boolean PositionIsValide(Position position) {
		if (position.x > 0 && position.y > 0 && position.x <= this.size && position.y <= this.size) {
			return true;
		}
		return false;
	}

	private Position positionSpace() {
		for (Position key : map.keySet()) {
			String string = map.get(key).toString();
			if (string.contains(" ")) {
				return key;
			}
		}
		return new Position(0, 0);
	}

	private void createMapCells(List<Position> listPositions, int lenghtMax) {
		int i = 0;
		for (Position temp : listPositions) {
			Value value = new Value(i, lenghtMax);
			map.put(temp, value);
			i++;
		}
	}

	private List<Position> createListPositions(int n) {
		List<Position> listPositions = new ArrayList<Position>(n * n);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				Position positionCell = new Position(i, j);
				listPositions.add(positionCell);
			}
		}

		return listPositions;

	}

	public int getSize() {
		return size;
	}

	class Position {
		private int x;
		private int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
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
			Position other = (Position) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "[" + x + "," + y + "]";
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((map == null) ? 0 : map.hashCode());
		result = prime * result + size;
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
		Taken other = (Taken) obj;
		if (map == null) {
			if (other.map != null)
				return false;
		} else if (!map.equals(other.map))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuffer outputBuffer = new StringBuffer();
		int cont = 0;
		for (Position key : map.keySet()) {
			outputBuffer.append(map.get(key));
			outputBuffer.append("|");
			cont++;
			if (cont == this.size) {
				outputBuffer.append("\n");
				cont = 0;
			}
		}
		return outputBuffer.toString();
	}
}
