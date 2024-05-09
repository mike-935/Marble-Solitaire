package cs3500.marblesolitaire.view;

import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * This is the abstract class that bridges the two current views we have.
 * Constructs a text view with the ability to render the board and messages.
 */
public abstract class ATextView {

  protected final MarbleSolitaireModelState game;
  protected Appendable appendObject;

  /**
   * To construct a ATextView from the given Model game.
   * Auto sets the Appendable to be System.out.
   *
   * @param game given MarbleSolitaireModel object.
   * @throws IllegalArgumentException if given MarbleSolitaireModelState is null.
   */
  public ATextView(MarbleSolitaireModelState game) throws IllegalArgumentException {
    if (game == null) {
      throw new IllegalArgumentException("given model is null");
    }
    this.game = game;
    this.appendObject = System.out;
  }

  /**
   * To construct a ATextView with a given model game and Appendable object.
   * If any input is null, throws an exception.
   * @param game the given model game.
   * @param appendObject the given Appendable to be used for transmission
   * @throws IllegalArgumentException if any of the given parameters is null
   */
  public ATextView(MarbleSolitaireModelState game, Appendable appendObject)
          throws IllegalArgumentException {
    if (game == null || appendObject == null) {
      throw new IllegalArgumentException("given null");
    }
    this.game = game;
    this.appendObject = appendObject;
  }

  /**
   * Return a string that represents the current state of the board. The
   * string should have one line per row of the game board. Each slot on the
   * game board is a single character (O, _ or space for a marble, empty and
   * invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   *
   * @return the game state as a string
   */
  public abstract String toString();

  /**
   * Render the board to the provided data destination.
   * The board should be rendered exactly in the format produced by the toString method above.
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  public void renderBoard() throws IOException {
    this.appendObject.append(this.toString());
  }

  /**
   * Render a specific message to the provided data destination.
   * Throw an exception if the transmission fails.
   * @param message the message to be transmitted
   * @throws IOException if transmission of the board to the provided data destination fails
   */
  public void renderMessage(String message) throws IOException {
    this.appendObject.append(message);
  }

  /**
   * This method takes in the result and will add to it,
   * What ever the given slot we are at requires. i.e if we are drawing a invalid slot it is " ",
   * Marble is "O " and empty is "_ "
   * @param result result is the board as a string so far.
   * @param slotAt this is what the slot is that we are currently attempting to draw, so it could be
   *               invalid, a marble, or an empty slot.
   * @return the result after we add the string correlated to the type of slot we are on.
   */
  protected static String modifyResult(String result, MarbleSolitaireModelState.SlotState slotAt) {
    switch (slotAt) {

      //Drawing an Invalid slot.
      case Invalid:
        result = result + "  ";
        break;

      //Drawing a Marble slot.
      case Marble:
        result = result + "O ";
        break;

      //Drawing an Empty slot.
      case Empty:
        result = result + "_ ";
        break;

      default:
        //should do nothing.
    }
    return result;
  }




}
