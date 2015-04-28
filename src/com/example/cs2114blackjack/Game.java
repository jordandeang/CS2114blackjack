package com.example.cs2114blackjack;

import sofia.util.Random;
import java.util.Stack;
import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * The primary model for 21 blackjack. Handles the backend of blackjack,
 * managing the dealer AI, the player, and the actions that either can call.
 * Used in conjunction with the MainScreen class to play on the android.
 *
 * @author1 Jason Davis (jdavis7)
 * @author2 Jordan Deang (jdeang)
 * @author3 Tommy Hyres (tommy085)
 * @version 2015.04.27
 */
public class Game
{
    // fields

    /**
     * the deck
     */
    private Stack<Card>     deck;
    private ArrayList<Card> discard;
    private Player          player;
    private Player          dealer;
    private Player          winner;
    private Player          currentPlayer;
    private static int      NUMBER_OF_DECKS      = 3;
    private static int      INITIAL_PLAYER_MONEY = 1000;
    private static int      INITIAL_DEALER_MONEY = 1000000000;
    private int             pot;


    // initialize
    // ----------------------------------------------------------
    /**
     * Create a new Game object.
     */
    public Game()
    {
        discard = new ArrayList<Card>();
        deck = new Stack<Card>();
        fillDiscard();
        shuffleDeck();
        player = new Player(INITIAL_PLAYER_MONEY);
        dealer = new Player(INITIAL_DEALER_MONEY);
        currentPlayer = dealer;
        pot = 0;
    }


    // methods

    /**
     * Shuffles the deck with cards from the discard pile
     */
    public void shuffleDeck()
    {
        while (!discard.isEmpty())
        {
            deck.push(discard.remove(Random.generator().nextInt(discard.size())));
        }

    }


    /**
     * Fills the discard pile with the given amount of decks.
     */
    public void fillDiscard()
    {
        for (int d = 0; d < NUMBER_OF_DECKS; d++)
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


    /**
     * Deals cards to the player and dealer, giving the dealer one face down
     * card.
     */
    public void dealHands()
    {
        hit(dealer);
        hit(player);
        checkDeckIsEmpty();
        Card card = deck.pop();
        card.flipCardDown();
        dealer.addCard(card);
        hit(player);
    }


    /**
     * Discards hands into the discard pile
     */
    public void discardHands()
    {
        for (Card c : player.getHand())
        {
            c.flipCardDown();
            if (c.getNumber() == 1 && c.getValue() == 1)
            {
                c.revertAceValue();
            }
            discard.add(c);
        }
        for (Card c : dealer.getHand())
        {
            c.flipCardDown();
            if (c.getNumber() == 1 && c.getValue() == 1)
            {
                c.revertAceValue();
            }
            discard.add(c);
        }
        player.clearHand();
        dealer.clearHand();
    }


    /**
     * Starts a new round with no winner and new hands and a given bet
     *
     * @param bet
     *            the amount the player bets
     */
    public void newRound(int bet)
    {
        pot = 0;
        currentPlayer = player;
        winner = null;
        pot -= player.changeMoney(-bet);
        pot -= dealer.changeMoney(-pot);
        discardHands();
        dealHands();
    }


    private void rewardPot()
    {
        if (winner != null)
        {
            winner.changeMoney(pot);
            pot = 0;
        }
        else if (pot % 2 == 0)
        {
            player.changeMoney(pot / 2);
            dealer.changeMoney(pot / 2);
            pot = 0;
        }
    }


    /**
     * Hit the given player with a card, shuffle if the deck is empty
     *
     * @param p
     *            the player to be hit
     */
    public void hit(Player p)
    {
        checkDeckIsEmpty();
        Card card = deck.pop();
        card.flipCardUp();
        p.addCard(card);
        if (p.getScore() > 21)
        {
            if (p.getUnchangedAce() != null)
            {
                p.getUnchangedAce().changeAceValue();
                p.recalculateScore();
            }
            else
            {
                if (p.equals(dealer))
                {
                    winner = player;
                }
                else
                {
                    winner = dealer;
                }
                rewardPot();
                currentPlayer = dealer;
            }
        }
        if (p.getScore() == 21)
        {
            stand(p);
        }
    }


    /**
     * Determines the winner if the dealer stands, otherwise starts dealer's
     * turn
     *
     * @param p
     *            the given player that is standing
     */
    public void stand(Player p)
    {
        if (p.equals(dealer) && currentPlayer.equals(dealer))
        {
            if (dealer.getScore() > player.getScore())
            {
                winner = dealer;
            }
            else if (dealer.getScore() < player.getScore())
            {
                winner = player;
            }
            else
            {
                winner = null;
            }
            rewardPot();
        }
        if (p.equals(player))
        {
            currentPlayer = dealer;
            dealerTurn();
        }
    }


    /**
     * The dealer flips his cards up and then hits until he beats the player,
     * hits 21, or busts
     */
    public void dealerTurn()
    {
        for (Card c : dealer.getHand())
        {
            c.flipCardUp();
        }
        while (dealer.getScore() < player.getScore())
        {
            hit(dealer);
        }
        if (dealer.getScore() <= 21)
        {
            stand(dealer);
        }
    }


    /**
     * Checks if the deck is empty and then shuffles the deck if it is
     */
    private void checkDeckIsEmpty()
    {
        if (deck.isEmpty())
        {
            shuffleDeck();
        }
    }


    /**
     * Returns the dealer to access his/her hand
     *
     * @return returns the dealer
     */
    public Player getDealer()
    {
        return dealer;
    }


    /**
     * Returns the player to access his/her hand
     *
     * @return returns the player
     */
    public Player getPlayer()
    {
        return player;
    }


    /**
     * Returns the discard for GUI purposes
     *
     * @return returns the discarded cards
     */
    public ArrayList<Card> getDiscard()
    {
        return discard;
    }


    /**
     * Returns the deck for GUI purposes
     *
     * @return returns the deck
     */
    public Stack<Card> getDeck()
    {
        return deck;
    }


    /**
     * Returns the winner of the round
     *
     * @return returns the winner
     */
    public Player getWinner()
    {
        return winner;
    }


    /**
     * Returns the current player to determine whose turn it is
     *
     * @return returns the current player
     */
    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }


    // ----------------------------------------------------------
    /**
     * Returns the total pot for the round
     *
     * @return the pot
     */
    public int getPot()
    {
        return pot;
    }
}
