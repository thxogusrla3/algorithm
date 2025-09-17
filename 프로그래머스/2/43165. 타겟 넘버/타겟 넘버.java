import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        
        while(!queue.isEmpty()) {
            int[] item = queue.poll();
            int idx = item[0];
            int sum = item[1];
            
            if(idx == numbers.length) {
                if(sum == target) {
                    answer++;
                }   
            } else {
                queue.offer(new int[]{idx + 1, sum + numbers[idx]});
                queue.offer(new int[]{idx + 1, sum - numbers[idx]});
            }
        }
        
        return answer;
    }
}