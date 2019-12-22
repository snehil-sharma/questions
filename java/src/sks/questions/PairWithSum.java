//Find all unique pairs in the given list which equals to the given sum.
package sks.questions.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PairWithSum {
	private final static class Pairs{
		final int value1;
		final int value2;
		
		Pairs(int v1, int v2){
			this.value1 = v1;
			this.value2 = v2;
		}
		
		@Override
		public String toString() {
			String s = this.value1 + "+" + this.value2;
			return s;
		}
	}
	
	//For Unsorted Array; T(n) = O(n)
	private static ArrayList<Pairs> getPairs1(int[] arr, int sum){
		if(arr == null || arr.length < 2)
			throw new IllegalArgumentException();	//Unchecked Exception i.e. subclass of RuntimeException or Error
		ArrayList<Pairs> al = new ArrayList<>();
		HashMap<Integer, Boolean> hm = new HashMap<>();
		int comp;	// complement = sum - value
		
		for(int i=0; i<arr.length; i++) {
			comp = sum - arr[i];
			if(hm.containsKey(arr[i])) {
				if(hm.get(arr[i]) == false) {
					al.add(new Pairs(comp, arr[i]));
					hm.put(arr[i],true);
				}
			}
			else
				if(!hm.containsKey(comp))
					hm.put(comp, false);
		}
		return al;
	}
	
	//Only for Sorted Array then; T(n) = O(n) otherwise T(n) = T(n) of sorting algorithm used.
	//This is running faster then getPairs1 even with sorting? => Because of very small size of array.
	private static ArrayList<Pairs> getPairs2(int arr[], int sum){
		if(arr == null || arr.length < 2)
			throw new IllegalArgumentException();
		ArrayList<Pairs> al = new ArrayList<>();
		int i = 0, j = arr.length-1;
		
		while(i<j) {
			if(arr[i] + arr[j] == sum) {
				al.add(new Pairs(arr[i], arr[j]));
				do {i++;} while(i<arr.length && arr[i-1] == arr[i]);
				do {j--;} while(j>=0 && arr[j] == arr[j+1]);
			}
			else if(arr[i] + arr[j] < sum)
				do {i++;} while(i<arr.length && arr[i-1] == arr[i]);
			else
				do {j--;} while(j>=0 && arr[j] == arr[j+1]);
		}
		return al;
	}

	public static void main(String[] args) {
		int[] arr = {1,1,2,4,4,4,4,7,1,1,7,7,-1,6,7,6,9,7,2};
		int sum = 8;
		long start = System.nanoTime();
		System.out.println(getPairs1(arr, sum));
		System.out.println("getPairs1: " + (System.nanoTime() - start) +" ns");
		
		start = System.nanoTime();
		Arrays.sort(arr);
		System.out.println("\n" + getPairs2(arr, sum));
		System.out.println("getPairs2: " + (System.nanoTime() - start) +" ns");
	}

}
