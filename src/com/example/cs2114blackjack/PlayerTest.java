package com.example.cs2114blackjack;

import java.util.*;

// -------------------------------------------------------------------------
/**
 * These are the test cases for the Player class
 *
 * @author1 Jason Davis (jdavis7)
 * @author2 Jordan Deang (jdeang)
 * @author3 Tommy Hyres (tommy085)
 * @version 2015.04.27
 */
public class PlayerTest extends student.TestCase
{
    private Player          testPlayer;
    private Card            testCard1;
    private Card            testCard2;
    private Card            testCard3;
    private ArrayList<Card> testHand;

    /**
     * setUp for all test cases in the Player class
     */
    public void setUp()
    {
        testPlayer = new Player();
        testCard1 = new Card(4, 1);
        testCard2 = new Card(1, 1);
        testCard3 = new Card(11, 1);
        testHand = new ArrayList<Card>();
    }

    /**
     * Tests the getUnchangedAce method
     */
    public void testGetUnchangedAce()
    {
        // TODO
    }

    /**
     * Tests the addCard method
     */
    public void testAddCard()
    {
        // TODO
    }

    /**
     * Tests the getScore method
     */
    public void testGetScore()
    {
        testPlayer.addCard(testCard1);
        assertEquals(4, testPlayer.getScore());
        testPlayer.clearHand();
        assertEquals(0, testPlayer.getScore());
        testPlayer.addCard(testCard1);
        testPlayer.recalculateScore();
        assertEquals(4, testPlayer.getScore());
    }
}
