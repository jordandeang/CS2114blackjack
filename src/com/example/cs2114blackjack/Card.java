package com.example.cs2114blackjack;

public class Card
{
    private int    number;
    private String suit;
    private int    value;


    private Card()
    {

    }


    // ----------------------------------------------------------
    /**
     * Create a new Card object.
     *
     * @param i
     *            number
     * @param j
     *            suit
     */
    public Card(int i, int j)
    {
        number = i;
        suit = numberToSuit(j);
        if (i < 10)
        {
            value = i;
        }
        else
        {
            value = 10;
        }

    }


    private String numberToSuit(int j)
    {
        if (j == 1)
        {
            return "c";
        }
        else if (j == 2)
        {
            return "d";
        }
        else if (j == 3)
        {
            return "h";
        }
        else if (j == 4)
        {
            return "s";
        }
        else
        {
            return null;
        }
    }
}
