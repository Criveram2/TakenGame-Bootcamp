package com.crivera.TakenGame.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.crivera.TakenGame.model.Move;

public class MenuUtils {

	private static Scanner in;

	private MenuUtils() {
		throw new AssertionError("Esta clase no se deberia instanciar");
	}

	public static String menuOptionMovieSpace() {
		StringBuffer outputBuffer = new StringBuffer();
		outputBuffer.append("   " + Move.UP.getValue()).append("\n").append("<-").append(Move.LEFT.getValue())
				.append(" ").append(Move.RIGHT.getValue()).append("->").append("\n").append("   ")
				.append(Move.DOWN.getValue()).append("\n");
		return outputBuffer.toString();
	}

	public static int ReadOption() {
		System.out.println(MenuUtils.menuOptionMovieSpace());

		in = new Scanner(System.in);
		try {
			int num = in.nextInt();
			return num;
		} catch (InputMismatchException e) {
			return 0;
		}

	}
}
