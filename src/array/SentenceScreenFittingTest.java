package array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SentenceScreenFittingTest {

    @Test
    public void testWordsTyping_SingleWordNoWrap() {
        SentenceScreenFitting sentenceScreenFitting = new SentenceScreenFitting();
        String[] sentence = {"word"};
        int result = sentenceScreenFitting.wordsTyping(sentence, 5, 8);
        assertEquals(5, result);
    }

    @Test
    public void testWordsTyping_MultipleWordsNoWrap() {
        SentenceScreenFitting sentenceScreenFitting = new SentenceScreenFitting();
        String[] sentence = {"word", "test"};
        int result = sentenceScreenFitting.wordsTyping(sentence, 5, 15);
        assertEquals(7, result);
    }

    @Test
    public void testWordsTyping_MultipleWordsWrap() {
        SentenceScreenFitting sentenceScreenFitting = new SentenceScreenFitting();
        String[] sentence = {"word", "test"};
        int result = sentenceScreenFitting.wordsTyping(sentence, 5, 8);
        assertEquals(2, result);
    }

    @Test
    public void testWordsTyping_LongWordNoFit() {
        SentenceScreenFitting sentenceScreenFitting = new SentenceScreenFitting();
        String[] sentence = {"supercalifragilisticexpialidocious"};
        int result = sentenceScreenFitting.wordsTyping(sentence, 5, 15);
        assertEquals(0, result);
    }
}