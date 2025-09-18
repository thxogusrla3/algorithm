import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        
        while(!queue.isEmpty()) {
            int[] items = queue.poll();
            int idx = items[0];
            int sum = items[1];
            
            if(idx == numbers.length) {
                if(target == sum) {
                    answer++;
                }
            } else {
                queue.offer(new int[] {idx + 1, sum + numbers[idx]});
                queue.offer(new int[] {idx + 1, sum - numbers[idx]});
            }
        }
        
        System.out.println(answer);
        
        return answer;//dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int idx, int sum) {
        if(numbers.length == idx) {
            return target == sum ? 1 : 0;
        }
        
        int plus = dfs(numbers, target, idx + 1, sum + numbers[idx]);
        int minus = dfs(numbers, target, idx + 1, sum - numbers[idx]);
        
        return plus + minus;
    }
    
}