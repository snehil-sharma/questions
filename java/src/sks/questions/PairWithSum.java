package sks.questions;

import java.util.ArrayList;
import java.util.HashMap;

public class PairWithSum {
	private final static class Pairs{
		final int value1;
		final int value1Pos;
		final int value2;
		final int value2Pos;
		
		Pairs(int v1, int v1p, int v2, int v2p){
			this.value1 = v1;
			this.value1Pos = v1p;
			this.value2 = v2;
			this.value2Pos = v2p;
		}
		
		@Override
		public String toString() {
			String s = this.value1 + " " + this.value2;
			return s;
		}
	}
	
	public static ArrayList<Pairs> getPairs(int[] arr, int sum){
		ArrayList<Pairs> al = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			if(hm.containsKey(arr[i])) {
				al.add(new Pairs(sum-arr[i], hm.get(arr[i]), arr[i], i));
				hm.remove(arr[i]);
			}
			else
				hm.put(sum-arr[i], i);
		}
		return al;
	}

	public static void main(String[] args) {
		int[] arr = {1,1,2,4,4,4,4,7,1,1,7,7,7,7};
		int sum = 8;
		System.out.println(getPairs(arr, sum));
	}

}
