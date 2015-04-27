package com.example.cs2114blackjack;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author1
 *  @author2
 *  @author3
 *  @version
 */
public class Card
{
    // fields
    private int     number;
    private String  suit;
    private int     value;
    private boolean faceDown;

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

    /**
     * String method to display the suit
     * @param suitInt is the number of suits
     */
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

    /**
     * method to flip the card up
     */
    public void flipCardUp()
    {
        faceDown = false;
    }

    /**
     * method to flip card down
     */
    public void flipCardDown()
    {
        faceDown = true;
    }

    /**
     * method to see if the card is face up or face down
     * @return returns the face direction
     */
    public boolean getFaceDirection()
    {
        return faceDown;
    }

    /**
     * returns the value
     * @return returns the value of the card
     */
    public int getValue()
    {
        return value;
    }

    /**
     * returns the number
     * @return returns the number of the card
     */
    public int getNumber()
    {
        return number;
    }

    /**
     * returns the suit
     * @return returns the suit of the card
     */
    public String getSuit()
    {
        return suit;
    }
}