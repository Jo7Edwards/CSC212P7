package edu.smith.cs.csc212.p7;

//import java.util.ArrayList;
import java.util.List;
//Cite: https://docs.oracle.com/javase/8/docs/api/java/util/List.html
//Cite: https://en.wikipedia.org/wiki/Selection_sort
/*
 * Slides that were useful from JJ's lecture:https://moodle.smith.edu/pluginfile.php/599659/mod_resource/content/0/14_Sorting_2.pdf
 * 
 * 
 * This corrects the minimum. That is, when it finds the 
 * minimum thing in the list, it removes it from where 
 * it is and adds it to the beginning. 
 */
public class SelectionSort {
	/*
	 * Move item to front and delete from where it was 
	 * @param list of items
	 * @param obj is the int that we want to move
	 * @param k is the index where it originally was on the list
	 */
/*	public static void moveToFront(List<Integer> items, int obj, int k, int indexStart) {
		items.remove(k);
		items.set(0,  obj);
		
		
	}*/
	public static void swap(List<Integer> items, int i, int j) {
		assert(i != j);
		int tmp = items.get(i);
		items.set(i,  items.get(j));
		items.set(j, tmp);
	}
	
	/*public static List<Integer> removeFront(List<Integer> items) {
		List<Integer> newList = new ArrayList<>();
		
		newList = items;
		newList.remove(0);
		
		return newList;
	}*/
	
	/*
	 * This works by using nested for loops. Within the first loop over the list
	 * start with the first int ( and make it min as its the smallest thing you've
	 * seen so far). Then, make the next for loop so that for every
	 * thing in the list you check what's the smallest. Once you
	 * get the min, if the min is something different than the item 
	 * we're on in the first for loop then swap them, which 
	 * always puts the min or next min at the beginning/next in order
	 */
	public static void selectionSort(List<Integer> input) {
		int N = input.size();
		int min = 0;
		int minIndex = 0;
		
			for (int i=0; i<N-1; i++) {
				//initialize minimum stuff
				min = input.get(i);
				minIndex = i;
				//Check everything after i in the list...
				for (int j = i+1; j<N ; j++ ) {
					//...and if any new item we come upon is smaller, set that to min
					if (input.get(j) < min) {
						min = input.get(j);
						minIndex = j;
					}
				}
				//if we set the min to something other than what's at i, then swap
				if (minIndex != i) {
					swap(input, minIndex, i);
				}
			}	
		}
}
