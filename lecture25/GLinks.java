interface StringList {
  public StringList add(String s);
  int length();
  boolean contains(String s);
}
class SLLink implements StringList {
  String value; StringList rest;
  public SLLink(String value, StringList rest) {
    this.value = value; this.rest = rest;
  }
  public StringList add(String s) { return new SLLink(s, this); }
  public int length() { return 1 + this.rest.length(); }
  public boolean contains(String s) {
    return this.value.equals(s) || this.rest.contains(s);
  }
}
class SLEmpty implements StringList {
  public StringList add(String s) { return new SLLink(s, this); }
  public int length() { return 0; }
  public boolean contains(String s) { return false; }
}


interface IntegerList {
  public IntegerList add(Integer s);
  int length();
  boolean contains(Integer s);
}
class ILLink implements IntegerList {
  Integer value; IntegerList rest;
  public ILLink(Integer value, IntegerList rest) {
    this.value = value; this.rest = rest;
  }
  public IntegerList add(Integer s) { return new ILLink(s, this); }
  public int length() { return 1 + this.rest.length(); }
  public boolean contains(Integer s) {
    return this.value.equals(s) || this.rest.contains(s);
  }
}
class ILEmpty implements IntegerList {















}



interface AnyList<ElementType> { // ElementType is a TYPE VARIABLE
  /* Returns a new list with t at the beginning followed by
   * the contents of the current list */
  AnyList<ElementType> add(ElementType t);
  /* Returns the number of elements in the list */
  int length();
  /* Returns true if s is contained in the list,
   * false otherwise */
  boolean contains(ElementType s);
}
class Link<ElementType> implements AnyList<ElementType> {
  ElementType value; // ElementType not Content!
  AnyList<ElementType> rest;
  public Link(ElementType value, AnyList<ElementType> rest) {
    this.value = value;
    this.rest = rest;
  }
  public Link<ElementType> add(ElementType s) {
    return new Link<ElementType>(s, this);
  }
  public int length() {
    return 1 + this.rest.length();
  }
  public boolean contains(ElementType s) {
    return this.value.equals(s) || this.rest.contains(s);
  }
  public String toString() {
    return "Link(" + this.value.toString() + ", " + this.rest.toString() + ")";
  }
}
class Empty<ElementType> implements AnyList<ElementType> {
  public Link<ElementType> add(ElementType s) {
    return new Link<ElementType>(s, this);
  }
  public int length() {
    return 0;
  }
  public boolean contains(ElementType s) {
    return false;
  }
  public String toString() {
    return "Empty";
  }
}

// This feature is called _generics_


public class GLinks {
  public static void main(String args[]) {
    AnyList<Integer> dlist = new Empty<Integer>().add(12).add(13);
    System.out.println(dlist + " contains 12? " + dlist.contains(12));

    AnyList<String> slist = new Empty<String>().add("a").add("b");
    System.out.println(slist + " contains b? " + slist.contains("b"));

    AnyList<Boolean> trueList = new Empty<Boolean>().add(true);

    String[] arr = { "a", "b" };
    AnyList<String[]> list_of_array = new Empty<String[]>().add(arr);
  }
}


