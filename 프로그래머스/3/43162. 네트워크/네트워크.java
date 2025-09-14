import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        return answer;
    }
    
    //bfs는 큐를 활용
    private void bfs(int start, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        //현재보다 다음꺼를 찾기 위해
        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            for(int next = 0 ; next < computers.length; next++) {
                if(next != current && computers[current][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
    
    private void dfs(int current, int[][] computers, boolean[] visited) {
        visited[current] = true;
        for(int next = 0; next < computers.length; next++) {
            if(next != current && computers[current][next] == 1 && !visited[next]) {
                dfs(next, computers, visited);
            }
        }
    }
}