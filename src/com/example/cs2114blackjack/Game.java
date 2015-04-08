package com.example.cs2114blackjack;

import sofia.util.Random;
import java.util.Stack;
import java.util.ArrayList;

public class Game
{

    //fields
    private ArrayList<Card> discard;
    private Stack<Card> deck;
    private ArrayList<Card> hand;

    //initialize
    public Game()
    {
        discard = new ArrayList<Card>();
        deck = new Stack<Card>();
        hand = new ArrayList<Card>();
        fillDiscard();
        shuffleDeck();
    }

    private void shuffleDeck()
    {
        // TODO take the cards from the discard into the deck
        while (!hand.isEmpty())
        {
            deck.push(discard.remove(Random.generator().nextInt(discard.size() +2 )));
        }

    }

    private void fillDiscard()
    {
        // TODO fill the discard pile with all of the cards necessary

    }


}
