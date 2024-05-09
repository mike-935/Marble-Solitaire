package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * To represent the view of our MarbleSolitaireModel.
 */
public class MarbleSolitaireTextView extends ATextView implements MarbleSolitaireView {

  /**
   * To construct a MarbleSolitaireView from the given Model game.
   * Auto sets the Appendable to be System.out.
   *
   * @param game given MarbleSolitaireModel object.
   * @throws IllegalArgumentException if given MarbleSolitaireModelState is null.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState game) throws IllegalArgumentException {
    super(game);
  }

  /**
   * To construct a MarbleSolitaireTextView with a given model game and Appendable object.
   * If any input is null, throws an exception.
   * @param game the given model game.
   * @param appendObject the given Appendable to be used for transmission
   * @throws IllegalArgumentException if any of the given parameters is null
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState game, Appendable appendObject)
          throws IllegalArgumentException {
    super(game,appendObject);
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
  @Override
  public String toString() {
    int widthHeight = this.game.getBoardSize();
    String result = "";
    for (int r = 0; r < widthHeight; r = r + 1) {

      for (int c = 0; c < widthHeight; c = c + 1) {

        //Comparative case is the kind of board slot of the slot being drawn.
        result = modifyResult(result, this.game.getSlotAt(r, c));

      }

      result = result.stripTrailing();
      if (r < widthHeight - 1) {
        result = result + "\n";
      }

    }
    return result;
  }

}

