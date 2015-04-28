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

    private Stack<Card>     testDeck;
    private ArrayList<Card> testDiscard;


    /**
     * setUp for all test cases in the Game class
     */
    public void setUp()
    {
        game = new Game();
        testPlayer = new Player(1000);
        testDiscard = new ArrayList<Card>();
        testDeck = new Stack<Card>();

    }


    /**
     * Tests the size of the deck and discard pile
     */
    public void testDeckAndDiscard()
    {
        game.shuffleDeck();
        game.fillDiscard();
        assertEquals(52, testDeck.size());
        assertEquals(0, testDiscard.size());
    }


    /**
     * Tests the newRound method
     */
    public void testNewRound()
    {
        game.newRound(10);
        assertEquals(game.getPlayer(), game.getCurrentPlayer());
        assertEquals(null, game.getWinner());
        assertEquals(20,game.getPot());
        assertEquals(990,game.getPlayer().getMoney());
        assertEquals(1999990,game.getDealer().getMoney());
    }


    /**
     * Tests the dealHands method
     */
    public void testHit()
    {
        assertEquals(0, testPlayer.getScore());
    }


    /**
     * Tests the dealHands method
     */
    public void testDealHands()
    {
        // TODO
    }


    /**
     * Tests the shuffleDeck method
     */
    public void testShuffleDeck()
    {
        // TODO
    }


    /**
     * Tests the fillDisard method
     */
    public void testFillDiscard()
    {
        // TODO
    }
}
