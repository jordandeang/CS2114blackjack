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
        updateGui();
    }


    /**
     * This method constantly updates the GUI
     */
    private void updateGui()
    {
        clear();
        background = new RectangleShape(0, 0, getWidth(), getHeight());
        background.setImage("blackjacktable");
        add(background);
        if (game.getDeck().size() > 0)
        {
            for (int i = 0; i < (game.getDeck().size() / 15) + 1; i++)
            {
                RectangleShape cardBack =
                    new RectangleShape(550, 500 + (10 * i), 550 + (71 * 3), 500
                        + (10 * i) + (96 * 3));
                cardBack.setImage("b2fv");
                add(cardBack);
            }
        }
        if (game.getDiscard().size() > 0)
        {
            for (int i = 0; i < (game.getDiscard().size() / 15) + 1; i++)
            {
                RectangleShape cardBack =
                    new RectangleShape(800, 500 + (10 * i), 800 + (71 * 3), 500
                        + (10 * i) + (96 * 3));
                cardBack.setImage("b2fv");
                add(cardBack);
            }
        }
        for (int i = 0; i < game.getDealer().getHand().size(); i++)
        {
            Card card = game.getDealer().getHand().get(i);
            card.setPosition(160 + (50 * i), 320);
            add(card);
        }
        for (int i = 0; i < game.getPlayer().getHand().size(); i++)
        {
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
