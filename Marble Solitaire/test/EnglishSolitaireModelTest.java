import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Represents the test class, could make fields MarbleSolitaireModel.
 */
public class EnglishSolitaireModelTest {
  private MarbleSolitaireModel game1;
  private MarbleSolitaireModel game2;
  private MarbleSolitaireModel game3;
  private MarbleSolitaireModel game4;
  private MarbleSolitaireModel game5;
  private MarbleSolitaireModel game6;
  private MarbleSolitaireModel game7;
  private MarbleSolitaireModel game8;
  private MarbleSolitaireModel game9;
  private MarbleSolitaireModel game10;


  //initializing data examples
  @Before
  public void setup() {
    this.game1 = new EnglishSolitaireModel();
    this.game2 = new EnglishSolitaireModel(5);
    this.game3 = new EnglishSolitaireModel(2, 2);
    this.game4 = new EnglishSolitaireModel(5, 6, 6);
    this.game5 = new EnglishSolitaireModel(3, 3);
    this.game6 = new EnglishSolitaireModel(3);
    this.game7 = new EnglishSolitaireModel();
    this.game8 = new EnglishSolitaireModel(3, 3, 3);
    this.game9 = new EnglishSolitaireModel(1);
    this.game10 = new EnglishSolitaireModel();
  }


  //to test the Move method.
  @Test
  public void testMove() {
    assertEquals(32, this.game1.getScore());
    assertEquals(104, this.game2.getScore());
    assertEquals(32, this.game5.getScore());
    assertEquals(104, this.game4.getScore());
    assertEquals(32, this.game10.getScore());
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game7.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game7.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game7.getSlotAt(4, 3));
    this.game1.move(5, 3, 3, 3);
    assertEquals(31, this.game1.getScore());
    this.game2.move(8, 6, 6, 6);
    assertEquals(103, this.game2.getScore());
    this.game5.move(1, 3, 3, 3);
    assertEquals(31, this.game5.getScore());
    this.game4.move(6, 8, 6, 6);
    assertEquals(103, this.game4.getScore());
    this.game7.move(5, 3, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game7.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game7.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game7.getSlotAt(4, 3));
    this.game10.move(3,1,3,3);
    assertEquals(31, this.game10.getScore());


    try {
      this.game1.move(6, 6, 3, 3);
      fail("Should have thrown an IllegalArgumentException because move is invalid" +
              "as its going from an invalid board slot to another far away from it with no" +
              "marble between it");
    } catch (IllegalArgumentException e) {
      //test should pass
    }
    try {
      this.game2.move(14, 14, 6, 6);
      fail("Should have thrown an IllegalArgumentException because from Row and Col " +
              "are not valid board slots");
    } catch (IllegalArgumentException e) {
      //test should pass
    }
    try {
      this.game1.move(3, 3, 5, 3);
      fail("Should have thrown an IllegalArgumentException because move is invalid");
    } catch (IllegalArgumentException e) {
      //test should pass
    }

    try {
      this.game2.move(1, 3, 4, 0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      //test should pass
    }

    try {
      this.game2.move(1, 3, 9, 9);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      //test should pass
    }

    try {
      this.game2.move(0, 2, 2, 2);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      //test should pass
    }

    try {
      this.game2.move(3, 2, 3, 4);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      //test should pass
    }

    try {
      this.game2.move(0, 2, 4, 2);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      //test should pass
    }


  }

