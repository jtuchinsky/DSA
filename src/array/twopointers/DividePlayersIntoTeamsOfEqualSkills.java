package array.twopointers;

import java.util.Arrays;

// Leetcode 2491
public class DividePlayersIntoTeamsOfEqualSkills {
    public long dividePlayers(int[] skill) {
        long ret = 0L;
        if(skill == null || skill.length == 0) return ret;

        Arrays.sort(skill);

        int l = 0, r = skill.length - 1;
        long sum = skill[0] + skill[skill.length - 1];

        while(l < r) {
            if (skill[l] + skill[r] != sum) return -1;
            ret = ret + (skill[l++] * skill[r--]);
        }

        return ret;
    }
}
