import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)) return 0;
        
        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[words.length];
        
        q.add(begin);
        map.put(begin, 0);
        
        while(!q.isEmpty()) {
            String current = q.poll();
            
            if(current.equals(target)) {
                return map.get(current);
            }
            
            for(int i = 0 ; i < words.length; i++) {
                if(visited[i]) continue;
                
                String next = words[i];

                if(isDiffOne(next, current)) {
                    map.put(next, map.get(current) + 1);
                    q.add(next);
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
    
    private boolean isDiffOne(String compare, String target) {
        int count = 0;
        for(int i = 0 ; i < compare.length(); i++) {
            char a = compare.charAt(i);
            char b = target.charAt(i);
            
            if(a != b) {
                count++;
            }
        }
        return count == 1;
    }
}