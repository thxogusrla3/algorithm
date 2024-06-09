import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        // 선물 지수를 구해보자
        String[] gift;
        Map<String, Integer> countIndexMap = new HashMap<>(); //선물지수
        Map<String, Map<String, Integer>> giveMap = new HashMap<>(); //준사람
        Map<String, Integer> takeMap;
        Map<String, Integer> giveDetailMap;

        int giveCount = 0;
        int takeCount = 0;
        int nextGiftCount = 0;

        initAllMap(friends, countIndexMap, giveMap);
        makeGiftToMap(gifts, countIndexMap, giveMap);

        //A > B 인 경우
        for(String give: friends) {
            giveDetailMap = giveMap.get(give);
            nextGiftCount = 0;
            for(String take: giveDetailMap.keySet()) {
                giveCount = giveDetailMap.get(take);
                takeCount = giveMap.get(take).get(give);

                if(giveCount > takeCount) {
                    nextGiftCount = nextGiftCount + 1;
                }

                if(giveCount == takeCount) {
                    if((countIndexMap.get(give) > countIndexMap.get(take))) {
                        nextGiftCount += 1;
                    }
                }
            }
            answer = Math.max(answer, nextGiftCount);
        }

       return answer;
    }   
    
    private void makeGiftToMap(String[] gifts, Map<String, Integer> countIndexMap, Map<String, Map<String, Integer>> giveMap) {
        String[] gift;
        Map<String, Integer> takeMap;
        for (String s : gifts) {
            gift = s.split(" ");
            countIndexMap.put(gift[0], countIndexMap.getOrDefault(gift[0], 0) + 1);
            countIndexMap.put(gift[1], countIndexMap.getOrDefault(gift[1], 0) - 1);

            takeMap = giveMap.get(gift[0]);
            takeMap.put(gift[1], takeMap.get(gift[1]) + 1);
            giveMap.put(gift[0], takeMap);
        }
    }

    private void initAllMap(
            String[] friends,
            Map<String, Integer> countIndexMap,
            Map<String, Map<String, Integer>> giveMap
    ) {
        Map<String, Integer> tempTakeMap;
        for(String friend: friends) {
            countIndexMap.put(friend, 0);
            tempTakeMap = new HashMap<>();
            for(String take: friends) {
                if(!friend.equals(take)) {
                    tempTakeMap.put(take, 0);
                    giveMap.put(friend, tempTakeMap);
                }
            }
        }
    }
    
}