import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for(int i = 0 ; i < n; i++) {
            if(!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int[][] computers, boolean[] visited, int current) {
        if(!visited[current]){
            visited[current] = true;
        }
        
        for(int next = 0; next < computers.length; next++) {
            if(next != current && !visited[next] && computers[current][next] == 1) {
                visited[next] = true;
                dfs(computers, visited, next);
            }
        }
    }
}