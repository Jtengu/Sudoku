// Josh Taing
// CS 143
// HW #2: Sudoku #2 (isValid, isSolved - SudokuBoard.java file)

// This file will read from a text file numbers and periods, and accurate setup and display those values in a 9x9 sudoku grid.
// In addition, this file will also check whether all the board entries are valid 1-9 inputs, as well as only having one of each number
// following traditional sudoku game rules (one instance of 1-9 in each row/column/3x3 grid.


import java.util.*;
import java.io.*;

public class SudokuBoard {

   private int[][] board = new int[9][9];
   
   // PRE: String filename must be an existing file name in shared folder, else will throw a FileNotFoundException error
   // POST: Will fill the 2D int[][] array with values given by specified file in an appropriate 9x9 sudoku board setup
   public SudokuBoard(String filename) throws FileNotFoundException {
      
      Scanner input = new Scanner(new File(filename));
      String sequence = "";
      
      while (input.hasNextLine()) {
         sequence = sequence + input.nextLine();
      }
      
      int counter = 0;
      char c = ' ';
      
      for (int row = 0; row < 9; row++) {
         for (int column = 0; column < 9; column++) {
            c = sequence.charAt(counter);
            counter++;
            
            if (c >= '1' && c <= '9') {
               board[row][column] = c - '0';
            } else if (c == '0' || c == ' ' || c == ',' || c == '.') {
               board[row][column] = 0;
            } else {
               board[row][column] = -1;
            }
         
         }
      
      }
      
   }
   
   // PRE: none
   // POST: returns boolean true if all board values are within 1-9 parameter, or false if '-1' is detected, as per the catch all for the constructor method
   private boolean boardValid() {
   
      TreeSet<Integer> result = new TreeSet<>();
      
      for (int row = 0; row < 9; row++) {
         for (int column = 0; column < 9; column++) {
            result.add(board[row][column]);
         }
      
      }
      
      if (result.contains(-1)) {
         return false;
      }
      return true;
   }
   
   // PRE: must input an integer row parameter that is within the bounds of the 9x9 sudoku grid (min 1, max 9)
   // POST: returns boolean false if any value is detected more than one time, and returns true if no duplicate is detected
   private boolean rowValid(int row) {
   
      Map<Integer, Integer> freq = new HashMap();
      
      for (int column = 0; column < 9; column++) {
         int value = board[row-1][column];
         if (value != 0) {
            freq.put(value, freq.getOrDefault(value, 0) + 1);
            if (freq.get(value) > 1) {
               return false;
            }
         
         }
      }
      return true;
   }
   
   // PRE: must input an integer column parameter that is within the bounds of the 9x9 sudoku grid (min 1, max 9)
   // POST: returns boolean false if any value is detected more than one time, and returns true if no duplicate is detected
   public boolean columnValid(int column) {
      
      Map<Integer, Integer> freq = new HashMap();
      
      for (int row = 0; row < 9; row++) {
         int value = board[row][column-1];
         if (value != 0) {
            freq.put(value, freq.getOrDefault(value, 0) + 1);
            if (freq.get(value) > 1) {
               return false;
            }
         
         }
      }
      return true;  
   }
   
   // PRE: must input an integer spot parameter that is within the bounds of 9x9 sudoku grid (min 1, max 9)
   // POST: returns boolean false if any value is detected more than once within specified 3x3 grid, and returns true if no duplicate is detected
   private boolean miniSquareValid(int spot) {
      int[][] mini = new int[3][3];
      for(int r = 0; r < 3; r++) {
         for(int c = 0; c < 3; c++) {
            mini[r][c] = board[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
         }
      }
      Map<Integer, Integer> freq = new HashMap();
      
      for (int r = 0; r < 3; r++) {
         for (int c = 0; c < 3; c++) {
            int value = mini[r][c];
            if (value != 0) {
               freq.put(value, freq.getOrDefault(value, 0) + 1);
               if (freq.get(value) > 1) {
                  return false;
               }
            }
         }
      }
      return true;
   }
   
   
   // PRE: none
   // POST: returns boolean true if boardValid(), rowValid() for each row, columnValid() for each column, and miniSquareValid() for each spot is true, otherwise false on first false detected
   public boolean isValid() {
      
      if (boardValid()) {
      
         for (int row = 1; row <= 9; row++) {
            boolean validity = rowValid(row);
            if (validity == false) {
               return false;
            }
         }
         for (int column = 1; column <= 9; column++) {
            boolean validity = columnValid(column);
            if (validity == false) {
               return false;
            }
         }
         for (int spot = 1; spot <= 9; spot++) {
            boolean validity = miniSquareValid(spot);
            if (validity == false) {
               return false;
            }
         }
         return true;
      }
      return false;
   }
   
   // PRE: none
   // POST: returns boolean true value if isValid comes back true AND no 0 entries have been detected AND no 1-9 entry has been caught more than 9 times, otherwise returns false
   public boolean isSolved() {
   
      Map<Integer, Integer> freq = new HashMap();
      if (isValid()) {
         for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
               int value = board[row][column];
                  if (value == 0) {
                     return false;
                  }
                  freq.put(value, freq.getOrDefault(value, 0) + 1);
                  if (freq.get(value) > 9) {
                     return false;
                  }
            }
         }
      } else {
         return false;
      }
      return true;
   }
   
   // PRE: none
   // POST: outputs a formatted String of the current Sudoku Board with spacers to denote individual 3x3 grids
   public String toString() {
   
      StringBuilder result = new StringBuilder();
      
      int rowbreak = 0;
      int columnbreak = 1;

      for (int row = 0; row < 9; row++) {
         if (rowbreak == 3 && row != 8) {
            result.append("\n\n");
            rowbreak = 1;
         } else {
            result.append("\n");
            rowbreak++;
         }
         for (int column = 0; column < 9; column++) {
            result.append(board[row][column]);
            if (columnbreak == 3) {
               result.append("    ");
               columnbreak = 1;
            } else {
               result.append("  ");
               columnbreak++;
            }
         }
      
      }
      
      return result.toString();
   }

}

