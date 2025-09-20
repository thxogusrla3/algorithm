import java.util.*;

class Solution {
    //1 또는 -1 을 번갈아가면서 해야하는데 5번 반복해야해
    public int solution(int[] numbers, int target) {
        int bfs = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int index = current[0];
            int sum = current[1];
            
            if(index == numbers.length) {
                if(target == sum) {
                    bfs++;
                }
            } else {
                queue.offer(new int[] {index + 1, sum + numbers[index]});
                queue.offer(new int[] {index + 1, sum - numbers[index]});
            }
        }
        //return dfs(numbers, target, 0, 0);
        return bfs;
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