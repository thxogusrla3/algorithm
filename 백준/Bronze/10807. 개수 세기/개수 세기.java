import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cntRow = Integer.parseInt(br.readLine());
        String[] row = br.readLine().split(" ");
        int target = Integer.parseInt(br.readLine());

        int result = 0;
        for(int i = 0; i < cntRow; i++) {
            if(target == Integer.parseInt(row[i])) {
                result += 1;
            }

        }
        System.out.println(result);
    }
}
