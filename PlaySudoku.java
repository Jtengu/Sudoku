// Josh Taing
// CS 143
// HW #1: Sudoku 31 (Board Setup - PlaySudoku file)

// This program serves as the main test file for SudokuBoard that runs a setup of the initial Sudoku board state and run a quick print statement
// to output the current board as a formatted toString.


import java.util.*;
import java.io.*;


public class PlaySudoku {

   public static void main(String[] args) throws FileNotFoundException {
      
   String filename = "boards/col-violation.sdk";
   
   SudokuBoard boardsetup = new SudokuBoard(filename);
   
   System.out.println(boardsetup);
   
   System.out.println("BoardValid = " + boardsetup.isValid());
   System.out.println("BoardSolved = " + boardsetup.isSolved());
   System.out.println("BoardSolved = " + boardsetup.columnValid(1));
   
   }

}

/*
  ----jGRASP exec: java PlaySudoku
 
 2  0  0    1  0  5    0  0  3    
 0  5  4    0  0  0    7  1  0    
 0  1  0    2  0  3    0  8  0    
 
 6  0  2    8  0  7    3  0  4    
 0  0  0    0  0  0    0  0  0    
 1  0  5    3  0  9    8  0  6    
 
 0  2  0    7  0  1    0  6  0    
 0  8  1    0  0  0    2  4  0    
 7  0  0    4  0  2    0  0  1    
 
  ----jGRASP: Operation complete. 
    
 */