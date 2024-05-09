package cs3500.marblesolitaire.controller;

/**
 * To represent a controller for MarbleSolitaire.
 */
public interface MarbleSolitaireController {

  /**
   * To run the game and make it playable.
   * Readable input determines how the game is played.
   * Will play game based on the given controller which will have the view,
   * corresponding to the appropriate view and the given board model.
   * This will allow the user to play the game by giving in either inputs for moves,
   * or ending the game with "q" or "Q". Will display the final board state when the game ends.
   * (Either by no moves left or victory).
   *
   * @throws IllegalStateException if any rule (according to assignment) is violated
   */
  void playGame() throws IllegalStateException;

}
