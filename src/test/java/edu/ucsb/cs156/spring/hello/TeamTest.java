package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");
    }

    @Test
    public void getName_returns_correct_name() {
        assert(team.getName().equals("test-team"));
    }

    @Test
    public void default_constructor_sets_empty_name_and_members() {
        Team t = new Team();
        assertEquals("", t.getName());
        assertEquals(new ArrayList<String>(), t.getMembers());
    }

    @Test
    public void addMember_and_getMembers_work_correctly() {
        team.addMember("Alice");
        assertTrue(team.getMembers().contains("Alice"));
    }

    @Test
    public void setName_updates_name() {
        team.setName("new-name");
        assertEquals("new-name", team.getName());
    }

    @Test
    public void setMembers_updates_members() {
        ArrayList<String> members = new ArrayList<>();
        members.add("Bob");
        team.setMembers(members);
        assertEquals(members, team.getMembers());
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_returns_false_for_non_team_object() {
        assertFalse(team.equals("not a team"));
    }

    @Test
    public void equals_returns_true_for_equal_teams() {
        Team other = new Team("test-team");
        assertTrue(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_name() {
        Team other = new Team("other-team");
        assertFalse(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_members() {
        Team other = new Team("test-team");
        other.addMember("Alice");
        assertFalse(team.equals(other));
    }

    @Test
    public void hashCode_returns_correct_value() {
        // Expected value computed from: "test-team".hashCode() | new ArrayList<>().hashCode()
        // Using | rather than & is verified by this hardcoded assertion
        assertEquals(-1226298695, team.hashCode());
    }

}
