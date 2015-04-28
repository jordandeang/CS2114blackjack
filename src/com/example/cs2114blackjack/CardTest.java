package com.example.cs2114blackjack;

// -------------------------------------------------------------------------
/**
 * Unit tests for the Card class
 *
 * @author1 Jason Davis (jdavis7)
 * @author2 Jordan Deang (jdeang)
 * @author3 Tommy Hyres (tommy085)
 * @version 2015.04.27
 */
public class CardTest
    extends student.TestCase
{
    private Card testCard1;
    private Card testCard2;
    private Card testCard3;
    private Card testCard4;
    private Card testCard5;


    /**
     * setUp for all test cases in the Card class
     */
    public void setUp()
    {
        testCard1 = new Card(1, 1);
        testCard2 = new Card(4, 2);
        testCard3 = new Card(6, 3);
        testCard4 = new Card(10, 4);
        testCard5 = new Card(11, 4);
    }


    /**
     * Tests the constructor of the card class
     */
    public void testConstructor()
    {
        assertEquals(1, testCard1.getNumber());
        assertEquals("c", testCard1.getSuit());
        assertEquals("c1", testCard1.getImageString());
        assertEquals(4, testCard2.getNumber());
        assertEquals("d", testCard2.getSuit());
        assertEquals("d4", testCard2.getImageString());
    }


    /**
     * Tests the numberToSuit method
     */
    public void testNumberToSuit()
    {
        assertEquals("c", testCard1.numberToSuit(1));
        assertEquals("d", testCard2.numberToSuit(2));
        assertEquals("h", testCard3.numberToSuit(3));
        assertEquals("s", testCard4.numberToSuit(4));

        Exception thrown = null;
        try
        {
            testCard1.numberToSuit(5);
        }
        catch (Exception exception)
        {
            thrown = exception;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        assertEquals(
            "Invalid suit number. Choose a number between 1 and 4.",
            thrown.getMessage());
    }


    /**
     * Tests the changeAceValue and revertAceValue methods
     */
    public void testChangeAceValueAndRevertAceValue()
    {
        testCard5.changeAceValue();
        assertEquals(1, testCard5.getValue());

        testCard1.revertAceValue();
        assertEquals(11, testCard1.getValue());
    }


    /**
     * Tests the flipCardUp method
     */
    public void testFlipCardUp()
    {
        testCard1.flipCardUp();
        assertEquals("c" + 1, testCard1.getImageString());
    }


    /**
     * Tests the flipCardDown method
     */
    public void testFlipCardDown()
    {
        testCard1.flipCardDown();
        assertNotSame("b2fv", testCard1.getImageString());
    }

}
