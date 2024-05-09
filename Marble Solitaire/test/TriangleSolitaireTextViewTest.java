import org.junit.Test;
import org.junit.Before;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This class is here to test our implementation of the view to represent the triangle board.
 * /Our implementation of the triangleSolitaireModel.
 */
public class TriangleSolitaireTextViewTest {

  private MarbleSolitaireView view1;
  private MarbleSolitaireView view2;
  private MarbleSolitaireView view3;
  private MarbleSolitaireView view4;
  private MarbleSolitaireView view5;

  private MarbleSolitaireView view6;
  private MarbleSolitaireView view7;
  private Appendable stringBuild;
  private MarbleSolitaireView view8;
  private Appendable stringBuild2;
  private MarbleSolitaireView view9;
  private MarbleSolitaireView view10;
  private MarbleSolitaireView view11;
  private MarbleSolitaireView view12;
  private MarbleSolitaireView view13;
  private MarbleSolitaireView view14;
  private MarbleSolitaireView failView1;
  private MarbleSolitaireView failView2;
  private MarbleSolitaireView failView3;
  private MarbleSolitaireView failView4;
  private Appendable stringBuild3;
  private Appendable stringBuild4;
  private Appendable stringBuild5;
  private String answer1;
  private String answer2;
  private String answer3;
  private String answer4;
  private String answer5;
  private String answer6;

  //to initialize data examples
  @Before
  public void setup() {
    this.view1 = new TriangleSolitaireTextView(new TriangleSolitaireModel());
    this.view2 = new TriangleSolitaireTextView(new TriangleSolitaireModel(1));
    this.view3 = new TriangleSolitaireTextView(new TriangleSolitaireModel(0, 0));
    this.view4 = new TriangleSolitaireTextView(new TriangleSolitaireModel(5,
            0,0));
    this.view5 = new TriangleSolitaireTextView(new TriangleSolitaireModel(5,
            0,0));

    TriangleSolitaireModel game1 = new TriangleSolitaireModel();
    game1.move(2, 0, 0, 0);
    this.view6 = new TriangleSolitaireTextView(game1);

    this.stringBuild = new StringBuilder();
    this.view7 = new TriangleSolitaireTextView(new TriangleSolitaireModel(),
            this.stringBuild);

    this.stringBuild2 = new StringBuilder("Test" + "\n");
    this.view8 = new TriangleSolitaireTextView(new TriangleSolitaireModel(5),
            this.stringBuild2);

    TriangleSolitaireModel game2 = new TriangleSolitaireModel();
    game2.move(2, 0, 0, 0);
    this.stringBuild3 = new StringBuilder();
    this.view9 = new TriangleSolitaireTextView(game2,
            this.stringBuild3);

    this.stringBuild4 = new StringBuilder();
    this.view10 = new TriangleSolitaireTextView(new TriangleSolitaireModel(),
            this.stringBuild4);

    this.stringBuild5 = new StringBuilder("Test: ");
    this.view11 = new TriangleSolitaireTextView(new TriangleSolitaireModel(5),
            this.stringBuild5);

    Appendable failAP1 = new MyAppendObject();
    Appendable failAP2 = new MyAppendObject();
    Appendable failAP3 = new MyAppendObject();
    Appendable failAP4 = new MyAppendObject();

    this.failView1 = new TriangleSolitaireTextView(new TriangleSolitaireModel(3),
            failAP1);
    this.failView2 = new TriangleSolitaireTextView(new TriangleSolitaireModel(), failAP2);

    this.failView3 = new TriangleSolitaireTextView(new TriangleSolitaireModel(0, 0),
            failAP3);
    this.failView4 =
            new TriangleSolitaireTextView(new TriangleSolitaireModel(3,
                    0, 0), failAP4);

    this.answer1 = "    _" + "\n" + "   O O" + "\n" + "  O O O" + "\n" + " O O O O" + "\n"
            + "O O O O O";

    this.answer2 = "    O" + "\n" + "   _ O" + "\n" + "  _ O O" + "\n" + " O O O O" + "\n"
            + "O O O O O";

    this.answer3 = "Test" + "\n" + "    _" + "\n" + "   O O" + "\n" + "  O O O" + "\n"
            + " O O O O" + "\n" + "O O O O O";

    this.view12 = new TriangleSolitaireTextView(new TriangleSolitaireModel(4));
    this.view13 = new TriangleSolitaireTextView(new TriangleSolitaireModel(3));
    this.view14 = new TriangleSolitaireTextView(new TriangleSolitaireModel(3, 3));

    this.answer4 = "   _" + "\n" + "  O O" + "\n" + " O O O" + "\n" + "O O O O";
    this.answer5 = "  _" + "\n" + " O O" + "\n" + "O O O";
    this.answer6 = "    O" + "\n" + "   O O" + "\n" + "  O O O" + "\n" + " O O O _" + "\n"
            + "O O O O O";

  }

