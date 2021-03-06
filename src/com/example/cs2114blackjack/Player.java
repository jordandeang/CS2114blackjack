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
     * Default constructor for Player(). Sets score to 0 and createa a hand.
     *
     * @param money
     *            the money to start the player with
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
     * Clears the hand and resets the player's score
     */
    public void clearHand()
    {
        hand.clear();
        score = 0;
    }


    /**
     * Checks hand for an Ace and returns it if it still has a value of 11
     *
     * @return An Ace with the value of 11 if it is in the hand, null otherwise
     */
    public Card getUnchangedAce()
    {
        for (Card c : hand)
        {
            // Loops through the player's hand and returns the card if it is an
            // ace with a value of 11
            if (c.getNumber() == 1 && c.getValue() == 11)
            {
                return c;
            }
        }
        return null;
    }


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
        // Adds the money unless it will put the person in negative money. In
        // that case it only takes what is left of the player's money.
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
            // Loops through the player's hand and adds up the values of the
            // cards
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
