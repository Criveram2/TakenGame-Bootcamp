package com.crivera.TakenGame.utils;

import org.junit.Test;

import com.crivera.TakenGame.model.Taken;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TakenUtilsTest {

	@Test
	public void newTableIsOrganize() {
		Taken taken = new Taken(3);
		assertThat(TakenUtils.isOrganized(taken), is(true));

	}

	@Test
	public void stringSpacesWithLenghtEgualtToOne() {
		assertThat(TakenUtils.stringSpaces(1), is(" "));

	}

	@Test
	public void moveSpaceRandonCeroTimesReturntheSameTaken() {
		Taken taken = new Taken(4);
		assertThat(TakenUtils.moveSpaceRandon(taken, 0).toString(), is(taken.toString()));
	}

}
