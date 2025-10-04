import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        if(!Arrays.asList(words).contains(target)) {
            return 0;
        }         
        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> dist = new HashMap<>();
        dist.put(begin, 0);
        q.add(begin);

        while(!q.isEmpty()) {
            String start = q.poll();
            if(start.equals(target)) return dist.get(start);

            for(String nextWord: words) {                
                if(isDiffOne(start, nextWord)) {
                    if(dist.containsKey(nextWord)) continue;
                    
                    dist.put(nextWord, dist.get(start) + 1);
                    q.add(nextWord);
                }
            }
        }
        return 0;
    }
    
    private boolean isDiffOne(String start, String next) {
        int count = 0;
        
        for(int i = 0 ; i < start.length(); i++) {
            char a = start.charAt(i);
            char b = next.charAt(i);
            
            if(a != b) count++;
        }
        
        return count == 1 ? true : false;
    }
}