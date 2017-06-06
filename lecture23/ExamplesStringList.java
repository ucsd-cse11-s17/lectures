import tester.*;
interface StringListWithMemory {
  /*
    @param String s The string to add
    EFFECT: after this, the string s appears first in the list, followed
    by the existing elements
  */
  void insertAtFront(String s);

  /*
    @param int i The index to add at
    @param String s The string to add
    EFFECT: after this, the string s appears at index i in the list,
    with all the existing elements around it
  */
  void insertAt(int i, String s);

  /*
    @param int i The index to add at
    @param String s The string to add
    EFFECT: after this, the string s appears at index i in the list,
    replacing the previous value at that index
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
  public void insertAtFront(String s) {
    String[] newContents = new String[this.contents.length + 1];
    newContents[0] = s;
    for(int i = 0; i < this.contents.length; i += 1) {
      newContents[i + 1] = this.contents[i];
    }
    this.contents = newContents;
  }

  public String getAt(int index) {
    if(index < this.contents.length && index >= 0) {
      return this.contents[index];
    }
    else {
      return "invalid";
      // throw new RuntimeException("getAt index out of bounds: " + index);
    }
  }


  public void insertAt(int index, String s) {
    // Implement insertAt
    String[] newContents = new String[this.contents.length + 1];
    newContents[index] = s;
    for(int i = 0; i < index; i += 1) {
      newContents[i] = this.contents[i];
    }
    for(int i = index; i < this.contents.length; i += 1) { //C
      newContents[i + 1] = this.contents[i];
    }
    this.contents = newContents;
  }
  public void setAt(int index, String value) {





  }
  public int length() { return this.contents.length; }
}








class ExamplesStringList {

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

    t.checkExpect(s.getAt(4), "kiwi");

    try {
      s.getAt(11);
    }
    catch(RuntimeException e) {
      System.out.println("We are reporting the error ourselves!");
      System.out.println(e.toString());
      System.out.println("This printed from inside the catch block");
    }

    System.out.println("This printed AFTER the catch block");


    // A: Just the first one
    // B: Just the second
    // C: Both


/*
    String[] arr = {"a", "b", "c"};
    String value = arr[5];
*/







    return true;
  }
}
