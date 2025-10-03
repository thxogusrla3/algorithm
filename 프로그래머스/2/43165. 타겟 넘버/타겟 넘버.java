import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int result = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        while(!q.isEmpty()) {
            int[] items = q.poll();
            int idx = items[0];
            int sum = items[1];
            
            if(idx == numbers.length) {
                if(target == sum) {
                    result++;
                }
                
            } else {
                q.add(new int [] {idx + 1, sum + numbers[idx]});
                q.add(new int [] {idx + 1, sum - numbers[idx]});    
            }
        }
        return result;
    }
    
    private int dfs(int[] numbers, int target, int start, int sum) {
        if(numbers.length == start) {
            return target == sum ? 1 : 0;
        }
        
        int plus = dfs(numbers, target, start + 1, sum + numbers[start]);
        int minus = dfs(numbers, target, start + 1, sum - numbers[start]);
        
        return plus + minus;
    }
}