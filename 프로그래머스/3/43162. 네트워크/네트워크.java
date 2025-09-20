import java.util.*;

class Solution {
    //시작하는 얘는 무조건 카운트 되어야함.
    //방문했는지 체크 필요하고.
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(computers, visited, i);
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
            
            for(int next = 0 ; next < computers.length; next++) {
                if(next != current && !visited[next] && computers[current][next] == 1) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
    
    private void dfs(int[][] computers, boolean[] visited, int current) {
        visited[current] = true;
        
        for(int next = 0; next < computers.length; next++) {
            if(current != next && !visited[next] && computers[current][next] == 1) {
                dfs(computers, visited, next);
                visited[next] = true;
            }
        }
    }
}