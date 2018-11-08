package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestSorting {
	/**
	 * This is useful for testing whether sort algorithms work!
	 * @param items - the list of integers.
	 * @return true if it is sorted, false if not.
	 */
	private static boolean checkSorted(List<Integer> items) {
		for (int i=0; i<items.size()-1; i++) {
			if (items.get(i) > items.get(i+1)) {
				System.err.println("items out of order: "+items.get(i)+", "+items.get(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Here's some data!
	 */
	private static int[] data = {9,8,7,6,5,4,3,2,1};
	private static int[] data2 = {4,7,8,9};
	private static int[] data3 = {1,3,4,5};
	private static int[] data4 = {9,4,6,7,2,3,1,5,8};
	@Test
	public void testBubbleSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		Collections.shuffle(sortMe);
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	
	@Test
	public void testClassBubbleSort() {
		// See if the data can be reversed:
		ArrayList<Integer> sortMe = new ArrayList<>();
		sortMe.addAll(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	
	@Test
	public void testSelectionSort() {
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		SelectionSort.selectionSort(sortMe);
		System.out.println(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
		
		
	}
	
	@Test 
	public void testInsertionSort() {
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data) {
			sortMe.add(y);
		}
		InsertionSort.insertionSort(sortMe);
		System.out.println(sortMe);
		Assert.assertTrue(checkSorted(sortMe));
	}
	
	@Test
	public void testMergeSort() {
		ArrayList<Integer> first = new ArrayList<>();
		for (int y : data2) {
			first.add(y);
		}
		ArrayList<Integer> second = new ArrayList<>();
		for (int y : data3) {
			second.add(y);
		}
		List<Integer> newList = new ArrayList<>();
		newList = MergeSort.mergeSort(first, second);
		System.out.println(newList);
		Assert.assertTrue(checkSorted(newList));
	}
	
	//@Test 
	public void testRMergeSort() {
		ArrayList<Integer> sortMe = new ArrayList<>();
		for (int y : data4) {
			sortMe.add(y);
		}
		List<Integer> newList = new ArrayList<>();
		newList = MergeSort.RmergeSort(sortMe);
		System.out.println(newList);
		Assert.assertTrue(checkSorted(newList));
	}


}
