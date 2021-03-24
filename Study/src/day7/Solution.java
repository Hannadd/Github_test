package day7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Solution {
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
       
        HashMap<Integer, String> part = new HashMap<Integer, String>();
        Set<Integer> partkey = part.keySet();
        Iterator<Integer> itpartkey = partkey.iterator();

        HashMap<Integer, String> comp = new HashMap<Integer, String>();
        Set<Integer> compkey = comp.keySet();
        Iterator<Integer> itcompkey = compkey.iterator();
        
        for (int i = 0; i < participant.length; i++) {
        	part.put(i+1, participant[i]);
        }
        
        for (int i = 0; i < completion.length; i++) {
        	comp.put(i+1, completion[i]);
        }
        
          
        
        
        
        
        
        
        return answer;
    }
	
	
	public static void main(String[] args) {
	String[] participant = {"leo", "kiki", "eden"};
	String[] completion = {"eden", "kiki"};
	
	System.out.println("Å»ÁÖÀÚ´Â" + solution(participant, completion));
	
		
		
	}

}
