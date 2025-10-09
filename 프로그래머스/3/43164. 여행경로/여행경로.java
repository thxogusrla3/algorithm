import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> tMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        for(String[] ticket : tickets) {
            tMap.computeIfAbsent(ticket[0], v -> new PriorityQueue<String>()).add(ticket[1]);
        }
        
        dfs("ICN", tMap, result);
        
        Collections.reverse(result);
        return result.toArray(new String[0]);
    }
    
    private void dfs(String start, Map<String, PriorityQueue<String>>tMap, List<String> result) {
        PriorityQueue<String> pq = tMap.get(start);
        while(pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(next, tMap, result);
        }
        result.add(start);
        
    }
}