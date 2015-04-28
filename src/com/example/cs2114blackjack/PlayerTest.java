package com.example.cs2114blackjack;

// -------------------------------------------------------------------------
/**
 * Unit tests for the Player class
 *
 * @author1 Jason Davis (jdavis7)
 * @author2 Jordan Deang (jdeang)
 * @author3 Tommy Hyres (tommy085)
 * @version 2015.04.27
 */
public class PlayerTest
    extends student.TestCase
{
    private Player testPlayer;
    private Card   testCard1;
    private Card   testAce;


    /**
     * setUp for all test cases in the Player class
     */
    public void setUp()
    {
        testPlayer = new Player(1000);
        testCard1 = new Card(4, 1);
        testAce = new Card(1, 1);
    }


// ----------------------------------------------------------
    /**
     * Tests the constructor of the player class
     */
    public void testConstructor()
    {
        assertEquals(true, testPlayer.getHand().isEmpty());
        assertEquals(0, testPlayer.getScore());
        assertEquals(1000, testPlayer.getMoney());
    }


    /**
     * Tests the addCard method
     */
    public void testAddCard()
    {
        testPlayer.addCard(testCard1);
        assertEquals(testCard1, testPlayer.getHand().get(0));
        assertEquals(testCard1.getValue(), testPlayer.getScore());
    }


    /**
     * Tests the clearHand method
     */
    public void testClearHand()
    {
        testPlayer.clearHand();
        assertEquals(true, testPlayer.getHand().isEmpty());
        assertEquals(0, testPlayer.getScore());
    }


    /**
     * Tests the getUnchangedAce method
     */
    public void testGetUnchangedAce()
    {
        testPlayer.addCard(testAce);
        assertEquals(testAce, testPlayer.getUnchangedAce());
    }


    /**
     * Tests the changeMoney method
     */
    public void testChangeMoney()
    {
        assertEquals(-20, testPlayer.changeMoney(-20));
        assertEquals(980, testPlayer.getMoney());
        assertEquals(10, testPlayer.changeMoney(10));
        assertEquals(990, testPlayer.getMoney());
        assertEquals(-990, testPlayer.changeMoney(-10000));
        assertEquals(0, testPlayer.getMoney());
    }


    /**
     * Tests the recalculateScore method
     */
    public void testRecalculateScore()
    {
        assertEquals(0, testPlayer.getScore());
        testPlayer.getHand().add(testCard1);
        testPlayer.recalculateScore();
        assertEquals(testCard1.getValue(), testPlayer.getScore());
    }

}
