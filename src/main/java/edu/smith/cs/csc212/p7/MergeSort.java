package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;
//Cite: https://en.wikipedia.org/wiki/Merge_sort

public class MergeSort {
	/*
	 * takes lists that are already sorted and
	 * returns a new, larger merged sorted list
	 */
	public static List<Integer> mergeSort(List<Integer> input1, List<Integer> input2) {
		//int N = input1.size();
		List<Integer> newList = new ArrayList<>();
		/*
		for (int i=0; i<N-1; i++) {
			int obj1 = input1.get(i);
			int obj2 = input2.get(i);
			if (obj1 < obj2) {
				newList.add(i, obj1);
				input1.remove(i);
			} else if (obj1 > obj2) {
				newList.add(i, obj2);
				input2.remove(i);
			}
		}*/
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
	 * RMerge sort that takes an unsorted list and uses 
	 * recursion to complete Merge Sort
	 */
	public static List<Integer> RmergeSort(List<Integer> input) {
		List<Integer> newList = new ArrayList<>();
		List<Integer> BList = new ArrayList<>();
		int N = input.size();
		//copy all elements to a list
		for (int i=0;i < N-1; i++) {
			BList.add(input.get(i));
		}
		newList = SplitMerge(BList, 0, N-1, input);
		
		return newList;
		
		
	}
	
	public static List<Integer> SplitMerge(List<Integer> B, int iBegin, int iEnd, List<Integer> A) {
		List<Integer> newList = new ArrayList<>();
		if (iEnd - iBegin < 2) {
			return A;
		}
		int iMiddle = (iEnd + iBegin) / 2;// midpoint
		
		SplitMerge(A, iBegin, iMiddle, B);
		SplitMerge(A, iMiddle, iEnd, B);
		newList = topMerge(B, iBegin, iMiddle, iEnd, A);
		return newList;
	}
	
	public static List<Integer> topMerge(List<Integer> B, int iBegin, int iMiddle, int iEnd, List<Integer> A) {
		int i = iBegin;
		int j = iMiddle;
		int k =0;
		while (B.size() != 0 || A.size() != 0) {
			for (k =iBegin;k<iEnd;k++) {
				if (i < iMiddle && (j >= iEnd || A.get(i) <= A.get(j))) {
					B.set(k, A.get(i));
					i++;
				} else {
					B.set(k, A.get(j));
					j++;
				}

			}
		}
		return B;
	}
	
	
	
	
}







