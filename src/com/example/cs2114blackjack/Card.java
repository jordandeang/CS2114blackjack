package com.example.cs2114blackjack;

import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author1
 * @author2 Jason Davis (jdavis7)
 * @author3
 * @version
 */
public class Card
    extends RectangleShape
{
    // fields
    private int                number;
    private String             suit;
    private int                value;
    private String             imageString;
    private static final float CARD_WIDTH  = 71;
    private static final float CARD_HEIGHT = 96;


    /**
     * Create a new Card object.
     *
     * @param number
     *            number of card
     * @param suitInt
     *            integer corresponding to suit of card
     */
    public Card(int number, int suitInt)
    {
        super(0, 0, CARD_WIDTH * 3, CARD_HEIGHT * 3);
        this.number = number;
        suit = numberToSuit(suitInt);
        if (number == 1)
        {
            value = 11;
        }
        else if (number < 10)
        {
            value = number;
        }
        else
        {
            value = 10;
        }
        imageString = suit;
        if (number <= 10)
        {
            imageString += number;
        }
        else if (number == 11)
        {
            imageString += "j";
        }
        else if (number == 12)
        {
            imageString += "q";
        }
        else if (number == 13)
        {
            imageString += "k";
        }
        flipCardDown();
    }


    /**
     * String method to display the suit
     *
     * @param suitInt
     *            is the number of suits
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
     * Changes the value of an ace to 1
     */
    public void changeAceValue()
    {
        value = 1;
    }


    /**
     * reveals card to the player
     */
    public void flipCardUp()
    {
        setImage(imageString);
    }


    /**
     * flips card upside down
     */
    public void flipCardDown()
    {
        setImage("b2fv");
    }


    /**
     * returns the value
     *
     * @return returns the value of the card
     */
    public int getValue()
    {
        return value;
    }


    /**
     * returns the number
     *
     * @return returns the number of the card
     */
    public int getNumber()
    {
        return number;
    }


    /**
     * returns the suit
     *
     * @return returns the suit of the card
     */
    public String getSuit()
    {
        return suit;
    }


    /**
     * returns the string to retrieve the image
     *
     * @return the string to retrieve the image
     */
    public String getImageString()
    {
        return imageString;
    }
}
