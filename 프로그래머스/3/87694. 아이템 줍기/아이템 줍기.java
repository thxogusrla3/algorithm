import java.util.*;

class Solution {
    private static final int MAX = 105; //50(최대입력값) * 2 + 5(여유값)
    private static final int[] dx = new int[] {1, -1, 0, 0};
    private static final int[] dy = new int[] {0, 0, 1, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int[] r : rectangle) {
            r[0] *= 2; r[1] *= 2; r[2] *= 2; r[3] *= 2;
        }
        characterX *= 2; characterY *= 2;
        itemX *= 2; itemY *= 2;
        
        boolean[][] board = new boolean[MAX][MAX];
        
        //모든 영역 true 처리
        for(int[] r : rectangle) {
            for(int x = r[0]; x <= r[2]; x++) {
                for(int y = r[1]; y <= r[3]; y++) {
                    board[x][y] = true;
                }
            }
        }
        
        //내부 영역 false 처리
        for(int[] r: rectangle) {
            for(int x = r[0] + 1; x <= r[2] -1; x++) {
                for(int y = r[1] + 1; y <= r[3] -1; y++) {
                    board[x][y] = false;
                }
            }
        }
        
        int[][] dist = new int[MAX][MAX];
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int[] row: dist) Arrays.fill(row, -1);
        
        dist[characterX][characterY] = 0;
        q.add(new int[]{characterX, characterY});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
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
        return -1;
    }
    
}