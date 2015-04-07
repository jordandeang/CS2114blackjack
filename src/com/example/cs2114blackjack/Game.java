package com.example.cs2114blackjack;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Game
{

    //fields
    private ArrayList<Card> discard;
    private ArrayDeque<Card> deck;
    private ArrayList<Card> hand;

    //initialize
    public Game()
    {
        discard = new ArrayList<Card>();
        deck = new ArrayDeque<Card>();
        hand = new ArrayList<Card>();
        fillDiscard();
        shuffleDeck();
    }

    private void shuffleDeck()
    {
        // TODO take the cards from the discard into the deck

    }

    private void fillDiscard()
    {
        // TODO fill the discard pile with all of the cards necessary

    }


}
