package cs3500.marblesolitaire.view;


import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;


/**
 * To represent out view for a TriangleSolitaireModel.
 */
public class TriangleSolitaireTextView extends ATextView implements MarbleSolitaireView {

  /**
   * To construct a TriangleSolitaireTextView from the given Model game.
   * Auto sets the Appendable to be System.out.
   *
   * @param game given MarbleSolitaireModel object.
   * @throws IllegalArgumentException if given MarbleSolitaireModelState is null.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState game) throws IllegalArgumentException {
    super(game);
  }

  /**
   * To construct a TriangleSolitaireTextView with a given model game and Appendable object.
   * If any input is null, throws an exception.
   * @param game the given model game.
   * @param appendObject the given Appendable to be used for transmission
   * @throws IllegalArgumentException if any of the given parameters is null
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState game, Appendable appendObject)
          throws IllegalArgumentException {
    super(game,appendObject);
  }

  /**
   * Return a string that represents the current state of the board. The
   * string should have one line per row of the game board. Each slot on the
   * game board is a single character (O, _ or space for a marble, empty and
   * invalid position respectively). Slots in a row should be separated by a
   * space. Each row has no space before the first slot and after the last slot.
   * Row should not end with any trailing spaces.
   *
   * @return the game state as a string
   */
  @Override
  public String toString() {
    int widthHeight = this.game.getBoardSize();
    String result = "";
    for (int r = 0; r < widthHeight; r = r + 1) {
      int spaceAmount = widthHeight - 1 - (r - 0);

      for (int s = 0; s < spaceAmount; s = s + 1) {
        result = result + " ";
      }

      for (int c = 0; c < r + 1; c++) {

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
