package com.crivera.TakenGame.utils;
import java.util.Scanner;
public class MenuUtils {

	private static Scanner in;

	private MenuUtils() {
		throw new AssertionError("Esta clase no se deberia instanciar");
	}
	
	public static String menuOptionMovieSpace() {
		StringBuffer outputBuffer = new StringBuffer();
		outputBuffer.append("   1").append("\n").append("<-2 3->").append("\n").append("   4").append("\n");
		return outputBuffer.toString();
	}
	
	public static int ReadOption() {
		System.out.println(MenuUtils.menuOptionMovieSpace());
		in = new Scanner(System.in);
		int num = in.nextInt();
		return num;
	}
}
