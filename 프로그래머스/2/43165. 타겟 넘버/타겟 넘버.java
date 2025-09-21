import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        
        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            int idx = q[0];
            int sum = q[1];
            
            if(idx == numbers.length) {
                if(target == sum) {
                    answer++;
                }
            } else {
                queue.add(new int[] {idx + 1, sum + numbers[idx]});
                queue.add(new int[] {idx + 1, sum - numbers[idx]});
            }
        }
        //return dfs(numbers, target, 0, 0);
        return answer;
    }
    
    private int dfs(int[] numbers, int target, int start, int sum) {
        if(start == numbers.length) {
            return target == sum ? 1 : 0;
        }
        
        int plus = dfs(numbers, target, start + 1, sum + numbers[start]);
        int minus = dfs(numbers, target, start + 1, sum - numbers[start]);
        
        return plus + minus;
    }
}