  //to test the isGameOver method.
  @Test
  public void isGameOver() {
    assertTrue(this.game9.isGameOver());
    assertFalse(this.game1.isGameOver());
    assertFalse(this.game2.isGameOver());

    //Playing through Game1 until there is only 1 Marble left.
    //(So the game is over)
    this.game1.move(3, 1, 3, 3);
    this.game1.move(5, 2, 3, 2);
    this.game1.move(4, 0, 4, 2);
    this.game1.move(4, 3, 4, 1);
    this.game1.move(4, 5, 4, 3);
    this.game1.move(6, 4, 4, 4);
    this.game1.move(3, 4, 5, 4);
    this.game1.move(6, 2, 6, 4);
    this.game1.move(6, 4, 4, 4);
    this.game1.move(2, 2, 4, 2);
    this.game1.move(0, 2, 2, 2);
    this.game1.move(1, 4, 3, 4);
    this.game1.move(3, 4, 5, 4);
    this.game1.move(5, 4, 5, 2);
    this.game1.move(5, 2, 3, 2);
    this.game1.move(3, 2, 1, 2);
    this.game1.move(2, 0, 4, 0);
    this.game1.move(4, 0, 4, 2);
    this.game1.move(4, 2, 4, 4);
    this.game1.move(2, 6, 2, 4);
    this.game1.move(2, 3, 2, 5);
    this.game1.move(4, 6, 2, 6);
    this.game1.move(2, 6, 2, 4);
    this.game1.move(0, 4, 0, 2);
    this.game1.move(0, 2, 2, 2);
    this.game1.move(2, 1, 2, 3);
    this.game1.move(2, 3, 2, 5);
    this.game1.move(2, 5, 4, 5);
    this.game1.move(4, 5, 4, 3);
    this.game1.move(4, 3, 2, 3);
    this.game1.move(1, 3, 3, 3);
    assertTrue(this.game1.isGameOver());

    //Playing through game7 until there are 2 Marbles left.
    //(So the game is not over yet)
    this.game7.move(3, 1, 3, 3);
    this.game7.move(5, 2, 3, 2);
    this.game7.move(4, 0, 4, 2);
    this.game7.move(4, 3, 4, 1);
    this.game7.move(4, 5, 4, 3);
    this.game7.move(6, 4, 4, 4);
    this.game7.move(3, 4, 5, 4);
    this.game7.move(6, 2, 6, 4);
    this.game7.move(6, 4, 4, 4);
    this.game7.move(2, 2, 4, 2);
    this.game7.move(0, 2, 2, 2);
    this.game7.move(1, 4, 3, 4);
    this.game7.move(3, 4, 5, 4);
    this.game7.move(5, 4, 5, 2);
    this.game7.move(5, 2, 3, 2);
    this.game7.move(3, 2, 1, 2);
    this.game7.move(2, 0, 4, 0);
    this.game7.move(4, 0, 4, 2);
    this.game7.move(4, 2, 4, 4);
    this.game7.move(2, 6, 2, 4);
    this.game7.move(2, 3, 2, 5);
    this.game7.move(4, 6, 2, 6);
    this.game7.move(2, 6, 2, 4);
    this.game7.move(0, 4, 0, 2);
    this.game7.move(0, 2, 2, 2);
    this.game7.move(2, 1, 2, 3);
    this.game7.move(2, 3, 2, 5);
    this.game7.move(2, 5, 4, 5);
    this.game7.move(4, 5, 4, 3);
    this.game7.move(4, 3, 2, 3);
    assertFalse(this.game7.isGameOver());
  }

  //to test the getBoardSize method.
  @Test
  public void testGetBoardSize() {
    assertEquals(7, this.game1.getBoardSize());
    assertEquals(13, this.game2.getBoardSize());
    assertEquals(7, this.game3.getBoardSize());
    assertEquals(13, this.game4.getBoardSize());
  }

