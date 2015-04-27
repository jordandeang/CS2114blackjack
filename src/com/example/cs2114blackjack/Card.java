package com.example.cs2114blackjack;

import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 * The Card class handles the data needed to be stored on each individual
 * card. This includes the number, suit, value, and Image specifics.
 *
<<<<<<< HEAD
 * @author1 Jason Davis (jdavis7)
 * @author2 Jordan Deang (jdeang)
 * @author3 Tommy Hyres (tommy085)
 * @version 2015.04.27
=======
 * @author1 Jordan Deang (jdeang)
 * @author2 Jason Davis (jdavis7)
 * @author3
 * @version
>>>>>>> 9d03ddfd681562a4cad23d8cd98154086ab68c96
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
<<<<<<< HEAD
     * Makes the ace value 1
=======
     * Changes the value of an ace to 1
>>>>>>> 9d03ddfd681562a4cad23d8cd98154086ab68c96
     */
    public void changeAceValue()
    {
        value = 1;
    }

<<<<<<< HEAD
    /**
     * Flips a card up that is face down
=======

    /**
     * reveals card to the player
>>>>>>> 9d03ddfd681562a4cad23d8cd98154086ab68c96
     */
    public void flipCardUp()
    {
        setImage(imageString);
    }

<<<<<<< HEAD
    /**
     * Flips a card down that is face up
=======

    /**
     * flips card upside down
>>>>>>> 9d03ddfd681562a4cad23d8cd98154086ab68c96
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

<<<<<<< HEAD
    /**
     * @return the imageString
=======

    /**
     * returns the string to retrieve the image
     *
     * @return the string to retrieve the image
>>>>>>> 9d03ddfd681562a4cad23d8cd98154086ab68c96
     */
    public String getImageString()
    {
        return imageString;
    }
}
