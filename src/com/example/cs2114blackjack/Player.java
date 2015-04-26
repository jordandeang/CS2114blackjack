package com.example.cs2114blackjack;

import java.util.ArrayList;

public class Player
{
    private ArrayList<Card> hand;
    private int             score;


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

    public void clearHand() {
        hand.clear();
        score = 0;
    }


    public ArrayList<Card> getHand()
    {
        return hand;
    }


    public int getScore()
    {
        return score;
    }
}
