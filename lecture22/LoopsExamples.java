import tester.*;
class LoopsExamples {
  /*
    Return the sum of numbers from 1 to n (inclusive)
    (Lesson: loops don't have to involve arrays)
  */
A int sumTo(int n) {
    int sum = 0;
    for(int i = 0; i < n; i += 1) { sum += i; }
    return sum;
  }
B int sumTo(int n) {
    int sum = 0;
    for(int i = 0; i <= n; i += 1) { sum += n; }
    return sum;
  }
C int sumTo(int n) {
    int sum = 0;
    for(int i = 0; i < n; i += 1) { sum += n; }
    return sum;
  }
D int sumTo(int n) {
    int sum = 0;
    for(int i = 0; i <= n; i += 1) { sum += i; }
    return sum;
  }

  /* Find the index of the first element matching str */
  int findWhile(String[] strs, String str) {
    int index = 0;
    while(index < strs.length) {  // check if condition is true
      if(strs[index].equals(str)) { return index; }
      index += 1;
    }
    return -1;
  }
  int findFor(String[] strs, String str) {
    for(int index = 0; index < strs.length; index += 1) {
      if(strs[index].equals(str)) { return index; }
    }
    return -1;
  }
  boolean testFind(Tester t) {
    String[] test = {"a", "b", "c"};
    t.checkExpect(findWhile(test, "a"), 0); t.checkExpect(findFor(test, "a"), 0);
    t.checkExpect(findFor(test, "z"), -1); t.checkExpect(findWhile(test, "z"), -1);
  }

  /* Returns the length of the longest string in strs, or -1 if the list is empty */
  int longestFor(String[] strs) {
    int longestLength = -1;
    for(int index = 0; index < strs.length; index += 1) {
      if(strs[index].length > longestLength) {
        longestLength = strs[index].length(); // a _method_, not a field
      }
    }
    return longestLength;
  }
  /* Now write it using a while loop */
  int longestWhile(String[] strs) {
    int longestLength = -1;
    int index = 0;
    while(index < strs.length) {
      if(strs[index].length > longestLength) {
        longestLength = strs[index].length(); // a _method_, not a field
      }
      index += 1;
    }
    return longestLength;
  }
  boolean testLongest(Tester t) {
    String[] test1 = {"apple", "banana", "kiwi"};
    t.checkExpect(longestFor(test1), 6);
    String[] test2 = {"apple", "banana", "pomegranate"};
    t.checkExpect(longestFor(test2), 11);
  } }
