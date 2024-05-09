package cs3500.marblesolitaire.model.hw04;

import java.awt.Point;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * To construct a TriangleSolitaireModel.
 * Board shape when being played will be viewed as a triangle board.
 */
public class TriangleSolitaireModel extends AModel implements MarbleSolitaireModel {

  /**
   * To construct a TriangleSolitaireModel with a side base length automatically being 5.
   * And the center empty is set to 0,0.
   */
  public TriangleSolitaireModel() {
    this(5,0,0);
  }

  /**
   * To construct a TriangleSolitaireModel-model with the side length being the given
   * and the center slot being set to 0,0 automatically.
   *
   * @param armThickness given value to set our bottom row length / side length to
   * @throws IllegalArgumentException if the given value is not positive
   */
  public TriangleSolitaireModel(int armThickness) throws IllegalArgumentException {
    this(armThickness,0,0);
  }

  /**
   * To construct a TriangleSolitaireModel with a base set side length of 5 and the center empty.
   * Set to the given row and given column value.
   *
   * @param sRow row value of intended empty space
   * @param sCol column value of intended empty space
   * @throws IllegalArgumentException if the position from the row and column are invalid
   */
  public TriangleSolitaireModel(int sRow, int sCol) throws IllegalArgumentException {
    this(5,sRow,sCol);
  }

  /**
   * To construct a TriangleSolitaireModel with a given side length and a given row
   * And column value to set the empty space to.
   *
   * @param armThickness given value to set our side length to
   * @param sRow         row value of intended empty space
   * @param sCol         column value of intended empty space
   * @throws IllegalArgumentException if the armThickness is non-positive or if the given position,
   *     is invalid, meaning they aren't even on the board or the slot is literally invalid.
   */
  public TriangleSolitaireModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {
    super();
    if (armThickness < 0) {
      throw new IllegalArgumentException("Invalid armThickness, not odd");
    }
    this.armThickness = armThickness;
    this.boardSize = armThickness;
    this.board = this.initBoard(sRow, sCol);
    if (!this.boardSlotValidity(sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position" + "("
              + sRow + "," + sCol + ")");
    }
  }

  /**
   * Move a single marble from a given position to another given position.
   * A move is valid only if the from and to positions are valid. Specific
   * implementations may place additional constraints on the validity of a move.
   * Move is only valid if it's within the board and the slots are not an Invalid slot.
   * (So they are either a Marble or empty).
   * The from position must be a marble and the to position must be empty.
   * And the move must be either up 2, down 2, right 2, or left 2 with a marble between the to from.
   *
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is not possible,
   *                                  so it violates any of these rules.
   *                                  So it throws an IllegalArgumentException if.
   *                                  to and from aren't valid, the move isn't going from a marble
   *                                  to an empty.
   *                                  Or if there isn't a marble between the move that is going up
   *                                  or down 2 or left or right 2.
   */
  @Override
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (this.validMove(fromRow, fromCol, toRow, toCol)) {
      if (toCol == fromCol + 2 && toRow == fromRow + 2
              && this.board.get(new Point(fromRow + 1, fromCol + 1))
              == MarbleSolitaireModelState.SlotState.Marble) {

        this.board.put(new Point(fromRow, fromCol), MarbleSolitaireModelState.SlotState.Empty);
        this.board.put(new Point(toRow, toCol), MarbleSolitaireModelState.SlotState.Marble);
        this.board.put(new Point(fromRow + 1, fromCol + 1),
                MarbleSolitaireModelState.SlotState.Empty);

        //to compute a move going diagonally up like (5,3) to (3,1)
      } else if (toCol == fromCol - 2 && toRow == fromRow - 2
              && this.board.get(new Point(fromRow - 1, fromCol - 1))
              == MarbleSolitaireModelState.SlotState.Marble) {

        this.board.put(new Point(fromRow, fromCol), MarbleSolitaireModelState.SlotState.Empty);
        this.board.put(new Point(toRow, toCol), MarbleSolitaireModelState.SlotState.Marble);
        this.board.put(new Point(fromRow - 1, fromCol - 1),
                MarbleSolitaireModelState.SlotState.Empty);
      } else {

        this.moveHelper(fromRow, fromCol, toRow, toCol);
      }
    }
  }

  /**
   * To make sure that a given position is a valid slot on the board.
   * Checks this by seeing if the given is in one of the invalid corners or not even on the board.
   * @param sRow the row y value of the given position.
   * @param sCol the column x value of the given position.
   * @return a boolean corresponding to the validity of the given position
   */
  @Override
  protected boolean boardSlotValidity(int sRow, int sCol) {
    return !((sCol > this.armThickness - (this.armThickness - sRow)) ||
            sRow > this.boardSize - 1 || sCol > this.boardSize - 1 || sRow < 0 || sCol < 0);
  }

  /**
   * To check if for the given location, if there is a possible move.
   * That can be made, if not returns false.
   *
   * @param sRow value to represent row of given location.
   * @param sCol value to represent column of given location.
   * @return a boolean on if a move is possible from the given position.
   */
  @Override
  protected boolean movesLeft(int sRow, int sCol) {
    if (this.board.get(new Point(sRow + 2, sCol)) == MarbleSolitaireModelState.SlotState.Empty
            && this.board.get(new Point(sRow + 1, sCol))
            == MarbleSolitaireModelState.SlotState.Marble) {
      return true;

      //Checks if a move can be made upwards.
    } else if (this.board.get(new Point(sRow - 2, sCol))
            == MarbleSolitaireModelState.SlotState.Empty
            && this.board.get(new Point(sRow - 1, sCol))
            == MarbleSolitaireModelState.SlotState.Marble) {
      return true;

      //Checks if a move can be made towards the right.
    } else if (this.board.get(new Point(sRow, sCol + 2))
            == MarbleSolitaireModelState.SlotState.Empty
            && this.board.get(new Point(sRow, sCol + 1))
            == MarbleSolitaireModelState.SlotState.Marble) {
      return true;

      //Checks if a move can be made to the left.
    } else if (this.board.get(new Point(sRow, sCol - 2))
            == MarbleSolitaireModelState.SlotState.Empty
            && this.board.get(new Point(sRow, sCol - 1))
            == MarbleSolitaireModelState.SlotState.Marble) {
      return true;

      //Checks if a move can be made diagonally down.
    } else if (this.board.get(new Point(sRow + 2, sCol + 2))
            == MarbleSolitaireModelState.SlotState.Empty
            && this.board.get(new Point(sRow - 1, sCol - 1))
            == MarbleSolitaireModelState.SlotState.Marble) {
      return true;

      //Final check to see if a move can be made diagonally up.
    } else {
      return this.board.get(new Point(sRow - 2, sCol - 2))
              == MarbleSolitaireModelState.SlotState.Empty
              && this.board.get(new Point(sRow - 1, sCol - 1))
              == MarbleSolitaireModelState.SlotState.Marble;
    }

  }
}
