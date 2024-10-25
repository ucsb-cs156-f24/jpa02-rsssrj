package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setUp() {
        team = new Team("f24-12");
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("f24-12", team.getName());
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=f24-12, members=[])", team.toString());
    }

    @Test
    public void testEquals_sameObject() {
        assertTrue(team.equals(team));
    }

    @Test
    public void testEquals_differentClass() {
        assertFalse(team.equals("team"));
    }

    @Test
    public void testEquals_sameNameAndMembers() {
        Team team1 = new Team("f24-12");
        Team team2 = new Team("f24-12");
        assertTrue(team1.equals(team2));
    }

    @Test
    public void testEquals_differentName() {
        Team team1 = new Team("f24-12");
        Team team2 = new Team("f24-13");
        assertFalse(team1.equals(team2));
    }

    @Test
    public void testEquals_differentMembers() {
        Team team1 = new Team("f24-12");
        team1.addMember("member1");
        Team team2 = new Team("f24-12");
        team2.addMember("member2");
        assertFalse(team1.equals(team2));
    }

    @Test
    public void testHashCode_sameNameAndMembers() {
        Team team1 = new Team("person");
        team1.addMember("something");
        Team team2 = new Team("person");
        team2.addMember("something");
        assertEquals(team1.hashCode(), team2.hashCode());
    }

    @Test
    public void testHashCode_differentMembers() {
        Team team1 = new Team("f24-12");
        team1.addMember("member1");
        Team team2 = new Team("f24-12");
        team2.addMember("member2");
        assertTrue(team1.hashCode() != team2.hashCode());
    }

    @Test
    public void testHashCode_specificHashValue() {
        int result = team.hashCode();
        int expectedResult = -1327023897;
        assertEquals(expectedResult, result);
    }
}
