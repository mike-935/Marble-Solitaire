import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * To construct a test class for the MarbleSolitaireController implementations.
 */
public class MarbleSolitaireControllerImplTest {

  /**
   * To represent a mock model for a MarbleSolitaireModel.
   */
  class MockMarbleSolitaireModel implements MarbleSolitaireModel {

    /**
     * To represent the log of this class to check whats going through.
     */
    private StringBuilder log;

    /**
     * To construct a Mock model with a given log to be modified.
     * Log is modified by move.
     *
     * @param log given string builder to modify with inputs when called upon.
     */
    public MockMarbleSolitaireModel(StringBuilder log) {
      this.log = log;
    }


    /**
     * Move a single marble from a given position to another given position.
     * A move is valid only if the from and to positions are valid. Specific
     * implementations may place additional constraints on the validity of a move.
     *
     * @param fromRow the row number of the position to be moved from
     *                (starts at 0)
     * @param fromCol the column number of the position to be moved from
     *                (starts at 0)
     * @param toRow   the row number of the position to be moved to
     *                (starts at 0)
     * @param toCol   the column number of the position to be moved to
     *                (starts at 0)
     * @throws IllegalArgumentException if the move is not possible
     */
    @Override
    public void move(int fromRow, int fromCol, int toRow, int toCol)
            throws IllegalArgumentException {
      this.log.append("Inputs: " + " from: (" + fromRow + "," + fromCol + ") "
              + "To: (" + toRow + "," + toCol + ")");
    }

    /**
     * Determine and return if the game is over or not. A game is over if no
     * more moves can be made.
     *
     * @return true if the game is over, false otherwise
     */
    @Override
    public boolean isGameOver() {
      return false;
    }

    /**
     * Return the size of this board.
     * The size is roughly the longest dimension of a board.
     *
     * @return the size as an integer.
     */
    @Override
    public int getBoardSize() {
      return 0;
    }

    /**
     * Get the state of the slot at a given position on the board.
     *
     * @param row the row of the position sought, starting at 0.
     * @param col the column of the position sought, starting at 0.
     * @return the state of the slot at the given row and column.
     * @throws IllegalArgumentException if the row or the column are beyond
     *                                  the dimensions of the board.
     */
    @Override
    public SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
      this.log.append("Inputs: " + "(" + row + "," + col + ")");
      return null;
    }