  //to test the getSlotAt method.
  @Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game1.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.game2.getSlotAt(0, 0));
    try {
      this.game2.getSlotAt(14, 14);
      fail("Should throw an Illegal argument exception - 1");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }
    try {
      this.game3.getSlotAt(-1, -1);
      fail("Should throw an Illegal argument exception - 2");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }
  }

  //to test the getScore method.
  @Test
  public void testGetScore() {
    assertEquals(32, this.game1.getScore());
    assertEquals(104, this.game2.getScore());
    assertEquals(32, this.game3.getScore());
    assertEquals(104, this.game4.getScore());

    //Playing through game1 so there is 1 Marble left.
    this.game1.move(3, 1, 3, 3);
    this.game1.move(5, 2, 3, 2);
    this.game1.move(4, 0, 4, 2);
    this.game1.move(4, 3, 4, 1);
    this.game1.move(4, 5, 4, 3);
    this.game1.move(6, 4, 4, 4);
    this.game1.move(3, 4, 5, 4);
    this.game1.move(6, 2, 6, 4);
    this.game1.move(6, 4, 4, 4);
    this.game1.move(2, 2, 4, 2);
    this.game1.move(0, 2, 2, 2);
    this.game1.move(1, 4, 3, 4);
    this.game1.move(3, 4, 5, 4);
    this.game1.move(5, 4, 5, 2);
    this.game1.move(5, 2, 3, 2);
    this.game1.move(3, 2, 1, 2);
    this.game1.move(2, 0, 4, 0);
    this.game1.move(4, 0, 4, 2);
    this.game1.move(4, 2, 4, 4);
    this.game1.move(2, 6, 2, 4);
    this.game1.move(2, 3, 2, 5);
    this.game1.move(4, 6, 2, 6);
    this.game1.move(2, 6, 2, 4);
    this.game1.move(0, 4, 0, 2);
    this.game1.move(0, 2, 2, 2);
    this.game1.move(2, 1, 2, 3);
    this.game1.move(2, 3, 2, 5);
    this.game1.move(2, 5, 4, 5);
    this.game1.move(4, 5, 4, 3);
    this.game1.move(4, 3, 2, 3);
    this.game1.move(1, 3, 3, 3);
    assertEquals(1, this.game1.getScore());
  }

  //to test that the first constructor is valid/can be initialized.
  @Test
  public void testValidConstructor1() {
    this.game1.move(5,3,3,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game1.getSlotAt(3,3));
    this.game7.move(3,1,3,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game7.getSlotAt(3,1));
  }

  //to test that the second constructor is valid and can be initialized.
  @Test
  public void testValidConstructor2() {
    this.game6.move(1,3,3,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game6.getSlotAt(3,3));
    this.game2.move(8,6,6,6);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game2.getSlotAt(6,6));
  }

  //to test an invalid initialization of the second constructor.
  @Test
  public void testInvalidConstructor2() {
    try {
      EnglishSolitaireModel game9 = new EnglishSolitaireModel(4);
      fail("Should throw an Illegal argument exception - 1");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }
    try {
      EnglishSolitaireModel game10 = new EnglishSolitaireModel(6);
      fail("Should throw an Illegal argument exception - 2");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }
  }

  //to test a valid initialization of the third constructor.
  @Test
  public void testValidConstructor3() {
    this.game5.move(1,3,3,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game5.getSlotAt(3,3));
    this.game3.move(4,2,2,2);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game3.getSlotAt(2,2));
  }

  //to test an invalid initialization of the third constructor.
  @Test
  public void testInvalidConstructor3() {
    try {
      EnglishSolitaireModel game11 = new EnglishSolitaireModel(0, 0);
      fail("Should throw an Illegal argument exception - 1");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }
    try {
      EnglishSolitaireModel game12 = new EnglishSolitaireModel(-1, -1);
      fail("Should throw an Illegal argument exception - 2");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }
  }

  //to test initializing a valid 4th constructor.
  @Test
  public void testValidConstructor4() {
    this.game8.move(5,3,3,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game8.getSlotAt(3,3));
    this.game4.move(8,6,6,6);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game4.getSlotAt(8,6));
  }

  //to test initializing an invalid 4th constructor.
  @Test
  public void testInvalidConstructor4() {
    try {
      EnglishSolitaireModel game13 = new EnglishSolitaireModel(4, 3, 3);
      fail("Should throw an Illegal argument exception - 1");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }
    try {
      EnglishSolitaireModel game14 = new EnglishSolitaireModel(3, 0, 0);
      fail("Should throw an Illegal argument exception - 2");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }

    try {
      EnglishSolitaireModel game14 = new EnglishSolitaireModel(3, -1, -1);
      fail("Should throw an Illegal argument exception - 2");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }

    try {
      EnglishSolitaireModel game14 = new EnglishSolitaireModel(-3, 3, 3);
      fail("Should throw an Illegal argument exception - 2");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }

  }

}
