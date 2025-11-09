import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[][] map = new char[h][w];

        for(int i = 0 ; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }
        StringBuilder sb = new StringBuilder();

        char current;
        char before;

        for(int i = 0 ; i < h; i++) {
            int count = -1;
            for(int j = 0 ; j < w; j++) {
                current = map[i][j];

                if(j == 0) {
                    before = map[i][j];
                } else {
                    before = map[i][j - 1];
                }

                if(current == 'c') {
                    count = 0;
                } else if (count < 0){
                    count = -1;
                } else {
                    count++;
                }
                sb.append(count).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
