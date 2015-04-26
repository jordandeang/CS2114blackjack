package com.example.cs2114blackjack;

import sofia.util.Random;
import java.util.Stack;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author1
 * @author2
 * @author3
 * @version
 */
public class Game
{

    // fields
    private ArrayList<Card>  discard;
    public Stack<Card>       deck;
    private Player           player;
    private Player           dealer;
    private Player           winner;
    private Player           currentPlayer;
    private static final int NUMBER_OF_DECKS = 1;


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
                    Card card = new Card(i, j);
                    discard.add(card);
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
        hit(dealer);
    }


    // ----------------------------------------------------------
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


    public void newRound()
    {
        currentPlayer = player;
        winner = null;
        discardHands();
        dealHands();
    }


    // ----------------------------------------------------------
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
        Card card = deck.pop();
        card.flipCardUp();
        p.addCard(card);
        if (p.getScore() > 21)
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
        else if (p.getScore() == 21)
        {
            stand(p);
        }
    }


    public void stand(Player p)
    {
        if (p.equals(dealer))
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
        else
        {
            currentPlayer = dealer;
            dealerTurn();
        }
    }


    public void dealerTurn()
    {
        while (dealer.getScore() < player.getScore())
        {
            hit(dealer);
        }
        if (dealer.getScore() <= 21)
        {
            stand(dealer);
        }
    }


    public Player getDealer()
    {
        return dealer;
    }


    public Player getPlayer()
    {
        return player;
    }


    public ArrayList<Card> getDiscard()
    {
        return discard;
    }


    public Stack<Card> getDeck()
    {
        return deck;
    }


    public Player getWinner()
    {
        return winner;
    }


    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }

}
