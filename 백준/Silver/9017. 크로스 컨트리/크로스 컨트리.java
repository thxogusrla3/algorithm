
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

//여섯명이 안되는 팀은 점수를 제외한다.
//상위 4명의 점수를 합산하고 가장 큰 점수를 가진 팀이 우승한다
//점수가 같은 팀이있다면, 5등 중에 점수가 더 높은 사람으로 해당 팀이 우승한다.
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            Map<Integer, Integer> teamSum = new HashMap<>();
            Map<Integer, Integer> teamCount = new HashMap<>();
            Map<Integer, Integer> teamFive = new HashMap<>();

            int len = Integer.parseInt(br.readLine());
            int[] arr = new int[len];

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < len; j++) {
                int team = Integer.parseInt(st.nextToken());
                arr[j] = team;

                if(!teamCount.containsKey(team)) {
                    teamSum.put(team, 0);
                    teamCount.put(team, 0);
                    teamFive.put(team, 0);
                }
            }

            //팀 당 몇명인지
            Map<Integer, Long> checkCount  = Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.groupingBy(Integer::valueOf, Collectors.counting()));

            //앞에 제외되는 사람이 있는지 카운트하고 그 값만큼 자기 인덱스에서 카운트 한 값 뺌
            int exceptionCount = 0;
            for(int point = 0; point < len; point++) {
                int team = arr[point];

                if(checkCount.get(team) < 6) {
                    exceptionCount++;
                } else {
                    if(teamCount.get(team) < 4) {
                        teamCount.put(team, teamCount.get(team) + 1);
                        teamSum.put(team, teamSum.get(team) + (point + 1 - exceptionCount));
                        continue;
                    }

                    if(teamCount.get(team) == 4) {
                        teamCount.put(team, teamCount.get(team) + 1);
                        teamFive.put(team, point + 1 - exceptionCount);
                    }
                }
            }

            int winner = 0;
            int min = 0;
            int fivePoint = 0;
            for(Map.Entry<Integer, Integer> team: teamSum.entrySet()) {
                int teamNum = team.getKey();
                int teamPoint = team.getValue(); //합산 금액
                int teamFivePoint = teamFive.get(team.getKey());

                if(teamPoint == 0) continue;

                if(min == 0) {
                    min = teamPoint;
                    winner = teamNum;
                    fivePoint = teamFive.get(teamNum);
                    continue;
                }

                if(min > teamPoint) {
                    min = teamPoint; //합산 금액이 더 큰 값 조회.
                    fivePoint = teamFivePoint;
                    winner = teamNum;
                } else if(min == teamPoint) {
                    //다섯번째 중에 누가 더 낮은지 체크
                    if(fivePoint > teamFivePoint) {
                        fivePoint = teamFivePoint;
                        winner  = teamNum;
                    }
                }
            }
            System.out.println(winner);
        }
    }
}
