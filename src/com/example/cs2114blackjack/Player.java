package com.example.cs2114blackjack;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * The Player class holds the methods and fields used by both the dealer and the
 * player use to play the game.
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
    private int             money;


    /**
     * Default constructor for Player(). Sets score to 0 and create a hand.
     */
    public Player(int money)
    {
        hand = new ArrayList<Card>();
        score = 0;
        this.money = money;
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


    // ----------------------------------------------------------
    /**
     * Change the money by the given amount and return the changed money
     *
     * @param amount
     *            the amount to change the money
     * @return the amount if the player has enough, as much money as the person
     *         had if it was less than the amount
     */
    public int changeMoney(int amount)
    {
        if (money + amount >= 0)
        {
            money += amount;
            return amount;
        }
        else
        {
            int oldMoney = money;
            money = 0;
            return -oldMoney;
        }
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
     * Returns the player's ArrayList hand
     *
     * @return returns the hand
     */
    public ArrayList<Card> getHand()
    {
        return hand;
    }


    /**
     * Returns the score of the player
     *
     * @return returns the score
     */
    public int getScore()
    {
        return score;
    }


    /**
     * Returns the money of the player
     *
     * @return the player's money
     */
    public int getMoney()
    {
        return money;
    }
}
