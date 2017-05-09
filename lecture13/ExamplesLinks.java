import tester.*;
/* An interface for a list of strings. */
interface StringList {
  /* Returns the number of strings in the list */
  int length();
  /* Returns true if the string is contained in the list,
   * false otherwise */
  boolean contains(String s);
  /* Returns the number of times s appears in the list */
  int count(String s);
  /* Returns a new StringList containing all the strings with
     length (strictly) longer than l */
  StringList keepLongerThan(int l);
  /* Returns a new StringList containing the elements of
     this list followed by those of other */
  StringList append(StringList other);
  /* Returns a new StringList where all the contents have
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
  public int length() { return 1 + this.rest.length(); }
  public boolean contains(String s) {
    return this.value.equals(s) || this.rest.contains(s);
  }
  public int count(String s) {
    if(this.value.equals(s)) {
      return 1 + this.rest.count(s);
    }
    else {
      return this.rest.count(s);
    }
  }
  public StringList keepLongerThan(int len) {
    if(this.value.length() > len) {
      return new SLLink(this.value, this.rest.keepLongerThan(len));
    }
    else {
      return this.rest.keepLongerThan(len);                           // B
    }
  }
  public StringList append(StringList other) {
    return new SLLink(this.value, this.rest.append(other));
  }
  public StringList upper() {
    return new SLLink(this.value.toUpperCase(), this.rest.upper());
  }
}
class SLEmpty implements StringList {
  public int length() { return 0; }
  public boolean contains(String s) { return false; }
  public int count(String s) { return 0; }
  public StringList keepLongerThan(int len) {
    return new SLEmpty();
  }
  public StringList append(StringList other) {
    return other;
  }
  public StringList upper() {
    return new SLEmpty();
  }
}
class ExamplesLinks {
  StringList mt  = new SLEmpty();

  StringList s1a = new SLLink("banana", new SLEmpty());
  StringList s1b  = new SLLink("apple", new SLLink("banana", new SLEmpty())); 
  StringList s1c  = new SLLink("grapefruit",
                      new SLLink("apple",
                        new SLLink("banana", new SLEmpty()))); 

  StringList s2  = new SLLink("kiwi",
                    new SLLink("lemon",
                      new SLLink("melon", new SLEmpty())));

  // HINT: s.length() returns the length in characters of a String s
  // HINT: s.toUpperCase() returns the upper-cased version of a String s

  // DO NOW!  Implement the SLLink case of keepLongerThan


boolean testLongerThan(Tester t) {
  return
  t.checkExpect(this.mt.keepLongerThan(5), new SLEmpty()) &&
  t.checkExpect(this.s1a.keepLongerThan(5), new SLLink("banana", new SLEmpty())) &&
  t.checkExpect(this.s1b.keepLongerThan(5), new SLLink("banana", new SLEmpty())) &&
  t.checkExpect(this.s1c.keepLongerThan(5),
                new SLLink("grapefruit", new SLLink("banana", new SLEmpty())));
}

  boolean testUpper(Tester t) {
    return t.checkExpect(this.s1a.upper(), new SLLink("BANANA", new SLEmpty()) &&
           t.checkExpect(this.mt.upper(), new SLEmpty()) &&
           t.checkExpect(this.s1b.upper(),
            new SLLink("APPLE", new SLLink("BANANA", new SLEmpty())));
  }

}

/*  Which is a good implementation of upper()?  Assume this is for SLLink,
 *  SLEmpty given 

/*
A:

public StringList upper() {
  return this.value.toUpperCase() + this.rest.upper();
}

B:
StringList upper() {
  return new SLLink(this.value.toUpperCase(), this.rest.upper());
}

C:
StringList upper() {
  return new SLLink(this.value.toUpperCase(), this.rest);
}

D:
StringList upper() {
  return this.rest.upper(this.value.toUpperCase());
}

E:
StringList upper() {
  return new SLLink(this.value.toUpperCase(), this.rest.toUpperCase());
}
*/


