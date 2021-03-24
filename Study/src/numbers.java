import java.util.ArrayList;

// 같은 숫자는 제거하는 배열 함수 만들기

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