    /**
     * Return the number of marbles currently on the board.
     * Which correlates to the score of the game.
     *
     * @return the number of marbles currently on the board.
     */
    @Override
    public int getScore() {
      return 0;
    }
  }

  /**
   * To construct a mock view of a MarbleSolitaireTextView.
   */
  public class MockMarbleSolitaireTextView implements MarbleSolitaireView {

    private StringBuilder log;

    /**
     * To construct a Mock view with a given log to modify.
     * Log is modified by render message.
     *
     * @param log log to be modified by render message to see inputs.
     */
    public MockMarbleSolitaireTextView(StringBuilder log) {
      this.log = log;
    }

    /**
     * Render the board to the provided data destination.
     * The board should be rendered exactly in the format produced by the toString method above.
     *
     * @throws IOException if transmission of the board to the provided data destination fails
     */
    @Override
    public void renderBoard() throws IOException {
      //Not needed right now.
    }

    /**
     * Render a specific message to the provided data destination.
     * Throw an exception if the transmission fails.
     *
     * @param message the message to be transmitted
     * @throws IOException if transmission of the board to the provided data destination fails
     */
    @Override
    public void renderMessage(String message) throws IOException {
      this.log.append("Input: " + message);
    }

  }

  private MarbleSolitaireController controller1;
  private MarbleSolitaireController controller2;
  private MarbleSolitaireController controller4;
  private MarbleSolitaireController controller5;
  private MarbleSolitaireController controller7;
  private MarbleSolitaireController controller8;
  private MarbleSolitaireController controller9;
  private MarbleSolitaireController controller10;
  private MarbleSolitaireController controller11;

  private MarbleSolitaireController controller12;
  private MarbleSolitaireController controller13;
  private MarbleSolitaireController controller14;
  private MarbleSolitaireController controller15;
  private MarbleSolitaireController controller16;
  private MarbleSolitaireController controller17;
  private MarbleSolitaireController controller18;
  private MarbleSolitaireController controller19;
  private MarbleSolitaireController controller20;
  private MarbleSolitaireController controller21;
  private MarbleSolitaireController controller22;
  private MarbleSolitaireController controller23;
  private MarbleSolitaireController controller24;
  private MarbleSolitaireController controller25;
  private MarbleSolitaireController controller26;
  private MarbleSolitaireController controller27;
  private MarbleSolitaireController controller28;
  private MarbleSolitaireController controller29;
  private MarbleSolitaireController controller30;
  private String answer1;
  private String answer4;
  private String answer5;
  private String answer6;
  private String answer7;
  private String answer8;
  private String answer10;
  private StringBuilder stringBuilder1;
  private StringBuilder stringBuilder4;
  private StringBuilder stringBuilder5;
  private StringBuilder stringBuilder7;
  private StringBuilder stringBuilder8;
  private StringBuilder stringBuilder9;
  private StringBuilder stringBuilder10;
  private StringBuilder stringBuilder17;
  private StringBuilder stringBuilder18;
  private StringBuilder stringBuilder20;
  private StringBuilder stringBuilder21;
  private StringBuilder stringBuilder22;
  private StringBuilder stringBuilder23;
  private StringBuilder stringBuilder24;
  private StringBuilder stringBuilder25;
  private StringBuilder stringBuilder26;
  private StringBuilder stringBuilder27;
  private StringBuilder stringBuilder28;
  private StringBuilder log1;
  private StringBuilder log2;
  private StringBuilder log3;
  private StringBuilder log4;
  private StringBuilder log5;
  //to run before every test and initialize this data.

  @Before
  public void setup() {
    Readable rd1 = new StringReader("6 4 4 4 q");
    this.stringBuilder1 = new StringBuilder();
    EnglishSolitaireModel game1 = new EnglishSolitaireModel();
    MarbleSolitaireView view1 = new MarbleSolitaireTextView(game1, this.stringBuilder1);
    this.controller1 = new MarbleSolitaireControllerImpl(game1, view1, rd1);

    Readable rd2 = new StringReader("2 4 4 4 q");
    StringBuilder stringBuilder2 = new StringBuilder();
    EnglishSolitaireModel game2 = new EnglishSolitaireModel(3);
    MarbleSolitaireView view2 = new MarbleSolitaireTextView(game2, stringBuilder2);
    this.controller2 = new MarbleSolitaireControllerImpl(game2, view2, rd2);

    Readable rd3 = new StringReader("4 2 4 4 q");
    StringBuilder stringBuilder3 = new StringBuilder();
    EnglishSolitaireModel game3 = new EnglishSolitaireModel(3, 3);
    MarbleSolitaireView view3 = new MarbleSolitaireTextView(game3, stringBuilder3);
    MarbleSolitaireController controller3 = new MarbleSolitaireControllerImpl(game3, view3, rd3);

    Readable rd4 = new StringReader("4 6 4 4 4 3 4 5 q");
    this.stringBuilder4 = new StringBuilder();
    EnglishSolitaireModel game4 = new EnglishSolitaireModel(3, 3, 3);
    MarbleSolitaireView view4 = new MarbleSolitaireTextView(game4, this.stringBuilder4);
    this.controller4 = new MarbleSolitaireControllerImpl(game4, view4, rd4);

    Readable rd5 = new StringReader("q");
    this.stringBuilder5 = new StringBuilder();
    EnglishSolitaireModel game5 = new EnglishSolitaireModel();
    MarbleSolitaireView view5 = new MarbleSolitaireTextView(game5, this.stringBuilder5);
    this.controller5 = new MarbleSolitaireControllerImpl(game5, view5, rd5);

    Readable rd6 = new StringReader("Q");
    StringBuilder stringBuilder6 = new StringBuilder();
    EnglishSolitaireModel game6 = new EnglishSolitaireModel();
    MarbleSolitaireView view6 = new MarbleSolitaireTextView(game6, stringBuilder6);
    MarbleSolitaireController controller6 = new MarbleSolitaireControllerImpl(game6, view6, rd6);

    Readable rd7 =
            new StringReader("4 2 4 4 6 3 4 3 5 1 5 3 5 4 5 2 5 6 5 4 7 5 5 5 4 5 6 5 7 3 "
                    + "7 5 7 5 5 5 3 3 5 3 1 3 3 3 2 5 4 5 4 5 6 5 6 5 6 3 6 3 4 3 4 3 2 3 3 1 5 1 "
                    + "5 1 5 3 "
                    + "5 3 5 5 3 7 3 5 3 4 3 6 5 7 3 7 3 7 3 5 1 5 1 3 1 3 3 3 3 2 3 "
                    + "4 3 4 3 6 3 6 5 6 5 6 "
                    + "5 4 5 4 3 4 2 4 4 4 Q");
    this.stringBuilder7 = new StringBuilder();
    EnglishSolitaireModel game7 = new EnglishSolitaireModel();
    MarbleSolitaireView view7 = new MarbleSolitaireTextView(game7, this.stringBuilder7);
    this.controller7 = new MarbleSolitaireControllerImpl(game7, view7, rd7);

    Readable rd8 = new StringReader(" 4 4 5 5 q");
    this.stringBuilder8 = new StringBuilder();
    EnglishSolitaireModel game8 = new EnglishSolitaireModel();
    MarbleSolitaireView view8 = new MarbleSolitaireTextView(game8, this.stringBuilder8);
    this.controller8 = new MarbleSolitaireControllerImpl(game8, view8, rd8);

    Readable rd9 = new StringReader("5 5 q");
    this.stringBuilder9 = new StringBuilder();
    EnglishSolitaireModel game9 = new EnglishSolitaireModel();
    MarbleSolitaireView view9 = new MarbleSolitaireTextView(game9, this.stringBuilder9);
    this.controller9 = new MarbleSolitaireControllerImpl(game9, view9, rd9);

    Readable rd10 = new StringReader("4 2 4 -1 4 q");
    this.stringBuilder10 = new StringBuilder();
    EnglishSolitaireModel game10 = new EnglishSolitaireModel();
    MarbleSolitaireView view10 = new MarbleSolitaireTextView(game10, this.stringBuilder10);
    this.controller10 = new MarbleSolitaireControllerImpl(game10, view10, rd10);

    Readable rd11 =
            new StringReader("4 2 4 4 6 3 4 3 5 1 5 3 5 4 5 2 5 6 5 4 7 5 5 5 4 5 6 5 7 3 "
                    + "7 5 7 5 5 5 3 3 5 3 1 3 3 3 2 5 4 5 4 5 6 5 6 5 6 3 6 3 4 3 4 3 2 "
                    + "3 3 1 5 1 5 1 5 3 " + "5 3 5 5 3 7 3 5 3 4 3 6 5 7 3 7 3 7 3 5 1 5 1 3 "
                    + "1 3 3 3 3 2 3 4 3 4 3 6 3 6 5 6 5 6 " + "5 4 5 4 3 4 2 4 4 4 Q");
    MyAppendObject failAppend1 = new MyAppendObject();
    EnglishSolitaireModel game11 = new EnglishSolitaireModel();
    MarbleSolitaireView view11 = new MarbleSolitaireTextView(game11, failAppend1);
    this.controller11 = new MarbleSolitaireControllerImpl(game11, view11, rd11);

    Readable rd12 = new StringReader(" 6 6 3 3 Q");
    MyAppendObject failAppend2 = new MyAppendObject();
    EnglishSolitaireModel game12 = new EnglishSolitaireModel();
    MarbleSolitaireView view12 = new MarbleSolitaireTextView(game12, failAppend2);
    this.controller12 = new MarbleSolitaireControllerImpl(game12, view12, rd12);

    Readable rd13 = new StringReader("q");
    MyAppendObject failAppend3 = new MyAppendObject();
    EnglishSolitaireModel game13 = new EnglishSolitaireModel();
    MarbleSolitaireView view13 = new MarbleSolitaireTextView(game13, failAppend3);
    this.controller13 = new MarbleSolitaireControllerImpl(game13, view13, rd13);

    Readable rd14 = new StringReader("");
    MyAppendObject failAppend4 = new MyAppendObject();
    EnglishSolitaireModel game14 = new EnglishSolitaireModel();
    MarbleSolitaireView view14 = new MarbleSolitaireTextView(game14, failAppend4);
    this.controller14 = new MarbleSolitaireControllerImpl(game14, view14, rd14);

    Readable rd15 = new StringReader("6 4 4 4 q");
    StringBuilder stringBuilder15 = new StringBuilder();
    this.log1 = new StringBuilder();
    MockMarbleSolitaireModel game15 = new MockMarbleSolitaireModel(this.log1);
    MarbleSolitaireView view15 = new MarbleSolitaireTextView(game15, stringBuilder15);
    this.controller15 = new MarbleSolitaireControllerImpl(game15, view15, rd15);

    Readable rd16 = new StringReader("6 6 4 4 q");
    StringBuilder stringBuilder16 = new StringBuilder();
    this.log2 = new StringBuilder();
    MockMarbleSolitaireModel game16 = new MockMarbleSolitaireModel(this.log2);
    MarbleSolitaireView view16 = new MarbleSolitaireTextView(game16, stringBuilder16);
    this.controller16 = new MarbleSolitaireControllerImpl(game16, view16, rd16);

    Readable rd17 =
            new StringReader("4 2 4 4 6 3 4 3 5 1 5 3 5 4 5 2 5 6 5 4 7 5 5 5 4 5 6 5 7 3 " +
                    "7 5 7 5 5 5 3 3 5 3 1 3 3 3 2 5 4 5 4 5 6 5 6 5 6 3 6 3 4 3 4 3 2 3 3 1 " +
                    "5 1 5 1 5 3 " + "5 3 5 5 3 7 3 5 3 4 3 6 5 7 3 7 3 7 3 5 1 5 1 3 1 3 3 3 3 " +
                    "2 3 4 3 4 3 6 3 6 5 6 5 6 " + "5 4 5 4 3 4 2 4 4 4 Q");
    this.log3 = new StringBuilder();
    EnglishSolitaireModel game17 = new EnglishSolitaireModel();
    MockMarbleSolitaireTextView view17 = new MockMarbleSolitaireTextView(this.log3);
    this.controller17 = new MarbleSolitaireControllerImpl(game17, view17, rd17);

    Readable rd18 = new StringReader(" 6 6 4 4 Q");
    this.log4 = new StringBuilder();
    EnglishSolitaireModel game18 = new EnglishSolitaireModel();
    MockMarbleSolitaireTextView view18 = new MockMarbleSolitaireTextView(this.log4);
    this.controller18 = new MarbleSolitaireControllerImpl(game18, view18, rd18);

    Readable rd19 = new StringReader(" Q");
    this.log5 = new StringBuilder();
    EnglishSolitaireModel game19 = new EnglishSolitaireModel();
    MockMarbleSolitaireTextView view19 = new MockMarbleSolitaireTextView(this.log5);
    this.controller19 = new MarbleSolitaireControllerImpl(game19, view19, rd19);

    Readable rd20 = new StringReader("1 q");
    this.stringBuilder20 = new StringBuilder();
    EnglishSolitaireModel game20 = new EnglishSolitaireModel();
    MarbleSolitaireView view20 = new MarbleSolitaireTextView(game20, this.stringBuilder20);
    this.controller20 = new MarbleSolitaireControllerImpl(game20, view20, rd20);

    Readable rd21 = new StringReader("1 1 1 q");
    this.stringBuilder21 = new StringBuilder();
    EnglishSolitaireModel game21 = new EnglishSolitaireModel();
    MarbleSolitaireView view21 = new MarbleSolitaireTextView(game21, this.stringBuilder21);
    this.controller21 = new MarbleSolitaireControllerImpl(game21, view21, rd21);

    Readable rd22 = new StringReader("q 1 1 1");
    this.stringBuilder22 = new StringBuilder();
    EnglishSolitaireModel game22 = new EnglishSolitaireModel();
    MarbleSolitaireView view22 = new MarbleSolitaireTextView(game22, this.stringBuilder22);
    this.controller22 = new MarbleSolitaireControllerImpl(game22, view22, rd22);

    Readable rd23 = new StringReader("3 1 1 1 q");
    this.stringBuilder23 = new StringBuilder();
    MarbleSolitaireModel game23 = new TriangleSolitaireModel();
    MarbleSolitaireView view23 = new TriangleSolitaireTextView(game23, this.stringBuilder23);
    this.controller23 = new MarbleSolitaireControllerImpl(game23, view23, rd23);

    Readable rd24 = new StringReader("6 4 4 4 q");
    this.stringBuilder24 = new StringBuilder();
    MarbleSolitaireModel game24 = new EuropeanSolitaireModel(3);
    MarbleSolitaireView view24 = new MarbleSolitaireTextView(game24, this.stringBuilder24);
    this.controller24 = new MarbleSolitaireControllerImpl(game24, view24, rd24);

    Readable rd25 = new StringReader("q");
    this.stringBuilder25 = new StringBuilder();
    MarbleSolitaireModel game25 = new TriangleSolitaireModel(3);
    MarbleSolitaireView view25 = new TriangleSolitaireTextView(game25, this.stringBuilder25);
    this.controller25 = new MarbleSolitaireControllerImpl(game25, view25, rd25);

    Readable rd26 = new StringReader("q");
    this.stringBuilder26 = new StringBuilder();
    MarbleSolitaireModel game26 = new EuropeanSolitaireModel(3, 3, 3);
    MarbleSolitaireView view26 = new MarbleSolitaireTextView(game26, this.stringBuilder26);
    this.controller26 = new MarbleSolitaireControllerImpl(game26, view26, rd26);

    Readable rd27 = new StringReader("2 2 2 2 q");
    this.stringBuilder27 = new StringBuilder();
    MarbleSolitaireModel game27 = new TriangleSolitaireModel(3);
    MarbleSolitaireView view27 = new TriangleSolitaireTextView(game27, this.stringBuilder27);
    this.controller27 = new MarbleSolitaireControllerImpl(game27, view27, rd27);

    Readable rd28 = new StringReader("2 2 2 2 q");
    this.stringBuilder28 = new StringBuilder();
    MarbleSolitaireModel game28 = new EuropeanSolitaireModel(3, 3, 3);
    MarbleSolitaireView view28 = new MarbleSolitaireTextView(game28, this.stringBuilder28);
    this.controller28 = new MarbleSolitaireControllerImpl(game28, view28, rd28);

    Readable rd29 = new StringReader("2 2 2 2 q");
    MyAppendObject failAppend5 = new MyAppendObject();
    MarbleSolitaireModel game29 = new TriangleSolitaireModel(3);
    MarbleSolitaireView view29 = new TriangleSolitaireTextView(game29, failAppend5);
    this.controller29 = new MarbleSolitaireControllerImpl(game29, view29, rd29);

    Readable rd30 = new StringReader("2 2 2 2 q");
    MyAppendObject failAppend6 = new MyAppendObject();
    MarbleSolitaireModel game30 = new EuropeanSolitaireModel(3, 3, 3);
    MarbleSolitaireView view30 = new MarbleSolitaireTextView(game30, failAppend6);
    this.controller30 = new MarbleSolitaireControllerImpl(game30, view30, rd30);

    this.answer1 = "    O O O"
            + "\n" + "    O O O" + "\n" + "O O O O O O O" + "\n" + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n" + "    O O O" + "\n" + "    O O O" + "\n" + "Score: 32" + "\n"
            + "Game quit!" + "\n" + "State of game when quit:" + "\n" + "    O O O" + "\n"
            + "    O O O" + "\n" + "O O O O O O O" + "\n" + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n" + "    O O O" + "\n" + "    O O O" + "\n" + "Score: 32" + "\n";

    String answer2 = "    O O O" + "\n" + "    O O O" + "\n" + "O O O O O O O" + "\n"
            + "O _ _ O O O O" + "\n" + "O O O O O O O" + "\n" + "    O O O"
            + "\n" + "    O O O";

    String answer3 = "Game quit!" + "\n" + "State of game when quit:" + "\n" + "    O O O"
            + "\n" + "    O O O" + "\n" + "O O O O O O O" + "\n" + "O O O O O O O"
            + "\n" + "O O O _ O O O" + "\n" + "    O _ O" + "\n" + "    O O O" + "\n" + "Score: 31";

    this.answer4 = "    O O O"
            + "\n" + "    O O O" + "\n" + "O O O O O O O" + "\n" + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n" + "    O O O" + "\n" + "    O O O" + "\n" + "Score: 32" + "\n"
            + "    O O O" + "\n" + "    O O O" + "\n" + "O O O O O O O" + "\n" + "O O O O _ _ O"
            + "\n" + "O O O O O O O" + "\n" + "    O O O" + "\n" + "    O O O" + "\n" + "Score: 31"
            + "\n" + "    O O O" + "\n" + "    O O O" + "\n" + "O O O O O O O" + "\n"
            + "O O _ _ O _ O" + "\n" + "O O O O O O O" + "\n" + "    O O O" + "\n"
            + "    O O O" + "\n" + "Score: 30" + "\n" + "Game quit!" + "\n"
            + "State of game when quit:" + "\n" + "    O O O" + "\n" + "    O O O" + "\n"
            + "O O O O O O O" + "\n" + "O O _ _ O _ O" + "\n" + "O O O O O O O" + "\n"
            + "    O O O" + "\n" + "    O O O" + "\n" + "Score: 30" + "\n";

    this.answer5 = "    O O O" + "\n" + "    O O O" + "\n" + "O O O O O O O"
            + "\n" + "O O O _ O O O" + "\n" + "O O O O O O O" + "\n" + "    O O O"
            + "\n" + "    O O O" + "\n" + "Score: 32" + "\n" + "    O O O"
            + "\n" + "    O O O" + "\n" + "O O O O O O O" + "\n" + "O O O O O O O"
            + "\n" + "O O O _ O O O" + "\n" + "    O _ O" + "\n" + "    O O O" + "\n" + "Score: 31"
            + "\n" + "Game quit!" + "\n" + "State of game when quit:" + "\n" + "    O O O"
            + "\n" + "    O O O" + "\n" + "O O O O O O O" + "\n" + "O O O O O O O"
            + "\n" + "O O O _ O O O" + "\n" + "    O _ O" + "\n" + "    O O O"
            + "\n" + "Score: 31" + "\n";

    this.answer6 = "Game over!" + "\n" + "    _ _ _"
            + "\n" + "    _ _ _" + "\n" + "_ _ _ _ _ _ _" + "\n" + "_ _ _ O _ _ _"
            + "\n" + "_ _ _ _ _ _ _" + "\n" + "    _ _ _" + "\n" + "    _ _ _" + "\n" + "Score: 1"
            + "\n";

    this.answer8 = "    O O O"
            + "\n" + "    O O O" + "\n" + "O O O O O O O" + "\n" + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n" + "    O O O" + "\n" + "    O O O" + "\n" + "Score: 32" + "\n"
            + "Invalid move. Play again." + "\n" + "Game quit!" + "\n" + "State of game when quit:"
            + "\n" + "    O O O" + "\n" + "    O O O" + "\n" + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n" + "    O O O" + "\n" + "    O O O" + "\n" + "Score: 32" + "\n";

    String answer9 = "    O O O"
            + "\n" + "    O O O" + "\n" + "O O O O O O O" + "\n" + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n" + "    O O O" + "\n" + "    O O O" + "\n" + "Score: 32" + "\n"
            + "Invalid move. Play again." + "\n" + "Game quit!" + "\n" + "State of game when quit:"
            + "\n" + "    O O O" + "\n" + "    O O O" + "\n" + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n"
            + "O O O O O O O" + "\n" + "    O O O" + "\n" + "    O O O" + "\n" + "Score: 32" + "\n";

    this.answer10 = "    O O O" + "\n" + "    O O O" + "\n" + "O O O O O O O"
            + "\n" + "O O O _ O O O" + "\n" + "O O O O O O O" + "\n" + "    O O O"
            + "\n" + "    O O O" + "\n" + "Score: 32" + "\n" + "    O O O"
            + "\n" + "    O O O" + "\n" + "O O O O O O O" + "\n" + "O _ _ O O O O"
            + "\n" + "O O O O O O O" + "\n" + "    O O O" + "\n" + "    O O O" + "\n" + "Score: 31"
            + "\n" + "Game quit!" + "\n" + "State of game when quit:" + "\n" + "    O O O"
            + "\n" + "    O O O" + "\n" + "O O O O O O O" + "\n" + "O _ _ O O O O"
            + "\n" + "O O O O O O O" + "\n" + "    O O O" + "\n" + "    O O O"
            + "\n" + "Score: 31" + "\n";


  }

  //Quick test to confirm that this controller works for both the Euro and Trig Models
  @Test
  public void testWithEuroTrig() {
    String trig3Move = "    _" + "\n" + "   O O" + "\n" + "  O O O" + "\n" + " O O O O" + "\n"
            + "O O O O O" + "\n" + "Score: 14" + "\n" + "    O" + "\n" + "   _ O" + "\n"
            + "  _ O O" + "\n" + " O O O O" + "\n" + "O O O O O" + "\n" + "Score: 13" + "\n"
            + "Game quit!" + "\n" + "State of game when quit:" + "\n" + "    O" + "\n"
            + "   _ O" + "\n" + "  _ O O" + "\n" + " O O O O" + "\n" + "O O O O O"
            + "\n" + "Score: 13" + "\n";

    String trig3Invalid = "  _" + "\n" + " O O" + "\n" + "O O O" + "\n"
            + "Score: 5" + "\n" + "Invalid move. Play again."
            + "\n" + "Game quit!" + "\n" + "State of game when quit:" + "\n" + "  _"
            + "\n" + " O O" + "\n" + "O O O" + "\n" + "Score: 5" + "\n";

    String trig3 = "  _" + "\n" + " O O" + "\n" + "O O O" + "\n"
            + "Score: 5" + "\n" + "Game quit!" + "\n"
            + "State of game when quit:" + "\n"
            + "  _" + "\n" + " O O" + "\n" + "O O O" + "\n" + "Score: 5" + "\n";

    String euro3Move = "    O O O" + "\n" + "  O O O O O" + "\n" + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n" + "O O O O O O O" + "\n" + "  O O O O O" + "\n"
            + "    O O O" + "\n" + "Score: 36" + "\n"
            + "    O O O" + "\n" + "  O O O O O" + "\n" + "O O O O O O O" + "\n" + "O O O O O O O"
            + "\n" + "O O O _ O O O" + "\n" + "  O O _ O O" + "\n" + "    O O O"
            + "\n" + "Score: 35" + "\n" + "Game quit!" + "\n"
            + "State of game when quit:" + "\n" + "    O O O" + "\n" + "  O O O O O"
            + "\n" + "O O O O O O O" + "\n" + "O O O O O O O" + "\n" + "O O O _ O O O"
            + "\n" + "  O O _ O O" + "\n" + "    O O O" + "\n" + "Score: 35" + "\n";

    String euro3 = "    O O O" + "\n" + "  O O O O O" + "\n" + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n" + "O O O O O O O" + "\n" + "  O O O O O" + "\n"
            + "    O O O" + "\n" + "Score: 36" + "\n" + "Game quit!" + "\n"
            + "State of game when quit:" + "\n" + "    O O O" + "\n" + "  O O O O O"
            + "\n" + "O O O O O O O" + "\n" + "O O O _ O O O" + "\n" + "O O O O O O O"
            + "\n" + "  O O O O O" + "\n" + "    O O O" + "\n" + "Score: 36" + "\n";
    String euro3Invalid = "    O O O" + "\n" + "  O O O O O" + "\n" + "O O O O O O O" + "\n"
            + "O O O _ O O O" + "\n" + "O O O O O O O" + "\n" + "  O O O O O" + "\n"
            + "    O O O" + "\n" + "Score: 36" + "\n" + "Invalid move. Play again." + "\n"
            + "Game quit!" + "\n" + "State of game when quit:" + "\n" + "    O O O"
            + "\n" + "  O O O O O" + "\n" + "O O O O O O O" + "\n" + "O O O _ O O O"
            + "\n" + "O O O O O O O" + "\n" + "  O O O O O" + "\n"
            + "    O O O" + "\n" + "Score: 36" + "\n";


    this.controller23.playGame();
    assertEquals(trig3Move, this.stringBuilder23.toString());

    this.controller25.playGame();
    assertEquals(trig3, this.stringBuilder25.toString());

    this.controller24.playGame();
    assertEquals(euro3Move, this.stringBuilder24.toString());

    this.controller26.playGame();
    assertEquals(euro3, this.stringBuilder26.toString());

    this.controller27.playGame();
    assertEquals(trig3Invalid, this.stringBuilder27.toString());

    this.controller28.playGame();
    assertEquals(euro3Invalid, this.stringBuilder28.toString());

    try {
      this.controller29.playGame();
      fail("Should fail");
    } catch (IllegalStateException e) {
      //
    }

    try {
      this.controller30.playGame();
      fail("Should fail");
    } catch (IllegalStateException e) {
      //
    }

  }

  //to test that play game works
  @Test
  public void playGame() {

    this.controller1.playGame();
    assertEquals(this.answer5, this.stringBuilder1.toString());

    this.controller5.playGame();
    assertEquals(this.answer1, this.stringBuilder5.toString());

    this.controller4.playGame();
    assertEquals(this.answer4, this.stringBuilder4.toString());

    //Test here to test what happens when the game is over
    //Shortens the output to the last part which is the game over part for convenience
    //This plays through the whole game, so it's a large string.
    this.controller7.playGame();

    assertEquals(this.answer6, this.stringBuilder7.toString().substring(2935));

    //to test a game with an invalid input and then a quit.
    this.controller8.playGame();
    assertEquals(this.answer8, this.stringBuilder8.toString());

    //to test a game with insufficient inputs, then a quit.
    this.controller9.playGame();
    assertEquals(this.answer1, this.stringBuilder9.toString());

    //to test a game with insufficient inputs, then a quit, 1 q
    this.controller20.playGame();
    assertEquals(this.answer1, this.stringBuilder20.toString());

    //to test a game with insufficient inputs, then a quit, 1 1 1 q
    this.controller21.playGame();
    assertEquals(this.answer1, this.stringBuilder21.toString());

    //to test a game with insufficient inputs, then a quit, q 1 1 1
    this.controller22.playGame();
    assertEquals(this.answer1, this.stringBuilder22.toString());


    //
    this.controller10.playGame();
    assertEquals(this.answer10, this.stringBuilder10.toString());

    try {
      this.controller11.playGame();
      fail("Should fail");
    } catch (IllegalStateException e) {
      //
    }

    try {
      this.controller12.playGame();
      fail("Should fail");
    } catch (IllegalStateException e) {
      //
    }

    try {
      this.controller13.playGame();
      fail("Should fail");
    } catch (IllegalStateException e) {
      //
    }

    try {
      this.controller14.playGame();
      fail("Should fail");
    } catch (IllegalStateException e) {
      //
    }

  }

  //to test with the mock that the move is getting the right inputs.
  @Test
  public void testPlayGameInputs() {
    String gameOver = "Input: " + "Game over!" + "\n" + "Input: " + "\n" + "Input: Score: 1" + "\n";
    String invalidMove = "Input: " + "Invalid move. Play again." + "\n";
    String gameQuit = "Input: " + "Game quit!" + "\n" + "Input: " + "State of game when quit:"
            + "\n" + "Input: " + "\n" + "Input: Score: 32" + "\n";
    this.controller15.playGame();
    assertEquals("Inputs: " + " from: (" + 5 + "," + 3 + ") "
            + "To: (" + 3 + "," + 3 + ")", this.log1.toString());
    this.controller16.playGame();
    assertEquals("Inputs: " + " from: (" + 5 + "," + 5 + ") "
            + "To: (" + 3 + "," + 3 + ")", this.log2.toString());

    //Should have all the inputs from render message but this tests render message from
    //inside the game over part, so It's shortened to just show that.
    // (Second inputs is empty because it doesn't get a board to render).
    this.controller17.playGame();
    assertEquals(gameOver, this.log3.toString().substring(791));

    //Tests when the method tries to transmit an invalid move statement.
    //Shortened to only show important part that shows it gets this input of that message.
    this.controller18.playGame();
    assertEquals(invalidMove, this.log4.toString().substring(25, 58));

    //Tests when there is a transmission for the game being quit.
    //Shortened to only include this part
    this.controller19.playGame();
    assertEquals(gameQuit, this.log5.toString().substring(25));

  }

  //to test that a valid constructor works and doesn't crash if initialized and called upon.
  //First test is because java style.
  @Test
  public void testValidConstructor() {
    assertEquals(this.controller1, this.controller1);
    this.controller2.playGame();
    this.controller4.playGame();
  }

  //test with corrupt appendable class as part of view and corrupt readable class passed into model?
  @Test
  public void testInvalidConstructor() {

    try {
      Readable failStringReader1 = new StringReader("q");
      EnglishSolitaireModel failGame1 = null;
      MarbleSolitaireView failView1 = new MarbleSolitaireTextView(failGame1, new StringBuilder());
      MarbleSolitaireController failController1 =
              new MarbleSolitaireControllerImpl(failGame1, failView1, failStringReader1);
      failController1.playGame();
      fail("Should fail");
    } catch (IllegalArgumentException e) {
      //do nothing should fail
    }

    try {
      Readable failStringReader2 = new StringReader("q");
      EnglishSolitaireModel failGame2 = new EnglishSolitaireModel();
      MarbleSolitaireView failView2 = null;
      MarbleSolitaireController failController2 =
              new MarbleSolitaireControllerImpl(failGame2, failView2, failStringReader2);
      failController2.playGame();
      fail("Should fail");
    } catch (IllegalArgumentException e) {
      //do nothing should fail
    }

    try {
      Readable failStringReader3 = null;
      EnglishSolitaireModel failGame3 = new EnglishSolitaireModel();
      MarbleSolitaireView failView3 = new MarbleSolitaireTextView(failGame3, new StringBuilder());
      MarbleSolitaireController failController3 =
              new MarbleSolitaireControllerImpl(failGame3, failView3, failStringReader3);
      failController3.playGame();
      fail("Should fail");
    } catch (IllegalArgumentException e) {
      //do nothing should fail
    }

    try {
      Readable failStringReader4 = null;
      EnglishSolitaireModel failGame4 = null;
      MarbleSolitaireView failView4 = null;
      MarbleSolitaireController failController4 =
              new MarbleSolitaireControllerImpl(failGame4, failView4, failStringReader4);
      failController4.playGame();
      fail("Should fail");
    } catch (IllegalArgumentException e) {
      //do nothing should fail
    }

  }
}