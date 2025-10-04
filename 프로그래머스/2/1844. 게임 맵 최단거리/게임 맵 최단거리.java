import java.util.*;

class Solution {
    private static int[] dx = new int[] {1, -1, 0, 0};
    private static int[] dy = new int[] {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        
        int[][] dist = new int[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0});
        
        dist[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] point = q.poll();
            int x = point[0];
            int y = point[1];
            
            if(x == N - 1 && y == M - 1) return dist[x][y];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(dist[nx][ny] != 0) continue;
                if(maps[nx][ny] == 0) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                q.add(new int[] {nx, ny});
            }
        }
        
        return -1;
    }
}