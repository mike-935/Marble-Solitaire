import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Represents the test class for a TriangleSolitaireModel. Tests that all our methods work for,
 * Our new triangleSolitaire board/implementation
 */
public class TriangleSolitaireModelTest {
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
  private MarbleSolitaireModel game11;
  private MarbleSolitaireModel game12;
  private MarbleSolitaireModel game13;
  private MarbleSolitaireModel game14;


  //initializing data examples
  @Before
  public void setup() {
    this.game1 = new TriangleSolitaireModel();
    this.game2 = new TriangleSolitaireModel(6);
    this.game3 = new TriangleSolitaireModel(2, 2);
    this.game4 = new TriangleSolitaireModel(5, 4, 4);
    this.game5 = new TriangleSolitaireModel(3, 3);
    this.game6 = new TriangleSolitaireModel(3);
    this.game7 = new TriangleSolitaireModel();
    this.game8 = new TriangleSolitaireModel(3, 2, 2);
    this.game9 = new TriangleSolitaireModel(1);
    this.game10 = new TriangleSolitaireModel();
    this.game11 = new TriangleSolitaireModel(6,3,1);
    this.game12 = new TriangleSolitaireModel(3);
    this.game13 = new TriangleSolitaireModel(3,0,0);
    this.game14 = new TriangleSolitaireModel(6,3,2);
  }


  //to test the Move method.
  @Test
  public void testMove() {
    assertEquals(14, this.game1.getScore());
    assertEquals(20, this.game2.getScore());
    assertEquals(14, this.game5.getScore());
    assertEquals(14, this.game4.getScore());
    assertEquals(14, this.game10.getScore());
    assertEquals(20, this.game11.getScore());
    assertEquals(20, this.game14.getScore());
    Assert.assertEquals(MarbleSolitaireModelState.SlotState.Empty,
            this.game7.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game7.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game7.getSlotAt(1, 0));
    this.game1.move(2, 0, 0, 0);
    assertEquals(13, this.game1.getScore());
    this.game2.move(2, 2, 0, 0);
    assertEquals(19, this.game2.getScore());
    this.game5.move(1, 1, 3, 3);
    assertEquals(13, this.game5.getScore());
    this.game4.move(2, 2, 4, 4);
    assertEquals(13, this.game4.getScore());
    this.game7.move(2, 0, 0, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game7.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game7.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game7.getSlotAt(1, 0));
    this.game10.move(2,2,0,0);
    assertEquals(13, this.game10.getScore());

    this.game11.move(3,3,3,1);
    assertEquals(19, this.game11.getScore());
    this.game11.move(1,1,3,3);
    assertEquals(18, this.game11.getScore());
    this.game14.move(3,0,3,2);
    assertEquals(18, this.game11.getScore());


    //Maybe can abstract this part
    try {
      this.game1.move(4, 0, 0, 0);
      fail("");
    } catch (IllegalArgumentException e) {
      //test should pass
    }
    try {
      this.game2.move(7, 0, 5, 0);
      fail("Should have thrown an IllegalArgumentException because from Row and Col " +
              "are not valid board slots");
    } catch (IllegalArgumentException e) {
      //test should pass
    }
    try {
      this.game1.move(0, 0, 2, 0);
      fail("Should have thrown an IllegalArgumentException because move is invalid");
    } catch (IllegalArgumentException e) {
      //test should pass
    }

    try {
      this.game2.move(0, 0, 0, 2);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      //test should pass
    }

    try {
      this.game2.move(1, 0, 3, 1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      //test should pass
    }

    try {
      this.game2.move(1, 0, 3, 2);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      //test should pass
    }

    try {
      this.game2.move(3, 2, 3, 3);
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
    assertFalse(this.game12.isGameOver());
    assertFalse(this.game13.isGameOver());

    this.game12.move(2,0,0,0);
    this.game12.move(2,2,2,0);
    assertTrue(this.game12.isGameOver());

    this.game13.move(2,0,0,0);
    assertFalse(this.game13.isGameOver());

    this.game13.move(2,2,2,0);
    assertTrue(this.game13.isGameOver());
  }

  //to test the getBoardSize method.
  //can abstract this
  @Test
  public void testGetBoardSize() {
    assertEquals(5, this.game1.getBoardSize());
    assertEquals(6, this.game2.getBoardSize());
    assertEquals(3, this.game12.getBoardSize());
    assertEquals(5, this.game4.getBoardSize());
  }

  //to test the getSlotAt method.
  //can abstract this except first 4 assertEquals
  @Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game1.getSlotAt(1,1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game1.getSlotAt(1,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game1.getSlotAt(4,0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game1.getSlotAt(3,2));

    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game1.getSlotAt(4, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.game2.getSlotAt(4, 5));

    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, this.game1.getSlotAt(0, 1));
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

    try {
      this.game3.getSlotAt(0, 6);
      fail("Should throw an Illegal argument exception - 2");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }

    try {
      this.game3.getSlotAt(6, 3);
      fail("Should throw an Illegal argument exception - 2");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }
  }

  //to test the getScore method.
  @Test
  public void testGetScore() {
    assertEquals(14, this.game1.getScore());
    assertEquals(20, this.game2.getScore());
    assertEquals(14, this.game3.getScore());
    assertEquals(5, this.game13.getScore());
    assertEquals(5, this.game12.getScore());

    this.game13.move(2,0,0,0);
    assertEquals(4, this.game13.getScore());

    this.game12.move(2,0,0,0);
    this.game12.move(2,2,2,0);
    assertEquals(3, this.game12.getScore());

  }

  //to test that the first constructor is valid/can be initialized.
  @Test
  public void testValidConstructor1() {
    this.game1.move(2,0,0,0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game1.getSlotAt(0,0));
    this.game7.move(2,2,0,0);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game7.getSlotAt(2,2));
  }

  //to test that the second constructor is valid and can be initialized.
  @Test
  public void testValidConstructor2() {
    this.game6.move(2,0,0,0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game6.getSlotAt(0,0));
    this.game2.move(2,2,0,0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game2.getSlotAt(0,0));
  }

  //to test an invalid initialization of the second constructor.
  @Test
  public void testInvalidConstructor2() {
    try {
      MarbleSolitaireModel game9 = new TriangleSolitaireModel(-1);
      fail("Should throw an Illegal argument exception - 1");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }
    try {
      MarbleSolitaireModel game10 = new TriangleSolitaireModel(-10);
      fail("Should throw an Illegal argument exception - 2");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }
  }

  //to test a valid initialization of the third constructor.
  @Test
  public void testValidConstructor3() {
    this.game5.move(1,1,3,3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game5.getSlotAt(3,3));
    this.game3.move(0,0,2,2);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game3.getSlotAt(2,2));
  }

