package array.counting;

public class MinNumberOfStepsToMakeTwoStringsAnagram {
    public int calculateSteps(String s, String t) {
        // ToDo: Write Your Code Here.
        int[] sf = new int[26];
        int[] tf = new int[26];

        for(int i= 0; i < s.length(); i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            sf[sc-'a']++;
            tf[tc-'a']++;
        }

        int ret = 0;

        for(int i = 0; i < 26; i ++) {
            if(sf[i] != tf[i] && tf[i] > sf[i]) {
                ret += tf[i] - sf[i];
            }
        }
        return ret;
    }
}
