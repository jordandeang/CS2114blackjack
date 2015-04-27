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
    private TextView       dealerHand;
    private TextView       playerHand;
    private TextView       discard;
    private TextView       deck;
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
        add(background);
        updateGui();
    }


    /**
     * This method constantly updates the GUI
     */
    private void updateGui()
    {
        discard.setText(game.getDiscard().size() + " cards in the discard");
        deck.setText(game.getDeck().size() + " cards in the deck");
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
