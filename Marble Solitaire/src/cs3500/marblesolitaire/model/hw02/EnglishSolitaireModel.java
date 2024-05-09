package cs3500.marblesolitaire.model.hw02;


import cs3500.marblesolitaire.model.hw04.AModel;

/**
 * To represent a Model view of an EnglishSolitaireGame.
 */
public class EnglishSolitaireModel extends AModel implements MarbleSolitaireModel {

  /**
   * First constructor that takes no parameters and initializes the board.
   * Sets arm thickness to 3, and center empty is at (Row 3, Column 3).
   */
  public EnglishSolitaireModel() {
    super(3, 3, 3);
  }

  /**
   * To construct an EnglishSolitaireModel with a given armThickness (a).
   * Sets armThickness (a) to given and the center empty to (a + 1 * (a-1) - 1) / 2
   *
   * @param armThickness (a) represents the armThickness of the game.
   *                     also known as the number of marbles in the top,bottom rows.
   *                     and left,right columns.
   * @throws IllegalArgumentException if the given position is invalid.
   */
  public EnglishSolitaireModel(int armThickness) throws IllegalArgumentException {
    super(armThickness, (armThickness + 2 * (armThickness - 1) - 1) / 2,
            (armThickness + 2 * (armThickness - 1) - 1) / 2);
  }

  /**
   * To construct an EnglishSolitaireModel with the center empty slot being given as sRow and sCol.
   * Sets empty center to (sRow, sCol) and the armThickness to 3.
   *
   * @param sRow Row/y value of the center empty slot.
   * @param sCol Column/x value of the center empty slot.
   * @throws IllegalArgumentException if given armThickness is not a positive odd number.
   */
  public EnglishSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    super(3, sRow, sCol);
  }

  /**
   * To construct an EnglishSolitaireModel with a given armThickness, Row, and Column.
   * Sets the armThickness to given, and the empty center to (sRow, sCol).
   *
   * @param armThickness given armThickness to represent the number of marbles.
   *                     in the top, bottom rows and left, right columns.
   * @param sRow         Row/y value of the center empty slot.
   * @param sCol         Column/x value of the center empty slot.
   * @throws IllegalArgumentException if armThickness is not an odd, positive number.
   *                                  Or if the given position is invalid.
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    super(armThickness, sRow, sCol);
  }

  /**
   * To check if the given row and column is a valid Slot in this game.
   * Checks if the given position is not in one of the unplayable corners.
   * Or if the given positions exceed the board slots
   * (I.e. its given a row and column that is bigger than the actual width/height of the board.
   * Or its given a negative position that doesn't exist on the board).
   *
   * @param sRow the row y value of the given position.
   * @param sCol the column x value of the given position.
   * @return a boolean that returns true if it is a valid slot, false if not.
   */
  protected boolean boardSlotValidity(int sRow, int sCol) {
    return !(((sRow < this.armThickness - 1 || sRow > this.armThickness + this.armThickness - 2)
            && (sCol < this.armThickness - 1 || sCol > this.armThickness + this.armThickness - 2))
            || sRow > this.boardSize - 1 || sCol > this.boardSize - 1 || sRow < 0 || sCol < 0);
  }

}

