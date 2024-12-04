public class Recursion {
    public static void preorder(int[] arr){
        System.out.println("Preorder from start: " + preorderFromStart(arr, 0));
        System.out.println("Preorder from end: " + preorderFromEnd(arr, arr.length - 1));
    }

    private static String preorderFromStart(int[] arr, int i){
        if(i == arr.length-1) {
            return "" + arr[i];
        }

        String s = "" + arr[i] + preorderFromStart(arr,i + 1);
        return s;
    }

    private static String preorderFromEnd(int[] arr, int i) {
        if(i == 0) {
            return "" + arr[i];
        }
        String prefix = preorderFromEnd(arr,i - 1);
        String s = prefix + arr[i];
        return s;
    }

    public static void postorder(int[] arr){
        System.out.println("Postorder from Start: " + postorderFromStart(arr, 0));
        System.out.println("Postorder from End: " + postorderFromEnd(arr, arr.length - 1));
    }

    private static String postorderFromStart(int[] arr, int i) {
        if(i== arr.length - 1){
            return "" + arr[i];
        }

        String prefix = postorderFromStart(arr, i + 1);
        String s = prefix + arr[i];
        return s;
    }

    private static String postorderFromEnd(int[] arr, int i){
        if(i == 0) {
            return "" + arr[i];
        }

        String s = "" + arr[i] + postorderFromEnd(arr,i - 1);
        return s;
    }

    public static String itoa(int i){
        //System.out.println("i:" + i);
        if(i / 10 == 0) {
            return "" + i%10;
        }

        int rest = i/10;
        String prefix = itoa(rest);
        //System.out.println(prefix);

        int lastDigit = i%10;
        return prefix + lastDigit;
    }

    public static String itoa2(int i){
        //System.out.println("i:" + i);
        if(i / 10 == 0) {
            return "" + i%10;
        }

        int rest = i/10;
        int lastDigit = i%10;

        String postfix = "" + lastDigit;

        return itoa(rest) + postfix;
    }

    public static Node intToList(int val){
        Node fake = new Node(0);
        intToList(val, fake);
        System.out.println(fake.next);
        return fake.next;
    }

    private static void intToList(int i, Node curr) {
        System.out.println("i = " + i + ", curr = " + curr);

        if (i == 0 && curr.next == null) {
            //curr.next = new Node(0);
            return;
        }

        if (i != 0) {
            intToList(i / 10, curr);  // Process remaining digits first
        }

        while (curr.next != null) {  // Move to the end of the list
            curr = curr.next;
        }

        curr.next = new Node(i % 10);  // Append the current digit
    }

    static class Node {
        int val;
        Node next;

        Node(int val){this.val = val;}

        @Override
        public String toString() {
            String ret = "[";
            Node curr = this;
            while(curr != null) {
                ret += curr.val + "->";
                curr = curr.next;
            }
            ret += "null]";
            return ret;
        }
    }
    public static void main(String[] args) {
        preorder(new int[]{1,2,3,4,5});
        postorder(new int[]{1,2,3,4,5});
        System.out.println(itoa(872));
        System.out.println(itoa2(872));
        System.out.println(intToList(936));
    }

}
