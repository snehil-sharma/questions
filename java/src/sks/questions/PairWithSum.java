//Find all unique pairs in given list which equal to given sum
package sks.questions;

import java.util.ArrayList;
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
	
	public static ArrayList<Pairs> getPairs(int[] arr, int sum){
		ArrayList<Pairs> al = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		int comp;	// complement = sum - value
		
		for(int i=0; i<arr.length; i++) {
			comp = sum - arr[i];
			if(hm.containsKey(arr[i])) {
				if(hm.get(arr[i]) == 1) {
					al.add(new Pairs(comp, arr[i]));
					hm.put(arr[i],2);
				}
			}
			else
				if(!hm.containsKey(comp))
					hm.put(comp, 1);
		}
		return al;
	}

	public static void main(String[] args) {
		int[] arr = {1,1,2,4,4,4,4,7,1,1,7,7,6,7,6,7,2};
		int sum = 8;
		System.out.println(getPairs(arr, sum));
	}

}