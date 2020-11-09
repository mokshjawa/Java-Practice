// Excel

// Implement a spreadsheet. The spreadsheet can be represented by a data type of your choosing, but it should be easy to get/update individual cells as well as display the entire spreadsheet.
// Each cell in the spreadsheet can have one of the following:
//   - a string such as "Name" in A1 or "John Doe" in A2
//   - a number such as 263 in B1 or 75 in B2
//   - a formula linking other items in the spreadsheet. Ex: "=C1*C2" in D2 or "=C1+C2" in D3
//     - cells that reference other cells with formulas are said to have dependencies. If the value in C1 or C2 changes, D2 will also need to be updated since it depends on those inputs.

// In the language of your choosing, implement the following functions:
// - 'initSpreadsheet', initialize the data structure storing your spreadsheet
// - 'addCell', to add a cell to your spreadsheet
// - 'getCell', to get the value inside of a spreadsheet cell
// - depending on your code, you might also implement 'parseCell' to handle all relevant formula parsing

// Assumptions:
// - assume the spreadsheet is initialized with 26 columns, 100 rows
// - assume valid input (no error checking on input)
// - assume that if a string begins with a '=', it's a valid formula
// - assume we just want to handle simple arithmetic for now (+-*/) only between two cells like '=B1*B2' or '=A1+A2'



/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

enum Type { 
  FORMULA, STRING, NUMBER;
}  

class Solution {
  static class Formula {
    String cell1;
    String cell2;
    String operator;
    
    public Formula(String cell1, String cell2, String op) {
      this.cell1 = cell1;
      this.cell2 = cell2;
      operator = op;
    }
    
    public int compute() {
      Integer val1 = sheet.get(cell1).numValue;
      Integer val2 = sheet.get(cell2).numValue;
      
      if (operator.equals("+")) {
        return val1 + val2;
      }
          
      return -1;
    }
  }
  
  static class Cell {
    Type type;
    String originalValue;
    
    String strValue;
    Integer numValue;
    Formula formValue;
  }
  
  static Map<String, Cell> sheet;
  static Map<String, Set<String>> dependencies;
  
  static void initSpreadsheet() {
    sheet = new HashMap<>();
    dependencies = new HashMap<>();
  }
  
  static void addCell(String cellLocation, String cellContents) {
    Type cellType = parseType(cellContents);
    Cell newCell = new Cell();
    newCell.type = cellType;
    newCell.originalValue = cellContents;
    
    if (newCell.type == Type.NUMBER) {
      newCell.numValue = Integer.parseInt(cellContents);
    }
    else if (newCell.type == Type.STRING) {
      newCell.strValue = cellContents;
    }
    else if (newCell.type == Type.FORMULA) {
      String formulaContents = cellContents.substring(1);
      
      // TODO:
      String operator = "+";
      
      System.out.println(formulaContents);
      String[] split = formulaContents.split("\\" + operator);
      
      Formula formula = new Formula(split[0], split[1], operator);
      newCell.formValue = formula;
    }
    
    sheet.put(cellLocation, newCell);
  }
  
  static String getCell(String cellLocation) {    
    Cell curr = sheet.get(cellLocation);
    
    if (curr.type == Type.FORMULA) {
      return Integer.toString(curr.formValue.compute());
    }
    
    return sheet.get(cellLocation).originalValue;
  }
  
  private static Type parseType(String cellContents) {
    if (isNumeric(cellContents)) {
      return Type.NUMBER;
    }
    else if (cellContents.charAt(0) == '=') {
      return Type.FORMULA;
    }
    
    return Type.STRING;
  }
  
  public static boolean isNumeric(String str) { 
    try {  
      Integer.parseInt(str);  
      return true;
    } catch(NumberFormatException e){  
      return false;  
    }  
  }

  public static void main(String[] args) {
    initSpreadsheet();
    
    addCell("A1", "Name");
    addCell("A2", "123");
    addCell("A3", "1");
    addCell("A4", "2");
    addCell("B1", "John Doe");
    System.out.println(getCell("A1"));
    addCell("A1", "Buddy");
    System.out.println(getCell("A1"));
    System.out.println(getCell("A2"));
    
    addCell("C1", "=A2+A3");
    addCell("C2", "=A4+A3");
    System.out.println(getCell("C1"));
    addCell("A2", "120");
    System.out.println(getCell("C1"));
    addCell("A3", "100");
    addCell("C1", "=A2+A4");
    System.out.println(getCell("C1"));
    System.out.println(getCell("C2"));
  }
}
