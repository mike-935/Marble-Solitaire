package cs3500.marblesolitaire;

import java.io.InputStreamReader;

import cs3500.marblesolitaire.controller.MarbleSolitaireController;
import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * To represent our class to run our game with the main method.
 */
public final class MarbleSolitaire {

  /**
   * Main method to run our game, inputs can determine the type of board,
   * the armThickness/Side Length of the board, and possibly the position of the empty space.
   *
   * @param args the inputs that configure the game.
   */
  public static void main(String[] args) {
    Readable rd = new InputStreamReader(System.in);

    switch (args[0]) {

      case "english":
        MarbleSolitaire.englishCase(args, rd);
        break;

      case "european":
        MarbleSolitaire.europeanCase(args, rd);
        break;

      case "triangular":

        MarbleSolitaire.triangularCase(args, rd);
        break;

      default:
        //
    }


  }

  //To run the case where an EnglishMarbleSolitaire is required.
  private static void englishCase(String[] args, Readable rd) {
    int inputAmount = args.length;

    int size = 0;
    int sRow = 0;
    int sCol = 0;

    MarbleSolitaireModel game = new EnglishSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game);

    if (inputAmount == 3 && args[1].equals("-size")) {
      size = Integer.parseInt(args[2]);
      game = new EnglishSolitaireModel(size);
      view = new MarbleSolitaireTextView(game);
    }

    if (inputAmount == 4 && args[1].equals("-hole")) {
      sRow = Integer.parseInt(args[2]);
      sCol = Integer.parseInt(args[3]);
      game = new EnglishSolitaireModel(sRow, sCol);
      view = new MarbleSolitaireTextView(game);
    }

    if (inputAmount == 6) {


      if (args[1].equals("-size")) {
        size = Integer.parseInt(args[2]);
        sRow = Integer.parseInt(args[4]);
        sCol = Integer.parseInt(args[5]);

      } else if (args[1].equals("-hole")) {
        sRow = Integer.parseInt(args[2]);
        sCol = Integer.parseInt(args[3]);
        size = Integer.parseInt(args[5]);
      }

      game = new EnglishSolitaireModel(size, sRow, sCol);
      view = new MarbleSolitaireTextView(game);
    }
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, rd);
    controller.playGame();
  }

  //To run the case where an EuropeanMarbleSolitaire is required.
  private static void europeanCase(String[] args, Readable rd) {
    int inputAmount = args.length;

    MarbleSolitaireModel game = new EuropeanSolitaireModel();
    MarbleSolitaireView view = new MarbleSolitaireTextView(game);

    int size = 0;
    int sRow = 0;
    int sCol = 0;

    if (inputAmount == 3 && args[1].equals("-size")) {
      size = Integer.parseInt(args[2]);
      game = new EuropeanSolitaireModel(size);
      view = new MarbleSolitaireTextView(game);
    }

    if (inputAmount == 4 && args[1].equals("-hole")) {
      sRow = Integer.parseInt(args[2]);
      sCol = Integer.parseInt(args[3]);
      game = new EuropeanSolitaireModel(sRow, sCol);
      view = new MarbleSolitaireTextView(game);
    }

    if (inputAmount == 6) {

      if (args[1].equals("-size")) {
        size = Integer.parseInt(args[2]);
        sRow = Integer.parseInt(args[4]);
        sCol = Integer.parseInt(args[5]);

      } else if (args[1].equals("-hole")) {
        sRow = Integer.parseInt(args[2]);
        sCol = Integer.parseInt(args[3]);
        size = Integer.parseInt(args[5]);
      }

      game = new EuropeanSolitaireModel(size, sRow, sCol);
      view = new MarbleSolitaireTextView(game);
    }
    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, rd);
    controller.playGame();
  }

  //To run the case where an TriangleMarbleSolitaire is required.
  private static void triangularCase(String[] args, Readable rd) {
    int inputAmount = args.length;

    int size = 0;
    int sRow = 0;
    int sCol = 0;

    MarbleSolitaireModel game = new TriangleSolitaireModel();
    MarbleSolitaireView view = new TriangleSolitaireTextView(game);

    if (inputAmount == 3 && args[1].equals("-size")) {
      size = Integer.parseInt(args[2]);
      game = new TriangleSolitaireModel(size);
      view = new TriangleSolitaireTextView(game);
    }

    if (inputAmount == 4 && args[1].equals("-hole")) {
      sRow = Integer.parseInt(args[2]);
      sCol = Integer.parseInt(args[3]);
      game = new TriangleSolitaireModel(sRow, sCol);
      view = new TriangleSolitaireTextView(game);
    }

    if (inputAmount == 6) {


      if (args[1].equals("-size")) {
        size = Integer.parseInt(args[2]);
        sRow = Integer.parseInt(args[4]);
        sCol = Integer.parseInt(args[5]);

      } else if (args[1].equals("-hole")) {
        sRow = Integer.parseInt(args[2]);
        sCol = Integer.parseInt(args[3]);
        size = Integer.parseInt(args[5]);
      }

      game = new TriangleSolitaireModel(size, sRow, sCol);
      view = new TriangleSolitaireTextView(game);
    }

    MarbleSolitaireController controller = new MarbleSolitaireControllerImpl(game, view, rd);
    controller.playGame();
  }



}
