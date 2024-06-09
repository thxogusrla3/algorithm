class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int totalHealth = health;
        int differenceAttack = 0;
        for(int i = 0 ; i < attacks.length; i++) {
            if( i == 0) {
                differenceAttack = attacks[i][0];
            } else {
                differenceAttack = attacks[i][0] - attacks[i - 1][0];
            }

            for(int j = 1; j < differenceAttack; j++) {
                totalHealth = Math.min(totalHealth + bandage[1], health);
                if (j % (bandage[0]) == 0) {
                    totalHealth = Math.min(totalHealth + bandage[2], health);
                }
            }
            totalHealth = totalHealth - attacks[i][1];
            if(totalHealth <= 0) {
                totalHealth = -1;
                break;
            }
        }
        
        return totalHealth;
    }
}