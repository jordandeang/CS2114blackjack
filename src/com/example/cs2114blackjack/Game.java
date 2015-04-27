package com.example.cs2114blackjack;

import sofia.util.Random;
import java.util.Stack;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * The primary model for 21 blackjack. Handles the backend of blackjack,
 * managing the dealer AI, the player, and the actions that either can call.
 * Used in conjunction with the MainScreen class to play on the android.
 *
<<<<<<< HEAD
 * @author1 Jason Davis (jdavis7)
 * @author2 Jordan Deang (jdeang)
 * @author3 Tommy Hyres (tommy085)
 * @version 2015.04.27
=======
 * @author1 Jordan Deang (jdeang)
 * @author2 Jason Davis (jdavis7)
 * @author3
 * @version 1.0
>>>>>>> 9d03ddfd681562a4cad23d8cd98154086ab68c96
 */
public class Game
{
    // fields

    /**
     * the deck
     */
    private Stack<Card>      deck;
    private ArrayList<Card>  discard;
    private Card             card;
    private Player           player;
    private Player           dealer;
    private Player           winner;
    private Player           currentPlayer;
    private static final int NUMBER_OF_DECKS = 3;


    // initialize
    // ----------------------------------------------------------
    /**
     * Create a new Game object.
     */
    public Game()
    {
        discard = new ArrayList<Card>();
        deck = new Stack<Card>();
        fillDiscard();
        shuffleDeck();
        player = new Player();
        dealer = new Player();
        card = deck.pop();
        dealHands();
        currentPlayer = player;
    }


    // methods

    /**
     * Shuffles the deck with cards from the discard pile
     */
    private void shuffleDeck()
    {
        while (!discard.isEmpty())
        {
            deck.push(discard.remove(Random.generator().nextInt(discard.size())));
        }

    }


    /**
     * Fills the discard pile with the given amount of decks.
     */
    private void fillDiscard()
    {
        for (int d = 0; d < NUMBER_OF_DECKS; d++)
        {
            for (int i = 1; i < 14; i++)
            {
                for (int j = 1; j < 5; j++)
                {
                    Card card2 = new Card(i, j);
                    discard.add(card2);
                }
            }
        }
    }


    /**
     * Deals cards to the player and dealer
     */
    public void dealHands()
    {
        hit(player);
        hit(dealer);
        hit(player);
        //hit(dealer);

        card.flipCardDown();
        dealer.addCard(card);
    }


    /**
     * Discards hands into the discard pile
     */
    public void discardHands()
    {
        for (Card c : player.getHand())
        {
            c.flipCardDown();
            discard.add(c);
        }
        for (Card c : dealer.getHand())
        {
            c.flipCardDown();
            discard.add(c);
        }
        player.clearHand();
        dealer.clearHand();
    }


    /**
     * Starts a new round with no winner and new hands
     */
    public void newRound()
    {
        currentPlayer = player;
        winner = null;
        discardHands();
        dealHands();
    }


    /**
     * Hit the given player with a card, shuffle if the deck is empty
     *
     * @param p
     *            the player to be hit
     */
    public void hit(Player p)
    {
        if (deck.size() == 0)
        {
            shuffleDeck();
        }
        Card card3 = deck.pop();
        card3.flipCardUp();
        p.addCard(card3);
        if (p.getScore() > 21)
        {
            if (p.getUnchangedAce() != null)
            {
                p.getUnchangedAce().changeAceValue();
                p.recalculateScore();
            }
            else
            {
                if (p.equals(dealer))
                {
                    winner = player;

                }
                else
                {
                    winner = dealer;
                }
                currentPlayer = dealer;
            }
        }
        if (p.getScore() == 21)
        {
            stand(p);
        }
    }


    /**
     * Determines the winner if the dealer stands, otherwise starts dealer's
     * turn
     *
     * @param p
     *            the given player that is standing
     */
    public void stand(Player p)
    {
        if (p.equals(dealer) && currentPlayer.equals(dealer))
        {
            if (dealer.getScore() > player.getScore())
            {
                winner = dealer;
            }
            else if (dealer.getScore() < player.getScore())
            {
                winner = player;
            }
            else
            {
                winner = null;
            }
        }
        if (p.equals(player))
        {
            currentPlayer = dealer;
            dealerTurn();
        }
    }


    /**
     * If the dealer's hand is lower than 17, the dealer hits and
     * stops once it reached 21 or is greater than or equal to 17.
     * Our game utilizes the "stand on 17" rule for the dealer
     */
    public void dealerTurn()
    {
<<<<<<< HEAD
        card.flipCardUp();
        while (dealer.getScore() < player.getScore())
=======
        while (dealer.getScore() < 17)
>>>>>>> 9d03ddfd681562a4cad23d8cd98154086ab68c96
        {
            hit(dealer);
        }
        if (dealer.getScore() <= 21)
        {
            stand(dealer);
        }
    }


    /**
     * Returns the dealer to access his/her hand
     *
     * @return returns the dealer
     */
    public Player getDealer()
    {
        return dealer;
    }


    /**
     * Returns the player to access his/her hand
     *
     * @return returns the player
     */
    public Player getPlayer()
    {
        return player;
    }


    /**
     * Returns the discard for GUI purposes
     *
     * @return returns the discarded cards
     */
    public ArrayList<Card> getDiscard()
    {
        return discard;
    }


    /**
     * Returns the deck for GUI purposes
     *
     * @return returns the deck
     */
    public Stack<Card> getDeck()
    {
        return deck;
    }


    /**
     * Returns the winner of the round
     *
     * @return returns the winner
     */
    public Player getWinner()
    {
        return winner;
    }


    /**
     * Returns the current player to determine whose turn it is
     *
     * @return returns the current player
     */
    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }

}
