package com.crivera.TakenGame.model;

import org.junit.Test;

import com.crivera.TakenGame.model.Taken;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TakenTest {

	private static final int UP = 1;
	private static final int DOWN = 4;
	private static final int RIGHT = 3;
	private static final int LEFT = 2;

	@Test
	public void createTake3X3() {
		StringBuffer outputBuffer = new StringBuffer();
		outputBuffer.append(" |1|2|\n").
					 append("3|4|5|\n").
					 append("6|7|8|\n");
		Taken take = new Taken(3);
		assertThat(take.toString(), is(outputBuffer.toString()));
	}

	@Test
	public void createTake4X4() {
		StringBuffer outputBuffer = new StringBuffer();
		outputBuffer.append("  |01|02|03|\n").
					 append("04|05|06|07|\n").
					 append("08|09|10|11|\n").
				     append("12|13|14|15|\n");
		Taken take = new Taken(4);
		assertThat(take.toString(), is(outputBuffer.toString()));
	}

	@Test
	public void moveSpaceDown() {
		StringBuffer outputBuffer = new StringBuffer();
		outputBuffer.append("04|01|02|03|\n").
		             append("  |05|06|07|\n").
		             append("08|09|10|11|\n").
				     append("12|13|14|15|\n");
		Taken take = new Taken(4);
		Taken takeDown = take.moveSpace(DOWN);
		assertThat(takeDown.toString(), is(outputBuffer.toString()));
	}

	@Test
	public void moveSpaceUpIsNotPosible() {
		StringBuffer outputBuffer = new StringBuffer();
		outputBuffer.append("  |01|02|03|\n").
		             append("04|05|06|07|\n").
		             append("08|09|10|11|\n").
				     append("12|13|14|15|\n");
		Taken take = new Taken(4);
		Taken takeUp = take.moveSpace(UP);
		assertThat(takeUp.toString(), is(outputBuffer.toString()));
	}

	@Test
	public void moveSpaceDownUp() {
		StringBuffer outputBuffer = new StringBuffer();
		outputBuffer.append("  |01|02|03|\n").
		             append("04|05|06|07|\n").
		             append("08|09|10|11|\n").
				     append("12|13|14|15|\n");
		Taken take = new Taken(4);
		Taken takeDown = take.moveSpace(DOWN);
		Taken takeUp = takeDown.moveSpace(UP);
		assertThat(takeUp.toString(), is(outputBuffer.toString()));
	}

	@Test
	public void moveSpaceRigt() {
		StringBuffer outputBuffer = new StringBuffer();
		outputBuffer.append("01|  |02|03|\n")
		            .append("04|05|06|07|\n")
		            .append("08|09|10|11|\n")
				    .append("12|13|14|15|\n");
		Taken take = new Taken(4);
		Taken takeDown = take.moveSpace(RIGHT);
		assertThat(takeDown.toString(), is(outputBuffer.toString()));
	}

	@Test
	public void moveSpaceLeftisNotPosible() {
		StringBuffer outputBuffer = new StringBuffer();
		outputBuffer.append("  |01|02|03|\n") 
		            .append("04|05|06|07|\n")
		            .append("08|09|10|11|\n")
				    .append("12|13|14|15|\n");
		Taken take = new Taken(4);
		Taken takeLeft = take.moveSpace(LEFT);
		assertThat(takeLeft.toString(), is(outputBuffer.toString()));
	}

	@Test
	public void moveSpaceRightLeft() {
		StringBuffer outputBuffer = new StringBuffer();
		outputBuffer.append("  |01|02|03|\n")
		            .append("04|05|06|07|\n")
		            .append("08|09|10|11|\n")
				    .append("12|13|14|15|\n");
		Taken take = new Taken(4);
		Taken takeRight = take.moveSpace(RIGHT);
		Taken takeLeft = takeRight.moveSpace(LEFT);
		assertThat(takeLeft.toString(), is(outputBuffer.toString()));
	}

	@Test
	public void moveSpaceRightIsNotPosibleInTheBorderRight() {
		StringBuffer outputBuffer = new StringBuffer();
		outputBuffer.append("1|2| |\n")
		            .append("3|4|5|\n")
		            .append("6|7|8|\n");
		Taken take = new Taken(3);
		Taken takeLeft = take;
		for (int i = 1; i < 4; i++) {
			takeLeft = takeLeft.moveSpace(RIGHT);
		}
		assertThat(takeLeft.toString(), is(outputBuffer.toString()));
	}

}
