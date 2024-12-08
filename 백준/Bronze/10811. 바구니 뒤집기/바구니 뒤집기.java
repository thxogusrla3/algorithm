import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] row1 = br.readLine().split(" ");
        int basketCount = stringToInteger(row1[0]);
        int rowCount = stringToInteger(row1[1]);

        int[] basket = new int[basketCount];
        for(int i = 1 ; i <= basketCount; i++) {
            basket[i - 1] = i;
        }

        int left = 0;
        int right = 0;
        int temp = 0;
        for(int i = 0; i < rowCount; i++) {
            String []row2 = br.readLine().split(" ");
            left = stringToInteger(row2[0]) - 1;
            right = stringToInteger(row2[1]) - 1;

            while (left < right) {
                temp = basket[left];
                basket[left++] = basket[right];
                basket[right--] = temp;
            }
        }

        for(int i = 0 ; i < basketCount; i++) {
            System.out.print(basket[i] + " ");
        }
    }

    private static int stringToInteger(String target) {
        return Integer.parseInt(target);
    }
}
