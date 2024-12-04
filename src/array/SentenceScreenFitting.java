package array;

// Leetcode 418
public class SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int count = 0;
        int curR = 0, curC = 0;

        while (true) {
            for (int i = 0; i < sentence.length; i++) {
                if (sentence[i].length() > cols) {
                    // If a single word cannot fit in a row, return 0
                    return 0;
                }
                if (curC + sentence[i].length() > cols) {
                    curR++;
                    curC = 0;
                    if (curR >= rows) return count;
                }
                curC += sentence[i].length() + 1; // +1 for the space
            }
            count++;
        }
    }
}

