// Josh Taing
// CS 143
// HW #3: Sodoku #3 - (Solve - SudokuSolverEngine File)

// This code is a SudokuSolverEngine check solution file that setups both the "very-fast-solve.sdk" board and "fast-solve.sdk" sudokuboards.
// It checks whether both board setups are valid, and if they have already been solved, then uses the newly written solve() method to auto solve the board and output it as a string of the final board setup.

import java.io.FileNotFoundException;

public class SudokuSolverEngine {

   public static void main(String[] args) throws FileNotFoundException {
      // Here I have called my class `MySudokuBoard` if you named your class
      // differently, modify the line below to use your own class name
      SudokuBoard board = new SudokuBoard("boards/very-fast-solve.sdk");
      System.out.println("Initial board");
      System.out.println(board);
      System.out.println("\nIs board valid: " + board.isValid());
      System.out.println("Is board already solved: " + board.isSolved());
      System.out.println();

      System.out.print("Solving board...");
      long start = System.currentTimeMillis();
      board.solve();
      long stop = System.currentTimeMillis();
      System.out.printf("SOLVED in %.3f seconds.\n", ((stop-start)/1000.0));
      System.out.println();
      System.out.println(board);
      
      System.out.println("\n------------------------------------------\n");
      
      board = new SudokuBoard("boards/fast-solve.sdk");
      System.out.println("Initial board");
      System.out.println(board);
      System.out.println("\nIs board valid: " + board.isValid());
      System.out.println("Is board already solved: " + board.isSolved());
      System.out.println();

      System.out.print("Solving board...");
      start = System.currentTimeMillis();
      board.solve();
      stop = System.currentTimeMillis();
      System.out.printf("SOLVED in %.3f seconds.\n", ((stop-start)/1000.0));
      System.out.println();
      System.out.println(board);
      
   }
}

/*
  ----jGRASP exec: java -ea SudokuSolverEngine
 Initial board
 
 0  3  4    6  7  8    9  1  2    
 0  7  2    1  9  5    3  4  8    
 1  9  8    3  4  2    5  6  7    
 
 0  0  9    0  6  1    4  2  3    
 0  2  6    8  5  3    7  9  1    
 0  1  3    9  2  4    0  5  6    
 
 0  6  1    5  3  7    2  8  4    
 0  8  0    4  1  9    6  3  5    
 3  4  5    0  8  6    1  7  9    
 
 Is board valid: true
 Is board already solved: false
 
 Solving board...SOLVED in 0.761 seconds.
 
 
 5  3  4    6  7  8    9  1  2    
 6  7  2    1  9  5    3  4  8    
 1  9  8    3  4  2    5  6  7    
 
 8  5  9    7  6  1    4  2  3    
 4  2  6    8  5  3    7  9  1    
 7  1  3    9  2  4    8  5  6    
 
 9  6  1    5  3  7    2  8  4    
 2  8  7    4  1  9    6  3  5    
 3  4  5    2  8  6    1  7  9    
 
 ------------------------------------------
 
 Initial board
 
 8  2  7    1  5  4    3  9  6    
 9  6  5    0  2  7    1  4  8    
 3  4  1    6  0  9    7  5  2    
 
 0  0  0    0  0  0    0  0  0    
 0  0  0    0  0  0    0  0  0    
 6  1  8    9  7  0    4  3  5    
 
 7  8  6    2  3  5    0  1  4    
 1  5  4    7  9  6    8  0  3    
 2  3  9    8  4  0    0  0  0    
 
 Is board valid: true
 Is board already solved: false
 
 Solving board...SOLVED in 3.485 seconds.
 
 
 8  2  7    1  5  4    3  9  6    
 9  6  5    3  2  7    1  4  8    
 3  4  1    6  8  9    7  5  2    
 
 4  7  2    5  1  3    6  8  9    
 5  9  3    4  6  8    2  7  1    
 6  1  8    9  7  2    4  3  5    
 
 7  8  6    2  3  5    9  1  4    
 1  5  4    7  9  6    8  2  3    
 2  3  9    8  4  1    5  6  7    
 
  ----jGRASP: Operation complete.
 */