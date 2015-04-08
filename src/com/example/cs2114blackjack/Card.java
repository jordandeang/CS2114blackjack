package com.example.cs2114blackjack;

public class Card
{
    private int number;
    private String suit;

    private Card()
    {

    }

    Card(int i, int j)
    {
        number = i;
        suit = numberToSuit(j);

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
