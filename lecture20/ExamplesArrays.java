import tester.*;
class ExamplesArrays {
  int[] nums = {40, 50, 60};
  int oneOfTheNums = nums[1];
  // What does nums[1] evaluate to?
  // A: 40     B: 50    C: 60    D: Error

  // Fill in the blank below with an appropriate type:

  //  ____________ x = {"CSE11", "CSE12", "CSE30"};
  // A: int    B: String    C: int[]    D: String[]

  /*
    @param strs Strings to search
    @param str The string to search for
    @return The index of the string found, or -1 if it isn't found
  */
  int findA(String[] strs, String str) {
    for(int ix = 0; ix < strs.length; ix = ix + 1) {
      if(strs[ix].equals(str)) {
        return ix;
      }
      else {
        return -1;
      }
    }
    return -1; // Only reached if strs is empty
  }

  int findB(String[] strs, String str) {
    for(int ix = 0; ix < strs.length; ix = ix + 1) {
      if(strs[ix].equals(str)) {
        return ix;
      }
    }
    return -1;
  }

  int findC(String[] strs, String str) {
    int foundIndex = -1; // A VARIABLE
    for(int ix = 0; ix < strs.length; ix = ix + 1) {
      if(strs[ix].equals(str)) {
        foundIndex = ix; // A VARIABLE ASSIGNMENT
      }
    }
    return foundIndex;
  }

  boolean testFind1(Tester t) {
    String[] test1 = {"apple", "banana", "kiwi", "banana"};

    // Which of the tests below will FAIL?
    t.checkExpect(this.findA(test1, "orange"), -1); // A
    t.checkExpect(this.findB(test1, "orange"), -1); // B
    t.checkExpect(this.findC(test1, "orange"), -1); // C
                                                  // D: None of the above
    // Which of the tests below will FAIL?
    t.checkExpect(this.findA(test1, "apple"), 0); // A
    t.checkExpect(this.findB(test1, "apple"), 0); // B
    t.checkExpect(this.findC(test1, "apple"), 0); // C
                                                  // D: None of the above
    // Which of the tests below will FAIL?
    t.checkExpect(this.findA(test1, "kiwi"), 2);  // A
    t.checkExpect(this.findB(test1, "kiwi"), 2);  // B
    t.checkExpect(this.findC(test1, "kiwi"), 2);  // C
                                                  // D: None of the above
    // Which of the tests below will SUCCEED?
    t.checkExpect(this.findA(test1, "banana"), 1);  // A
    t.checkExpect(this.findB(test1, "banana"), 1);  // B
    t.checkExpect(this.findC(test1, "banana"), 1);  // C
                                                    // D: None of the above
    return true;
  }


  // Arrays created with new are initialized with default values (0.0 for
  // doubles)
  double[] exampleNewArray = new double[4];
  // { 0.0, 0.0, 0.0, 0.0 }

  // We can use *array assignment* to update particular values.  This makes
  // the exampleNewArray have the values {0.0, 0.0, 75.0, 0.0} stored in its
  // elements
  {
    this.exampleNewArray[2] = 75;
  }


  double[] arrayOf(int howMany, double whichValue) {
    double[] elements = new double[howMany]; // Create a new array of howMany doubles
    for(int ix = 0; ix < howMany; ix += 1) {
      elements[ix] = whichValue;
    }
    return elements;
  }
  
  double[] someNums = this.arrayOf(4, 5.5);

  // What is in someNums?
  // A: {5.5, 5.5, 5.5, 5.5, 5.5}
  // B: {1.5, 2.5, 3.5, 4.5, 5.5}
  // C: {5.5, 5.5, 5.5, 5.5}
  // D: {0, 1, 2, 3, 4}


  /*
    This is a method conceptually similar to "link" from linked lists

    @param String[] base The starting list of strings
    @param String str The string to pre-pend
    @return A new array containing str followed by all the strings in base
  */
  String[] addAtFront(String[] strs, String str) {
    String[] result = new String[strs.length + 1];

    result[0] = str;

    for(int ix = 1; ix < result.length; ix += 1) {

      result[ix] = strs[ix - 1];

    }



    return result;
  }


}
