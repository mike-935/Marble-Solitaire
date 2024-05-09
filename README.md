# Marble Solitaire
 
Implementation of the board game Marble Solitaire.

Playable through the terminal.

Supports variations of the board (English, European, Triangle).

To run the game there are various options to add in the command line.

First you choose the board:

There are 3 options:
-english
-european
-triangular

Next you can do these in varying order:

Add -size with a number after to specify the board size.

Add -hole with a row and column after to specify where the hole goes (normally in the middle).

You can also have both.

Or you dont add any of these.

Navigate to the Jar directory and in there run java -jar MarbleSolitaire.jar + whatever input you want.
For example. If I want the regular board I can run java -jar MarbleSolitaire.jar -english

To play: Enter the row and column of the piece you wish to move then the destination.
As in you enter InitialRow InitialColumn TargetRow TargetColumn.
Press q at anytime to quit.
