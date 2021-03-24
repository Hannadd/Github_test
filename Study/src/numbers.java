import java.util.ArrayList;

//이거 주석 깨졌다 ..

public class numbers {

	public static int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> arrInt = new ArrayList<Integer>();
        for(int i = 0; i < arr.length; i++) {
        	if(i == 0) {
        		arrInt.add(i, arr[i]);
        	}
        	else {
        		if(arrInt.get(arrInt.size()-1) != arr[i]) {
        			arrInt.add(arrInt.size(), arr[i]);
        		}
        	}
        }
        
        answer = new int[arrInt.size()];
        
        for(int i = 0; i < arrInt.size(); i++) {
        	answer[i] = arrInt.get(i);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] arr1 = {1,1,3,3,0,1,1};
		int[] arr2 = {4,4,4,3,3};
		
		for(int i = 0; i < solution(arr2).length; i++) {
			System.out.println(solution(arr2)[i]);
		}
	    
	}

}
