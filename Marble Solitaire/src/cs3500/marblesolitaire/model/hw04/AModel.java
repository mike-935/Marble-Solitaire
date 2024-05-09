package cs3500.marblesolitaire.model.hw04;


import java.awt.Point;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Abstract class to represent all our current models and representations for the MarbleSolitaire.
 * Game. Handles functionality and operations that are common to all models.
 */
public abstract class AModel {

  //to represent the game board
  protected Map<Point, MarbleSolitaireModelState.SlotState> board;

  //to represent the board's width/height
  protected int boardSize;

  protected int armThickness;

  /**
   * First constructor that takes no parameters and initializes the board.
   * Sets arm thickness to 3, and center empty is at (Row 3, Column 3).
   */
  protected AModel() {
    this(3, 3, 3);
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
  protected AModel(int armThickness) throws IllegalArgumentException {
    this(armThickness, (armThickness + 2 * (armThickness - 1) - 1) / 2,
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
  protected AModel(int sRow, int sCol) throws IllegalArgumentException {
    this(3, sRow, sCol);
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
  protected AModel(int armThickness, int sRow, int sCol)
          throws IllegalArgumentException {

    if (armThickness % 2 == 0 || armThickness < 0) {
      throw new IllegalArgumentException("Invalid armThickness, not odd");
    }
    this.armThickness = armThickness;
    this.boardSize = this.armThickness + (2 * (this.armThickness - 1));
    this.board = this.initBoard(sRow, sCol);

    if (!this.boardSlotValidity(sRow, sCol)) {
      throw new IllegalArgumentException("Invalid empty cell position" + "("
              + sRow + "," + sCol + ")");
    }
  }


  /**
   * To initialize our board utilizing a hashmap with a key of a Point.
   * Given row and column represents the empty tile.
   * And a value of an enum to represent three states.
   * Point: Stores row y value as Point's X and column x value as Point's y.
   * Enum states are Marble, Empty, Invalid (not a playable tile).
   *
   * @param sRow represents the row y value that represents the center empty tile.
   * @param sCol represents the column x value that represents the center empty tile.
   * @return a HashMap representing our board with a position and a SlotState
   */
  protected HashMap<Point, MarbleSolitaireModelState.SlotState> initBoard(int sRow, int sCol) {
    HashMap<Point, MarbleSolitaireModelState.SlotState> boardHM =
            new HashMap<Point, MarbleSolitaireModelState.SlotState>();
    for (int r = 0; r < this.boardSize; r = r + 1) {
      for (int c = 0; c < this.boardSize; c = c + 1) {
        if (r == sRow && c == sCol) {
          boardHM.put(new Point(r, c), MarbleSolitaireModelState.SlotState.Empty);
        } else if (this.boardSlotValidity(r, c)) {
          boardHM.put(new Point(r, c), MarbleSolitaireModelState.SlotState.Marble);
        } else {
          boardHM.put(new Point(r, c), MarbleSolitaireModelState.SlotState.Invalid);
        }
      }
    }
    return boardHM;
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
  protected abstract boolean boardSlotValidity(int sRow, int sCol);

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
  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    this.moveHelper(fromRow, fromCol, toRow, toCol);
  }

  /**
   * This method just handles the generic move methods's parts as it can handle moving up,
   * down, left, and right. This operation is similar in all of our current models. But Triangle
   * Has additional moves so abstracting the move pattern they all have allows us to abstract move,
   * To a point where move will have all the generic move's but it open for specific class to add.
   * Additional move capabilities.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @throws IllegalArgumentException if the move is not possible so it violates any of these rules.
   *                                  So it throws an IllegalArgumentException if.
   *                                  to and from aren't valid, the move isn't going from a marble
   *                                  to an empty.
   *                                  Or if there isn't a marble between the move that is going up
   *                                  or down 2 or left or right 2.
   */
  protected void moveHelper(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {

    //Checks if the from and/or to given positions are out of bounds
    //and if they are even valid positions.
    if (this.validMove(fromRow, fromCol, toRow, toCol)) {

      //The case where the move is going upwards.
      if (toRow == fromRow - 2 && toCol == fromCol
              && this.board.get(new Point(fromRow - 1, fromCol))
              == MarbleSolitaireModelState.SlotState.Marble) {

        this.board.put(new Point(fromRow, fromCol), MarbleSolitaireModelState.SlotState.Empty);
        this.board.put(new Point(toRow, toCol), MarbleSolitaireModelState.SlotState.Marble);
        this.board.put(new Point(fromRow - 1, fromCol),
                MarbleSolitaireModelState.SlotState.Empty);

        //Case where the move is going downwards.
      } else if (toRow == fromRow + 2 && toCol == fromCol
              && this.board.get(new Point(fromRow + 1, fromCol))
              == MarbleSolitaireModelState.SlotState.Marble) {

        this.board.put(new Point(fromRow, fromCol), MarbleSolitaireModelState.SlotState.Empty);
        this.board.put(new Point(toRow, toCol), MarbleSolitaireModelState.SlotState.Marble);
        this.board.put(new Point(fromRow + 1, fromCol),
                MarbleSolitaireModelState.SlotState.Empty);

        //The case when the move is going left.
      } else if (toCol == fromCol - 2 && toRow == fromRow
              && this.board.get(new Point(fromRow, fromCol - 1))
              == MarbleSolitaireModelState.SlotState.Marble) {

        this.board.put(new Point(fromRow, fromCol), MarbleSolitaireModelState.SlotState.Empty);
        this.board.put(new Point(toRow, toCol), MarbleSolitaireModelState.SlotState.Marble);
        this.board.put(new Point(fromRow, fromCol - 1),
                MarbleSolitaireModelState.SlotState.Empty);

        //Case where move is going right.
      } else if (toCol == fromCol + 2 && toRow == fromRow
              && this.board.get(new Point(fromRow, fromCol + 1))
              == MarbleSolitaireModelState.SlotState.Marble) {

        this.board.put(new Point(fromRow, fromCol), MarbleSolitaireModelState.SlotState.Empty);
        this.board.put(new Point(toRow, toCol), MarbleSolitaireModelState.SlotState.Marble);
        this.board.put(new Point(fromRow, fromCol + 1),
                MarbleSolitaireModelState.SlotState.Empty);

      } else {
        throw new IllegalArgumentException("Not moving to legal slot with a marble in between");
      }

    } else {
      throw new IllegalArgumentException("The given from and move slots are not valid slots");
    }
  }


  /**
   * Determine and return if the game is over or not. A game is over if no
   * more moves can be made.
   *
   * @return true if the game is over, false otherwise.
   */
  public boolean isGameOver() {
    Set<Point> boardPoints = this.board.keySet();
    for (Point p : boardPoints) {
      if (this.board.get(p) == MarbleSolitaireModelState.SlotState.Marble
              && this.movesLeft((int) p.getX(), (int) p.getY())) {
        return false;
      }
    }
    return true;
  }

  /**
   * To check if for the given location, if there is a possible move.
   * That can be made, if not returns false.
   *
   * @param sRow value to represent row of given location.
   * @param sCol value to represent column of given location.
   * @return a boolean on if a move is possible from the given position.
   */
  protected boolean movesLeft(int sRow, int sCol) {

    //Checks if a move can be made downward.
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
    } else {
      return this.board.get(new Point(sRow, sCol - 2))
              == MarbleSolitaireModelState.SlotState.Empty
              && this.board.get(new Point(sRow, sCol - 1))
              == MarbleSolitaireModelState.SlotState.Marble;
    }
  }

  /**
   * Return the size of this board.
   * The size is roughly the longest dimension of a board.
   *
   * @return the size as an integer.
   */
  public int getBoardSize() {
    return this.boardSize;
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
  public MarbleSolitaireModelState.SlotState getSlotAt(int row, int col)
          throws IllegalArgumentException {
    if (row < this.boardSize
            && col < this.boardSize
            && row >= 0 && col >= 0) {
      return this.board.get(new Point(row, col));
    } else {
      throw new IllegalArgumentException("Row and/or Column are beyond board dimensions");
    }

  }

  /**
   * To compute what the score is of the game of the remaining marbles.
   * Does this by checking the board HashMap for every Enum value that is a Marble.
   *
   * @return an int value corresponding to the remaining marbles.
   */
  protected int checkScore() {
    int score = 0;
    Collection<MarbleSolitaireModelState.SlotState> aLofEnums = this.board.values();
    for (MarbleSolitaireModelState.SlotState s : aLofEnums) {
      if (s == MarbleSolitaireModelState.SlotState.Marble) {
        score = score + 1;
      }
    }
    return score;
  }


  /**
   * Return the number of marbles currently on the board.
   * Which correlates to the score of the game.
   *
   * @return the number of marbles currently on the board.
   */
  public int getScore() {
    return this.checkScore();
  }

  /**
   * This abstracts the valid move check that we have for the generic move, as in this will check.
   * That the move attempted is a move that involves a from position and to position that are on.
   * The board and are both valid slots, and that the move is going from a marble to an empty slot.
   *
   * @param fromRow the row number of the position to be moved from (starts at 0)
   * @param fromCol the column number of the position to be moved from (starts at 0)
   * @param toRow   the row number of the position to be moved to (starts at 0)
   * @param toCol   the column number of the position to be moved to (starts at 0)
   * @return a boolean corresponding to if a move is valid.
   * @throws IllegalArgumentException if the move is not possible so it violates any of these rules.
   *                                  So it throws an IllegalArgumentException if.
   *                                  to and from aren't valid, the move isn't going from a marble
   *                                  to an empty.
   *                                  Or if there isn't a marble between the move that is going up
   *                                  or down 2 or left or right 2.
   */
  protected boolean validMove(int fromRow, int fromCol, int toRow, int toCol)
          throws IllegalArgumentException {
    if ((fromRow < this.boardSize && fromCol < this.boardSize
            && toRow < this.boardSize && toCol < this.boardSize
            && this.boardSlotValidity(fromRow, fromCol) && this.boardSlotValidity(toRow, toCol))) {
      if ((this.board.get(new Point(fromRow, fromCol)) == MarbleSolitaireModelState.SlotState.Marble
              && this.board.get(new Point(toRow, toCol))
              == MarbleSolitaireModelState.SlotState.Empty)) {
        return true;
      } else {
        throw new IllegalArgumentException("Sorry, you not moving from a marble to an empty slot");
      }
    } else {
      throw new IllegalArgumentException("Sorry, not valid positions");
    }

  }


}
