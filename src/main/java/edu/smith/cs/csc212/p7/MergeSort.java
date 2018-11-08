package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Cite: https://en.wikipedia.org/wiki/Merge_sort
//Cite: https://www.geeksforgeeks.org/merge-sort/
import java.util.Set;

public class MergeSort {
	
	/*
	 * takes lists that are already sorted and
	 * returns a new, larger merged sorted list
	 */
	public static List<Integer> mergeSort(List<Integer> input1, List<Integer> input2) {
		//int N = input1.size();
		List<Integer> newList = new ArrayList<>();
		
		while (input1.size() !=0 && input2.size() !=0) {
			if (input1.get(0) <= input2.get(0)) {
				newList.add(input1.get(0));
				input1 = input1.subList(1, input1.size()-1);
			} else {
				newList.add(input2.get(0));
				input2 = input2.subList(1, input2.size()-1);
			}
		}
		while (input1.size() !=0) {
			newList.add(input1.get(0));
			input1 = input1.subList(1, input1.size()-1);
		}
		while (input2.size() != 0) {
			newList.add(input2.get(0));
			input2 = input2.subList(1,  input2.size()-1);
		}
		return newList;
	}
	
	/*
	 * Used by mergeSortR. Takes two sorted halves of a list and 
	 * merges them together 
	 * @return a single sorted list  
	 */
	public static List<Integer> merge(List<Integer> left, List<Integer> right) {
		

		
		List<Integer> output = new ArrayList<>();

		int i = 0;
		int j = 0;
		int n1 = left.size(); //size of first half 
		int n2 = right.size();//size of the second half 
		int endi = 0;
		int endj = 0;
		
		while(i<n1 && j<n2) {
			
			if(left.get(i) <= right.get(j)) {
				output.add(left.get(i));
				System.out.println(output);
				i++;
			} else {
				output.add(right.get(j));
				System.out.println(output);
				j++;
			}
		}
		
		while (i < n1)  {
			output.add(left.get(i));
			System.out.println("left" +output);
			i++;
		}
		while (j < n2) {
			output.add(right.get(j));
			System.out.println("right" + output);
			j++;
		}
		System.out.println("Returned" +output);
		return output;
	}
	
	
	/*
	 * The is merge sort that sorts an unsorted list recursively. 
	 * It recursively breaks down the list and eventually calls merge
	 * to merge the two already sorted lists of fixedRight and fixedLeft
	 * @return the entire input List sorted 
	 */
	public static List<Integer> mergeSortRec(List<Integer> input) {
		if (input.size() >= 2) {
			int iMiddle =input.size() / 2;
			
			List<Integer> fixedLeft = mergeSortRec(input.subList(0, iMiddle));
			List<Integer> fixedRight = mergeSortRec(input.subList(iMiddle, input.size()));
			return merge(fixedLeft, fixedRight);
		} else {
			return input;
		}
	}
	
	
	public static List<Integer> mergeSortIns(List<Integer> input) {
		List<List<Integer>> worklist = new ArrayList<>();
		int N = input.size();
		
		//Makes a list (worklist) that contains each element of input at a list
		//
		for (int i = 0; i< N-1; i++) {
			int x = input.get(i);
			List<Integer> xchunk = Collections.singletonList(x);
			worklist.add(xchunk);
		}
		System.out.println("Worklist: " + worklist);
		int wn = worklist.size();
		System.out.println("Worklist SIZE: " + wn);
		while (worklist.size()>=2) {
			for (int i = 0; i< wn-1; i++) {
				List<Integer> temp = merge(worklist.get(0), worklist.get(1));
				System.out.println("TEMP!: " + temp);
				//delete the first and then "the second" (when first is 
				//deleted the second moves to the first spot
				worklist.remove(0);
				worklist.remove(0);
				worklist.add(temp);

			}
		}
		return worklist.get(0);
		
	}
	
	
	
	
	
}







