package com.example.cs2114blackjack;

// -------------------------------------------------------------------------
/**
 * Unit Tests for the Game class
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


    /**
     * setUp for all test cases in the Game class
     */
    public void setUp()
    {
        game = new Game();
    }


    /**
     * Tests the constructor of the game class
     */
    public void testConstructor()
    {
        assertEquals(true, game.getDiscard().isEmpty());
        assertEquals(156, game.getDeck().size());
        assertEquals(game.getDealer(), game.getCurrentPlayer());
        assertEquals(0, game.getPot());
    }


    /**
     * Tests the shuffleDeck method
     */
    public void testShuffleDeck()
    {
        game.getDeck().clear();
        game.fillDiscard();
        game.shuffleDeck();
        assertEquals(156, game.getDeck().size());
    }


    /**
     * Tests fillDiscard method to if the NUMBER_OF_DECKS is added to the
     * discard
     */
    public void testFillDiscard()
    {
        game.fillDiscard();
        assertEquals(156, game.getDiscard().size());
    }


    /**
     * Tests the dealHands method
     */
    public void testDealHands()
    {
        game.dealHands();
        assertNotSame(0, game.getPlayer().getHand().size());
        assertNotSame(0, game.getDealer().getHand().size());
        assertNotSame(156, game.getDeck().size());
    }


    /**
     * Tests the discardHands method
     */
    public void testDiscardHands()
    {
        game.getPlayer().addCard(new Card(1, 1));
        game.getPlayer().addCard(new Card(2, 3));
        game.getDealer().addCard(new Card(1, 1));
        game.getDealer().addCard(new Card(2, 3));
        game.discardHands();
        assertEquals(false, game.getDiscard().isEmpty());
        assertEquals(true, game.getPlayer().getHand().isEmpty());
        assertEquals(true, game.getDealer().getHand().isEmpty());
    }


    /**
     * Tests the newRound method
     */
    public void testNewRound()
    {
        game.newRound(10);
        assertNotSame(0, game.getPlayer().getHand().size());
        assertNotSame(0, game.getDealer().getHand().size());
        assertEquals(0, game.getDiscard().size());
        assertNotSame(156, game.getDeck().size());
        game.newRound(10);
        assertNotSame(0, game.getPlayer().getHand().size());
        assertNotSame(0, game.getDealer().getHand().size());
        assertNotSame(0, game.getDiscard().size());
        assertNotSame(156, game.getDeck().size());
    }


    /**
     * Tests the rewardPot method
     */
    public void testRewardPot()
    {
        game.setWinner(game.getPlayer());
        game.setPot(500);
        game.rewardPot();
        assertEquals(1500, game.getPlayer().getMoney());
        assertEquals(0, game.getPot());
        game.setWinner(null);
        game.setPot(1000);
        game.rewardPot();
        assertEquals(2000, game.getPlayer().getMoney());
        assertEquals(1000000500, game.getDealer().getMoney());
        assertEquals(0, game.getPot());

    }


    /**
     * Tests the hit method
     */
    public void testHit()
    {
        game.getDeck().clear();
        game.getDeck().push(new Card(1, 1));
        game.getDeck().push(new Card(10, 1));
        game.getDeck().push(new Card(10, 1));
        game.getDeck().push(new Card(1, 1));
        game.getDeck().push(new Card(10, 1));
        game.getDeck().push(new Card(10, 1));
        game.hit(game.getPlayer());
        game.hit(game.getPlayer());
        game.hit(game.getPlayer());
        assertTrue(game.getPlayer().getScore() > 0);
        assertEquals(null, game.getWinner());
        assertEquals(null, game.getPlayer().getUnchangedAce());
        assertEquals(0, game.getPot());

        game.discardHands();
        game.getDeck().clear();
        game.getDeck().push(new Card(10, 1));
        game.getDeck().push(new Card(10, 1));
        game.getDeck().push(new Card(10, 1));
        game.hit(game.getPlayer());
        game.hit(game.getPlayer());
        game.hit(game.getPlayer());
        assertEquals(game.getDealer(), game.getWinner());
        assertEquals(game.getDealer(), game.getCurrentPlayer());
        assertEquals(0, game.getPot());

        game.discardHands();
        game.getDeck().clear();
        game.getDeck().push(new Card(10, 1));
        game.getDeck().push(new Card(10, 1));
        game.getDeck().push(new Card(10, 1));
        game.hit(game.getDealer());
        game.hit(game.getDealer());
        game.hit(game.getDealer());
        assertEquals(game.getPlayer(), game.getWinner());
        assertEquals(game.getDealer(), game.getCurrentPlayer());
        assertEquals(0, game.getPot());
    }


    /**
     * Test the stand method in the game class
     */
    public void testStand()
    {
        game.setCurrentPlayer(game.getDealer());
        game.stand(game.getDealer());
        assertEquals(null, game.getWinner());
        assertEquals(0, game.getPot());

        game.getDealer().addCard(new Card(1, 1));
        game.stand(game.getDealer());
        assertEquals(game.getDealer(), game.getWinner());
        assertEquals(0, game.getPot());
        game.discardHands();

        game.getPlayer().addCard(new Card(1, 1));
        game.stand(game.getDealer());
        assertEquals(game.getPlayer(), game.getWinner());
        assertEquals(0, game.getPot());

        game.stand(game.getPlayer());
        assertEquals(0, game.getPot());
        assertEquals(game.getDealer(), game.getCurrentPlayer());
    }


    /**
     * Tests the dealerTurn method in the game class
     */
    public void testDealerTurn()
    {
        game.getDealer().addCard(new Card(1, 1));
        game.getDealer().addCard(new Card(11, 1));
        game.dealerTurn();
        assertEquals(game.getDealer(), game.getWinner());
        assertEquals(0, game.getPot());
        game.discardHands();

        game.getDealer().addCard(new Card(1, 1));
        game.getDealer().addCard(new Card(4, 1));
        game.getPlayer().addCard(new Card(1, 1));
        game.getPlayer().addCard(new Card(11, 1));
        game.dealerTurn();
        assertEquals(0, game.getPot());
        assertNotSame(game.getDealer(), game.getWinner());
    }

}
