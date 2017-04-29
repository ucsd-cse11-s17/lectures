/* An interface to a list of strings. */

interface StringList {
  /* Returns the number of strings in the list */
  int length();

  /* Returns true if the string is contained in the list,
   * false otherwise */
  boolean contains(String s);

  /* Returns the number of times s appears in the list */
  int count(String s);
}
class SLLink implements StringList {
  String value;
  StringList rest;
  public SLLink(String value, StringList rest) {
    this.value = value;
    this.rest = rest;
  }

  public int length() {
    return 1 + this.rest.length();
  }

  public boolean contains(String s) {
    return false; // FILL
  }

  public int count(String s) {
    return 0; // FILL
  }
}
class SLEmpty implements StringList {
  SLEmpty() {
    // does nothing
  }
  public int length() {
    return 0;
  }
  public boolean contains(String s) {
    return false;
  }
  public int count(String s) {
    return 0;
  }
}
class ExamplesLinks {
  StringList s1 = new SLLink("apple", new SLLink("banana", new SLEmpty())); 
  StringList s2 = new SLLink("kiwi", new SLLink("lemon",
    new SLLink("melon", new SLEmpty())));

  // A: 2  B: 3  C: 4  D: 5  E: 6
  int l1 = this.s1.length();

  // A: 2  B: 3  C: 4  D: 5  E: 6
  int l2 = this.s2.length();

  boolean c1 = this.s1.contains("lemon");
  boolean c2 = this.s2.contains("lemon");
  boolean c3 = this.s2.contains("apple");

/* What should c1, c2, c3 hold, once we have a
 * correct implementation of contains?

  A: true        B: true
     true           false
     true           true

  C: false       D: false
     true           true
     true           false

*/
}
