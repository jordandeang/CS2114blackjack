package com.example.cs2114blackjack;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author1 Jason Davis (jdavis7)
 * @author2 Jordan Deang (jdeang)
 * @author3 Tommy Hyres (tommy085)
 * @version 2015.04.27
 */
public class GameTest
    extends student.TestCase
{
    private Game game;


    public void setUp()
    {
        game = new Game();
    }


    public void testNewRound()
    {
        game.newRound();
        assertEquals(game.getPlayer(), game.getCurrentPlayer());
        assertEquals(null, game.getWinner());
    }
}
