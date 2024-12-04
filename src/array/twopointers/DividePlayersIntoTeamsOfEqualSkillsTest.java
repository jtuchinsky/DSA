package array.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DividePlayersIntoTeamsOfEqualSkillsTest {

    @Test
    void testDividePlayersAllEqualSkills() {
        DividePlayersIntoTeamsOfEqualSkills playerDivider = new DividePlayersIntoTeamsOfEqualSkills();
        int[] skills = {5, 5, 5, 5};
        long result = playerDivider.dividePlayers(skills);
        assertEquals(50, result);
    }

    @Test
    void testDividePlayersSomeEqualSkills() {
        DividePlayersIntoTeamsOfEqualSkills playerDivider = new DividePlayersIntoTeamsOfEqualSkills();
        int[] skills = {3, 3, 5, 5};
        long result = playerDivider.dividePlayers(skills);
        assertEquals(30, result);
    }

    @Test
    void testDividePlayersInCorrectTeams() {
        DividePlayersIntoTeamsOfEqualSkills playerDivider = new DividePlayersIntoTeamsOfEqualSkills();
        int[] skills = {1, 3, 5, 7};
        long result = playerDivider.dividePlayers(skills);
        assertEquals(22, result);
    }

    @Test
    void testDividePlayersEmptyTeams() {
        DividePlayersIntoTeamsOfEqualSkills playerDivider = new DividePlayersIntoTeamsOfEqualSkills();
        int[] skills = {};
        long result = playerDivider.dividePlayers(skills);
        assertEquals(0, result);
    }
}