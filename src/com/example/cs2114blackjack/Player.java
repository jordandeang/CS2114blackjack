package com.example.cs2114blackjack;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * The Player class holds the methods and fields used by both the dealer and
 * the player use to play the game.
 *
 * @author1 Jason Davis (jdavis7)
 * @author2 Jordan Deang (jdeang)
 * @author3 Tommy Hyres (tommy085)
 * @version 2015.04.27
 */
public class Player
{
    private ArrayList<Card> hand;
    private int             score;

    /**
     * Default constructor for Player(). Sets score to 0 and create a hand.
     */
    public Player()
    {
        hand = new ArrayList<Card>();
        score = 0;
    }


    /**
     * Add the given card to the players hand and record the score
     *
     * @param card
     *            the card to the player receives
     */
    public void addCard(Card card)
    {
        hand.add(card);
        score += card.getValue();
    }


    /**
     * clears the hand
     */
    public void clearHand()
    {
        hand.clear();
        score = 0;
    }

    /**
     * Checks hand for an Ace
     *
     * @return An Ace with the value of 11 if it is in the hand
     */
    public Card getUnchangedAce()
    {
        for (Card c : hand)
        {
            if (c.getNumber() == 1 && c.getValue() == 11)
            {
                return c;
            }
        }
        return null;
    }


    /**
     * Recalculates the players score
     */
    public void recalculateScore()
    {
        score = 0;
        for (Card c : hand)
        {
            score += c.getValue();
        }
    }


    /**
     * @return returns the hand
     */
    public ArrayList<Card> getHand()
    {
        return hand;
    }


    /**
     * @return returns the score
     */
    public int getScore()
    {
        return score;
    }
}
