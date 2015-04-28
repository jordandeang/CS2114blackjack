package com.example.cs2114blackjack;

import android.widget.EditText;
import sofia.graphics.RectangleShape;
import sofia.app.ShapeScreen;
import android.widget.Button;
import android.widget.TextView;

// -------------------------------------------------------------------------
/**
 * The MainScreen class is used to control the user interaction and display of
 * the game. This class links its GUI to the backend information handled by the
 * Game class.
 *
 * @author1 Jason Davis (jdavis7)
 * @author2 Jordan Deang (jdeang)
 * @author3 Tommy Hyres (tommy085)
 * @version 2015.04.27
 */
public class MainScreen
    extends ShapeScreen
{
    private Game           game;
    private TextView       winner;
    private TextView       playerLabel;
    private TextView       dealerLabel;
    private Button         hit;
    private Button         stand;
    private Button         newRound;
    private RectangleShape background;
    private EditText       editBet;


    /**
     * This method initializes the screen
     */
    public void initialize()
    {
        game = new Game();
        background = new RectangleShape(0, 0, getWidth(), getHeight());
        background.setImage("blackjacktable");
        editBet.setHint("Enter a bet");
        updateGui();
    }


    /**
     * This method updates the GUI by first clearing it and then adding the
     * background and the appropriate card rectangle shapes. It also disabled
     * the buttons if the player is not the current player.
     */
    private void updateGui()
    {
        clear();
        add(background);
        playerLabel.setText("You: $" + game.getPlayer().getMoney());
        dealerLabel.setText("Dealer: $" + game.getDealer().getMoney());
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
                winner.setText("You win!");
            }
        }
        else
        {
            winner.setText("Current pot: $" + game.getPot());
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
        String editString = editBet.getText().toString();
        if (editString.equals(""))
        {
            game.newRound(0);
        }
        else
        {
            int bet = Integer.parseInt(editString);
            game.newRound(bet);
        }
        editBet.setText("");
        editBet.setHint("Enter a bet");
        updateGui();
    }


    // ----------------------------------------------------------
    /**
     * Returns the hit button for testing purposes. Allows the test class to
     * check if it is enabled or not.
     *
     * @return the hit button
     */
    public Button getHit()
    {
        return hit;
    }


    // ----------------------------------------------------------
    /**
     * Returns the stand button for testing purposes. Allows the test class to
     * check if it is enabled or not.
     *
     * @return the stand button
     */
    public Button getStand()
    {
        return stand;
    }


    // ----------------------------------------------------------
    /**
     * Returns the newRound button for testing purposes. Allows the test class
     * to check if it is enabled or not.
     *
     * @return the newRound button
     */
    public Button getNewRound()
    {
        return newRound;
    }


    // ----------------------------------------------------------
    /**
     * Returns the game for this screen for testing purposes.
     *
     * @return the game of this screen
     */
    public Game getGame()
    {
        return game;
    }


    // ----------------------------------------------------------
    /**
     * Returns the background rectangle shape for testing purposes.
     *
     * @return the background rectangle shape
     */
    public RectangleShape getBackground()
    {
        return background;
    }

}
