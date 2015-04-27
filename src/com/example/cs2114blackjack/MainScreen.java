package com.example.cs2114blackjack;

import sofia.graphics.RectangleShape;
import sofia.app.ShapeScreen;
import android.widget.Button;
import android.widget.TextView;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author1
 * @author2
 * @author3
 * @version
 */
public class MainScreen
    extends ShapeScreen
{
    private Game           game;
    private TextView       winner;
    private Button         hit;
    private Button         stand;
    private RectangleShape background;


    /**
     * This method initializes the screen
     */
    public void initialize()
    {
        game = new Game();
        background = new RectangleShape(0, 0, getWidth(), getHeight());
        background.setImage("blackjacktable");
        updateGui();
    }


    /**
     * This method constantly updates the GUI
     */
    private void updateGui()
    {
        clear();
        add(background);
        if (game.getDeck().size() > 0)
        {
            for (int i = 0; i < (game.getDeck().size() / 30) + 1; i++)
            {
                // Loops through deck and adds a rectangle card that is already
                // flipped down for every 30 cards
                Card card = game.getDeck().get(i);
                card.setPosition(650, 600 + (10 * i));
                add(card);
            }
        }
        if (game.getDiscard().size() > 0)
        {
            for (int i = 0; i < (game.getDiscard().size() / 30) + 1; i++)
            {
                // Loops through the discard and adds a rectangle card that is
                // already flipped down for every 30 cards
                Card card = game.getDiscard().get(i);
                card.setPosition(900, 600 + (10 * i));
                add(card);
            }
        }
        for (int i = 0; i < game.getDealer().getHand().size(); i++)
        {
            // Loops through the dealer's hand and adds the rectangle images to
            // the screen
            Card card = game.getDealer().getHand().get(i);
            card.setPosition(160 + (50 * i), 320);
            add(card);
        }
        for (int i = 0; i < game.getPlayer().getHand().size(); i++)
        {
            // Loops through the player's hand and adds the rectangle images to
            // the screen
            Card card = game.getPlayer().getHand().get(i);
            card.setPosition(160 + (50 * i), 960);
            add(card);
        }
        if (game.getWinner() != null)
        {
            if (game.getWinner().equals(game.getDealer()))
            {
                winner.setText("Dealer wins!");
            }
            else if (game.getWinner().equals(game.getPlayer()))
            {
                winner.setText("Player wins!");
            }
        }
        else
        {
            winner.setText("No winner");
        }
        if (game.getCurrentPlayer().equals(game.getPlayer()))
        {
            hit.setEnabled(true);
            stand.setEnabled(true);
        }
        else
        {
            hit.setEnabled(false);
            stand.setEnabled(false);
        }
    }


    /**
     * executes when the user taps the "Hit" button
     */
    public void hitClicked()
    {
        game.hit(game.getPlayer());
        updateGui();
    }


    /**
     * executes when the user taps the "Stand" button
     */
    public void standClicked()
    {
        game.stand(game.getPlayer());
        updateGui();
    }


    /**
     * executes when the user taps the "New Round" button
     */
    public void newRoundClicked()
    {
        game.newRound();
        updateGui();
    }
}
