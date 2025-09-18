import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0 ; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(computers, visited, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void bfs(int[][] computers, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            for(int next = 0; next < computers.length; next++) {
                if(next != current && !visited[next] && computers[current][next] == 1) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
    
    private void dfs(int[][] computers, boolean[] visited, int start) {
        for(int next = 0; next < computers.length; next++) {
            if(next != start && !visited[next] && computers[start][next] == 1) {
                visited[next] = true;
                dfs(computers, visited, next);
            }
        }
    }
}