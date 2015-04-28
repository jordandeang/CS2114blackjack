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
public class GameTest extends student.TestCase
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
        testPlayer = new Player();
        testPlayer = new Player();
        testDiscard = new ArrayList<Card>();
        testDeck = new Stack<Card>();
        game.dealHands();
    }

    /**
     * Tests the size of the deck and discard pile
     */
    public void testDeckAndDiscard()
    {
        game.shuffleDeck();
        game.fillDiscard();
        assertEquals(0, testDeck.size());
        assertEquals(0, testDiscard.size());
    }

    /**
     * Tests the newRound method
     */
    public void testNewRound()
    {
        game.newRound();
        assertEquals(game.getPlayer(), game.getCurrentPlayer());
        assertEquals(null, game.getWinner());
    }

    /**
     * Tests the dealHands method
     */
    public void testHit()
    {
        game.hit(testPlayer);
        assertTrue(testPlayer.getScore() > 0);
    }

    // TODO, not producing correct results. I don't think the cards are being
    // dealt to the player and dealer.
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
        //assertEquals(0, deck.size());
        //assertEquals(0, Game().discard.size());
    }

    /**
     * Tests the fillDisard method
     */
    public void testFillDiscard()
    {
        // TODO
    }
}
