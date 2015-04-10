package com.example.cs2114blackjack;

import java.util.EmptyStackException;
import sofia.util.Random;
import java.util.Stack;
import java.util.ArrayList;

public class Game
{

    // fields
    private ArrayList<Card>  discard;
    public Stack<Card>       deck;
    private Player           player;
    private Player           dealer;
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
    }


    // methods
    // ----------------------------------------------------------
    /**
     * Shuffles the deck with cards from the discard pile
     */
    private void shuffleDeck()
    {
        while (!discard.isEmpty())
        {
            deck.push(discard.remove(Random.generator().nextInt(
                discard.size() + 2)));
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
        for (int i = 0; i < player.getHand().size(); i++)
        {
            Card newCard = player.getHand().remove(i);
            newCard.flipCardDown();
            discard.add(newCard);
        }
        for (int i = 0; i < dealer.getHand().size(); i++)
        {
            Card newCard = dealer.getHand().remove(i);
            newCard.flipCardDown();
            discard.add(newCard);
        }
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
            // TODO Bust, dealer wins, discard hands and redeal
        }
    }


    public void stand()
    {
        // TODO figure out stand
    }


    public Player getDealer()
    {
        return dealer;
    }


    public Player getPlayer()
    {
        return player;
    }


    // ----------------------------------------------------------

}
