class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0 ; i < n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(computers, visited, i);
            }
        }
        
        return answer;
    }
    
    private void dfs(int[][] computers, boolean[] visited, int current) {
        visited[current] = true;
        
        for(int next = 0; next < computers.length; next++) {            
            if(current != next && !visited[next] && computers[current][next] == 1) {
                dfs(computers, visited, next);
            }
        }
    }
}