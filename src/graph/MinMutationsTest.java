package graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinMutationsTest {

    /**
     * The `MinMutations` class provides a method `minMutation` that determines the minimum number
     * of mutations required to change a starting gene sequence to a target gene sequence using
     * only a specified set of valid mutations (bank). The mutation is only valid if it changes
     * one gene at a time and all intermediate sequences must appear in the gene bank.
     */

    private final MinMutations minMutations = new MinMutations();

    @Test
    void testNoMutationNeeded() {
        String startGene = "AAAA";
        String endGene = "AAAA";
        String[] bank = {"AAAA", "AATA", "TATA"};
        assertEquals(0, minMutations.minMutation(startGene, endGene, bank));
    }

    @Test
    void testSingleMutation() {
        String startGene = "AAAA";
        String endGene = "AAAT";
        String[] bank = {"AAAA", "AAAT", "AATT"};
        assertEquals(1, minMutations.minMutation(startGene, endGene, bank));
    }

    @Test
    void testMultipleMutations() {
        String startGene = "AAAA";
        String endGene = "TTTT";
        String[] bank = {"AAAA", "AAAT", "AATT", "ATTT", "TTTT"};
        assertEquals(4, minMutations.minMutation(startGene, endGene, bank));
    }

    @Test
    void testNoPossibleMutation() {
        String startGene = "AAAA";
        String endGene = "CCCC";
        String[] bank = {"AAAA", "AAAT", "AATT", "TTTT"};
        assertEquals(-1, minMutations.minMutation(startGene, endGene, bank));
    }

    @Test
    void testEndGeneNotInBank() {
        String startGene = "AAAA";
        String endGene = "GGGG";
        String[] bank = {"AAAA", "AATT", "TTTT", "CCCC"};
        assertEquals(-1, minMutations.minMutation(startGene, endGene, bank));
    }
}