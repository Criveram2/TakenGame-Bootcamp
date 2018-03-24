package com.crivera.TakenGame.Controller;

import com.crivera.TakenGame.model.Taken;
import com.crivera.TakenGame.utils.MenuUtils;
import com.crivera.TakenGame.utils.TakenUtils;

public class ControllerTake {

	public static void main(String[] args) {
		int sizeTaken=4;
		System.out.println("Iniciando");
		System.out.println("Solucion Esperada");
		Taken taken = new Taken(sizeTaken);
		System.out.print(taken.toString());
		System.out.println("para mover el espacio digite uno de los siguientes valores");
		System.out.println(MenuUtils.menuOptionMovieSpace());
		taken = TakenUtils.moveSpaceRandon(taken, 100);
		do {
			System.out.println(taken.toString());
			int optionMove = MenuUtils.ReadOption();
			taken = taken.moveSpace(optionMove);
		} while (!TakenUtils.isOrganized(taken));
		System.out.println("Feliciraciones");

	}

}
