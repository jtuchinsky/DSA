package array.twopointers;

public class SeparateBlackAndWhiteBalls {
    public long minimumSteps(String s) {
        int slow = -1, fast = -1; long cnt = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            fast++;
            if(c == '0') {
                slow++;
                cnt += (fast - slow);
                //fast++;
            }

            //System.out.println("s: " + slow + " f: " + fast + " c: " + cnt);
        }
        return cnt;
    }
}
