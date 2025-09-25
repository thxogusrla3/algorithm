import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] t: tickets) {
            map.computeIfAbsent(t[0], k -> new PriorityQueue<>()).offer(t[1]);
        }
        
        List<String> route = new ArrayList<>();
        dfs("ICN", map, route);
        
        Collections.reverse(route);
        
        return route.toArray(new String[0]);
    }
    
    private void dfs(String u, Map<String, PriorityQueue<String>> map, List<String> route) {
        PriorityQueue<String> pq = map.get(u);
        while(pq != null && !pq.isEmpty()) {
            String current = pq.poll();
            dfs(current, map, route);
        }
        route.add(u);
    }
}