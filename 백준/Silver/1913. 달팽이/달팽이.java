import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int target = Integer.parseInt(br.readLine().trim());

        int[][] board = new int[N][N];

        // 방향: 위, 오른쪽, 아래, 왼쪽
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = N / 2;
        int y = N / 2;
        int num = 1;
        board[x][y] = num;

        int ansRow = x;  // 0-based
        int ansCol = y;  // 0-based
        if (num == target) {
            ansRow = x;
            ansCol = y;
        }

        int len = 1;      // 현재 구간에서 이동할 칸 수
        int dir = 0;      // 현재 방향 인덱스 (0:위, 1:오른쪽, 2:아래, 3:왼쪽)

        outer:
        while (num < N * N) {
            // 같은 길이(len)로 두 방향을 움직인다.
            for (int r = 0; r < 2; r++) {
                for (int i = 0; i < len; i++) {
                    if (num == N * N) {
                        break outer;
                    }

                    x += dx[dir];
                    y += dy[dir];
                    num++;
                    board[x][y] = num;

                    if (num == target) {
                        ansRow = x;
                        ansCol = y;
                    }
                }
                dir = (dir + 1) % 4;  // 방향 전환
            }
            len++; // 두 방향 이동 후에 길이 증가
        }

        StringBuilder sb = new StringBuilder();
        // 배열 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]).append(' ');
            }
            sb.append('\n');
        }
        // target 위치 (1-based)
        sb.append(ansRow + 1).append(' ').append(ansCol + 1).append('\n');

        System.out.print(sb.toString());
    }
}
