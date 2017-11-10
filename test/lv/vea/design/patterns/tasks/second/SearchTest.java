package lv.vea.design.patterns.tasks.second;

import static lv.vea.design.patterns.tasks.second.Search.find;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import lv.vea.design.patterns.tasks.second.exceptions.EmptyArrayException;
import lv.vea.design.patterns.tasks.second.exceptions.UnsortedArrayException;

public class SearchTest {

	private int x;
	private int[] a;

	private int result;

	@Test(expected = EmptyArrayException.class)
	public void testFindInEmptyArray() {
		x = 2;
		a = new int[] {};

		result = find(x, a);
	}

	@Test
	public void testFindInSortedArrayWithOneElements() {
		x = 2;
		a = new int[] { 2 };

		result = find(x, a);
		assertEquals(0, result);
	}

	@Test
	public void testFindInSortedArrayWithTwoElements() {
		x = 1;
		a = new int[] { 1, 2 };

		result = find(x, a);
		assertEquals(0, result);
	}

	@Test
	public void testFindInSortedArrayWithThreeElements() {
		x = 2;
		a = new int[] { 1, 2, 3 };

		result = find(x, a);
		assertEquals(1, result);
	}

	@Test
	public void testFindInSortedArrayWithFourElements() {
		x = 4;
		a = new int[] { 1, 2, 3, 4 };

		result = find(x, a);
		assertEquals(3, result);
	}

	@Test(expected = UnsortedArrayException.class)
	public void testFailToFindInUnsortedArrayWithThreeElements() {
		x = 3;
		a = new int[] { 1, 6, 3 };

		result = find(x, a);
	}

}
