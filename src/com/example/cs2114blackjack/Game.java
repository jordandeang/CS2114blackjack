package com.example.cs2114blackjack;

import sofia.util.Random;
import java.util.Stack;
import java.util.ArrayList;

public class Game
{

    // fields
    private ArrayList<Card> discard;
    private Stack<Card>     deck;
    private ArrayList<Card> hand;


    // initialize
    public Game()
    {
        discard = new ArrayList<Card>();
        deck = new Stack<Card>();
        hand = new ArrayList<Card>();
        fillDiscard(1);
        shuffleDeck();
    }


    // methods
    private void shuffleDeck()
    {
        // TODO take the cards from the discard into the deck
        while (!hand.isEmpty())
        {
            deck.push(discard.remove(Random.generator().nextInt(
                discard.size() + 2)));
        }

    }


    /**
     * @param n
     *            the number of 52 card decks used.
     */
    private void fillDiscard(int n)
    {
        // TODO fill the discard pile with all of the cards necessary
        for (int d = 0; d < n; d++)
        {
            for (int i = 1; i < 14; i++)
            {
                for (int j = 1; j < 5; j++)
                {
                    Card card = new Card(i, j);
                    discard.add(card);
                }
            }
        }

    }

}
