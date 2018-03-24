package com.crivera.TakenGame.model;

import org.junit.Test;

import com.crivera.TakenGame.model.Value;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValueTest {

	@Test
	public void valueWithTwoDigits() {
		Value value = new Value(1, 2);
		assertThat(value.toString(), is("01"));
	}

	@Test
	public void valueWithTreeDigits() {
		Value value = new Value(5, 3);
		assertThat(value.toString(), is("005"));
	}

	@Test
	public void valueCeroWithLenghtoneIsSpace() {
		Value value = new Value(0, 1);
		assertThat(value.toString(), is(" "));
	}
	
	@Test
	public void valueCeroWithLenghtTwoIsTwoSpaces() {
		Value value = new Value(0, 2);
		assertThat(value.toString(), is("  "));
	}

	@Test
	public void valueCeroWithLenghtTreeIsTwoSpaces() {
		Value value = new Value(0, 3);
		assertThat(value.toString(), is("   "));
	}
}
