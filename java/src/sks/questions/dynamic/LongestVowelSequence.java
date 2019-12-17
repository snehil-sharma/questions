//https://www.hackerearth.com/problem/algorithm/fun-with-vowels/description/
package sks.questions.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestVowelSequence {
	//Using concept of Longest Increasing Subsequence
	//Bottom Up Method
	
	public static int hasInOrder(String s, char c, int index){
        for(int i=index; i<s.length(); i++)
            if(s.charAt(i) == c)
                return i;
        
        return s.length();
    }
	
    public static int longestVowelSequence(String s){
        if(s == null || s.length() < 5)
            return 0;
        int i;
        
        //For checking that a,e,i,o,u appear in order at least once.
        if((i=hasInOrder(s,'a',0))==s.length())
            return 0;
        if((i=hasInOrder(s,'e',i))==s.length())
            return 0;
        if((i=hasInOrder(s,'i',i))==s.length())
            return 0;
        if((i=hasInOrder(s,'o',i))==s.length())
            return 0;
        if((i=hasInOrder(s,'u',i))==s.length())
            return 0;
        
        int max =0;
        int[] lvs = new int[s.length()];
        lvs[0] = 1;
        for(i=1; i<s.length(); i++){
            for(int j=0; j<i; j++){
            	if(lvs[i] <= lvs[j]){
                    if(s.charAt(i) == s.charAt(j))
                        lvs[i] = lvs[j] + 1;
                    else if(s.charAt(i) > s.charAt(j)){
                        if(s.charAt(i)-s.charAt(j) == 4 || s.charAt(i)-s.charAt(j) == 6)
                            lvs[i] = lvs[j] + 1;
                    }
                }
            }
            if(max < lvs[i])
                max = lvs[i];
        }
        return max;
    }
    
    public static void main(String args[] ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(longestVowelSequence(s));
    }
}