  //to test toString.
  @Test
  public void testToString() {
    assertEquals(this.answer1, this.view1.toString());
    assertEquals(this.answer1, this.view3.toString());
    assertEquals(this.answer1, this.view4.toString());
    assertEquals(this.answer1, this.view5.toString());
    assertEquals("_", this.view2.toString());
    assertEquals(this.answer2, this.view6.toString());
    assertEquals(this.answer4, this.view12.toString());
    assertEquals(this.answer5, this.view13.toString());
    assertEquals(this.answer6, this.view14.toString());
  }

  //to test valid initialization of the first constructor.
  @Test
  public void testValidConstructor1() {
    assertEquals(this.answer1, this.view1.toString());
    assertEquals(this.answer2, this.view6.toString());
  }

  //to test an invalid first constructor.
  @Test
  public void testInvalidConstructor1() {
    EnglishSolitaireModel game3 = null;
    try {
      MarbleSolitaireView invalidView1 = new TriangleSolitaireTextView(game3);
      fail("Should throw an Illegal argument exception - 1");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }
    try {
      MarbleSolitaireView invalidView2 = new TriangleSolitaireTextView(null);
      fail("Should throw an Illegal argument exception - 2");
    } catch (IllegalArgumentException e) {
      //test should pass;
    }
  }

  //to test valid initializations of the second constructor/
  //it doesn't crash or throw an exception if acted upon.
  @Test
  public void testValidConstructor2() throws IOException {
    this.view7.renderBoard();
    assertEquals(this.answer1, this.stringBuild.toString());
    this.view10.renderBoard();
    assertEquals(this.answer1, this.stringBuild4.toString());
  }

  //to test invalid initializations of the second constructor.
  @Test
  public void testInvalidConstructor2() {
    try {
      new TriangleSolitaireTextView(new TriangleSolitaireModel(3,3,3),
              null);
      fail("Should throw exception");
    }
    catch (IllegalArgumentException e) {
      //
    }

    try {
      new TriangleSolitaireTextView(null,
              new StringBuilder());
      fail("Should throw exception");
    } catch (IllegalArgumentException e) {
      //
    }

    try {
      new TriangleSolitaireTextView(null,
              null);
      fail("Should throw exception");
    } catch (IllegalArgumentException e) {
      //
    }
  }

  //to test renderBoard
  @Test
  public void testRenderBoard() throws IOException {

    //Should be the same because method transmits the board to the appendable
    assertEquals(this.answer1, this.view7.toString());
    this.view7.renderBoard();
    assertEquals(this.answer1, this.stringBuild.toString());

    //Should be different because appendable already had something there
    assertEquals(this.answer1, this.view8.toString());
    this.view8.renderBoard();
    assertEquals(this.answer3, this.stringBuild2.toString());

    //Should be the same because method transmits the board to the appendable
    assertEquals(this.answer2, this.view9.toString());
    this.view9.renderBoard();
    assertEquals(this.answer2, this.stringBuild3.toString());

    try {
      failView1.renderBoard();
      fail("Should throw an IOException - 1");
    } catch (IOException e) {
      //should fail, do nothing
    }

    try {
      failView2.renderBoard();
      fail("Should throw an IOException - 2");
    } catch (IOException e) {
      //should fail, do nothing
    }

    try {
      failView3.renderBoard();
      fail("Should throw an IOException - 3");
    } catch (IOException e) {
      //should fail, do nothing
    }

    try {
      failView4.renderBoard();
      fail("Should throw an IOException - 4");
    } catch (IOException e) {
      //should fail, do nothing
    }

  }

  //to test renderMessage.
  @Test
  public void testRenderMessage() throws IOException {

    //Should start empty because appendable started empty.
    assertEquals("", this.stringBuild4.toString());
    this.view10.renderMessage("Hello");
    assertEquals("Hello", this.stringBuild4.toString());

    //Starts with something already there, so this is appended to it.
    assertEquals("Test: ", this.stringBuild5.toString());
    this.view11.renderMessage("Message");
    assertEquals("Test: Message", this.stringBuild5.toString());

    try {
      this.failView1.renderMessage("Oh no this will fail");
      fail("Should throw an IOException - 1");
    }
    catch (IOException e) {
      //should fail, do nothing
    }

    try {
      this.failView2.renderMessage("Hello");
      fail("Should throw an IOException - 2");
    }
    catch (IOException e) {
      //should fail, do nothing
    }

    try {
      this.failView1.renderMessage("");
      fail("Should throw an IOException - 3");
    }
    catch (IOException e) {
      //should fail, do nothing
    }

  }



}