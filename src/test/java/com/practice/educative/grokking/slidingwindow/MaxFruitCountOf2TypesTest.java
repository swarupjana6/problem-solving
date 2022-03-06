package com.practice.educative.grokking.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.practice.problems.grokking.educative.slidingwindow.impl.may.MaxFruitCountOf2TypesMay;
import com.practice.problems.grokking.educative.slidingwindow.impl.tap.MaxFruitCountOf2TypesTap;

class MaxFruitCountOf2TypesTest {

	@Disabled
	@Test
	void findLengthTapan() {
		assertEquals(new MaxFruitCountOf2TypesTap().findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }), 3);
		assertEquals(new MaxFruitCountOf2TypesTap().findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }), 5);
	}

	@Test
	void findLengthMayur() {
		assertEquals(new MaxFruitCountOf2TypesMay().findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }), 3);
		assertEquals(new MaxFruitCountOf2TypesMay().findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }), 5);
	}
}