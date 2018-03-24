package com.crivera.TakenGame.utils;


import java.util.Random;

import com.crivera.TakenGame.model.Taken;
import com.google.common.base.Preconditions;

public final class TakenUtils {

	private TakenUtils() {
		throw new AssertionError("Esta clase no se deberia instanciar");
	}

	public static String stringSpaces(int length) {
		Preconditions.checkArgument((length > 0), "la longitud debe ser mayor a 0");
		StringBuffer outputBuffer = new StringBuffer(length);
		for (int i = 0; i < length; i++) {
			outputBuffer.append(" ");
		}
		return outputBuffer.toString();
	}



	public static Taken moveSpaceRandon(Taken taken, int countMove) {
		Preconditions.checkArgument((countMove>= 0), "la cantidad de movimientos debe ser un numero positivo");
		Taken newTake = taken;
		Random rn = new Random();

		for (int move = 0; move < countMove; move++) {
			int option = rn.nextInt(4) + 1;
			newTake = newTake.moveSpace(option);
		}
		return newTake;
	}
	
	public static boolean isOrganized(Taken taken){
		int size = taken.getSize();
		Taken takenNew = new Taken(size);
		if(takenNew.toString().equals(taken.toString())){
			return true;
		}
		return false;
	}
	
	
}
