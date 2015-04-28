package com.example.cs2114blackjack;

import java.util.ArrayList;
import java.util.*;

// -------------------------------------------------------------------------
/**
 * These are the test cases for the Game class
 *
 * @author1 Jason Davis (jdavis7)
 * @author2 Jordan Deang (jdeang)
 * @author3 Tommy Hyres (tommy085)
 * @version 2015.04.27
 */
public class GameTest
    extends student.TestCase
{
    private Game            game;
    private Player          testPlayer;
    private Player          testDealer;
    private Stack<Card>     testDeck;
    private ArrayList<Card> testDiscard;


    /**
     * setUp for all test cases in the Game class
     */
    public void setUp()
    {
        game = new Game();
        testDiscard = game.getDiscard();
        testDeck = game.getDeck();
        testPlayer = game.getPlayer();
        testDealer = game.getDealer();
        game.dealHands();
    }


    /**
     * Tests fillDiscard method to if the NUMBER_OF_DECKS is added to the
     * discard
     */
    public void testFillDiscard()
    {
        game.fillDiscard();
        assertEquals(156, testDiscard.size());
    }


    /**
     * Tests the newRound method
     */
    public void testNewRound()
    {
        game.newRound(10);
        assertNotSame(0, testPlayer.getHand().size());
        assertNotSame(0, testDealer.getHand().size());
        assertNotSame(0, testDiscard.size());
        assertNotSame(156, testDeck.size());
    }


    /**
     * Tests the rewardPot method
     */
    public void testRewardPot()
    {
        game.setWinner(testPlayer);
        game.setPot(500);
        game.rewardPot();
        assertEquals(1500, testPlayer.getMoney());
        assertEquals(0, game.getPot());
        game.setWinner(null);
        game.setPot(1000);
        game.rewardPot();
        assertEquals(2000, testPlayer.getMoney());
        assertEquals(1000000500, testDealer.getMoney());
        assertEquals(0, game.getPot());

    }


    /**
     * Tests the dealHands method
     */
    public void testHit()
    {
        game.hit(testPlayer);
        assertTrue(testPlayer.getScore() > 0);
    }


    /**
     * Tests the dealHands method
     */
    public void testDealHands()
    {
        assertNotSame(0, testPlayer.getHand().size());
        assertNotSame(0, testDealer.getHand().size());
    }


    /**
     * Tests the shuffleDeck method
     */
    public void testShuffleDeck()
    {
        game.shuffleDeck();
        assertEquals(152, testDeck.size());
    }

}