  //to test an invalid initialization of the third constructor.
  @Test
  public void testInvalidConstructor3() {
    try {
      MarbleSolitaireModel game11 = new EuropeanSolitaireModel(0, 1);
      fail("Should throw an Illegal argument exception - 1");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }
    try {
      MarbleSolitaireModel game12 = new EuropeanSolitaireModel(7, 7);
      fail("Should throw an Illegal argument exception - 2");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }
  }

  //to test initializing a valid 4th constructor.
  @Test
  public void testValidConstructor4() {
    this.game8.move(0,0,2,2);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, this.game8.getSlotAt(2,2));
    this.game4.move(4,2,4,4);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, this.game4.getSlotAt(4,2));
  }

  //to test initializing an invalid 4th constructor.
  @Test
  public void testInvalidConstructor4() {
    try {
      MarbleSolitaireModel game13 = new TriangleSolitaireModel(4, 0, 1);
      fail("Should throw an Illegal argument exception - 1");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }
    try {
      MarbleSolitaireModel game14 = new TriangleSolitaireModel(-1, 0, 0);
      fail("Should throw an Illegal argument exception - 2");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }

    try {
      MarbleSolitaireModel game14 = new TriangleSolitaireModel(-1, -1, -1);
      fail("Should throw an Illegal argument exception - 2");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }

    try {
      MarbleSolitaireModel game14 = new TriangleSolitaireModel(3, 5, 1);
      fail("Should throw an Illegal argument exception - 2");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }

  }

}
