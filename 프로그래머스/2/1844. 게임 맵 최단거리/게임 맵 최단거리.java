import java.util.*;

//메모제이션 간 곳마다 카운트를 먹임.
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        if(maps[0][0] == 0 || maps[n - 1][m - 1] == 0) return -1;
        
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        int[][] memo = new int[n][m];
        memo[0][0] = 1;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int nx, ny;
        
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            
            if(x == n - 1 && y == m - 1) {
                return memo[x][y];
            }
            
            for(int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(memo[nx][ny] != 0) continue;
                if(maps[nx][ny] == 0) continue;
                
                memo[nx][ny] = memo[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
        return -1;
    }
}