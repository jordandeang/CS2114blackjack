package com.example.cs2114blackjack;

public class Card
{
    private int     number;
    private String  suit;
    private int     value;
    private boolean faceDown;


    // ----------------------------------------------------------
    /**
     * Create a new Card object.
     *
     * @param number
     *            number of card
     * @param suitInt
     *            integer corresponding to suit of cardF
     */
    public Card(int number, int suitInt)
    {
        this.number = number;
        suit = numberToSuit(suitInt);
        if (number < 10)
        {
            value = number;
        }
        else
        {
            value = 10;
        }
        faceDown = true;

    }


    private String numberToSuit(int suitInt)
    {
        if (suitInt == 1)
        {
            return "c";
        }
        else if (suitInt == 2)
        {
            return "d";
        }
        else if (suitInt == 3)
        {
            return "h";
        }
        else if (suitInt == 4)
        {
            return "s";
        }
        throw new IllegalArgumentException(
            "Invalid suit number. Choose a number between 1 and 4.");
    }


    public void flipCardUp()
    {
        faceDown = false;
    }


    public void flipCardDown()
    {
        faceDown = true;
    }


    public boolean getFaceDirection()
    {
        return faceDown;
    }


    public int getValue()
    {
        return value;
    }


    public int getNumber()
    {
        return number;
    }


    public String getSuit()
    {
        return suit;
    }

}
