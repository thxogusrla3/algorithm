import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] row1 = br.readLine().split(" ");
        String[] row2 = br.readLine().split(" ");

        int rowCount = Integer.parseInt(row1[0]);
        int compare = Integer.parseInt(row1[1]);
        int target = 0;

        for(int i = 0; i < rowCount; i++) {
            target = Integer.parseInt(row2[i]);
            if(compare > target) {
                System.out.print(target + " ");
            }
        }

    }
}
