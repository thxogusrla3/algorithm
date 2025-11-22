import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//총 경기는 48분
//비기고 있을 때 점수를 얻는 경우
//이기고 있을 때 동점이 될 경우
//이기고 있는데 점수를 얻는 경우

//입력 예제: 1 20:00
//테스트케이스 3번으로 수정 개발 진행해볼것.
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //시간 다루는 것은 다 ss 로 변환할 것
        int maxMM = formatSecond(48);
        int n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> scoreMap = new HashMap<>();
        scoreMap.put(1, 0);
        scoreMap.put(2, 0);

        Map<Integer, Integer> timeMap = new HashMap<>();
        timeMap.put(1, 0);
        timeMap.put(2, 0);

        Map<Integer, Integer> timeSumMap = new HashMap<>();
        timeSumMap.put(1, 0);
        timeSumMap.put(2, 0);

        int currentWinTeam = 0;
        for(int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            //점수딴 팀
            int upperTeam =  Integer.parseInt(st.nextToken());

            //점수딴 시간
            String time = st.nextToken();
            int mm = formatSecond(Integer.parseInt(time.split(":")[0]));
            int ss = Integer.parseInt(time.split(":")[1]);

            int total = mm + ss;

            //점수딴 팀 점수 + 1
            scoreMap.put(upperTeam, scoreMap.getOrDefault(upperTeam, 0) + 1);

            //이기고 있는 팀 비기고 있으면 0
            int moreTeam = getMoreTeamNum(scoreMap);

            if(currentWinTeam == 0 && upperTeam == moreTeam) {
                //점수를 얻은 팀과 이기고 있는 팀이 같은 경우
                currentWinTeam = moreTeam;
                timeMap.put(currentWinTeam, total);
            } else if(upperTeam != moreTeam) {
                //점수를 얻었지만 이기고 있는 팀이 다른 경우
                //점수를 얻은 팀 시간 셋팅
                timeMap.put(upperTeam, total);
            }

            //동점 인 경우 시간 셋팅.
            if(moreTeam == 0) {
                timeSumMap.put(currentWinTeam, timeSumMap.get(currentWinTeam) + timeMap.get(upperTeam) - timeMap.get(currentWinTeam));

                timeMap.put(1, 0);
                timeMap.put(2, 0);

                currentWinTeam = 0;
            }

            if(currentWinTeam != 0 && i == n - 1){
                timeSumMap.put(currentWinTeam, timeSumMap.get(currentWinTeam) + maxMM - timeMap.get(currentWinTeam));
            }
        }

        int aTime = timeSumMap.get(1);
        int bTime = timeSumMap.get(2);

        System.out.println(numToString(getMinute(aTime)) + ":" + numToString(getRemainSecond(aTime)));
        System.out.println(numToString(getMinute(bTime)) + ":" + numToString(getRemainSecond(bTime)));
    }

    private static int formatSecond(int mm) {
        return mm * 60;
    }

    private static int getMinute(int second) {
        return second / 60;
    }

    private static int getRemainSecond(int minute) {
        return  minute % 60;
    }

    private static int getMoreTeamNum(Map<Integer, Integer> score) {
        int score1 = score.get(1);
        int score2 = score.get(2);

        if(score1 == score2) return 0;
        return score.get(1) > score.get(2) ? 1 : 2;
    }

    private static String numToString(int num) {
        return num < 10 ? "0" + num : num + "";
    }
}
