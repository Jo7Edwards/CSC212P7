package edu.smith.cs.csc212.p7;

import java.util.ArrayList;
import java.util.List;

//Cite: https://en.wikipedia.org/wiki/Insertion_sort 
//Cite: https://docs.oracle.com/javase/8/docs/api/java/util/List.html

public class InsertionSort {
	/**
	 * Swap items in a list!
	 * @param items the list.
	 * @param i swap the item at this index with the one at j.
	 * @param j swap the item at this index with the one at i.
	 */
	public static void swap(List<Integer> items, int i, int j) {
		assert(i != j);
		int tmp = items.get(i);
		items.set(i,  items.get(j));
		items.set(j, tmp);
	}
	
	public static void insertionSort(List<Integer> input) {
		int N = input.size();
		int min = 0;
		int minIndex = 0;
		
		int moveObj = 0;
		int x = 0;
		int k = 0;
		//int newN = newList.size();
		for (int i = 1; i < N; i++) {
			x = input.get(i);
			k = i-1;
			while (k>= 0 && input.get(k) > x) {
				input.set(k+1, input.get(k));
				k = k-1;
			}
			input.set(k+1, x);
		}
		
		/*int firstInt = 0;
		firstInt = input.get(0);
		List<Integer> newList = new ArrayList<>();
		int N2 = newList.size();
		newList.add(firstInt);
		for (int i = 0; i < N-1; i++) {
			 moveObj = input.get(i);
			 for (int j = 0; j <= N2; j++) {
				 if (N2 == 0) {
					 newList.add(0, moveObj);
				 }
				 if (j == N2) {
					 continue;
				 }
				 if (N2 == 1) {
					 
				 }
				 if (newList.get(j) < moveObj && newList.get(j+1) > moveObj) {
					 newList.add(j+1, moveObj);
				 }
			 }
		}*/
	}

}
