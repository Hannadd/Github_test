
public class Solution {

	public static int solution(int[][] board, int[] moves) {
        int[] basket = new int [moves.length]; // move 한 만큼 바구니에 인형이 담길거다.
		int answer = 0;
		int count = 0;
		for(int i = 0; i < moves.length; i++) {
			int crain = moves[i];
			for(int j = 0; j <board.length; j++) {
					if(board[j][crain-1] != 0) {
						basket[i] = board[j][crain-1];
						board[j][crain-1] = 0;						
						break;
					}
				}	
			System.out.println(basket[i]);
		}
		while(true) {
			for(int i = 0; i < (basket.length); i++) {
				if(basket[i] != 0) {
					for (int j = (i + 1); j < basket.length; j++) {
						if(basket[j] != 0 && basket[j] == basket[i]) {
								basket[i] = 0;
								basket[j] = 0;
								answer += 2;
								break;
							}							
						else if (basket[j] != 0 && basket[j] != basket[i]){
								count ++;
								break;
							}
						}
					}
				else {
					count++;
				}
			}
			if(count == basket.length) {
				break;
			}
		}
		
        return answer;
   }
	public static void main(String[] args) {
		int[][] board = { {0,0,0,0,0},
						  {0,0,1,0,3},
						  {0,2,5,0,1},
						  {4,2,4,4,2},
						  {3,5,1,3,1}	
		};
		int[] moves = {5,1,4,1,2,3,3,2};
	
		System.out.println(solution(board, moves) + "개");
		
	}


}
