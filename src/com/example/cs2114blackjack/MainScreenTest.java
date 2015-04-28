package com.example.cs2114blackjack;

// -------------------------------------------------------------------------
/**
 * Unit Tests for the MainScreen class. Run as Android JUnit Tests to test the
 * functions of the GUI including the buttons.
 *
 * @author1 Jason Davis (jdavis7)
 * @author2 Jordan Deang (jdeang)
 * @author3 Tommy Hyres (tommy085)
 * @version 2015.04.27
 */
public class MainScreenTest
    extends student.AndroidTestCase<MainScreen>
{
    private MainScreen screen;
    private Game       game;


    /**
     * Test cases that extend AndroidTestCase must have a parameterless
     * constructor that calls super() and passes it the screen/activity class
     * being tested.
     */
    public MainScreenTest()
    {
        super(MainScreen.class);
    }

    /**
     * Initializes the text fixtures.
     */
    public void setUp()
    {
        screen = getScreen();
        game = screen.getGame();
    }

    /**
     * Unit test for the initialization of the MainScreen. Checks that the card
     * shapes are in the appropriate places. and that the buttons are
     * appropriate enabled/disabled.
     */
    public void testInitialize()
    {
        for (int i = 0; i < game.getPlayer().getHand().size(); i++)
        {
            assertEquals(true, screen.getShapeView().getShapes().all()
                .contains(game.getPlayer().getHand().get(i)));
        }
        for (int i = 0; i < game.getDealer().getHand().size(); i++)
        {
            assertEquals(true, screen.getShapeView().getShapes().all()
                .contains(game.getDealer().getHand().get(i)));
        }
        for (int i = 0; i < (game.getDeck().size() / 30) + 1; i++)
        {
            assertEquals(true, screen.getShapeView().getShapes().all()
                .contains(game.getDeck().get(i)));
        }
        assertEquals(
            true,
            screen.getShapeView().getShapes().all()
                .contains(screen.getBackground()));
    }

    /**
     * Unit test the hit button on the GUI.
     */
    public void testHitClicked()
    {
        while (screen.getHit().isEnabled())
        {
            click(screen.getHit());
        }
        for (int i = 0; i < game.getPlayer().getHand().size(); i++)
        {
            assertEquals(true, screen.getShapeView().getShapes().all()
                .contains(game.getPlayer().getHand().get(i)));
        }
        for (int i = 0; i < game.getDealer().getHand().size(); i++)
        {
            assertEquals(true, screen.getShapeView().getShapes().all()
                .contains(game.getDealer().getHand().get(i)));
        }
        for (int i = 0; i < (game.getDeck().size() / 30) + 1; i++)
        {
            assertEquals(true, screen.getShapeView().getShapes().all()
                .contains(game.getDeck().get(i)));
        }
        assertEquals(
            true,
            screen.getShapeView().getShapes().all()
                .contains(screen.getBackground()));
        assertEquals(false, screen.getHit().isEnabled());
        assertEquals(false, screen.getStand().isEnabled());
    }

    /**
     * Unit test the stand button on the GUI.
     */
    public void testStandClicked()
    {
        click(screen.getStand());
        for (int i = 0; i < game.getPlayer().getHand().size(); i++)
        {
            assertEquals(true, screen.getShapeView().getShapes().all()
                .contains(game.getPlayer().getHand().get(i)));
        }
        for (int i = 0; i < game.getDealer().getHand().size(); i++)
        {
            assertEquals(true, screen.getShapeView().getShapes().all()
                .contains(game.getDealer().getHand().get(i)));
        }
        for (int i = 0; i < (game.getDeck().size() / 30) + 1; i++)
        {
            assertEquals(true, screen.getShapeView().getShapes().all()
                .contains(game.getDeck().get(i)));
        }
        assertEquals(
            true,
            screen.getShapeView().getShapes().all()
                .contains(screen.getBackground()));
        assertEquals(false, screen.getHit().isEnabled());
        assertEquals(false, screen.getStand().isEnabled());
    }

    /**
     * Unit test the stand button on the GUI.
     */
    public void testNewRoundClicked()
    {
        click(screen.getNewRound());
        for (int i = 0; i < game.getPlayer().getHand().size(); i++)
        {
            assertEquals(true, screen.getShapeView().getShapes().all()
                .contains(game.getPlayer().getHand().get(i)));
        }
        for (int i = 0; i < game.getDealer().getHand().size(); i++)
        {
            assertEquals(true, screen.getShapeView().getShapes().all()
                .contains(game.getDealer().getHand().get(i)));
        }
        for (int i = 0; i < (game.getDeck().size() / 30) + 1; i++)
        {
            assertEquals(true, screen.getShapeView().getShapes().all()
                .contains(game.getDeck().get(i)));
        }
        for (int i = 0; i < (game.getDiscard().size() / 30) + 1; i++)
        {
            assertEquals(true, screen.getShapeView().getShapes().all()
                .contains(game.getDeck().get(i)));
        }
        assertEquals(
            true,
            screen.getShapeView().getShapes().all()
                .contains(screen.getBackground()));
    }
}
