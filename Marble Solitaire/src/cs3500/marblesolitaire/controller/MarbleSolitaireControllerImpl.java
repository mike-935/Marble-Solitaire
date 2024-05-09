package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * To construct the implementation of the MarbleSolitaire controller. This will take in a readable,
 * input as well as a model for the game's functionality and a view to display the game. This can,
 * Facilitate the process of playing the game.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private Readable rd;

  private MarbleSolitaireModel model;

  private MarbleSolitaireView view;

  /**
   * To construct an implementation of a MarbleSolitaireController with a readable input
   * and a given model game state and view to display the game.
   *
   * @param model the given model game state that has the game functionality
   * @param view  the given view state that displays the game
   * @param rd    readable input of the game
   * @throws IllegalArgumentException if the controller is unable to successfully
   *                                  read input or transmit output.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
                                       MarbleSolitaireView view, Readable rd)
          throws IllegalArgumentException {
    if (rd == null || model == null || view == null) {
      throw new IllegalArgumentException("Given null");
    }
    this.rd = rd;
    this.model = model;
    this.view = view;

  }

  /**
   * To run the game and make it playable.
   * Readable input determines how the game is played.
   *
   * @throws IllegalStateException if any rule (according to assignment) if violated
   */
  @Override
  public void playGame() throws IllegalStateException {
    Scanner sc = new Scanner(this.rd);
    boolean quit = false;
    int[] inputs = new int[4];
    this.render();

    while (!quit) {
      try {

        String posInput = sc.next();

        try {


          for (int i = 0; i < 3; i++) {

            while (!this.tryInt(posInput)) {
              posInput = sc.next();
            }
            inputs[i] = Integer.parseInt(posInput);
            posInput = sc.next();

          }

          //Tried to abstract this but for some reason it causes issues that I'm not sure why it.
          //Does that, so I couldn't avoid repetition with this line.
          while (!this.tryInt(posInput)) {
            posInput = sc.next();
          }

          inputs[3] = Integer.parseInt(posInput);

          try {

            this.model.move(inputs[0] - 1, inputs[1] - 1, inputs[2] - 1,
                    inputs[3] - 1);
            this.render();

          } catch (IllegalArgumentException e) {

            this.tryInvalidMove();

          }
        } catch (NumberFormatException e) {
          if (posInput.equalsIgnoreCase("q")) {
            try {
              this.view.renderMessage("Game quit!" + "\n");
              this.view.renderMessage("State of game when quit:" + "\n");
              this.render();
              quit = true;
            } catch (IOException c) {
              throw new IllegalStateException(c.getMessage());
            }
          }
        }

        if (this.model.isGameOver()) {
          try {
            this.view.renderMessage("Game over!" + "\n");
            this.render();
            quit = true;

          } catch (IOException e) {
            //
          }
        }

      } catch (NoSuchElementException e) {
        throw new IllegalStateException("Couldn't read readable");
      }
    }
  }

  /**
   * To attempt to parse the input given to playGame.
   * If the input can be parsed and is invalid (less than 0), it will return false.
   * otherwise return true.
   * But if the string cannot be parsed and throws and exception.
   * It will check if the input was some version of the quit input, if it is then this returns true.
   * Else return false.
   *
   * @param s given input from playGame to check.
   * @return a boolean corresponding to if the string is a valid input.
   *     (quit input or positive number).
   */
  private boolean tryInt(String s) {
    try {
      Integer.parseInt(s);
      return (Integer.parseInt(s) - 1 >= 0);

    } catch (NumberFormatException e) {
      return s.equalsIgnoreCase("q");
    }
  }

  /**
   * To render the board and transmit it along with a new line.
   * Then render/transmit the message of the game's score and a new line.
   * Throws an IllegalStateException if this fails.
   *
   * @throws IllegalStateException if transmission fails
   */
  private void render() {
    try {
      this.view.renderBoard();
      this.view.renderMessage("\n");
      this.view.renderMessage("Score: " + this.model.getScore() + "\n");
    } catch (IOException c) {
      throw new IllegalStateException(c.getMessage());
    }
  }

  /**
   * This method is the try catch that is where we (attempt to) display the message,
   * That the given move was invalid.
   */
  private void tryInvalidMove() {
    try {
      this.view.renderMessage("Invalid move. Play again." + "\n");
    } catch (IOException ex) {
      throw new IllegalStateException(ex.getMessage());
    }
  }

}

