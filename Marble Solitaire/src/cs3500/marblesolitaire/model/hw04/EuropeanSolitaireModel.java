package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;

/**
 * To represent a European version/Model of the Solitaire Game.
 * This version's board is represented as an Octagon.
 */
public class EuropeanSolitaireModel extends AModel implements MarbleSolitaireModel {

  /**
   * This constructor takes in no inputs and automatically sets the game up with a sideLength of 3.
   * And the beginning empty space is set to 3,3.
   */
  public EuropeanSolitaireModel() {
    super(3, 3, 3);
  }

  /**
   * Constructor creates a game with a given side length and the empty space is at the center of it.
   * Correlated to the center in terms of sideLength.
   *
   * @param armThickness the given side length to create a board from.
   */
  public EuropeanSolitaireModel(int armThickness) {
    super(armThickness, (armThickness + 2 * (armThickness - 1) - 1) / 2,
            (armThickness + 2 * (armThickness - 1) - 1) / 2);
  }

  /**
   * To constructor a game with the side length being set to 3 automatically.
   * But the empty board slot is set to the given Row and Column.
   *
   * @param sRow given Row value of the intended empty space.
   * @param sCol given Column value of the intended empty space.
   */
  public EuropeanSolitaireModel(int sRow, int sCol) {
    super(3, sRow, sCol);
  }

  /**
   * To cosntruct a game based on the given Side length, row value, and column value.
   * Sets the side to the given and the empty space in the given slot.
   *
   * @param armThickness the given side length of the board to be set.
   * @param sRow         given Row value of the intended empty space.
   * @param sCol         given Column value of the intended empty space.
   */
  public EuropeanSolitaireModel(int armThickness, int sRow, int sCol) {
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
    int topOfBoard = this.armThickness - 1;
    int rightSide = this.armThickness + topOfBoard - 1;
    int doubleOfSideLength = this.armThickness + this.armThickness;
    boolean topValidity = (sRow < topOfBoard
            && ((sCol < topOfBoard && sCol < topOfBoard - Math.abs(sRow - 0))
            || sCol > rightSide && sCol > rightSide + Math.abs(sRow - 0)));
    boolean bottomValidity = ((sRow > doubleOfSideLength - 2
            && ((sCol < topOfBoard && sCol < Math.abs(sRow - rightSide))
            || sCol > rightSide && sCol > this.boardSize - 1 - Math.abs(sRow - rightSide))));

    return !(topValidity
            || bottomValidity
            || sRow > this.boardSize - 1 || sCol > this.boardSize - 1 || sRow < 0 || sCol < 0);
  }

}
