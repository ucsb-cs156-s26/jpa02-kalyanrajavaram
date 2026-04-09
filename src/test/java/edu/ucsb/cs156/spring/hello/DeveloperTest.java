package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Kalyan", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("kalyanrajavaram", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("s26-03", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_Alexandru() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Alexandru"), "Team should contain Alexandru");
    }

    @Test
    public void getTeam_returns_team_with_AlexL() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Alex L."), "Team should contain Alex L.");
    }

    @Test
    public void getTeam_returns_team_with_BrianL() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Brian L."), "Team should contain Brian L.");
    }

    @Test
    public void getTeam_returns_team_with_Kalyan() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Kalyan"), "Team should contain Kalyan");
    }

    @Test
    public void getTeam_returns_team_with_RaymondXie() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Raymond Xie"), "Team should contain Raymond Xie");
    }

}
