import java.util.*;

class Solution {
    private final int[] dx = new int[] {1, -1, 0, 0};
    private final int[] dy = new int[] {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        int[][] dist = new int[n][m];
        
        if(maps[0][0] == 0 || maps[n-1][m-1] == 0) return -1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        
        dist[0][0] = 1;
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            
            if(x == n - 1 && y == m - 1) {
                return dist[x][y];
            }
            
            for(int i = 0 ; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= n || ny >= m || ny < 0) continue;
                if(dist[nx][ny] != 0) continue;
                if(maps[nx][ny] == 0) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                queue.offer(new int[] {nx, ny});
            }
        }
        
        return -1;
    }
}