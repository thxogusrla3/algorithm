import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] a = new int[n][2];

        for(int i = 0 ; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] rank = new int[n];

        for(int i = 0 ; i < n; i++) {
            int count = 0;
            for(int j = 0 ; j < n; j++) {
                if(i == j) continue;
                if(a[j][0] > a[i][0] && a[j][1] > a[i][1]) count++;
            }
            rank[i] = count + 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n; i++) {
            sb.append(rank[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
