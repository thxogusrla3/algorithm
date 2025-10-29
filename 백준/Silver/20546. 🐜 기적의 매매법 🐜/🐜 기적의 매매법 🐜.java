
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
100
10 20 23 34 55 30 22 19 12 45 23 44 34 38
=> BNP
*
15
20 20 33 98 15 6 4 1 1 1 2 3 6 14
=> TIMING
* */
public class Main {
    private static final int SIZE = 14;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] numbers = new int[SIZE];
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < SIZE; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int a = bnp(N, numbers);
        int b = timing(N, numbers);

        if(a == b){
            System.out.println("SAMESAME");
        } else {
            System.out.println(a > b ? "BNP" : "TIMING");
        }
    }

    private static int bnp(int n, int[] numbers) {
        int count = 0;

        for(int i = 0; i < SIZE; i++) {
            int num = numbers[i];
            if(num <= n) {
                count += (n / num);
                n = n % num;
            }
        }
        return n + (count * numbers[SIZE - 1]);
    }

    //전량매수, 매도
    //3일동안 오르 내린 경우
    private static int timing(int n, int[] numbers) {
        int beforeAmt = 0;
        int upCnt = 0; //상승횟수
        int downCnt = 0; //하락횟수

        int count = 0;
        for(int i = 1 ; i < SIZE; i++) {
            int num = numbers[i];
            beforeAmt = numbers[i - 1];

            if(beforeAmt < num) {
                upCnt++;
                downCnt = 0;

                if(upCnt == 3) { //전량매도
                    n = n + (count * num);
                    count = 0;
                }
            } else if(beforeAmt > num){
                upCnt = 0;
                downCnt++;

                if(downCnt >= 3) { //전량 매수
                    if(n >= num) {
                        count = count + (n / num);
                        n = n % num;
                    }
                }
            } else {
                upCnt = 0;
                downCnt = 0;
            }
        }

        return n + (count * numbers[SIZE - 1]);
    }
}
