/* An interface for a list of strings. */
interface StringList {
  /* Returns the number of strings in the list */
  int length();

  /* Returns true if the string is contained in the list,
   * false otherwise */
  boolean contains(String s);

  /* Returns the number of times s appears in the list */
  int count(String s);

  /* Returns a StringList containing the elements of
     this list followed by those of other */
  StringList append(StringList other);

  /* Returns a StringList where all the contents have
     been converted to uppercase */
  StringList upper();
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

  // If pineapple is in the list, and we check for apple
  // should we return true or false?
  public boolean contains(String s) {
    return this.value.equals(s)
           || this.rest.contains(s);
  }
  // Implement count – the number of times s
  // appears in this list
  public int count(String s) {
    if(this.value.equals(s)) {
                  // how many times in the rest of list
      return 1 + this.rest.count(s);
    }
    else {   // how many times in the rest of list
      return this.rest.count(s);
    }
  }

  public StringList append(StringList other) {


  }

  public StringList upper() {


  }
}
class SLEmpty implements StringList {
  public int length() {
    return 0;
  }
  public boolean contains(String s) {
    return false;
  }
  public int count(String s) {
    return 0;
  }
  public StringList append(StringList other) {


  }
  public StringList upper() {


  }
}
class ExamplesLinks {
  StringList s1 = new SLLink("apple",
    new SLLink("banana", new SLEmpty())); 
  StringList s2 = new SLLink("kiwi", new SLLink("lemon",
    new SLLink("melon", new SLEmpty())));

  // A: 2  B: 3  C: 4  D: 5  E: 6
  int l1 = this.s1.length(); // Answer is 2

  // A: 2  B: 3  C: 4  D: 5  E: 6
  int l2 = this.s2.length();

  boolean c1 = this.s1.contains("lemon");
  boolean c2 = this.s2.contains("lemon");
  boolean c3 = this.s2.contains("apple");

// Right now:  Write contains() in both classes

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

