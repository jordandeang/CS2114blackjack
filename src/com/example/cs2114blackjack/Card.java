package com.example.cs2114blackjack;

import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 * The Card class handles the data needed to be stored on each individual card.
 * This includes the number, suit, value, and Image specifics.
 *
 * @author1 Jason Davis (jdavis7)
 * @author2 Jordan Deang (jdeang)
 * @author3 Tommy Hyres (tommy085)
 * @version 2015.04.27
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
        // Sets the value to 11 if the card is an ace, its number if its a
        // number, and 10 if it is a face card.
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
        // Constructs the imageString to match the filename of the corresponding
        // card
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
     * @return returns the suit in the form of a string
     */
    public String numberToSuit(int suitInt)
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
     * Sets the value of an ace to 1
     */
    public void changeAceValue()
    {
        value = 1;
    }


    /**
     * Sets the value of an ace to 11
     */
    public void revertAceValue()
    {
        value = 11;
    }


    /**
     * Flips a card up, thus setting the shape image to the imageString made in
     * the constructor
     */
    public void flipCardUp()
    {
        setImage(imageString);
    }


    /**
     * Flips a card down, thus setting the shape image to the card back image
     */
    public void flipCardDown()
    {
        setImage("b2fv");
    }


    /**
     * Returns the value of the card
     *
     * @return returns the value of the card
     */
    public int getValue()
    {
        return value;
    }


    /**
     * Returns the number of the card
     *
     * @return returns the number of the card
     */
    public int getNumber()
    {
        return number;
    }


    /**
     * Returns the suit of the card
     *
     * @return returns the suit of the card
     */
    public String getSuit()
    {
        return suit;
    }


    /**
     * Returns the string to retrieve the image for the specified card
     *
     * @return the string to retrieve the image
     */
    public String getImageString()
    {
        return imageString;
    }
}
