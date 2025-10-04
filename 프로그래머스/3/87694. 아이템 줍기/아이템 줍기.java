import java.util.*;

class Solution {
    private static final int[] dx = new int[] {1, -1, 0, 0};
    private static final int[] dy = new int[] {0, 0, 1, -1};
    private static final int MAX = 105;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        boolean[][] board = new boolean[MAX][MAX];
        int[][] dist = new int[MAX][MAX];
        
        for(int[] r: rectangle) {
            r[0] *= 2; r[1] *= 2; r[2] *= 2; r[3] *= 2;
        }
        characterX *= 2; characterY *= 2;
        itemX *= 2; itemY *= 2;
        
        for(int[] r: rectangle) {
            for(int x = r[0]; x <= r[2]; x++) {
                for(int y = r[1]; y <= r[3]; y++) {
                    board[x][y] = true;
                    dist[x][y] = -1;
                }
            }
        }
        
        for(int[] r: rectangle) {
            for(int x = r[0] + 1; x <= r[2] - 1; x++) {
                for(int y = r[1] + 1; y <= r[3] - 1; y++) {
                    board[x][y] = false;
                }
            }
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{characterX, characterY});
        dist[characterX][characterY] = 0;
        
        while(!q.isEmpty()) {
            int[] point = q.poll();
            int cx = point[0];
            int cy = point[1];
            
            if(cx == itemX && cy == itemY) return dist[cx][cy] / 2;
            
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= MAX || ny >= MAX) continue;
                if(!board[nx][ny]) continue;
                if(dist[nx][ny] != -1) continue;
                
                dist[nx][ny] = dist[cx][cy] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        
        return 0;
    }
}