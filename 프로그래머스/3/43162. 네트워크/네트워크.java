import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[computers.length];
        
        for(int i = 0 ; i < n; i++) {
            if(!visited[i]) {
                bfs(computers, visited, i);
                answer++;
            }
        }
        return answer;
    }
    
    private void bfs(int[][] computers, boolean[] visited, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int current = q.poll();
            
            for(int next = 0; next < computers.length; next++) {
                if(next != current && !visited[next] && computers[current][next] == 1) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}