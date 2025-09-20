import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {        
        if(!Arrays.asList(words).contains(target)) return 0;
        
        boolean[] visited           = new boolean[words.length];
        Map<String, Integer> dist   = new HashMap<>();
        Queue<String> queue         = new ArrayDeque<>();
        
        dist.put(begin, 0);
        queue.add(begin);
        
        while(!queue.isEmpty()) {
            String current = queue.poll();
            int step = dist.get(current);
            
            for(int i = 0 ; i < words.length; i++) {
                if(visited[i]) continue;
                String next = words[i];
                if(!isDiffOne(current, next)) continue;
                
                
                visited[i] = true;
                dist.put(next, step + 1);
                
                if(target.equals(next)) return step + 1;
                
                queue.add(next);
            }
        }
        
        return 0;
    }
    
    private boolean isDiffOne(String a, String b) {
        int size = a.length();
        int diffCount = 0;
        
        for(int i = 0; i < size; i++) {
            if(a.charAt(i) != b.charAt(i)) {
                diffCount++;
                
                if(diffCount > 1) {
                    return false;
                }
            }
        }
        
        return diffCount == 1;
    }
}