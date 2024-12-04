package array;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if(k == 0) return;

        int[] tmp = new int[len*2];
        for(int i = 0; i < len; i++) {
            tmp[i] = nums[i];
            tmp[i+len] = nums[i];
        }

        //System.out.println(Arrays.toString(tmp));
        for(int i = 0; i < len; i++) {
            nums[i] = tmp[len - i - k];

        }
    }
}
