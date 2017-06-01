import tester.*;
interface StringListWithMemory {
  /*
    @param String s The string to add
    EFFECT: after this, the string s appears first in the list, followed by the
    existing elements
  */
  void insertAtFront(String s);
  /*
    @param int i The index to add at
    @param String s The string to add
    EFFECT: after this, the string s appears at index i in the list, with all
    the existing elements around it
  */
  void insertAt(int i, String s);
  /*
    @param int i The index to add at
    @param String s The string to add
    EFFECT: after this, the string s appears at index i in the list, replacing
    the previous value at that index
  */
  void setAt(int i, String s);
  int length();
  String getAt(int i);
}
class StringArrayList implements StringListWithMemory {
  String[] contents;
  StringArrayList() {
    contents = new String[0];
  }

  public void setAt(int index, String value) {
    if(index >= this.contents.length || index < 0) {
      throw new RuntimeException("Index out of bounds " + index);
    }
    this.contents[index] = value;
  }
  public int length() { return this.contents.length; }

  public void insertAtFront(String s) {
    String[] newContents = new String[this.contents.length + 1];
    newContents[0] = s;
    for(int i = 0; i < this.contents.length; i += 1) {
      newContents[i + 1] = this.contents[i];
    }
    this.contents = newContents;
  }
  public void checkIndex(int index) {
    if(index >= this.contents.length || index < 0) { // HERE
      throw new RuntimeException("Index out of bounds " + index);
    }
  }
  public String getAt(int index) {
    checkIndex(index);
    return this.contents[index];
  }
  public void insertAt(int index, String s) {
    checkIndex(index);
    String[] newContents = new String[this.contents + 1];
    for(int i = 0; i < index; i += 1) {
      newContents[i] = this.contents[i];
    }
    newContents[index] = s;
    for(int i = index; i < this.contents.length; i += 1) {
      newContents[i + 1] = this.contents[i];
    }
    this.contents = newContents;
  }
}
class ExamplesStringList {
  void example1() {
    StringArrayList l = new StringArrayList();
    try {
      l.insertAtFront("swiss");
      l.insertAt(4, "provolone");
      l.insertAtFront("cheddar");
      l.getAt(3);
    }
    catch(RuntimeException e) {
      System.out.println(e); // CONTENTS OF l HERE
    }
  }

  boolean testArrayList(Tester t) {
    StringListWithMemory s = new StringArrayList();    

    s.insertAtFront("apple");
    s.insertAtFront("kiwi");
    s.insertAtFront("banana");
    s.insertAtFront("orange");

    t.checkExpect(s.getAt(0), "orange");

    s.insertAtFront("lime");

    t.checkExpect(s.getAt(0), "lime");

    s.insertAt(3, "lemon");

    t.checkExpect(s.getAt(3), "lemon");

    t.checkException(
      new RuntimeException("Index out of bounds -1"),
      s, "getAt", -1);

    t.checkExpect(s.getAt(4), "kiwi");
    return true;
  }
}
